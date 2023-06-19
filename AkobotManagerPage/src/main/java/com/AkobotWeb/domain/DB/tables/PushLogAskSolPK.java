package com.AkobotWeb.domain.DB.tables;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
