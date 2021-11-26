package com.example.moneyquoteapp.model;

import lombok.Data;

@Data
public class UssdRequest {
    private String sessionId;
    private String msisdn;
    private String userEntry;
}
