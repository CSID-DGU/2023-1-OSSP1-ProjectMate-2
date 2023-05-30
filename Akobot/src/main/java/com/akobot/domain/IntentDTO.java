package com.akobot.domain;

import com.akobot.domain.tables.PushLogPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntentDTO {
    /*
    private int school_key;
    private String field;
    private String document;
    */
    private PushLogPK pks;

    private String method;
    private String target;
    private String content;
    private String condition_text;
    private String point;
    private String test;
    private String elseData;
    private int level;
}
