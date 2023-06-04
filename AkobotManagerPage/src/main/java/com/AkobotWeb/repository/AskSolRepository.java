package com.AkobotWeb.repository;

import com.AkobotWeb.domain.BoardVO;
import com.AkobotWeb.domain.DB.tables.AskSolEntity;
import com.AkobotWeb.domain.DB.tables.EtcEntity;
import com.AkobotWeb.domain.DB.tables.PushLogAskSolPK;
import com.AkobotWeb.domain.SolveVO.SolveVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
@DynamicUpdate
public class AskSolRepository {
    private final EntityManager em;

    public void save(AskSolEntity askSol){
        if(askSol.getPks() == null){
            em.persist(askSol);
        }
        else{
            em.merge(askSol);
        }
    }

    public void save(BoardVO board){
        PushLogAskSolPK askSolPK = new PushLogAskSolPK();
        askSolPK.setSchool_key(board.getSchool_key());
        askSolPK.setField(board.getField());
        askSolPK.setBno(board.getBno());

        AskSolEntity askSol = new AskSolEntity(
                askSolPK,
                board.getQuestion(),
                board.getAnswer(),
                board.getEmail(),
                board.getName(),
                board.getAskDate(),
                null,
                0
        );

        save(askSol);
    }

    @Transactional
    public void updateSol(SolveVO solveVO){
        AskSolEntity askSol = findOne(solveVO.getSchool_key(),
                solveVO.getField(), solveVO.getBno());

        askSol.setAnswer(solveVO.getAnswer());
        askSol.setAnswerDate(solveVO.getAnswerDate());
        askSol.setIsAnswered(1);

        save(askSol);

        log.info("Update Question Board: " + askSol.getClass() + " -> " + askSol);
    }

    public AskSolEntity findOne(long school_key, String field, long bno){
        PushLogAskSolPK pk = new PushLogAskSolPK();
        pk.setSchool_key(school_key);
        pk.setField(field);
        pk.setBno(bno);

        return em.find(AskSolEntity.class, pk);
    }

    public List<AskSolEntity> findAll(){
        return em.createQuery("select askSol from ask_sol askSol", AskSolEntity.class)
                .getResultList();
    }

    public List<AskSolEntity> unsolvedAll(){
        List<AskSolEntity> rtList = em.createQuery("select askSol from ask_sol askSol where askSol.isAnswered=0", AskSolEntity.class)
                .getResultList();
        log.info("AskSol Repository unsolved all: " + rtList.getClass() + " -> " + rtList);
        return rtList;
    }

    public List<AskSolEntity> solvedAll(){
        return em.createQuery("select askSol from ask_sol askSol where askSol.isAnswered=1", AskSolEntity.class)
                .getResultList();
    }

    public AskSolEntity findByBno(long bno){
        AskSolEntity askSol = em.createQuery("select askSol from ask_sol askSol where askSol.pks.bno = :bno", AskSolEntity.class)
                .setParameter("bno", bno)
                .getSingleResult();

        log.info("AskSol Repository find by bno: " + askSol.getClass() + " -> " + askSol);

        return askSol;
    }

    public long maxBno(){
        return em.createQuery("select MAX(askSol.bno) from ask_sol askSol", long.class)
                .getSingleResult();
    }
}
