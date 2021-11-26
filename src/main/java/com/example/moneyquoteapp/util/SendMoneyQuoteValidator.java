package com.example.moneyquoteapp.util;


import com.example.moneyquoteapp.model.InteractionEvent;
import com.example.moneyquoteapp.model.UssdRequest;

public class SendMoneyQuoteValidator {
    private UssdRequest request;
    private InteractionEvent latestEvent;

    public SendMoneyQuoteValidator(UssdRequest request, InteractionEvent latestEvent) {
        this.request = request;
        this.latestEvent = latestEvent;
    }

    public String validate() {
        String error = "";

        return error;
    }
}
