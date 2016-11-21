package com.example.emrebabur.wordcounter.di.component;

import com.example.emrebabur.wordcounter.di.module.NetworkModule;
import com.example.emrebabur.wordcounter.model.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by emre.babur on 18.11.2016.
 */
@Singleton
@Component(
        modules = {
                NetworkModule.class
        }
)
public interface DataServiceComponent {
    ApiService apiService();
}
