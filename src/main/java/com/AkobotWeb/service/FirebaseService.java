package com.AkobotWeb.service;

import com.AkobotWeb.domain.BoardVO;
import com.AkobotWeb.domain.SolveVO.SolveVO;
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

    /* bno 읽어와 bno 갱신한 새 도큐먼트 DB에 삽입*/
    public void add(BoardVO board) throws Exception;

    /* getBno*/
    public long getBno() throws Exception;

    /*
    * 해결질문게시판 관련
    * */
    /* 해결 질문 게시판 전체 조회 */
    public List<SolveVO> getSolveVO() throws Exception;

    /* 해결 질문 게시판 개별 조회 */
    public SolveVO readSolve(Long bno) throws Exception;

    /* 미해결 -> 해결 질문 게시판으로 처리 */
    public void migrate(Long bno) throws Exception;

}
