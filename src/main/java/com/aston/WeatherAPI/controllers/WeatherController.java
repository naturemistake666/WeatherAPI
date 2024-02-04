package com.aston.WeatherAPI.controllers;

import com.aston.WeatherAPI.entity.Weather;
import com.aston.WeatherAPI.service.WeatherServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController {
  private final WeatherServiceImpl weatherService;

  @Autowired
  public WeatherController(WeatherServiceImpl weatherService) {
    this.weatherService = weatherService;
  }

  @GetMapping("/weather/{town}")
    public String getWeather(@PathVariable("town") String town, Model model) {
      model.addAttribute("weather", weatherService.findByTown(town));
      return "exmpl";
    }

 /** @GetMapping("/weather")
  public String getAllWeather(Model model) {
    model.addAttribute("weather", weatherService.findAll());
    return "exmpl";
  }

  @RequestMapping("/weather/error")
  public String handleError(HttpServletRequest request, Model model) {
    return "error"; // Создайте представление error.html
  }
}**/

 @RequestMapping("/weather")
 public String showWeather(Model model) {
   // В реальном приложении здесь будет ваш сервис для получения данных
   // Я просто создам фиктивный объект Weather для примера
   Weather weather = new Weather ("Moscow", "2024-02-04", 20, 15, 30, 1010, 50, 5.0, 22);

   // Передайте объект Weather в представление
   model.addAttribute("weather", weather);

   // Верните имя представления (без расширения)
   return "exmpl";
 }
}
