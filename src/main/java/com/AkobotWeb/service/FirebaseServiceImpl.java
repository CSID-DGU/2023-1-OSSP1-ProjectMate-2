package com.AkobotWeb.service;

import com.AkobotWeb.domain.BoardVO;
import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FirebaseServiceImpl implements FirebaseService {
    /*public static final String COLLECTION_NAME="BOARD"; // cloud firestore의 collection name*/
    public static final String COLLECTION_NAME = "TBL_BOARD"; // cloud firestore의 collection name

    Firestore firestore;

    @Override
    public String add(BoardVO board) throws Exception {
        firestore = FirestoreClient.getFirestore();
        ApiFuture<com.google.cloud.firestore.WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document(board.getName()).set(board);
        return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public BoardVO getMemberDetail(String name) throws Exception {
        firestore = FirestoreClient.getFirestore();
        DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(name);
        ApiFuture<DocumentSnapshot> apiFuture = docRef.get();
        DocumentSnapshot docShot = apiFuture.get();
        BoardVO member = null;
        if (docShot.exists()) {
            member = docShot.toObject(BoardVO.class);
            return member;
        } else {
            return null;
        }
    }

    /* 0503 질문 게시글 전체 조회 기능 구현 */
    @Override
    public List<BoardVO> getBoardVO() throws Exception {
        /*System.out.println("getboard");*/
        List<BoardVO> list = new ArrayList<BoardVO>();
        firestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future = firestore.collection(COLLECTION_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            // logger 이용하는 방식으로 바꿔주기
            /*System.out.println(document.getId() + " -> "+ document.toObject(BoardVO.class));*/
            list.add(document.toObject(BoardVO.class));
        }

        return list;
    }

    /* TODO 0510 */
    @Override
    public Long insert(BoardVO board) throws Exception {


        return 1L;
    }

    /* 0510 질문 상세 페이지 조회 구현 */
    @Override
    public BoardVO read(Long bno) throws Exception {
        firestore = FirestoreClient.getFirestore();
        BoardVO boardVO;
        // Create a reference to the collection
        CollectionReference ref = firestore.collection(COLLECTION_NAME);

        // Create a query against the collection.
        Query query = ref.whereEqualTo("bno", bno);

        // retrieve  query results asynchronously using query.get()
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        DocumentSnapshot document = querySnapshot.get().getDocuments().get(0); // 리스트의 0번쨰 요소를 가져오도록

        boardVO = document.toObject(BoardVO.class);

        /* TODO log */
        /*System.out.println(boardVO.toString());*/

        return boardVO;
    }

    /* 0510 mkDummy */
    @Override
    public void mkDummy(){
        firestore= FirestoreClient.getFirestore();
        for(int i=1; i<1000; i++){
            BoardVO boardVO = new BoardVO(Integer.toUnsignedLong(i),"dummy content","dummy", Timestamp.now());
            ApiFuture<DocumentReference> future = firestore.collection("TBL_DUMMY").add(boardVO);
        }
        System.out.println("Done");
    }
}
