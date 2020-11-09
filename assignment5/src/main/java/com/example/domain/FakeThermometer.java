package com.example.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class FakeThermometer implements Thermometer {
  private int currentTemperature = 21;

  @Override
  public int measure() {
    return currentTemperature++;
  }
}
