package com.AkobotWeb;

import com.AkobotWeb.domain.Mail.MailDTO;
import com.AkobotWeb.service.Email.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class AkobotWebApplicationTests {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendEmail() {
        // 이메일 전송 테스트 코드 작성
        // emailService.sendEmail(...) 메소드 호출 및 검증
        MailDTO mailDTO = new MailDTO();
        mailDTO.setUserEmail("mandar2n09@gmail.com");
        mailDTO.setTitle("메일이 발송되었습니다");
        mailDTO.setMessage("공소화이팅");
        mailDTO.setFilename("D:/hi.txt"); // 첨부할 파일의 경로와 파일명을 설정해주세요

        mailService.attachSend(mailDTO);

    }

}
