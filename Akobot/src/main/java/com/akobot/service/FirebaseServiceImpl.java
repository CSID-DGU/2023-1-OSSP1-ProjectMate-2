package com.akobot.service;

import com.akobot.domain.AnswerDTO;
import com.akobot.domain.AskDTO;
import com.akobot.domain.IntentDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FirebaseServiceImpl implements FirebaseService {

    public static final String COLLECTION_NAME = "users";
    public static final String DOCUMENT_NAME = "userA";
    Firestore firestore;

    @Override
    public ArrayList<AnswerDTO> getAnswer(AskDTO ask) throws Exception {
        firestore = FirestoreClient.getFirestore();
        ArrayList<AnswerDTO> answer = new ArrayList<>();

        String higherField = "";        // ex) competition, foreign, jungsi, ...
        String doc = "";                // ex) competition_susi, competition_jungsi, ...

        /* TODO
         * 전처리 모듈이 완성되기 전까지는 바로 firebase에 접근하여 답변 받아오는 형식으로..
         *  */
        
        // 임시로 ","를 기준으로 intent 분류
        String [] intents = ask.getAsk().split(",");
        
        for(String intent : intents) {
            String[] tmp = intent.split("_");
            if (tmp.length != 0) {
                higherField = tmp[0];
                doc = intent;
            }

            CollectionReference colRef = firestore.collection(COLLECTION_NAME);
            DocumentReference docRef = colRef.document(DOCUMENT_NAME);

            Query query = docRef.getParent().whereEqualTo(higherField, doc);

            ApiFuture<QuerySnapshot> querySnapshot = query.get();
            DocumentSnapshot document = querySnapshot.get().getDocuments().get(0);

            log.info(document.getId() + " -> " + document.toObject(AnswerDTO.class));
            answer.add(document.toObject(AnswerDTO.class));
        }

        return answer;
    }
}
