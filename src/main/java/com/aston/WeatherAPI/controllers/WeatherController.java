package com.aston.WeatherAPI.controllers;

import com.aston.WeatherAPI.entity.Weather;
import com.aston.WeatherAPI.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/weather")
public class WeatherController {
  private final WeatherServiceImpl weatherServiceImpl;
  @Autowired
  public WeatherController(WeatherServiceImpl weatherServiceImpl) {
      this.weatherServiceImpl = weatherServiceImpl;
  }

    @GetMapping("/{town}")
    public String getWeather(@PathVariable("town") String town, Model model) {
      weatherServiceImpl.saveWeather(town);
      List<Weather> weatherList = weatherServiceImpl.findByTown(town);
      System.out.println(weatherList.get(0).toString());
      model.addAttribute("weather", weatherList.get(0));
      return "exmpl";
    }
}
