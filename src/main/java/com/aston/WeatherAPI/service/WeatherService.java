package com.aston.WeatherAPI.service;

import com.aston.WeatherAPI.component.WeatherConverter;
import com.aston.WeatherAPI.entity.Weather;
import com.aston.WeatherAPI.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    private final WeatherConverter weatherConverter;

    public List<Weather> getWeatherObjFromJSON(String jsonWeather, String cityName){
        JSONObject jsonObject = new JSONObject(jsonWeather);
        List<Weather> result = new ArrayList<>();

        for(int i = 0; i <= 32; i += 8){
            makeNewWeatherObject(i, result, jsonObject, cityName);
        }

        return result;
    }

    private void makeNewWeatherObject(int index, List<Weather> result,
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
        weatherRepository.save(weather);
        result.add(weather);
    }
}
