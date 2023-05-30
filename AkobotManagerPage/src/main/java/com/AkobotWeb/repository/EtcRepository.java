package com.AkobotWeb.repository;

import com.AkobotWeb.domain.DB.tables.EtcEntity;
import com.AkobotWeb.domain.DB.tables.PushLogIntentsPK;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
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

    public EtcEntity findOne(int school_key, String field, String doc){
        PushLogIntentsPK pk = new PushLogIntentsPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(doc);

        return em.find(EtcEntity.class, pk);
    }

    public List<EtcEntity> findAll(){
        return em.createQuery("select e from etc e", EtcEntity.class)
                .getResultList();
    }

    public List<EtcEntity> findByBno(String field){
        return em.createQuery("select e from etc e where etc.field = :field", EtcEntity.class)
                .setParameter("field", field)
                .getResultList();
    }
}
