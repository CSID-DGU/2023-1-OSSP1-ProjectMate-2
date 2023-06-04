package com.AkobotWeb.domain.SolveVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolveVO {
    private long school_key;
    private String field;
    private Long bno;
    private String content;
    private String name;
    //private String phone;
    private String answer;
    private ZonedDateTime answerDate;
}
