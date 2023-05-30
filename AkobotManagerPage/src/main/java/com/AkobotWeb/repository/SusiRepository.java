package com.AkobotWeb.repository;


import com.AkobotWeb.domain.DB.tables.EtcEntity;
import com.AkobotWeb.domain.DB.tables.PushLogIntentsPK;
import com.AkobotWeb.domain.DB.tables.SusiEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SusiRepository {
    private final EntityManager em;

    public void save(SusiEntity susi){
        if(susi.getPks() == null){
            em.persist(susi);
        }
        else{
            em.merge(susi);
        }
    }

    public SusiEntity findOne(int school_key, String field, String doc){
        PushLogIntentsPK pk = new PushLogIntentsPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(doc);

        return em.find(SusiEntity.class, pk);
    }

    public List<SusiEntity> findAll(){
        return em.createQuery("select s from susi s", SusiEntity.class)
                .getResultList();
    }

    public List<SusiEntity> findByBno(String field){
        return em.createQuery("select s from susi s where susi.field = :field", SusiEntity.class)
                .setParameter("field", field)
                .getResultList();
    }
}
