package com.AkobotWeb.domain.DB;

import com.AkobotWeb.domain.DB.tables.PushLogIntentsPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntentDTO {
    private PushLogIntentsPK pks;

    private String method;
    private String target;
    private String content;
    private String condition_text;
    private String point;
    private String test;
    private String elseData;
    private int level;
}
