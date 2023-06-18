package com.AkobotWeb.controller;

import com.AkobotWeb.domain.BoardVO;
import com.AkobotWeb.service.MySqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Rest Controller
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    MySqlService mySqlService;

    /*@GetMapping("/getMemberDetail")
    public BoardVO getMemberDetail(@RequestParam String name) throws Exception {
        return mySqlService.getMemberDetail(name);
    }*/

    /* mk dummy */
    /*@GetMapping("/mkDummy")
    public void mkDummy() throws Exception {
        mySqlService.mkDummy();
    }*/

    /* 질문 사용자가 직접 등록*/
    /*@RequestMapping("/add")
    public String add(BoardVO board) throws Exception {
        firebaseService.add(board);
        *//*rttr.addFlashAttribute("bno" , board.getBno());*//*
        *//*return "redirect:/ask";*//*
        return "redirect:dongguk";
    }*/

    private final UserRepository userRepository;

    public RestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/checkPassword")
    public Map<String, Object> checkPassword(@RequestBody Map<String, String> requestBody) {
        String password = requestBody.get("password");
        boolean correct = userRepository.existsById(password);

        Map<String, Object> response = new HashMap<>();
        response.put("result", correct);

        return response;
    }

}
