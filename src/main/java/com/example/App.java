package com.example;

import org.json.JSONObject;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
    public static String GenenateSign(String stringText) {
        return org.apache.commons.codec.digest.DigestUtils.sha256Hex(stringText);
    }

    public static String objTOString(Object obj) {
        Gson gson = new Gson();

        return gson.toJson(obj);
    }

    static String comCode = "1407810004";

    public static void doAPI_fullEncrypt(String algm, String token, String AESKey) {
        try {
            System.out.println("\n\n######Begin#######  MyAESUtil.Encrypt \n\n");
            System.out.println(algm);
            String aesToken = MyAESUtil.Encrypt(algm, token, AESKey);
            getAlarmInfo gai = new getAlarmInfo();
            gai.comCode = comCode;
            gai.token = aesToken;

            gai.sign = GenenateSign(String.format("comCode%s", gai.comCode));

            String jsonData = objTOString(gai);

            System.out.println(jsonData);
            // String newSign = MyAESUtil.Encrypt(algm, obj.getString("sign"), AESKey);
            String enryptJsonData = MyAESUtil.Encrypt(algm, jsonData, AESKey);

            String addd = MyAESUtil.Decrypt(algm, enryptJsonData, AESKey);
            System.out.println("\naddd------------");
            System.out.println(addd);
            System.out.println("\n--------------------");
            JSONObject postJsonObj = new JSONObject();
            postJsonObj.put("comCode", comCode);

            // String text = MyAESUtil.Encrypt(aglm, obj.toString(), AESKey);

            postJsonObj.put("text", enryptJsonData);

            // 1 对每个字段值加密
            // 2 对所有加密

            System.out.println(postJsonObj.toString(1));

            System.out.println("\n\n######Begin#######  postAPI32 \n\n");

            // 构建 发送json

            MyHttp.postAPI32(postJsonObj.toString());
        } catch (Exception ex) {
            System.out.println("\n ALGM:" + algm + "\n\n");
            System.out.println(ex);
        }
    }

    public static void doAPI(String algm, String token, String AESKey) {
        System.out.println("\n-----------doAPI_fullEncrypt----------\n");
        doAPI_fullEncrypt(algm, token, AESKey);
        System.out.println("\n-----------doAPI_paramEncrypt----------\n");
        doAPI_paramEncrypt(algm, token, AESKey);
    }

    public static void doAPI_paramEncrypt(String algm, String token, String AESKey) {
        try {
            System.out.println("\n\n######Begin#######  MyAESUtil.Encrypt \n\n");
            System.out.println(algm);
            String aesToken = MyAESUtil.Encrypt(algm, token, AESKey);
            getAlarmInfo gai = new getAlarmInfo();
            gai.comCode = comCode;
            gai.token = aesToken;

            gai.sign = GenenateSign(String.format("comCode%s", gai.comCode));

            gai.token = MyAESUtil.Encrypt(algm, gai.token, AESKey);

            gai.sign = MyAESUtil.Encrypt(algm, gai.sign, AESKey);

            String jsonData = objTOString(gai);

            System.out.println(jsonData);
            // String newSign = MyAESUtil.Encrypt(algm, obj.getString("sign"), AESKey);
            // String enryptJsonData = MyAESUtil.Encrypt(algm, jsonData, AESKey);

            JSONObject postJsonObj = new JSONObject();
            postJsonObj.put("comCode", comCode);

            // String text = MyAESUtil.Encrypt(aglm, obj.toString(), AESKey);

            postJsonObj.put("text", jsonData);

            // 1 对每个字段值加密
            // 2 对所有加密

            System.out.println(postJsonObj.toString(1));

            System.out.println("\n\n######Begin#######  postAPI32 \n\n");

            // 构建 发送json

            MyHttp.postAPI32(postJsonObj.toString());
        } catch (Exception ex) {
            System.out.println("\n ALGM:" + algm + "\n\n");
            System.out.println(ex);
        }
    }

    public static void main(String[] args) throws Exception {

        String api32Json = "{\r\n  \"brakeCode\": \"1407810004A01\",\r\n  \"brakeStatus\": 0,\r\n  \"carDeviceStatus\": 0,\r\n  \"videoDeviceCode\": \"1407810004001\",\r\n  \"videoDeviceStatus\":0,\r\n  \"comCode\": \"1407810004\",\r\n  \"token\": \"//HLa/HOlFUWo2UtUvegsSOEVoQ2UwEBRHJ73+Fvk/TRX1ZK6K0VIc7CHgIok1uure/k3Uh1jHlZVkXZU8t8KvAH41F0lb1TvlAGFy5aJ5Ch9kZ7SdMiGqNbaoDYtjdcSQUni7G2y16sIJDV/Un3O/oCUGWoPqNRYSS9UFGi4Er3E35IU6/DYd/jYSHdRE3UBXBCV7qu18MSET7Vrj/uWHHoOBszN4RPh60B71ovg3bWG1A4oehbdVtzewAYUetE5JIDjG+ynWH1fqQkYdI90gYK39REhAu5yThev/nHBL3uEyUy6ClypWN5KDFjQ76iPy+emRyubA9M3rq65nobAoneepd0ppkfHSydwZUo+jQuxOuUIMtGupSzJodBvhHaXcuXAJ9JMkSnmOjYr3dTYEZoCKP1s4GC7CXIQwonmQ==\",\r\n  \"sign\": \"U2FsdGVkX19t2ullQmRxSLMRRZpAQXPr7zIU0b317M/QDxf24lkeGwhTUlIXPWf5cmteniZ5Dp6jvwU0zt3x9ByuyJsUE8SW/F9voa3JbKhHmBAxpNkSLdqK7hnEX80A\"\r\n}";

        // http获取token
        System.out.println("\n\n######Begin#######   get token\n\n");
        Token token = MyHttp.getToken();
        // System.out.println(token);
        // System.out.println("\n\n######Begin####### RSA Decrypt \n\n");
        // 解密RSA
        String ssss = "Mnr8ir4EH/WIQrb1zMKGiqz8CQgVRhCPGd7ADN5JEbR+SneoCNB/cSL9F3OlfEuSUPtfAIzvAct3ee3CV/Uw2QcoEC9/hFBCPx8tqYpmfCyM0hctHGAk8YEQhnpikJpW6vXd2z10sEa/OhH9CzFUkpKFALUXq+aOL/VFn75JAug=";

        String AESKey = MyRSA.decrypt(ssss);
        System.out.println("   AESKey\n" + AESKey);

        // AES 加密
        // System.out.println("Hello World!");
        // String encString = MyAESUtil.Encrypt("反正 与cuda 有关的程序 都有问题", AESKey);
        // System.out.println("加密后的字串是：" + encString);
        // String decString = MyAESUtil.Decrypt(encString, AESKey);
        //// System.out.println("解密后的字串是：" + decString);
        // AES/ECB/PKCS5Padding
        // doAPI("AES/CBC/NoPadding", token.token, AESKey);
        doAPI("AES/CBC/PKCS5Padding", token.token, AESKey);
        // doAPI("AES/ECB/NoPadding", token.token, AESKey);
        doAPI("AES/ECB/PKCS5Padding", token.token, AESKey);

        System.out.println("\n\n\n   ----------OVER------------ \n\n");
        // ObjectMapper m = new ObjectMapper();
        // API32 api32 = m.readValue(api32Json, API32.class);
        //
        // System.out.println(api32.getComCode());
        //
        // ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        // String json = ow.writeValueAsString(api32);
        // System.out.println(json);
    }
}
