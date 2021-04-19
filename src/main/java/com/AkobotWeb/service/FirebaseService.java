package com.AkobotWeb.service;

import com.AkobotWeb.domain.BoardVO;

public interface FirebaseService {

    /*TODO 좀 더 정밀하게 */
    public String add(BoardVO board) throws Exception;
    public BoardVO getMemberDetail(String id) throws Exception;

}
