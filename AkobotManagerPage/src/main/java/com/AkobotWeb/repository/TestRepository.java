package com.AkobotWeb.repository;

import com.AkobotWeb.domain.DB.tables.EtcEntity;
import com.AkobotWeb.domain.DB.tables.PushLogIntentsPK;
import com.AkobotWeb.domain.DB.tables.TestEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestRepository {
    private final EntityManager em;

    public void save(TestEntity test){
        if(test.getPks() == null){
            em.persist(test);
        }
        else{
            em.merge(test);
        }
    }

    public TestEntity findOne(int school_key, String field, String doc){
        PushLogIntentsPK pk = new PushLogIntentsPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(doc);

        return em.find(TestEntity.class, pk);
    }

    public List<TestEntity> findAll(){
        return em.createQuery("select t from test t", TestEntity.class)
                .getResultList();
    }

    public List<TestEntity> findByBno(String field){
        return em.createQuery("select t from test t where test.field = :field", TestEntity.class)
                .setParameter("field", field)
                .getResultList();
    }
}
