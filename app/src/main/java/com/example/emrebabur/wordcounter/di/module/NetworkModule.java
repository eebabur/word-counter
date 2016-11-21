package com.example.emrebabur.wordcounter.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by emre.babur on 18.11.2016.
 */
@Module
public class NetworkModule {
    String apiAddress;

    public NetworkModule(String apiAddress) {
        this.apiAddress = apiAddress;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(apiAddress)
                .build();
        return retrofit;
    }
}
