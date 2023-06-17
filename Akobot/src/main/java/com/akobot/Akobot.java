package com.akobot;

import com.akobot.service.MySqlService;
import com.akobot.service.MySqlServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.processing.Processor;
import java.io.IOException;

@SpringBootApplication
@RequiredArgsConstructor
public class Akobot {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Akobot.class, args);
    }
}