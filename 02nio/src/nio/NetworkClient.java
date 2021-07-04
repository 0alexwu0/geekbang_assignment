package nio;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NetworkClient {
    private static OkHttpClient oHttpClient;

    public static void main(String[] args){
        //初始化okHttpClient
        oHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();

        //访问指定网页并获取body里的信息
        String sBody = doGet("http://localhost:8801");
        System.out.println(sBody);
    }

    //使用get方式同步访问指定url
    private static String doGet(String sUrl) {
        final Request request = new Request.Builder().url(sUrl).build();
        Call call = oHttpClient.newCall(request);
        try {
            Response oHttpResponse = call.execute();
            return oHttpResponse.body().string();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}