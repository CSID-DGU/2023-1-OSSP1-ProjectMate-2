package com.akobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Akobot {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(Akobot.class, args);
    }
}