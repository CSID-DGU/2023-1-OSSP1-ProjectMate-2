package com.AkobotWeb.controller;

/*
 *
 *
 * */

import com.AkobotWeb.config.auth.LoginUser;
import com.AkobotWeb.config.auth.dto.SessionUser;
import com.AkobotWeb.domain.BoardVO;
import com.AkobotWeb.service.FirebaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@RequestMapping("/*")
public class MainController {
    /*TODO Service 작성 */
    @Autowired
    private FirebaseService fbservice;
    private final HttpSession httpSession;


    /* 로그인 전이라면 로그인하라하고, 로그인하면 구글 로그인 정보 보여줌 */
    @GetMapping("/")
    public String index(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
            model.addAttribute("userImg",user.getPicture());
        }
        return "index";
    }
    /**
    *   중복코드 최소화 하는 방법이지만, NULL EXCEPTION 이 일어남..
    public String index(Model model, @LoginUser SessionUser user) {
        // .............
        // 사용자 정보: 위의 @LoginUser 어노테이션으로 대체
        // SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userImg", user.getPicture());
        }
        return "index";
    }*/

    /*일단은 /home 요청해서 view 읽도록 함 -> index.html을 기본으로 */
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    /* 질문 게시판 */
    @GetMapping("/tables")
    public String tables(BoardVO boardVO, Model model) throws Exception {
        /* 세션 정보 */
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
            model.addAttribute("userImg",user.getPicture());
        }
        /* log 이용하는 방식으로 변경할 것*/
        /*System.out.println(boardVO);*/
        model.addAttribute("result", fbservice.getBoardVO());
        return "tables";
    }

    /* DB 관리 게시판*/
    @GetMapping("/manage")
    public String manage(BoardVO boardVO, Model model) throws Exception {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
            model.addAttribute("userImg",user.getPicture());
        }
        /* log 이용하는 방식으로 변경할 것*/
        /*System.out.println(boardVO);*/
        /*model.addAttribute("result", fbservice.getBoardVO());*/
        return "manage";
    }

    /* 0510 질문 상세 정보 조회*/
    @GetMapping("/questionDetail")
    public void read(long bno, Model model) throws Exception {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
            model.addAttribute("userImg",user.getPicture());
        }
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
    public String manual(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
            model.addAttribute("userImg",user.getPicture());
        }
        return "manual";
    }

    /* 아코봇에서 미해결 질문 등록하는 페이지*/
    @GetMapping("/ask")
    public String ask() {
        return "ask";
    }

    /* 아코봇을 띄워주는 가상 동국대 입학처 페이지 연결*/
    @GetMapping("/dongguk")
    public String dongguk() {
        return "dongguk";
    }

    /* 질문 사용자가 직접 등록*/
    @PostMapping("/add")
    public String add(BoardVO board) throws Exception {
        fbservice.add(board);
        /*rttr.addFlashAttribute("bno" , board.getBno());*/
        return "redirect:dongguk"; // dongguk으로 redirect
    }

    /* SMS 등록 처리*/

}
