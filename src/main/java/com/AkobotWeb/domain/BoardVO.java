package com.AkobotWeb.domain;

/**
 *  게시판 Board의 기본 ValueObject
 *  Junho Choi
 */

import lombok.Data;

@Data
public class BoardVO {
    private String name;
    private String phone;
    private String content;
}
