package com.AkobotWeb.domain.DB.tables;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="test")
public class TestEntity {
    @EmbeddedId
    private PushLogIntentsPK pks;

    @Column(name="method", length=1000)
    private String method;

    @Column(name="target", length=1000)
    private String target;

    @Column(name="elseData", length=1000)
    private String elseData;

    @Column(name="level")
    private int level;
}
