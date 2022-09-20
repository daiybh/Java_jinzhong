package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class MyHttp {

    public static String jsonStr =

            "{\r\n  \"appId\": \"871cefbed55c43a9bc14ca81a7e4e49a\",\r\n  \"comCode\": \"1407810004\",\r\n  \"manufacturerUniqueCode\": \"9874c789b3c143a2b130122a7a96125a\",\r\n  \"sign\": \"0bca6e75b7a54e06a071171f76c19e0f56e77853f67560e986fb5d112001f0de\"\r\n}";
    static String postTokenUrl = "http://192.168.203.187:8092/company/supervision/enterpriseApi/token";// put in your
    static String post32URL = "http://192.168.203.187:8092/company/supervision/enterpriseApi/getAlarmInfo";

    public static String postAPI32(String body) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost request = new HttpPost(post32URL);
            StringEntity postingString = new StringEntity(body);
            request.addHeader("content-type", "application/json");
            request.setEntity(postingString);
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entityOne = response.getEntity();

            {
                String result = EntityUtils.toString(entityOne);
                System.out.println("远程返回\n" + result);
                return result;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            // @Deprecated httpClient.getConnectionManager().shutdown();
        }
        return "";
    }

    public static Token getToken() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost request = new HttpPost(postTokenUrl);
            StringEntity postingString = new StringEntity(jsonStr);
            request.addHeader("content-type", "application/json");
            request.setEntity(postingString);
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entityOne = response.getEntity();

            {
                String result = EntityUtils.toString(entityOne);
                System.out.println("EntityUtils\n" + result);
                // CONVERT RESPONSE STRING TO JSON ARRAY
                JSONObject jsonObj = new JSONObject(result);
                // System.out.println(jsonObj.getString("msg"));
                // System.out.println(jsonObj.getInt("code"));
                JSONObject dataObj = jsonObj.getJSONObject("data");
                String aceSecret = (dataObj.getString("aceSecret"));
                String token = (dataObj.getString("token"));
                // String sign = (jsonObj.getString("sign"));
                Token a = new Token();
                a.screct = aceSecret;
                a.token = token;
                return a;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            // @Deprecated httpClient.getConnectionManager().shutdown();
        }
        return null;
    }

}
