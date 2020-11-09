package com.example.config;

import com.example.domain.FakeThermometer;
import com.example.service.TemperatureMeasurementCallback;
import com.example.service.WeatherForecastService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@Import({FakeThermometer.class, WeatherForecastService.class})
class Config {

  @Bean
  public TemperatureMeasurementCallback callback() {
    return (temperature) -> System.out.println(temperature);
  }
}
