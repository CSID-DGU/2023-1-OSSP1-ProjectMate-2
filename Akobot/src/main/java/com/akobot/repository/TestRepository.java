package com.akobot.repository;

import com.akobot.domain.IntentDTO;
import com.akobot.domain.tables.KsatEntity;
import com.akobot.domain.tables.PushLogIntentsPK;
import com.akobot.domain.tables.TestEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestRepository {
    private final EntityManager em;

    public void save(TestEntity test){
        if (test.getPks() == null){
            em.persist(test);
        } else{
            em.merge(test);
        }
    }

    public IntentDTO findOne(int school_key, String field, String document){
        PushLogIntentsPK pk = new PushLogIntentsPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(document);

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

    public List<TestEntity> findAll() {
        return em.createQuery("select t from test t", TestEntity.class)
                .getResultList();
    }
}
