package com.AkobotWeb.repository;

import com.AkobotWeb.domain.DB.IntentDTO;
import com.AkobotWeb.domain.DB.tables.EtcEntity;
import com.AkobotWeb.domain.DB.tables.PushLogIntentsPK;
import com.AkobotWeb.domain.DB.tables.TestEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@DynamicUpdate
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

    @Transactional
    public void update(PushLogIntentsPK pk, String elseDataUpdate){
        TestEntity test = em.find(TestEntity.class, pk);
        test.setElseData(elseDataUpdate);

        save(test);
    }

    public IntentDTO findOne(long school_key, String field, String doc){
        PushLogIntentsPK pk = new PushLogIntentsPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(doc);

        TestEntity testEntity = em.find(TestEntity.class, pk);

        if(testEntity != null) {
            IntentDTO intentDTO = new IntentDTO();
            intentDTO.setPks(testEntity.getPks());
            intentDTO.setContent(testEntity.getMethod());
            intentDTO.setContent(testEntity.getTarget());
            intentDTO.setElseData(testEntity.getElseData());
            intentDTO.setLevel(testEntity.getLevel());

            return intentDTO;
        }

        return null;
    }

    public List<TestEntity> findAll(){
        return em.createQuery("select t from test t", TestEntity.class)
                .getResultList();
    }

    public List<TestEntity> findByBno(String field){
        return em.createQuery("select t from test t where t.pks.field = :field", TestEntity.class)
                .setParameter("field", field)
                .getResultList();
    }
}
