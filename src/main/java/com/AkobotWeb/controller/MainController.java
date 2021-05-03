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


}
