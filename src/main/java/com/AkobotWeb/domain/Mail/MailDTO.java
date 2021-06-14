package com.AkobotWeb.domain.Mail;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDTO {
    private String userEmail;
    private String title;
    private String message;
}
