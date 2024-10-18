package com.example.ttkg.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class PersistenceInitializer {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void clearPersistence() {
        em.clear();
    }
}
