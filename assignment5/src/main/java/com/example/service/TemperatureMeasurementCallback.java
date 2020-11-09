package com.example.service;
@FunctionalInterface
public interface TemperatureMeasurementCallback {
    public void temperatureMeasured(int temperature);
}
