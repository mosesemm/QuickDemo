package com.example.moneyquoteapp.model;

public enum Country {
    ZA("South Africa"),
    MW("Malawi"),
    KE("Kenya");

    private String label;

    private Country(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
