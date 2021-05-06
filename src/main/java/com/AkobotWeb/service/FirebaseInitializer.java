package com.AkobotWeb.service;

/**
 * Firebase 연동
 * 참고 문서
 * https://firebase.google.cn/docs/firestore/quickstart?hl=ko#java_1
 */

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.tree.ExpandVetoException;
import java.io.FileInputStream;

@Service
public class FirebaseInitializer {
    @PostConstruct
    public void initialize() {
        /* 자체 서버에서 초기화 방식 */
        try {
            /*db 접근하는 json 파일의 위치 해당 json은 .gitignore 등록 필수*/
            FileInputStream serviceAccount =
                    new FileInputStream("./src/main/resources/serviceAccountKey.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
