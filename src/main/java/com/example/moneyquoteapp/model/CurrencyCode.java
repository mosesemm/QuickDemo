package com.example.moneyquoteapp.model;

public enum CurrencyCode {
    ZAR(Country.ZA, "R", "Rand"),
    KES(Country.KE, "K", "Shilling"),
    MWK(Country.MW, "MK", "Kwacha");

    private Country country;
    private String symbol;
    private String label;

    private CurrencyCode(Country country, String symbol, String label) {
        this.country = country;
        this.symbol = symbol;
        this.label = label;
    }

}
