package com.AkobotWeb.service.Email;

import com.AkobotWeb.config.propertiesConfig.PropertyUtil;
import com.AkobotWeb.domain.Mail.MailDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class MailService {
    private JavaMailSender javaMailSender;

    private static final String FROM_ADDRESS = PropertyUtil.getProperty("spring.mail.username");

    public void mailSend(MailDTO mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setFrom(FROM_ADDRESS);
            message.setTo(mailDto.getUserEmail());
            message.setSubject(mailDto.getTitle());
            message.setText(mailDto.getMessage());
            javaMailSender.send(message);
        } catch (Exception e) {
            log.info("ERROR : MailService.java" + e.getMessage());
        }

    }

    /**
     *  FUTURE WORK - ATTACHMENT
     *  */
    /*public void attachSend(MailDTO mailDTO) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessage(message, true, "UTF-8");

            messageHelper.setFrom(FROM_ADDRESS);
            messageHelper.setTo(mailDTO.getUserEmail());
            messageHelper.setSubject(mailDTO.getTitle());
            messageHelper.setText(mailDTO.getMessage());

            // 파일 첨부 처리
            MimeBodyPart mbp = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(filename);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }*/
}
