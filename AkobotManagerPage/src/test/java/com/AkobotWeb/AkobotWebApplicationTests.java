package com.AkobotWeb;

import com.AkobotWeb.domain.Mail.MailDTO;
import com.AkobotWeb.service.Email.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class AkobotApplicationTests {

    /* 이메일 전송 테스트 */
    @Autowired
    private MailService mailService;

    @Test
    public void testSendEmail() {

        MailDTO mailDTO = new MailDTO();
        mailDTO.setUserEmail("mandar2n09@gmail.com");
        mailDTO.setTitle("메일이 발송되었습니다");
        mailDTO.setMessage("공소화이팅");

        mailService.mailSend(mailDTO);

    }

}
