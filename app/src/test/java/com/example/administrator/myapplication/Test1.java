package com.example.administrator.myapplication;

import org.junit.Test;



import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class Test1 {
    Retrofit retrofit;
    @Test
    public void addition_isCorrect() {





        retrofit =new Retrofit.Builder().baseUrl("http://www.baidu.com/").
                addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        Itest itest= retrofit.create(Itest.class);
        itest.getTest().subscribeOn(Schedulers.io())
               // .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.print("ss");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.print(s);
                    }
                });

//        itest.getTest().enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                System.out.print(response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                System.out.print("onFailure");
//            }
//        });
    }



    interface  Itest{
        @GET("test")
        Observable<String> getTest();
    }
}
