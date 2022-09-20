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
        /*//对文本全部加密，
         报文结构
         {
            "comCode":"12345656",
            "text":"aes加密的密文"
         }
         aes加密的密文 = 
         {
            "comCode":"123456",
            "token":"xxxxxxxxxx",
            "sign":"xxxxxxxxxx"
         }

         */
        
        try {
            System.out.printf("\n\n######Begin#######  doAPI_fullEncrypt  [%s] \n\n",algm);
            System.out.println(algm);
            getAlarmInfo gai = new getAlarmInfo();
            gai.comCode = comCode;
            gai.token = token;

            gai.sign = GenenateSign(String.format("comCode%s", gai.comCode));

            String jsonData = objTOString(gai);

            System.out.println(jsonData);
            String enryptJsonData = MyAESUtil.Encrypt(algm, jsonData, AESKey);

            {
                //验证 aes 加密
                String decryptJson = MyAESUtil.Decrypt(algm, enryptJsonData, AESKey);
                System.out.printf("\ndecryptJson  \n%s",decryptJson);

                if(decryptJson!=jsonData)
                {
                    System.out.printf("\n ********error  aes decrypt failed.***********\n");
                }
            }
            JSONObject postJsonObj = new JSONObject();
            postJsonObj.put("comCode", comCode);
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
        doAPI_fullEncrypt(algm, token, AESKey);
        doAPI_paramEncrypt(algm, token, AESKey);
    }

    public static void doAPI_paramEncrypt(String algm, String token, String AESKey) {
        /*//只对参数值加密，
         报文结构
         {
            "comCode":"12345656",
            "text":"{"paramA":"aes加密的密文","paramB":"aes加密的密文"}"
         }
         
         
         {
            "comCode":"123456",
            "token":"xxxxxxxxxx",
            "sign":"xxxxxxxxxx"
          }

         */
        try {
            System.out.printf("\n\n######Begin#######  doAPI_paramEncrypt  [%s] \n\n",algm);
            String aesToken = MyAESUtil.Encrypt(algm, token, AESKey);
            getAlarmInfo gai = new getAlarmInfo();
            gai.comCode = comCode;
            gai.token = aesToken;

            gai.sign = GenenateSign(String.format("comCode%s", gai.comCode));

            gai.token = MyAESUtil.Encrypt(algm, gai.token, AESKey);

            gai.sign = MyAESUtil.Encrypt(algm, gai.sign, AESKey);

            String jsonData = objTOString(gai);

            System.out.println(jsonData);

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
        // http获取token
        System.out.println("\n\n######Begin#######   get token\n\n");
        Token token = MyHttp.getToken();

        // RSA public Key解密  得到aes 密钥
        String AESKey = MyRSA.decrypt(token.screct);
        System.out.println("   AESKey\n" + AESKey);

        
        
        //doAPI("AES/CBC/PKCS5Padding", token.token, AESKey);
        doAPI_fullEncrypt("AES/ECB/PKCS5Padding", token.token, AESKey);

        // doAPI("AES/ECB/NoPadding", token.token, AESKey);
        //doAPI("AES/ECB/PKCS5Padding", token.token, AESKey);

        System.out.println("\n\n\n   ----------OVER------------ \n\n");        
    }
}
