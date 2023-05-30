package com.AkobotWeb.domain.DB.tables;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class PushLogIntentsPK implements Serializable {
    @Column(name="school_key")
    private Long school_key;

    @Column(name="field", length=50)
    private String field;

    @Column(name="document", length=50)
    private String document;
}
