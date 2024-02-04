package com.aston.WeatherAPI.repository;

import com.aston.WeatherAPI.WeatherApiApplication;
import com.aston.WeatherAPI.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    @Query("SELECT w FROM Weather w WHERE w.town = :town")
    List<Weather> findByTown(String town);


}
