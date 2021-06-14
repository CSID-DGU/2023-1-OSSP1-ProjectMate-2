package com.AkobotWeb.service;

/**
 * Firebase 연동
 * 참고 문서
 * https://firebase.google.cn/docs/firestore/quickstart?hl=ko#java_1
 */

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.io.*;

@Service
public class FirebaseInitializer {
    @PostConstruct
    public void initialize() {
        /* 자체 서버에서 초기화 방식 */
        try {
            /*db 접근하는 json 파일의 위치 해당 json은 .gitignore 등록 필수*/
            //FileInputStream serviceAccount = new FileInputStream("./src/main/resources/serviceAccountKey.json");
            //FileInputStream serviceAccount = new FileInputStream("out/production/resources/serviceAccountKey.json");
           /* Resource resource = new ClassPathResource("serviceAccountKey.json");

            InputStream inputStream = resource.getInputStream();
            File temp = File.createTempFile("serviceAccountKey", ".json");
            Files.copy(inputStream, temp.toPath());
        */
            Resource resource = new ClassPathResource("serviceAccountKey.json");
            FileInputStream serviceAccount = new FileInputStream(convertToFile(resource.getInputStream()));

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public File convertToFile(InputStream is) throws IOException {
        File tempFile = File.createTempFile(String.valueOf(is.hashCode()), ".tmp");
        tempFile.deleteOnExit();

        try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            int read;
            byte[] bytes = new byte[1024];

            while ((read = is.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }

        return tempFile;
    }
}
