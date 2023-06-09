package com.AkobotWeb.repository;


import com.AkobotWeb.domain.DB.IntentDTO;
import com.AkobotWeb.domain.DB.tables.PushLogIntentsPK;
import com.AkobotWeb.domain.DB.tables.EarlyAdmissionEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@DynamicUpdate
public class EarlyAdmissionRepository {
    private final EntityManager em;

    public void save(EarlyAdmissionEntity earlyAdmission){
        if(earlyAdmission.getPks() == null){
            em.persist(earlyAdmission);
        }
        else{
            em.merge(earlyAdmission);
        }
    }

    @Transactional
    public void update(PushLogIntentsPK pk, String elseDataUpdate){
        EarlyAdmissionEntity earlyAdmission = em.find(EarlyAdmissionEntity.class, pk);
        earlyAdmission.setElseData(elseDataUpdate);

        save(earlyAdmission);
    }

    public IntentDTO findOne(long school_key, String field, String doc){
        PushLogIntentsPK pk = new PushLogIntentsPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(doc);

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

    public List<EarlyAdmissionEntity> findAll(){
        return em.createQuery("select s from susi s", EarlyAdmissionEntity.class)
                .getResultList();
    }

    public List<EarlyAdmissionEntity> findByBno(String field){
        return em.createQuery("select s from susi s where s.pks.field = :field", EarlyAdmissionEntity.class)
                .setParameter("field", field)
                .getResultList();
    }
}
