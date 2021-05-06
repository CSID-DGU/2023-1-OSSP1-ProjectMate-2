package com.AkobotWeb.service;

import com.AkobotWeb.domain.BoardVO;
import com.google.api.core.ApiFuture;
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
    BoardVO boardVO = null;

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

    /* 0503 */
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
}
