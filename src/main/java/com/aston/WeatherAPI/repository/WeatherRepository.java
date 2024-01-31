package com.aston.WeatherAPI.repository;

import com.aston.WeatherAPI.WeatherApiApplication;
import com.aston.WeatherAPI.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
