package com.example.moneyquoteapp.service;

import com.example.moneyquoteapp.model.CurrencyCode;

import java.math.BigDecimal;

public interface ICurrencyService {
    BigDecimal calculateTargetAmount(CurrencyCode sourceTarget, BigDecimal sourceAmount);
}
