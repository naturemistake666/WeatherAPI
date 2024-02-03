package com.aston.WeatherAPI.service;

import com.aston.WeatherAPI.entity.Weather;

import java.util.List;

public interface WeatherService {
    Weather findById(Long id);

    List<Weather> findAll();

    void saveWeather(String town);

    void deleteById(Long id);

    List<Weather> findByTown(String town);
}
