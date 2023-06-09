package com.AkobotWeb.domain.DB.tables;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="ksat")
public class KsatEntity {
    @EmbeddedId
    private PushLogIntentsPK pks;

    @Column(name="condition_text", length=1000)
    private String condition_text;

    @Column(name="point", length=1000)
    private String point;

    @Column(name="else_data", length=1000)
    private String elseData;

    @Column(name="level")
    private int level;
}
