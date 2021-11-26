package com.example.moneyquoteapp.util;


import com.example.moneyquoteapp.model.InteractionEvent;
import com.example.moneyquoteapp.model.UssdRequest;

import java.util.Objects;

public class SendMoneyQuoteValidator {
    private UssdRequest request;
    private InteractionEvent latestEvent;

    public SendMoneyQuoteValidator(UssdRequest request, InteractionEvent latestEvent) {
        this.request = request;
        this.latestEvent = latestEvent;
    }

    public String validate() {

        if(requiredFieldsInvalid()) {
            return "Invalid input";
        }

        return null;
    }

    private boolean requiredFieldsInvalid(){
        return request == null || request.getSessionId() == null || request.getMsisdn() == null;
    }
}
