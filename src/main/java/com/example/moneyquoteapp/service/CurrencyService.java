package com.example.moneyquoteapp.service;

import com.example.moneyquoteapp.model.CurrencyCode;
import com.example.moneyquoteapp.model.CurrencyPrice;
import com.example.moneyquoteapp.repository.CurrencyPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyService implements ICurrencyService{
    @Autowired
    private CurrencyPriceRepository priceRepository;

    @Override
    public BigDecimal calculateTargetAmount(CurrencyCode targetCurrency, BigDecimal sourceAmount) {
        CurrencyPrice currencyPrice = priceRepository.findCurrencyPriceByBaseCurrencyAndTargetCurrency(CurrencyCode.ZAR, targetCurrency);

        return currencyPrice.getCurrentAmount();
    }
}
