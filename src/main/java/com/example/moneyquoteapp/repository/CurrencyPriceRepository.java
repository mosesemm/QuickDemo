package com.example.moneyquoteapp.repository;

import com.example.moneyquoteapp.model.CurrencyCode;
import com.example.moneyquoteapp.model.CurrencyPrice;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyPriceRepository extends CrudRepository<CurrencyPrice, Long> {
    CurrencyPrice findCurrencyPriceByBaseCurrencyAndTargetCurrency(CurrencyCode baseCurrency, CurrencyCode targetCurrency);
}
