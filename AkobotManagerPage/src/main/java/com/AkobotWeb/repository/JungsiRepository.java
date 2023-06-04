package com.AkobotWeb.repository;

import com.AkobotWeb.domain.DB.IntentDTO;
import com.AkobotWeb.domain.DB.tables.JungsiEntity;
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
public class JungsiRepository {
    private final EntityManager em;

    public void save(JungsiEntity jungsi){
        if(jungsi.getPks() == null){
            em.persist(jungsi);
        }
        else{
            em.merge(jungsi);
        }
    }

    @Transactional
    public void update(PushLogIntentsPK pk, String elseDataUpdate){
        JungsiEntity jungsi = em.find(JungsiEntity.class, pk);
        jungsi.setElseData(elseDataUpdate);

        save(jungsi);
    }

    public IntentDTO findOne(long school_key, String field, String doc){
        PushLogIntentsPK pk = new PushLogIntentsPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(doc);

        JungsiEntity jungsiEntity = em.find(JungsiEntity.class, pk);

        if(jungsiEntity != null) {
            IntentDTO intentDTO = new IntentDTO();
            intentDTO.setPks(jungsiEntity.getPks());
            intentDTO.setContent(jungsiEntity.getCondition_text());
            intentDTO.setContent(jungsiEntity.getPoint());
            intentDTO.setElseData(jungsiEntity.getElseData());
            intentDTO.setLevel(jungsiEntity.getLevel());

            return intentDTO;
        }

        return null;
    }

    public List<JungsiEntity> findAll(){
        return em.createQuery("select j from jungsi j", JungsiEntity.class)
                .getResultList();
    }

    public List<JungsiEntity> findByBno(String field){
        return em.createQuery("select j from jungsi j where j.pks.field = :field", JungsiEntity.class)
                .setParameter("field", field)
                .getResultList();
    }
}
