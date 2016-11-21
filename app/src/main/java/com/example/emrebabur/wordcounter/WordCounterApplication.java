package com.example.emrebabur.wordcounter;

import android.app.Application;

import com.example.emrebabur.wordcounter.di.component.DaggerDataManagerComponent;
import com.example.emrebabur.wordcounter.di.component.DaggerDataServiceComponent;
import com.example.emrebabur.wordcounter.di.component.DataManagerComponent;
import com.example.emrebabur.wordcounter.di.component.DataServiceComponent;
import com.example.emrebabur.wordcounter.di.module.DataManagerModule;
import com.example.emrebabur.wordcounter.di.module.NetworkModule;
import com.example.emrebabur.wordcounter.util.Constants;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by emre.babur on 18.11.2016.
 */
public class WordCounterApplication extends Application {

    private DataServiceComponent dataServiceComponent;
    private DataManagerComponent dataManagerComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if(LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        dataServiceComponent = DaggerDataServiceComponent.builder()
                .networkModule(new NetworkModule(Constants.ADDRESS_API))
                .build();

        dataManagerComponent = DaggerDataManagerComponent.builder()
                .dataServiceComponent(dataServiceComponent)
                .dataManagerModule(new DataManagerModule())
                .build();
    }

    public DataManagerComponent getDataManagerComponent() {
        return dataManagerComponent;
    }
}
