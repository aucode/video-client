package com.shiro.demo.config;

import java.io.FileWriter;
import java.io.IOException;


/**
 * @Project springboot-alipay-sandbox
 * @Description: AlipayConfig
 * @Author Du Yi Code
 * @Explain Alipay配置
 * @Date 2020-07-15 10:50
 */
public class AlipayConfig {
    public static String app_id = "2016101900723373";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDyxVygOg+CcDfWw4ZfFJQHj0WTmPVxRt2YcXxAalWTZ5RH4J02OrsVkxPVOE22n//4yqGUnLJnXb9T9U7/k2aRmrozBiNSqKDN4cunFtXKv0rWsK20H15cyWrKPJNlZTPHpXYgv4rqAsRV9a28CTVps2huCY+Nbi1MOixwbyPmd/9kOy9mm78bcjbBdPILcwosxV7bIp70fMVZPGrry5qB9Z+iYfPNRWyOdTBYteNRl17SJzFfzCAC4ZvoFp3Ji3pXJlbVwnTVAzlZbnQyWO2uJcGrOIqDL+7qP1/BR/cpx80le0061ZwLebJposj/uoUribR4GTP0yKS1doe51fNLAgMBAAECggEBAKlOfLd9Zl2Yd0i+mVJr3oSbJXG25c03F8l9s6KUxdOEFARAoEM2mEyGgvlbR89KLFDMt/0VftHZrloWJR7WJFz9JEf7St0VnveWNdn0cerwl3e8RZftnHhnO6OItV6sQn1EZmqWSoHCpjwwlxYg8fAiX30GC+gdY1fa5i0PRWEvCOG53dYZjzs+0JMinL+6R5FvibEhp4JIX2B0HAnynZZX51mYYNbXBCuQuqIEyjtn0AqxLUGrdbH1DCxoE0ocrynfHfWVmsAFwl18exk2Wsxhgt62LBIKR9l6HQkdfC2dWgmkaASQLfIQRkFT13gn7PF5Q2ScKKUTjdWZbuJ8n2ECgYEA+uGg5X1VDyN6lY5JOKTwYP4qwlbtJGooHb15bqJN81KFyNjzRn3K4DjaJrQQlOMqf/QyFs0k18tbthRQ76wKlzseDOq0FDx4NgE96a1NLnqX0obfR8Ga8iDe7GXBnRrTj2ri//HTWwm5XUuTuGW7yfXupN49oS9Q826f4ZUmRfECgYEA97lfPQXwxngwM8Jw9eV7gD6zdoJMBnfkdGMTTwP7jtwbIn0w8FaK5GolQu1p0LZ0peaPP1WAdtPEqdNHJBRrJzdaaHDB/LUPqDOPHO9nQhn46KvigEW0i3z4ywflm9OP7qs6gGVPbG5cmjn637b+2pzcjNlIKrCQIAnRdDtlYPsCgYBtAD7htnSQYT/PXsSdYbw2x/dX/GCII79OPJZX5RitETujKe94vwq4JLtTeYSCy7gZY8WndnX9dBNipq0LlNn9HuhNgGPBLwyjmiKGNo+EFCuGgqbcDFf/vxxb5VIbqh4k/7GktjK4KR9qU33Y7gqLEtketJheQaqQOY4pep3oYQKBgEARy5YG0U0jjKP2aCzQ225ByTyfWnZZz9ZiQX4wM4GxX7s90ch3OZj18wkqSjHW3riBtw7UWFNjVfvuTvn/5e7QnCti7mkjkxcXrq33JSete/kBa6VtYdKp0dcBBduVjiZWVt0aVr5elMi2sjHmLGfyJgCvucCAxeXjZC7Bpei9AoGAQ+/5F1rD/WjXJ9e7JR8rpruvicapPdV0hcsTNF+1mCL7G0DGaxF/cz60dxtMeNTpAY+MJCBbvOEwo5vBsulDeIROsM1cp/wACXRC3Szf4JklzY4HWK/zA5yZifQ9dUSkQmJPlGkNGWIFic6VRQcf+SSaaje4420zxO6fjqNw8zw=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi1yg1n+wV81q2mTn07Xt2u7yZx5IqLLuJrkbA1TX3E5qXvIGMRF7WoGWn/kSUiCflcExf2Zrtowth2j/TbmhBUN8hhDx1GTP/1CK+aryWNqHiDMGeVJExE1/GJydlG7HrDbbNlgxk0KM38U+V9JRmYiHyObZZ/9lvCJZ7oJzRmFnQsmOA7voTlns7Brsm4zvqlqS16jmJ7eFl1lXOOHzEZhpKrPL52GJkdfmnfc1unhgJrtBbbDbrZebLPi9kpnoLXccEIKnd80aYndgfmkFx1mKIl04Ih9vUT8spVBKVKHQq/6Ra1Semr9PYLF1t8t0fOiqAnddXqHCY5NEw46L7wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://bjxxby.com/notify_url.view";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://bjxxby.com/return_url.view";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


