package com.AkobotWeb.repository;

import com.AkobotWeb.domain.DB.IntentDTO;
import com.AkobotWeb.domain.DB.tables.KsatEntity;
import com.AkobotWeb.domain.DB.tables.PushLogIntentsPK;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@DynamicUpdate
public class KsatRepository {
    private final EntityManager em;

    public void save(KsatEntity ksat){
        if(ksat.getPks() == null){
            em.persist(ksat);
        }
        else{
            em.merge(ksat);
        }
    }

    @Transactional
    public void update(PushLogIntentsPK pk, String elseDataUpdate){
        KsatEntity jungsi = em.find(KsatEntity.class, pk);
        jungsi.setElseData(elseDataUpdate);

        save(jungsi);
    }

    public IntentDTO findOne(long school_key, String field, String doc){
        PushLogIntentsPK pk = new PushLogIntentsPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(doc);

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

    public List<KsatEntity> findAll(){
        return em.createQuery("select j from jungsi j", KsatEntity.class)
                .getResultList();
    }

    public List<KsatEntity> findByBno(String field){
        return em.createQuery("select j from jungsi j where j.pks.field = :field", KsatEntity.class)
                .setParameter("field", field)
                .getResultList();
    }
}
