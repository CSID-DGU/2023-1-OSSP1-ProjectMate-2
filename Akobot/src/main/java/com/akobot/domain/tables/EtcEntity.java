package com.akobot.domain.tables;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="etc")
public class EtcEntity {
    @EmbeddedId
    private PushLogIntentsPK pks;

    @Column(name="content", length=1000)
    private String content;

    @Column(name="else_data", length=1000)
    private String elseData;

    @Column(name="level")
    private int level;

    @Column(name="fname")
    private String fname;

    @Column(name="dname")
    private String dname;
}
