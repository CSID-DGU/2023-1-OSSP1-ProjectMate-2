package com.akobot.domain.tables;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Entity(name = "ask_sol")
@EntityListeners(AuditingEntityListener.class)
public class AskSolEntity implements Persistable<PushLogAskSolPK> {
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
    //@CreationTimestamp
    private ZonedDateTime askDate;

    @Column(name = "answer_date")
    //@UpdateTimestamp
    private ZonedDateTime answerDate;

    @Column(name = "is_answered")
    private int isAnswered;

    @Override
    public PushLogAskSolPK getId(){
        return pks;
    }

    @Override
    public boolean isNew() {
        return askDate == null;
    }

    @Override
    public String toString(){
        return "school_key=" + getPks().getSchool_key() +
                ", field=" + getPks().getField() +
                ", bno=" + getPks().getBno() +
                ", question=" + getQuestion() +
                ", answer=" + getAnswer() +
                ", email=" + getEmail() +
                ", name=" + getName() +
                ", askDate=" + getAskDate() +
                ", answerDate=" + getAnswerDate() +
                ", isAnswered=" + getIsAnswered();
    }
}
