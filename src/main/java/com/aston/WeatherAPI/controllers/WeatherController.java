package com.aston.WeatherAPI.controllers;

import com.aston.WeatherAPI.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
  private final WeatherServiceImpl weatherServiceImpl;
  @Autowired
  public WeatherController(WeatherServiceImpl weatherServiceImpl) {
      this.weatherServiceImpl = weatherServiceImpl;
  }

    @GetMapping("/{town}")
    public String getWeather(@PathVariable("town") String town, Model model) {
    model.addAttribute("weather", weatherServiceImpl.findByTown(town));
    return "exmpl.html";
    }
}
