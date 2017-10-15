package it.melo;


import com.fasterxml.jackson.databind.ObjectMapper;
import it.melo.data.Account;
import it.melo.data.AccountChange;
import it.melo.data.Hold;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.management.RuntimeErrorException;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.time.Instant;
import java.util.Base64;
import java.util.List;

/**
 * Created by melo on 13/10/17.
 */
public class GdaxService {


    private static Mac mac;
    private final String baseaddress = "https://api.gdax.com/";
    private String apiKey;
    private String apiSecret;
    private String passPhrase;


    public GdaxService(String apiKey,String apiSecret, String passPhrase){
        this.apiKey=apiKey;
        this.apiSecret=apiSecret;
        this.passPhrase=passPhrase;

    }

    public List<Hold> getAccountHolds(String accountId){
        try {
            InputStream accountsInputStream = doHttp("accounts/"+accountId+"/holds","GET","");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(accountsInputStream,mapper.getTypeFactory().constructCollectionType(List.class, Hold.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<AccountChange> getAccountHistory(String accountId){
        try {
            InputStream accountsInputStream = doHttp("accounts/"+accountId+"/ledger","GET","");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(accountsInputStream,mapper.getTypeFactory().constructCollectionType(List.class, AccountChange.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> getAccounts(){
        try {
            InputStream accountsInputStream = doHttp("accounts","GET","");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(accountsInputStream,mapper.getTypeFactory().constructCollectionType(List.class, Account.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private InputStream doHttp(String endpoint, String method, Object requestBody) throws IOException {
        URL url = new URL(baseaddress + endpoint);

        URLConnection urlConnection = url.openConnection();
        if (!(urlConnection instanceof HttpsURLConnection)) {
            throw new RuntimeException(
                    "Custom Base URL must return javax.net.ssl.HttpsURLConnection on openConnection.");
        }
        HttpsURLConnection conn = (HttpsURLConnection) urlConnection;
        conn.setRequestMethod(method);
        setSecurity(conn, "/" + endpoint, "");
        String body = null;
        if (requestBody != null) {
            //  body = objectMapper.writeValueAsString(requestBody);
            conn.setRequestProperty("Content-Type", "application/json");
        }


        if (body != null) {
            conn.setDoOutput(true);
            OutputStream outputStream = conn.getOutputStream();
            try {
                outputStream.write(body.getBytes(Charset.forName("UTF-8")));
            } finally {
                outputStream.close();
            }

        }
        InputStream output;
        if (conn.getResponseCode() < 400) {
            output = conn.getInputStream();
        } else {
            output = conn.getErrorStream();
        }

    return output;

    }



    private void setSecurity(HttpsURLConnection connection,String endpoint, String body){
        String timestamp = Instant.now().getEpochSecond() + "";

        connection.setRequestProperty("accept", "application/json");
      //  connection.setRequestProperty("content-type", "application/json");
        connection.setRequestProperty("CB-ACCESS-KEY", apiKey); //api key
        String signature = generateSignature(endpoint, "GET", body, timestamp);
        connection.setRequestProperty("CB-ACCESS-SIGN", signature);
        connection.setRequestProperty("CB-ACCESS-TIMESTAMP", timestamp);
        connection.setRequestProperty("CB-ACCESS-PASSPHRASE", passPhrase); //passphrase

    }

    public String generateSignature(String requestPath, String method, String body, String timestamp) {
        try {
            String prehash = timestamp + method.toUpperCase() + requestPath + body;
            try {
                if (mac == null) mac = Mac.getInstance("HmacSHA256");
                //api secret
                byte[] base64secret = Base64.getDecoder().decode(apiSecret);

                mac.init(new SecretKeySpec(base64secret, "HmacSHA256"));
            } catch (Throwable t) {
                throw new IOException(t);
            }
            return Base64.getEncoder().encodeToString(mac.doFinal(prehash.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeErrorException(new Error("Cannot set up authentication headers."));
        }
    }

}
