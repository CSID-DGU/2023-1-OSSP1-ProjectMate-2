package com.akobot.repository;

import com.akobot.domain.IntentDTO;
import com.akobot.domain.tables.EtcEntity;
import com.akobot.domain.tables.KsatEntity;
import com.akobot.domain.tables.PushLogIntentsPK;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class KsatRepository {
    private final EntityManager em;

    public void save(KsatEntity ksat){
        if (ksat.getPks() == null){
            em.persist(ksat);
        } else{
            em.merge(ksat);
        }
    }

    public IntentDTO findOne(int school_key, String field, String document){
        PushLogIntentsPK pk = new PushLogIntentsPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(document);

        KsatEntity ksatEntity = em.find(KsatEntity.class, pk);

        if(ksatEntity != null) {
            IntentDTO intentDTO = new IntentDTO();
            intentDTO.setPks(ksatEntity.getPks());
            intentDTO.setContent(ksatEntity.getCondition_text());
            intentDTO.setContent(ksatEntity.getPoint());
            intentDTO.setElseData(ksatEntity.getElseData());
            intentDTO.setLevel(ksatEntity.getLevel());

            return intentDTO;
        }

        return null;
    }

    public List<KsatEntity> findAll() {
        return em.createQuery("select k from ksat k", KsatEntity.class)
                .getResultList();
    }
}
