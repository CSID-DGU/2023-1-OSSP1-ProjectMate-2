package com.AkobotWeb.controller;

/*
 *
 *
 * */

import com.AkobotWeb.domain.BoardVO;
import com.AkobotWeb.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class MainController {
    /*TODO Service 작성 */
    @Autowired
    private FirebaseService fbservice;

    /*TODO home.html을 기본페이지? 관습적으로 index.html을 기본페이지로 하는데..*/
    /* home.html 로그인 하기전 홈 화면(login 버튼 -> 클릭 시 login.html로 이동) */
   /* @GetMapping("/")
    public String home(){
        return "home";
    }
    *//* index.html..*/

    /*일단은 /home 요청해서 view 읽도록 함 */
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    /* 질문 게시판 */
    @GetMapping("/tables")
    public String tables(BoardVO boardVO, Model model) throws Exception {
        /* log 이용하는 방식으로 변경할 것*/
        /*System.out.println(boardVO);*/
        model.addAttribute("result", fbservice.getBoardVO());
        return "tables";
    }

    /* 질문 question 페이지 작성 */
    /* @GetMapping("/question")
    public String list() {
        return "questionDetail";
    }*/
    /* 0510 질문 상세 정보 조회*/
    @GetMapping("/questionDetail")
    public void read(long bno, Model model) throws Exception {
        //TODO log
        model.addAttribute("result", fbservice.read(bno));
    }


    /* Login.html —> bootstrap에 있던 로그인 페이지(일단 그대로 따옴)*/
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /* manual.html —> 아코봇 사용방법이 앞으로 등재될 페이지*/
    @GetMapping("/manual")
    public String manual() {
        return "manual";
    }

    /* 아코봇에서 미해결 질문 등록하는 페이지*/
    @GetMapping("/ask")
    public String ask(){
        return "ask";
    }

    /* 아코봇을 띄워주는 가상 동국대 입학처 페이지 연결*/
    @GetMapping("/dongguk")
    public String dongguk(){
        return "dongguk";
    }

}
