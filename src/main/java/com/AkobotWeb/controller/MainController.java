package com.AkobotWeb.controller;

/*
*
*
* */

import com.AkobotWeb.domain.BoardVO;
import com.AkobotWeb.service.FirebaseService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class MainController {
    /*TODO Service 작성 */
    private FirebaseService fbservice;

    /*TODO list페이지 작성*/
    @GetMapping("/list")
    public String list(BoardVO board, Model model){

        return "list";
    }

    /*TODO 질문 ask 페이지 작성*/
    @GetMapping("/ask")
    public String list(){
        return "ask";
    }

}
