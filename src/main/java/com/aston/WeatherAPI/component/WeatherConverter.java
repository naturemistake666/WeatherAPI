package com.aston.WeatherAPI.component;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

@Component
public class WeatherConverter {

    public String convertDate(JSONObject littleJSONObj){
        return substringTimeInDate(littleJSONObj.getString("dt"));
    }

    public int convertTemperature(JSONObject littleJSONObj){
        return convertToOurTemperature(littleJSONObj
                .getJSONObject("main").getDouble("temp"));
    }

    public int convertTemperatureFeels(JSONObject littleJSONObj){
        return convertToOurTemperature(littleJSONObj
                .getJSONObject("main").getDouble("feels_like"));
    }

    public int convertMinTemperature(JSONObject bigJSONObj, int startIndex){
        return countMinOrMaxTemp(bigJSONObj, startIndex, "temp_min");
    }

    public int convertMaxTemperature(JSONObject bigJSONObj, int startIndex){
        return countMinOrMaxTemp(bigJSONObj, startIndex, "temp_max");
    }

    public int convertPressure(JSONObject littleJSONObj){
        return convertToOurPressure(littleJSONObj
                .getJSONObject("main").getDouble("pressure"));
    }

    public double convertWindSpeed(JSONObject littleJSONObj){
        return littleJSONObj.getJSONObject("wind").getDouble("speed");
    }

    public int convertHumidity(JSONObject littleJSONObj){
        return littleJSONObj.getJSONObject("main").getInt("humidity");
    }

    private int countMinOrMaxTemp(JSONObject bigJSONObj, int startIndex, String type){
        List<Integer> listOfTemps = new ArrayList<>();
        for(int i = startIndex; i < startIndex + 2; i++){
            listOfTemps.add(convertToOurTemperature(bigJSONObj.getJSONArray("weather")
                    .getJSONObject(i).getJSONObject("main").getDouble(type)));
        }
        OptionalDouble result = listOfTemps.stream().mapToInt(t -> t).average();
        return (int) result.getAsDouble();
    }

    private int convertToOurTemperature(double temperature){
        return (int) Math.round(temperature - 273.15);
    }

    private int convertToOurPressure(double pressure){
        return (int) Math.round((pressure * 100) / 133.3);
    }

    private String substringTimeInDate(String dateWithTime){
        return dateWithTime.substring(0, 10);
    }
}
