package com.AkobotWeb.domain.SMS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SMSDTO {
    private String smsType;
    private String subject;
    private String msg;
    private String rphone;
    private String destination; // 필요없을듯
    private String sphone; // 보내는 번호
    private String rdate; //
    private String rtime;
    private String returnurl;
    private String testflag;
    private String nointeractive;
    private String repeatFlag;
}
