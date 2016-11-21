package com.example.emrebabur.wordcounter.di.module;

import com.example.emrebabur.wordcounter.di.scope.ApplicationScope;
import com.example.emrebabur.wordcounter.model.ApiService;
import com.example.emrebabur.wordcounter.model.DataManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by emre.babur on 18.11.2016.
 */
@Module
public class DataManagerModule {

    @Provides
    @ApplicationScope
    DataManager provideDataManager(ApiService apiService) {
        return new DataManager(apiService);
    }
}
