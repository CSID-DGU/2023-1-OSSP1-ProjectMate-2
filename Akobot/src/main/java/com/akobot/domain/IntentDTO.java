package com.akobot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntentDTO {
    private long level;
    private String elseData;
    private String link;
    private String point;
    private String condition;
    private String test;
    private String target;
}
