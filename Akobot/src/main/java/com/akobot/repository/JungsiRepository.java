package com.akobot.repository;

import com.akobot.domain.IntentDTO;
import com.akobot.domain.tables.JungsiEntity;
import com.akobot.domain.tables.PushLogPK;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JungsiRepository {
    private final EntityManager em;

    public void save(JungsiEntity jungsi){
        if (jungsi.getPks() == null){
            em.persist(jungsi);
        } else{
            em.merge(jungsi);
        }
    }

    public IntentDTO findOne(int school_key, String field, String document){
        PushLogPK pk = new PushLogPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setDocument(document);

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
}
