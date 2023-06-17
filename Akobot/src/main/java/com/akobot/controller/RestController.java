package com.akobot.controller;

import com.akobot.domain.BoardVO;
import com.akobot.service.MySqlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/*")
public class RestController {
    @Autowired
    private MySqlService mySqlService;

    /* 아코봇에서 미해결 질문 등록하는 페이지*/
    @GetMapping("/ask")
    public String ask() {
        return "ask";
    }

    /* 질문 사용자가 직접 등록*/
    @PostMapping("/add")
    public String add(BoardVO board) throws Exception {
        mySqlService.add(board);
        return "redirect:http://localhost:8090/"; // 챗봇으로 redirect
    }
}
