/*
package com.AkobotWeb.service;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Util {
    */
/**
     * 베이스64 인코딩 처리
     *
     * @param content 인코딩할 문자열
     * @return 인코딩된 문자열
     *//*

    public static String encode(String content) {
        Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode(content.getBytes());
        return new String(encodedBytes);
    }

    */
/**
     * 베이스64 디코딩 처리
     *
     * @param encodedContent 인코딩된 문자열
     * @return 디코딩으로 원복된 문자열
     *//*

    public static String decode(String encodedContent) {
        Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(encodedContent));
    }

    // 테스트용 메인 함수
    public static void main(String[] args) {
        String content = "abcdefghijklmnop";
        String encodedContent = Base64Util.encode(content);
        String decodedContent = Base64Util.decode(encodedContent);

        System.out.println("Encoded string: " + encodedContent);
        System.out.println("Decoded string: " + decodedContent);
    }

}
}
*/
