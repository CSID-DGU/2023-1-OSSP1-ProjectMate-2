package com.akobot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.akobot.domain.*;
import com.akobot.service.FirebaseService;

import java.util.ArrayList;

@Controller
public class GreetingController {
    @Autowired
    private FirebaseService fbservice;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ArrayList<AnswerDTO> greeting(AskDTO ask) throws Exception {
        Thread.sleep(1000); // simulated delay
        return fbservice.getAnswer(ask);
    }

}