package com.AkobotWeb.service;

import com.AkobotWeb.domain.BoardVO;
import com.google.cloud.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public interface FirebaseService {


    public BoardVO getMemberDetail(String id) throws Exception;

    /* 0503 게시판 테이블 가져오기 */
    public List<BoardVO> getBoardVO() throws Exception;

    /* 0510 insert*/
    public Long insert(BoardVO board) throws Exception;

    /* 0510 questionDetails 질문 등록된 내용 가져옴*/
    public BoardVO read(Long bno) throws Exception;


    /**
     * 테스트 관련
     * */
    /* 0510 make Dummy Collections */
    public void mkDummy() throws Exception;

    /*TODO 좀 더 정밀하게 */
    public void add(BoardVO board) throws Exception;

    /* getBno*/
    public long getBno() throws Exception;
}
