package com.example.moneyquoteapp.repository;

import com.example.moneyquoteapp.model.InteractionEvent;
import org.springframework.data.repository.CrudRepository;

public interface InteractionEventRepository extends CrudRepository<InteractionEvent, Long> {
    InteractionEvent findLatestInteractionEventBySessionId(String sessionId);
}
