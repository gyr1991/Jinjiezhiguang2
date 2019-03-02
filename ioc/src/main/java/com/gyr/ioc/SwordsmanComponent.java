package com.gyr.ioc;

import dagger.Component;

@Component(modules = SwordsmanModule.class)
public interface SwordsmanComponent {
    Swordsman getSwordsman();
}
