package com.akobot.repository;

import com.akobot.domain.IntentDTO;
import com.akobot.domain.tables.PushLogPK;
import com.akobot.domain.tables.TestEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
        PushLogPK pk = new PushLogPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(document);

        TestEntity testEntity = em.find(TestEntity.class, pk);

        IntentDTO intentDTO = new IntentDTO();
        intentDTO.setPks(testEntity.getPks());
        intentDTO.setContent(testEntity.getMethod());
        intentDTO.setContent(testEntity.getTarget());
        intentDTO.setElseData(testEntity.getElseData());
        intentDTO.setLevel(testEntity.getLevel());

        return intentDTO;
    }
}
