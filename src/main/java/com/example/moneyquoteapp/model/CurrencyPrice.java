package com.example.moneyquoteapp.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "CURRENCY_PRICE")
public class CurrencyPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CurrencyCode baseCurrency;
    @Enumerated(EnumType.STRING)
    private CurrencyCode targetCurrency;
    private BigDecimal currentAmount;
}
