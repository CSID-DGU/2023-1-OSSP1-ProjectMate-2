package com.akobot.controller;

import com.akobot.service.MySqlServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.akobot.domain.*;

import java.util.ArrayList;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GreetingController {
    private final MySqlServiceImpl mySqlService;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ArrayList<AnswerDTO> greeting(AskDTO ask) throws Exception {
        Thread.sleep(1000); // simulated delay

        return mySqlService.getAnswer(ask);
    }

}