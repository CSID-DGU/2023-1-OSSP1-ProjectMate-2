package com.AkobotWeb.domain.DB.tables;

import com.AkobotWeb.domain.BoardVO;
import com.AkobotWeb.domain.SolveVO.SolveVO;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="ask_sol")
public class AskSolEntity {
    @EmbeddedId
    private PushLogAskSolPK pks;

    @Column(name="question", length = 1000)
    private String question;

    @Column(name = "answer", length = 1000)
    private String answer;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "ask_date")
    @CreatedDate
    private ZonedDateTime askDate;

    @Column(name = "answer_date")
    private ZonedDateTime answerDate;

    @Column(name = "is_answered")
    private int isAnswered;

    public BoardVO toBoardVO(){
        BoardVO boardVO = new BoardVO();

        boardVO.setSchool_key(pks.getSchool_key());
        boardVO.setField(pks.getField());
        boardVO.setBno(pks.getBno());
        boardVO.setQuestion(question);
        boardVO.setAnswer(answer);
        boardVO.setEmail(email);
        boardVO.setName(name);
        boardVO.setAskDate(askDate);
        boardVO.setAnswerDate(answerDate);
        boardVO.setIsAnswered(isAnswered);

        return boardVO;
    }

    public SolveVO toSolveVO(){
        SolveVO solveVO = new SolveVO();

        solveVO.setSchool_key(pks.getSchool_key());
        solveVO.setField(pks.getField());
        solveVO.setBno(pks.getBno());
        solveVO.setContent(question);
        solveVO.setName(name);
        solveVO.setAnswer(answer);
        solveVO.setAnswerDate(answerDate);

        return solveVO;
    }
}
