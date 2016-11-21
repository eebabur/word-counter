package com.example.emrebabur.wordcounter.di.component;

import com.example.emrebabur.wordcounter.di.module.DataManagerModule;
import com.example.emrebabur.wordcounter.di.scope.ApplicationScope;
import com.example.emrebabur.wordcounter.model.DataManager;
import com.example.emrebabur.wordcounter.view.MainActivity;

import dagger.Component;

/**
 * Created by emre.babur on 18.11.2016.
 */
@ApplicationScope
@Component(
        dependencies =  DataServiceComponent.class,
        modules = {
                DataManagerModule.class
        }
)
public interface DataManagerComponent {
    DataManager dataManager();
    void inject(MainActivity activity);
}
