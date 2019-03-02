package com.gyr.ioc;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {
    @ApplicationScope
    @Provides
    public Gson provideGson(){
        return new Gson();
    }
}
