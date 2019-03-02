package com.gyr.ioc;

import javax.inject.Inject;

public class Swordsman {

    @Inject
    public Swordsman(){

    }

    public String fighting(){
        return "欲为大树，不与草争";
    }
}
