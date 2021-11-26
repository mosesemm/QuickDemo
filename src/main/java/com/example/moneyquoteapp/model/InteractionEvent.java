package com.example.moneyquoteapp.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class InteractionEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sessionId;
    private String msisdn;
    private String userEntry;
    @Enumerated(EnumType.STRING)
    private InteractionState status;
    @Enumerated(EnumType.STRING)
    private Country country;
    private BigDecimal targetAmount;
    @Enumerated(EnumType.STRING)
    private CurrencyCode targetCurrency;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date insertDate;
}
