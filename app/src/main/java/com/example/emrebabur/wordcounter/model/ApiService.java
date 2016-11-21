package com.example.emrebabur.wordcounter.model;


import com.example.emrebabur.wordcounter.WordCounterApplication;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by emre.babur on 18.11.2016.
 */
public class ApiService {

    private final Api api;

    @Inject
    public ApiService(Retrofit retrofit) {
        api = retrofit.create(Api.class);
    }

    public Observable<String> getBook(String bookName) {
        return api.getBook(bookName);
    }

    interface Api {
        @GET("/download/text/{book_name}")
        Observable<String> getBook(@Path("book_name") String bookName);
    }
}
