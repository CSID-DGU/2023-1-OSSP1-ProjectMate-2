package com.AkobotWeb.service.SMS;

import com.AkobotWeb.config.propertiesConfig.PropertyUtil;
import com.AkobotWeb.domain.SMS.SMSDTO;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Base64;

@Slf4j
public class SMSService {


    //private final static String apiUrl = "https://sslsms.cafe24.com/smsSenderPhone.php";
    private final static String apiUrl = "https://sslsms.cafe24.com/sms_sender.php";
    private final static String userAgent = "Mozilla/5.0";
    private final static String charset = "UTF-8";
    private final static boolean isTest = true;

    public int dealingSMS(SMSDTO smsdto) {
        int responseCode = 0;  // HTTP_OK 200 를 리턴하고자 하는 의도
        try {
            // parameter로 관련 토큰을 보냄
            URL obj = new URL(apiUrl);
            HttpURLConnection con = null;
            String key="";
            try {
                con = (HttpURLConnection) obj.openConnection();
            } catch (IOException e) {
                log.info("HTTPURLConnection오류");
            }
            try {
                key = PropertyUtil.getProperty(/*"sms.key"*/"31e2e5d46e1e2059449efe64cde0693ds");
            } catch (Exception e) {
                log.info("SMS 전송 관련 서비스 키 오류");
            }
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Accept-Charset", charset);
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", userAgent);

            log.info(key);
            log.info(smsdto.toString());

            String postParams =
                            "user_id=" + base64Encode("ajchoi9709")
                            + "&secure=" + base64Encode(key)
                            + "&msg=" + base64Encode(smsdto.getMsg())
                            + "&rphone=" + base64Encode(smsdto.getRphone())
                            + "&sphone1=" + base64Encode(smsdto.getSphone1())
                            + "&sphone2=" + base64Encode(smsdto.getSphone2())
                            + "&sphone3=" + base64Encode(smsdto.getSphone3())
                            + "&mode=" + base64Encode("1")
                            + "&smsType=" + base64Encode(smsdto.getSmsType());

            log.info("postParams 확인 " + postParams);

            // test 모드일 때 SMS 발송 NONO
            if (smsdto.getTestflag().equals("Y")) {
                postParams += "&testflag" + base64Encode("Y");
                log.info("테스트 모드 입니다");
            }else{
                log.info("실제 발송 모드입니다.");
            }

            // For POST only - START
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(postParams.getBytes());
            os.flush();
            os.close();
            // For POST only - END

            responseCode = con.getResponseCode();
            log.info("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer buf = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    buf.append(inputLine);
                }
                in.close();
                log.info("SMS 전송 성공");
                //log.info("SMS Content : " +buf.toString());
            } else {
                log.info("POST request not worked");
            }
        } catch (IOException ex) {
            log.info("SMS Service has an IOException : " + ex.getMessage());
        }
        return responseCode;
    }

    public static String nullcheck(String str, String Defaultvalue) throws Exception {
        String ReturnDefault = "";
        if (str == null) {
            ReturnDefault = Defaultvalue;
        } else if (str == "") {
            ReturnDefault = Defaultvalue;
        } else {
            ReturnDefault = str;
        }
        return ReturnDefault;
    }

    public static String base64Encode(String str) throws IOException {
        //0613 테스트
        /* base64 encoding */
        byte[] encodedBytes = Base64.getEncoder().encode(str.getBytes()); /* base64 decoding */
        byte[] decodedBytes = Base64.getEncoder().encode(encodedBytes);
        /*Base64.encodeBase encoder = null;
        byte[] strByte = str.getBytes();
        assert encoder != null;
        String result = encoder.encode(strByte).toString();*/
        //System.out.println(new String(encodedBytes));

        return new String(encodedBytes);
    }

}
