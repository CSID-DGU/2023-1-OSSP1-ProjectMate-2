package com.akobot.repository;

import com.akobot.domain.IntentDTO;
import com.akobot.domain.tables.EtcEntity;
import com.akobot.domain.tables.PushLogIntentsPK;
import com.akobot.domain.tables.EarlyAdmissionEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EarlyAdmissionRepository {
    private final EntityManager em;

    public void save(EarlyAdmissionEntity earlyAdmission){
        if (earlyAdmission.getPks() == null){
            em.persist(earlyAdmission);
        } else{
            em.merge(earlyAdmission);
        }
    }

    public IntentDTO findOne(int school_key, String field, String document){
        PushLogIntentsPK pk = new PushLogIntentsPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(document);

        EarlyAdmissionEntity earlyAdmissionEntity = em.find(EarlyAdmissionEntity.class, pk);

        if(earlyAdmissionEntity != null) {
            IntentDTO intentDTO = new IntentDTO();
            intentDTO.setPks(earlyAdmissionEntity.getPks());
            intentDTO.setContent(earlyAdmissionEntity.getCondition_text());
            intentDTO.setContent(earlyAdmissionEntity.getPoint());
            intentDTO.setContent(earlyAdmissionEntity.getTest());
            intentDTO.setElseData(earlyAdmissionEntity.getElseData());
            intentDTO.setLevel(earlyAdmissionEntity.getLevel());

            return intentDTO;
        }

        return null;
    }

    public List<EarlyAdmissionEntity> findAll() {
        return em.createQuery("select e from earlyadmission e", EarlyAdmissionEntity.class)
                .getResultList();
    }
}
