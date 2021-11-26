package com.example.moneyquoteapp.service;

import com.example.moneyquoteapp.model.*;
import com.example.moneyquoteapp.repository.InteractionEventRepository;
import com.example.moneyquoteapp.util.SendMoneyQuoteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@Transactional
public class SendMoneyQuoteService {
    @Autowired
    private ICurrencyService currencyService;
    @Autowired
    private InteractionEventRepository eventRepository;

    public UssdResponse handleRequest(UssdRequest request) {
        InteractionEvent latestEvent = eventRepository.findFirstBySessionIdOrderByInsertDateDesc(request.getSessionId());
        SendMoneyQuoteValidator validator = new SendMoneyQuoteValidator(request, latestEvent);

        UssdResponse response = new UssdResponse();
        response.setSessionId(request.getSessionId());
        String error = validator.validate();
        if(error != null) {
            response.setMessage("Error: "+error);
            return response;
        }

        InteractionEvent event = new InteractionEvent();
        event.setSessionId(request.getSessionId());
        event.setMsisdn(request.getMsisdn());
        event.setUserEntry(request.getUserEntry());

        //new request
        if(latestEvent == null || latestEvent.getStatus().equals(InteractionState.COMPLETE)) {
            event.setStatus(InteractionState.INITIAL);
            eventRepository.save(event);
            response.setMessage("Welcome to Mama Money! Where would you like to send money to?\n1) Kenya\n2) Malawi");
            return response;
        }

        //from initial state
        if(latestEvent.getStatus().equals(InteractionState.INITIAL)) {
            Country selectedCountry = request.getUserEntry().equals("1")?Country.KE:Country.MW;
            event.setCountry(selectedCountry);
            event.setStatus(InteractionState.COUNTRY_ENTERED);
            eventRepository.save(event);
            response.setMessage(String.format("How much money (in rands) will you like to send to %s?", selectedCountry.getLabel()));
            return response;
        }

        if(latestEvent.getStatus().equals(InteractionState.COUNTRY_ENTERED)) {
            Country selectedCountry = latestEvent.getCountry();
            CurrencyCode targetCurrencyCode = CurrencyCode.lookupCurrencyByCountry(selectedCountry);
            BigDecimal targetAmount = currencyService.calculateTargetAmount(targetCurrencyCode,
                    new BigDecimal(request.getUserEntry()));
            event.setTargetAmount(targetAmount);
            event.setTargetCurrency(targetCurrencyCode);
            event.setStatus(InteractionState.AMOUNT_ENTERED);
            eventRepository.save(event);
            response.setMessage(String.format("Your person you sending to will receive: %.2f %s\n1) Ok", targetAmount, targetCurrencyCode.getSymbol()));
            return response;
        }

        if(latestEvent.getStatus().equals(InteractionState.AMOUNT_ENTERED)) {
            event.setStatus(InteractionState.COMPLETE);
            eventRepository.save(event);
            response.setMessage("Thank you for using Mama Money!");
            return response;
        }

        response.setMessage("Unknown option");

        return response;
    }
}
