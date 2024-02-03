package com.aston.WeatherAPI.service;

import com.aston.WeatherAPI.component.OpenWeatherImpl;
import com.aston.WeatherAPI.entity.Weather;
import com.aston.WeatherAPI.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;
    private final OpenWeatherImpl openWeather;

    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository, OpenWeatherImpl openWeather) {
        this.weatherRepository = weatherRepository;
        this.openWeather = openWeather;
    }

    @Override
    public Weather findById(Long id) {
        Optional<Weather> weather = weatherRepository.findById(id);
        return weather.orElse(new Weather());
    }

    @Override
    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }

    @Override
    public void saveWeather(String town) {
        openWeather.getWeatherInCity(town);
    }

    @Override
    public void deleteById(Long id) {
        weatherRepository.deleteById(id);
    }

    @Override
    public Weather findByTown(String town) {
        return weatherRepository.findByTown(town);
    }


}
