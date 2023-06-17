package com.akobot.domain.tables;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="earlyadmission")
public class EarlyAdmissionEntity {
    @EmbeddedId
    private PushLogIntentsPK pks;

    @Column(name="condition_text", length=2000)
    private String condition_text;

    @Column(name="point", length=2000)
    private String point;

    @Column(name="test", length=2000)
    private String test;

    @Column(name="else_data", length=1000)
    private String elseData;

    @Column(name="level")
    private int level;

    @Column(name="fname")
    private String fname;

    @Column(name="dname")
    private String dname;
}
