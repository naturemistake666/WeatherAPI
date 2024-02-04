package com.aston.WeatherAPI.controllers;

import com.aston.WeatherAPI.entity.Weather;
import com.aston.WeatherAPI.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class WeatherController {
  private final WeatherServiceImpl weatherService;

  @Autowired
  public WeatherController(WeatherServiceImpl weatherService) {
    this.weatherService = weatherService;
  }

  /**@GetMapping("/weather/{town}")
    public String getWeather(@PathVariable("town") String town, Model model) {
    if (town.equals(weatherService.findByTown(town))){
      model.addAttribute("weathers", weatherService.findByTown(town));
    } else {
      weatherService.saveWeather(town);
      model.addAttribute("weathers", weatherService.findByTown(town));
    }
      return "index2";
    }**/

  @GetMapping("/weather")
  public String getAllWeather( Model model) {
    model.addAttribute("weathers", weatherService.findAll());
    return "index2";
  }
}

