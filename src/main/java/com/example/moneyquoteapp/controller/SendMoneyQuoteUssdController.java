package com.example.moneyquoteapp.controller;

import com.example.moneyquoteapp.model.UssdRequest;
import com.example.moneyquoteapp.model.UssdResponse;
import com.example.moneyquoteapp.service.SendMoneyQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ussd")
public class SendMoneyQuoteUssdController {

    @Autowired
    private SendMoneyQuoteService quoteService;

    @RequestMapping(method = RequestMethod.POST)
    public UssdResponse handleRequest(UssdRequest ussdRequest) {
        return quoteService.handleRequest(ussdRequest);
    }
}
