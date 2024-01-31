package com.aston.WeatherAPI.component;

import com.aston.WeatherAPI.entity.Weather;
import com.aston.WeatherAPI.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OpenWeatherImpl {
    private final WeatherService weatherService;

    @Value("${first.part.of.url}")
    private String firstPartOfUrl;

    @Value("${second.part.of.url}")
    private String secondPartOfUrl;

    public List<Weather> getWetherInCity(String cityName){
        String output = getUrlContent(urlConstructor(cityName));
        if(output != null){
            return weatherService.getWeatherObjFromJSON(output, cityName);
        }
        return null;
    }

    private String urlConstructor(String cityName){
        return firstPartOfUrl + cityName + secondPartOfUrl;
    }

    private String getUrlContent(String urlAddress){
        StringBuffer stringBuffer = new StringBuffer();

        try{
            String line;
            URL url = new URL(urlAddress);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch (Exception e){
            return null;
        }
        return stringBuffer.toString();
    }


}
