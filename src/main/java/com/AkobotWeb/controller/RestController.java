package com.AkobotWeb.controller;

import com.AkobotWeb.domain.BoardVO;
import com.AkobotWeb.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Rest Controller
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/add")
    public String add(@RequestParam BoardVO board) throws Exception{
        return firebaseService.add(board);
    }

    @GetMapping("/getMemberDetail")
    public BoardVO getMemberDetail(@RequestParam String name) throws Exception{
        return firebaseService.getMemberDetail(name);
    }


}
