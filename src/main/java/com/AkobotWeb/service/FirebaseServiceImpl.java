package com.AkobotWeb.service;

import com.AkobotWeb.domain.BoardVO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
public class FirebaseServiceImpl implements FirebaseService {
    public static final String COLLECTION_NAME="TBL_BOARD"; // cloud firestore의 collection name

    @Override
    public String add(BoardVO board) throws Exception{
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<com.google.cloud.firestore.WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document(board.getName()).set(board);
        return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public BoardVO getMemberDetail(String name) throws Exception{
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference docRef=firestore.collection(COLLECTION_NAME).document(name);
        ApiFuture<DocumentSnapshot> apiFuture = docRef.get();
        DocumentSnapshot docShot = apiFuture.get();
        BoardVO member = null;
        if(docShot.exists()){
            member = docShot.toObject(BoardVO.class);
            return member;
        }else{
            return null;
        }
    }
}
