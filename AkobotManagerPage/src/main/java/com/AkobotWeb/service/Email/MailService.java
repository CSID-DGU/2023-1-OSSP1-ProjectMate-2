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
     *  FUTURE WORK - ATTACHMENT - 파일 첨부 기능
     *  */
    /*public void attachSend(MailDTO mailDTO) {
        try {
            log.info("attachSend(MailDTO) -> set javamailSender");
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

            log.info("attachSend(MailDTO) -> Email receiver and title");
            messageHelper.setFrom(FROM_ADDRESS);
            messageHelper.setTo(mailDTO.getUserEmail());
            messageHelper.setSubject(mailDTO.getTitle());

            // 파일 첨부 처리
            log.info("attachSend(MailDTO) -> file handle 1");
            MimeMultipart multipart = new MimeMultipart();

            // 본문 내용 추가
            log.info("attachSend(MailDTO) -> set email body content");
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(mailDTO.getMessage());
            multipart.addBodyPart(textBodyPart);

            // 파일 첨부 처리
            log.info("attachSend(MailDTO) -> file handle 2");
            MimeBodyPart fileBodyPart = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(mailDTO.getFilename());
            fileBodyPart.setDataHandler(new DataHandler(fds));
            fileBodyPart.setFileName(fds.getName());
            multipart.addBodyPart(fileBodyPart);

            // 메일에 첨부 파일 추가
            log.info("attachSend(MailDTO) -> set file at email");
            message.setContent(multipart);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }*/
}