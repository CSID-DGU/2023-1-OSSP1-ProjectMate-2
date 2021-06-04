<%@ page language="java" import="java.util.*, java.security.*, java.io.*, java.net.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.net.*" %>
<%@ page import="java.io.*" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    try {
        String apiUrl =  "https://sslsms.cafe24.com/smsSenderPhone.php";
        String userAgent = "Mozilla/5.0";
        String postParams = "userId=ajchoi9709&passwd=31e2e5d46e1e2059449efe64cde0693d";  // 인증키 필수
        URL obj = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", userAgent);

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
            out.print(buf.toString());
        } else {
            out.println("POST request not worked");
        }
    } catch(IOException ex){

    }
%>
