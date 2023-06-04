package com.akobot.domain.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class PushLogAskSolPK implements Serializable {
    @Column(name="school_key")
    private long school_key;

    @Column(name="field", length=50)
    private String field;

    @Column(name="bno", length=50)
    private long bno;
}
