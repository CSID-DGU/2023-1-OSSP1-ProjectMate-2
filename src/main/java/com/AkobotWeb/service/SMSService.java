package com.AkobotWeb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Base64;

public class SMSService {
    private final static String apiUrl = "https://sslsms.cafe24.com/smsSenderPhone.php";
    private final static String userAgent = "Mozilla/5.0";
    private final static String charset = "UTF-8";
    private final static boolean isTest = true;

    public void dealingSMS(String str) {
        try {
            // parameter로 관련 토큰을 보냄
            URL obj = new URL(apiUrl);
            HttpURLConnection con = null;
            try {
                con = (HttpURLConnection) obj.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Accept-Charset", charset);
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", userAgent);

            String postParams = "userId=ajchoi9709&passwd=" + str;
            // test 모드일 때 SMS 발송 NONO
            /*if (isTest) {
                postParams += "&testflag" + base64Util.base64Encode("Y");
            }*/

            // For POST only - START
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(postParams.getBytes());
            os.flush();
            os.close();
            // For POST only - END

            int responseCode = con.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer buf = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    buf.append(inputLine);
                }
                in.close();
                System.out.print(buf.toString());
            } else {
                System.out.println("POST request not worked");
            }
        } catch (IOException ex) {

        }
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
    public static String base64Encode(String str)  throws java.io.IOException {
        Base64.Encoder encoder = null;
        byte[] strByte = str.getBytes();
        String result = encoder.encode(strByte).toString();
        return result ;
    }



}
