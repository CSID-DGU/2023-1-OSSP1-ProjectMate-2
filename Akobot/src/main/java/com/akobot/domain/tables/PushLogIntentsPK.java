package com.akobot.domain.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class PushLogIntentsPK implements Serializable {
    @Column(name="school_key")
    private int school_key;

    @Column(name="field", length=50)
    private String field;

    @Column(name="document", length=50)
    private String document;
}
