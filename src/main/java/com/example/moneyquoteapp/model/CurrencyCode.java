package com.example.moneyquoteapp.model;

import java.util.Arrays;
import java.util.Optional;

public enum CurrencyCode {
    ZAR(Country.ZA, "R", "Rand"),
    KES(Country.KE, "KES", "Shilling"),
    MWK(Country.MW, "MWK", "Kwacha");

    private Country country;
    private String symbol;
    private String label;

    private CurrencyCode(Country country, String symbol, String label) {
        this.country = country;
        this.symbol = symbol;
        this.label = label;
    }

    public static CurrencyCode lookupCurrencyByCountry(Country country) {
        Optional<CurrencyCode> currencyCode = Arrays.stream(CurrencyCode.values())
                .filter(item -> item.country == country).findFirst();
        return currencyCode.orElse(null);
    }

    public String getSymbol() {
        return symbol;
    }
}
