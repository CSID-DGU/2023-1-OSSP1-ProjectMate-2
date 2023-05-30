package com.akobot.repository;

import com.akobot.domain.IntentDTO;
import com.akobot.domain.tables.PushLogPK;
import com.akobot.domain.tables.SusiEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SusiRepository {
    private final EntityManager em;

    public void save(SusiEntity susi){
        if (susi.getPks() == null){
            em.persist(susi);
        } else{
            em.merge(susi);
        }
    }

    public IntentDTO findOne(int school_key, String field, String document){
        PushLogPK pk = new PushLogPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(document);

        SusiEntity susiEntity = em.find(SusiEntity.class, pk);

        IntentDTO intentDTO = new IntentDTO();
        intentDTO.setPks(susiEntity.getPks());
        intentDTO.setContent(susiEntity.getCondition_text());
        intentDTO.setContent(susiEntity.getPoint());
        intentDTO.setContent(susiEntity.getTest());
        intentDTO.setElseData(susiEntity.getElseData());
        intentDTO.setLevel(susiEntity.getLevel());

        return intentDTO;
    }
}
