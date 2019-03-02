package com.gyr.ioc;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class EngineModule {
    @Provides
    @Ga
    public Engine provideEngine1(){
        return new GasolineEngine();
    }

    @Provides
    @Di
    public Engine provideEngine2(){
        return new DieselEngine();
    }
}
