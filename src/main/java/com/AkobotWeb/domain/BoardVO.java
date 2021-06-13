package com.AkobotWeb.domain;

/**
 * 게시판 Board의 기본 ValueObject
 * Junho Choi
 */

import com.google.cloud.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
    private Long bno;
    private String content;
    private String name;
    //private String phone;
    private String email;
    private Timestamp regDate;
}
