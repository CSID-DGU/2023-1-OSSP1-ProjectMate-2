package com.AkobotWeb.repository;

import com.AkobotWeb.domain.DB.tables.EtcEntity;
import com.AkobotWeb.domain.DB.tables.JungsiEntity;
import com.AkobotWeb.domain.DB.tables.PushLogIntentsPK;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
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

    public JungsiEntity findOne(int school_key, String field, String doc){
        PushLogIntentsPK pk = new PushLogIntentsPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(doc);

        return em.find(JungsiEntity.class, pk);
    }

    public List<JungsiEntity> findAll(){
        return em.createQuery("select j from jungsi j", JungsiEntity.class)
                .getResultList();
    }

    public List<JungsiEntity> findByBno(String field){
        return em.createQuery("select j from jungsi j where jungsi.field = :field", JungsiEntity.class)
                .setParameter("field", field)
                .getResultList();
    }
}
