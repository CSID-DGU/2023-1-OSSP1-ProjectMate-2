package com.AkobotWeb.service;

import com.AkobotWeb.domain.BoardVO;
import com.google.cloud.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public interface FirebaseService {

    /*TODO 좀 더 정밀하게 */
    public String add(BoardVO board) throws Exception;

    public BoardVO getMemberDetail(String id) throws Exception;

    /* 0503 게시판 테이블 가져오기 */
    public List<BoardVO> getBoardVO() throws Exception;


    /* 0504 테스트*/

}
