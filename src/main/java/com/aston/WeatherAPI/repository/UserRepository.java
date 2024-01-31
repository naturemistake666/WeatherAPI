package com.aston.WeatherAPI.repository;

import com.aston.WeatherAPI.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
