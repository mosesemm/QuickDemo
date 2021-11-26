package com.example.moneyquoteapp.service;

import com.example.moneyquoteapp.model.CurrencyCode;
import com.example.moneyquoteapp.model.InteractionEvent;
import com.example.moneyquoteapp.model.UssdRequest;
import com.example.moneyquoteapp.model.UssdResponse;
import com.example.moneyquoteapp.repository.InteractionEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SendMoneyQuoteService {
    @Autowired
    private ICurrencyService currencyService;
    @Autowired
    private InteractionEventRepository eventRepository;

    public UssdResponse handleRequest(UssdRequest request) {
        UssdResponse response = new UssdResponse();
        BigDecimal amount = currencyService.calculateTargetAmount(CurrencyCode.KES, new BigDecimal(1.5));
        response.setMessage("test"+amount);

        InteractionEvent latestEvent = eventRepository.findLatestInteractionEventBySessionId(request.getSessionId());

        return response;
    }
}
