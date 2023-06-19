package com.akobot.repository;

import com.akobot.domain.tables.AskSolEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;

@Slf4j
@Repository
@RequiredArgsConstructor
@DynamicInsert
public class AskSolRepository{
    @PersistenceContext
    private final EntityManager em;

    @Transactional
    public AskSolEntity save(AskSolEntity askSol){
        if(askSol.isNew()){
            log.info("call EntityManager.persist(<Entity>)");
            askSol.setAskDate(ZonedDateTime.now());
            em.persist(askSol);
            return askSol;
        }
        else{
            log.info("call EntityManager.merge(<Entity>)");
            askSol.setAnswerDate(ZonedDateTime.now());
            return em.merge(askSol);
        }
    }

    public long maxBno(){
        return em.createQuery("select MAX(askSol.pks.bno) from ask_sol askSol", long.class)
                .getSingleResult();
    }
}
