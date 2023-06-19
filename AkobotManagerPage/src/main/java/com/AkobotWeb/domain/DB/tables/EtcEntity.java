package com.AkobotWeb.domain.DB.tables;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
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
}
