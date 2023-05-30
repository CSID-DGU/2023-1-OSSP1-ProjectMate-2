package com.AkobotWeb.Query.Dummy;

import com.AkobotWeb.domain.BoardVO;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Dummy Data 를 insert하기 위한 클래스
 * 2021-05-11 Junho Choi
 */
/*@Service
public class InsertDummy  {
    public static final String COLLECTION_NAME = "TBL_DUMMY"; // cloud firestore의 collection name

    Firestore firestore;

    public void insertDummy(){
        firestore= FirestoreClient.getFirestore();
        for(int i=1; i<1000; i++){
            BoardVO boardVO = new BoardVO(Integer.toUnsignedLong(i),"dummy content","dummy","example@akobot.com", ZonedDateTime.now(ZoneId.of("Asia/Seoul")));
            ApiFuture<DocumentReference> future = firestore.collection(COLLECTION_NAME).add(boardVO);
        }
        System.out.println("Done");
    }

}
*/