package com.aston.WeatherAPI.config;

import com.aston.WeatherAPI.component.WeatherConverter;
import com.aston.WeatherAPI.entity.Weather;
import com.aston.WeatherAPI.repository.WeatherRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WeatherConfig {

    private final WeatherRepository weatherRepository;

    private final WeatherConverter weatherConverter;

    public void getWeatherObjFromJSON(String jsonWeather, String cityName){
        JSONObject jsonObject = new JSONObject(jsonWeather);

        for(int i = 0; i <= 32; i += 8){
           weatherRepository.save(makeNewWeatherObject(i, jsonObject, cityName));
        }
    }

    private Weather makeNewWeatherObject(int index,
                                      JSONObject jsonObject, String cityName){
        JSONObject littleJSONObj = jsonObject.getJSONArray("list")
                .getJSONObject(index);

        String date = weatherConverter.convertDate(littleJSONObj);
        int temperature = weatherConverter.convertTemperature(littleJSONObj);
        int temperatureFeels = weatherConverter.convertTemperatureFeels(littleJSONObj);
        int minTemperature = weatherConverter.convertMinTemperature(jsonObject, index);
        int maxTemperature = weatherConverter.convertMaxTemperature(jsonObject, index);
        int pressure = weatherConverter.convertPressure(littleJSONObj);
        double windSpeed = weatherConverter.convertWindSpeed(littleJSONObj);
        int humidity = weatherConverter.convertHumidity(littleJSONObj);

       Weather weather = new Weather(cityName, date, temperature, temperatureFeels,
                minTemperature, maxTemperature, pressure, windSpeed, humidity);
        return weather;
    }
}
