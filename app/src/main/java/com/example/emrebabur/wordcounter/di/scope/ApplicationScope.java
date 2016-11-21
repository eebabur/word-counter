package com.example.emrebabur.wordcounter.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by emre.babur on 18.11.2016.
 */
@Scope
@Documented
@Retention(value= RetentionPolicy.RUNTIME)

public @interface ApplicationScope {
}
