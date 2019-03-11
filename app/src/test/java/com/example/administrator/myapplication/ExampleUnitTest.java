package com.example.administrator.myapplication;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    OkHttpClient okHttpClient;
    @Test
    public void addition_isCorrect() {
        okHttpClient = new OkHttpClient().newBuilder().readTimeout(5, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            response.body().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}