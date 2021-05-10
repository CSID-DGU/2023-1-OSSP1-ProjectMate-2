package com.AkobotWeb.domain;

/**
 * 게시판 Board의 기본 ValueObject
 * Junho Choi
 */

import com.google.cloud.Timestamp;
import lombok.Builder;
import lombok.Data;

@Data
public class BoardVO {
    private Long bno;
    private String content;
    private String name;
    private Timestamp regDate;
}
