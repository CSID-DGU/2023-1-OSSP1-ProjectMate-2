package com.AkobotWeb.controller;

/*
 *
 *
 * */

import com.AkobotWeb.domain.BoardVO;
import com.AkobotWeb.service.FirebaseService;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/*")
public class MainController {
    /*TODO Service 작성 */
    @Autowired
    private FirebaseService fbservice;

    /*TODO list페이지 작성*/
    @GetMapping("/tables")
    public String tables(BoardVO boardVO, Model model) throws Exception {
        /* log 이용하는 방식으로 변경할 것*/
        /*System.out.println(boardVO);*/
        model.addAttribute("result", fbservice.getBoardVO());
        return "tables";
    }

    /*TODO 질문 question 페이지 작성*/
    @GetMapping("/question")
    public String list() {
        return "questionDetail";
    }

    /*TODO Home.html 로그인 하기전 홈 화면(login 버튼 -> 클릭 시 login.html로 이동) */
    @GetMapping("/home")
    public String home(){
        return "Home";
    }
    /*TODO Login.html —> bootstrap에 있던 로그인 페이지(일단 그대로 따옴)*/
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    /*TODO Manual.html —> 아코봇 사용방법이 앞으로 등재될 페이지*/
    @GetMapping("/manual")
    public String manual(){
        return "Manual";
    }

}
