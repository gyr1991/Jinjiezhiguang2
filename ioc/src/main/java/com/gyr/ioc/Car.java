package com.gyr.ioc;

import javax.inject.Inject;

public class Car {
    private Engine engine;
    @Inject
    public Car(@Ga Engine engine) {
        this.engine = engine;
    }

    public String run(){
        return engine.work();
    }
}
