package com.AkobotWeb.service.Email;

import com.AkobotWeb.config.propertiesConfig.PropertyUtil;
import com.AkobotWeb.domain.Mail.MailDTO;
import com.sun.mail.util.logging.MailHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Slf4j
@Service
@AllArgsConstructor
public class MailService {
    private JavaMailSender javaMailSender;

    private static final String FROM_ADDRESS = PropertyUtil.getProperty("spring.mail.username");

    public void mailSend(MailDTO mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getUserEmail());
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());
        javaMailSender.send(message);
    }
}
