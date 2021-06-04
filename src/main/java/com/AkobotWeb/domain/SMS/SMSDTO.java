package com.AkobotWeb.domain.SMS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SMSDTO {
    private String msg;
    private String rphone;
    private String sphone1; // 보내는 번호 010
    private String sphone2; // 보내는 번호 000
    private String sphone3; // 보내는 번호 0000
    private String testflag;
    private String smsType;

}
