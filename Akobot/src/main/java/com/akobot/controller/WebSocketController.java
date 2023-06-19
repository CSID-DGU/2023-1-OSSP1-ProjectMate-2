package com.akobot.controller;

import com.akobot.service.MySqlServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.akobot.domain.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WebSocketController {
    private final MySqlServiceImpl mySqlService;

    @MessageMapping("/question")
    @SendTo("/topic/answers")
    public ArrayList<AnswerDTO> answering(AskDTO ask) throws Exception {
        //Thread.sleep(1000); // simulated delay
        log.info("AskDTO -> ", ask);
        mySqlService.generateDBBackUpFile();

        return mySqlService.getAnswer(ask);
    }

}