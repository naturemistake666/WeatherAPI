package com.aston.WeatherAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weather", schema = "weatherapi")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "town", nullable = false)
    private String town;

    @Column(name = "date_", nullable = false)
    private String date;

    @Column(name = "temperature_now", nullable = false)
    private int temperatureNow;

    @Column(name = "temperature_min", nullable = false)
    private int temperatureMin;

    @Column(name = "temperature_max", nullable = false)
    private int temperatureMax;

    @Column(name = "pressure", nullable = false)
    private int pressure;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "wind_speed", nullable = false)
    private double windSpeed;

    @Column(name = "temperature_feels", nullable = false)
    private int temperatureFeels;

    public Weather(String town, String date, int temperatureNow,
                   int temperatureFeels, int temperatureMin,
                   int temperatureMax, int pressure,
                   double windSpeed, int humidity) {
        this.town = town;
        this.date = date;
        this.temperatureNow = temperatureNow;
        this.temperatureFeels = temperatureFeels;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
    }
}
