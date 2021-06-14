package com.AkobotWeb.controller;

/*
 *
 *
 * */

import com.AkobotWeb.config.auth.dto.SessionUser;
import com.AkobotWeb.domain.BoardVO;
import com.AkobotWeb.domain.DB.UpdateDTO;
import com.AkobotWeb.domain.Mail.MailDTO;
import com.AkobotWeb.domain.SMS.SMSDTO;
import com.AkobotWeb.service.Email.MailService;
import com.AkobotWeb.service.FirebaseService;
import com.AkobotWeb.service.SMS.SMSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.net.HttpURLConnection;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/*")
public class MainController {
    /*TODO Service 작성 */
    @Autowired
    private FirebaseService fbservice;
    private final MailService mailService;
    private final HttpSession httpSession;


    /* 로그인 전이라면 로그인하라하고, 로그인하면 구글 로그인 정보 보여줌 */
    @GetMapping("/")
    public String firstpage() {
        return "firstpage";
    }
    //public String index(Model model){
      //  SessionUser user = (SessionUser) httpSession.getAttribute("user");
        //if(user != null){
          //  model.addAttribute("userName",user.getName());
            //model.addAttribute("userImg",user.getPicture());
        //}
        //return "index";

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
        long start = System.nanoTime();
        /* 세션 정보 */
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
            model.addAttribute("userImg",user.getPicture());
        }

        log.info("GET Request to tables.html : "+boardVO.toString());

        model.addAttribute("result", fbservice.getBoardVO());
        long end = System.nanoTime();
        log.info("Finished GET Request to solve.html --- " + (end-start)/1000000000.0+"sec");
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

        log.info("GET Request to manage.html : "+boardVO.toString());
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
        model.addAttribute("result", fbservice.read(bno));
        log.info("GET Request to questionDetail.html with parameters bno:"+ bno+ " model:"+model.toString());
    }

    /* 아코봇에서 해결 질문 처리 */
    @GetMapping("/solve")
    public String solve(BoardVO boardVO, Model model) throws Exception{
        long start = System.nanoTime();
        /* 세션 정보 */
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
            model.addAttribute("userImg",user.getPicture());
        }

        /*TODO 해결질문게시판 서비스 구성*/
        model.addAttribute("result", fbservice.getSolveVO());
        long end = System.nanoTime();
        log.info("Finished GET Request to solve.html --- " + (end-start)/1000000000.0+"sec");
        return "solve";
    }

    @GetMapping("/solvedDetail")
    public void solveRead(long bno, Model model) throws Exception {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
            model.addAttribute("userImg",user.getPicture());
        }
        /*TODO 해결 질문 게시판 조회 서비스 구성*/
        model.addAttribute("result", fbservice.readSolve(bno));
        log.info("GET Request to questionDetail.html with parameters bno:"+ bno+ " model:"+model.toString());
    }

    /* Login.html —> bootstrap에 있던 로그인 페이지(일단 그대로 따옴)*/
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userImg", user.getPicture());
        }
        return "index";
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

    @GetMapping("/how_answer")
    public String how_answer() {
        return "how_answer";
    }

    @GetMapping("/how_mangeDB")
    public String how_manageDB() {
        return "how_mangeDB";
    }

    @GetMapping("/how_notice_question")
    public String how_notice_question() {
        return "how_notice_question";
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

    /**
     * SMS 및 EMAIL 발신 처리
     *
     * */

    /* SMS 등록 처리 */
    @PostMapping("/smsService")
    public String sms(SMSDTO smsdto,long bno) throws Exception {
        log.info(smsdto.toString());
        log.info(String.valueOf(bno));

        SMSService smsService = new SMSService();
        if(smsService.dealingSMS(smsdto) == HttpURLConnection.HTTP_OK){ // HTTP STATUS OK : 200 일 때
            /*TODO 정상처리시 미해결 질문 게시판에서 해결 질문 게시판으로 옮기기*/
            fbservice.migrateSMS(smsdto, bno);
            log.info("답변 완료 - 미해결 질문 게시판에서 -> 해결 질문 게시판으로 이동 완료");
        }
        else{
            log.info("SMS 처리 실패");
        }

        return "redirect:tables";
    }
    /* E-Mail 등록 처리 */
    @PostMapping("/mailService")
    public String email(MailDTO mailDTO,long bno) throws Exception{
        log.info(mailDTO.toString());
        log.info(String.valueOf(bno));

        /* TODO EMAIL */
        try {
            mailService.mailSend(mailDTO);
            fbservice.migrateEmail(mailDTO, bno);
            log.info("답변 완료 - 미해결 질문 게시판에서 -> 해결 질문 게시판으로 이동 완료");
        }catch(Exception e){
            log.info("메일 발송 실패 : " + e.getMessage());
        }

        return "redirect:tables";
    }

    /* DB 관리자 챗봇 수정 처리*/
    @PostMapping("/updateDB")
    public String updateDB(UpdateDTO updateDTO) throws Exception {
        // TODO 파라미터 파싱
        String collection="";
        String doc="";
        log.info("DB update input: " +updateDTO.toString());
        String[] temp = updateDTO.getRadio_input().split("_");
        if(temp.length != 0 ){
            collection = temp[0];
            doc = temp[1];
        }
        // 호출
        fbservice.updateCB(collection, doc, updateDTO.getAnswer());
        return "redirect:solve";
    }
}
