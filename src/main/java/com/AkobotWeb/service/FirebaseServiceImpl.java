package com.AkobotWeb.service;

import com.AkobotWeb.domain.BoardVO;
import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FirebaseServiceImpl implements FirebaseService {
    /*public static final String COLLECTION_NAME="TBL_BOARD"; // cloud firestore의 collection name*/
    public static final String COLLECTION_NAME = "TBL_ASK_DUMMY"; // cloud firestore의 collection name

    Firestore firestore;

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
        for(int i=1; i<=25; i++){
            BoardVO boardVO = new BoardVO(Integer.toUnsignedLong(i),"dummy content","dummy","010-0000-0000", Timestamp.now());
            ApiFuture<DocumentReference> future = firestore.collection(COLLECTION_NAME).add(boardVO);
        }
        System.out.println("Done");
    }

    @Override
    public void add(@ModelAttribute BoardVO board) throws Exception {

        /*firestore= FirestoreClient.getFirestore();
        firestore.collection(COLLECTION_NAME).get(
        CollectionReference ref = firestore.collection(COLLECTION_NAME);

        //현재 db의 bno max값을 가져온다
        Query query = ref.orderBy("bno", Query.Direction.DESCENDING).limit(0);

        long bno = query;
        // bno ++; 하고 새로운 BoardVO객체를 만들어서 전달한다.

        firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document(board.getName()).set(board);
        return apiFuture.get().getUpdateTime().toString();*/

        /* 마지막 bno을 읽어와 ++bno 값으로 새 도큐먼트를 DB에 삽입*/
        long bno = getBno();
        board.setBno(++bno);
        board.setRegDate(Timestamp.now());

        ApiFuture<DocumentReference> future = firestore.collection(COLLECTION_NAME).add(board);

    }

    @Override
    public long getBno() throws Exception {
        firestore= FirestoreClient.getFirestore();
        // Create a reference to the collection
        CollectionReference ref = firestore.collection(COLLECTION_NAME);

        // Create a query against the collection.
        Query query = ref.orderBy("bno", Query.Direction.DESCENDING).limit(1);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        DocumentSnapshot document = querySnapshot.get().getDocuments().get(0);
        return document.getLong("bno");
    }
}
