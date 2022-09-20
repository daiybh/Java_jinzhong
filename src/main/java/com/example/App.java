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

    public static String doPost(String url,String textData, String AESKey) {
        try {
            System.out.println(textData);
            String enryptJsonData = MyAESUtil.Encrypt("AES/ECB/PKCS5Padding", textData, AESKey);

            {
                // 验证 aes 加密
                String decryptJson = MyAESUtil.Decrypt("AES/ECB/PKCS5Padding", enryptJsonData, AESKey);
                if (decryptJson.compareTo(textData) != 0) {
                    System.out.printf("\n ********error  aes decrypt failed.***********\n");
                    System.out.printf("\ndecryptJson  \n%s", decryptJson);
                }
            }
            JSONObject postJsonObj = new JSONObject();
            postJsonObj.put("comCode", comCode);
            postJsonObj.put("text", enryptJsonData);
            System.out.println(postJsonObj.toString(1));
            // 构建 发送json
            String httpResult = MyHttp.postAPI32(url,postJsonObj.toString());

            String aesDecode = MyAESUtil.Decrypt("AES/ECB/PKCS5Padding", httpResult, AESKey);
            System.out.printf("\n   aesDecode  :  \n %s\n", aesDecode);
            return aesDecode;
        } catch (Exception ex) {

        }
        return "";
    }

    public static void doAPI_getAlarmInfo(String token, String AESKey) {
        try {
            getAlarmInfo gai = new getAlarmInfo();
            gai.comCode = comCode;
            gai.token = token;

            gai.sign = GenenateSign(String.format("comCode%s", gai.comCode));
            String post32URL = "http://192.168.203.187:8092/company/supervision/enterpriseApi/getAlarmInfo";

            String jsonData = objTOString(gai);
            doPost(post32URL,jsonData, AESKey);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public static void doAPI_netStatusAndTimeSynchronization(String token, String AESKey) {
        try {

            JSONObject postJsonObj = new JSONObject();
            postJsonObj.put("comCode", comCode);
            postJsonObj.put("brakeCode","brakeCode");
            postJsonObj.put("brakeStatus","1");
            postJsonObj.put("carDeviceStatus","1");
            postJsonObj.put("videoDeviceCode","videoDeviceCode");
            postJsonObj.put("videoDeviceStatus","1");
            postJsonObj.put("token",token);
            postJsonObj.put("sign","brakeCode");
            
            String sign = GenenateSign(String.format("comCode%sbrakeCode%sbrakeStatus%scarDeviceStatus%svideoDeviceCode%svideoDeviceStatus%s", 
            comCode,
            postJsonObj.getString("brakeCode"),
            postJsonObj.getString("brakeStatus"),
            postJsonObj.getString("carDeviceStatus"),
            postJsonObj.getString("videoDeviceCode"),
            postJsonObj.getString("videoDeviceStatus")));
            postJsonObj.put("sign",sign);
            String jsonData = postJsonObj.toString();
            String post32URL = "http://192.168.203.187:8092/company/supervision/enterpriseApi/netStatusAndTimeSynchronization";

            doPost(post32URL,jsonData, AESKey);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) throws Exception {
        // http获取token
        System.out.println("\n\n######Begin#######   get token\n\n");
        Token token = MyHttp.getToken();

        // RSA public Key解密 得到aes 密钥
        String AESKey = MyRSA.decrypt(token.screct);
        System.out.println("   AESKey\n" + AESKey);

        doAPI_getAlarmInfo(token.token, AESKey);

        doAPI_netStatusAndTimeSynchronization(token.token, AESKey);
        System.out.println("\n\n\n   ----------OVER------------ \n\n");
    }
}
