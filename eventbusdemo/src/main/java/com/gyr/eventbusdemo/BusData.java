package com.gyr.eventbusdemo;

public class BusData {
    private String message;

    public BusData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
