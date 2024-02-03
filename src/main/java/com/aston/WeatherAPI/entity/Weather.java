package com.aston.WeatherAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "town")
    private String town;

    @Column(name = "date_")
    private String date;

    @Column(name = "temperature_now")
    private int temperatureNow;
    @Column(name = "temperature_min")
    private int temperatureMin;

    @Column(name = "temperature_max")
    private int temperatureMax;

    @Column(name = "pressure")
    private int pressure;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "wind_speed")
    private double windSpeed;
    @Column(name = "temperature_feels")
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
