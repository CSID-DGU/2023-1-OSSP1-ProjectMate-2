package com.AkobotWeb.domain.Mail;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDTO {
    private String userEmail;
    private String title;
    private String message;
}
