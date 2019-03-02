package com.gyr.ioc;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

@Module
public class SwordsmanModule {
    @Provides
    public Swordsman provideSwordsman(){
        return new Swordsman();
    }
}
