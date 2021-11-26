package com.example.moneyquoteapp.model;

public enum InteractionState {
    INITIAL("Initial"),
    COUNTRY_ENTERED("Country entered"),
    AMOUNT_ENTERED("Amount entered"),
    COMPLETE("Complete");

    private String label;

    private InteractionState(String label) {
        this.label = label;
    }
}
