package com.AkobotWeb.repository;

import com.AkobotWeb.domain.DB.IntentDTO;
import com.AkobotWeb.domain.DB.tables.EtcEntity;
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
public class EtcRepository {
    private final EntityManager em;

    public void save(EtcEntity etc){
        if(etc.getPks() == null){
            em.persist(etc);
        }
        else{
            em.merge(etc);
        }
    }

    @Transactional
    public void update(PushLogIntentsPK pk, String elseDataUpdate){
        EtcEntity etcEntity = em.find(EtcEntity.class, pk);
        etcEntity.setElseData(elseDataUpdate);

        save(etcEntity);
    }

    public IntentDTO findOne(long school_key, String field, String doc){
        PushLogIntentsPK pk = new PushLogIntentsPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(doc);

        EtcEntity etcEntity = em.find(EtcEntity.class, pk);

        if(etcEntity != null) {
            IntentDTO intentDTO = new IntentDTO();
            intentDTO.setPks(etcEntity.getPks());
            intentDTO.setContent(etcEntity.getContent());
            intentDTO.setElseData(etcEntity.getElseData());
            intentDTO.setLevel(etcEntity.getLevel());

            return intentDTO;
        }

        return null;
    }

    public List<EtcEntity> findAll(){
        return em.createQuery("select e from etc e", EtcEntity.class)
                .getResultList();
    }

    public List<EtcEntity> findByBno(String field){
        return em.createQuery("select e from etc e where etc.pks.field = :field", EtcEntity.class)
                .setParameter("field", field)
                .getResultList();
    }
}
