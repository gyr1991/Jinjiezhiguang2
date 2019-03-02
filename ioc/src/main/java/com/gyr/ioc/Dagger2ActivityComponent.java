package com.gyr.ioc;

import javax.inject.Singleton;

import dagger.Component;

@ApplicationScope
@Component(modules = {GsonModule.class,EngineModule.class},dependencies = SwordsmanComponent.class)
public interface Dagger2ActivityComponent {
    void inject(Dagger2Activity activity);
    void inject(Dagger3Activity activity);
}
