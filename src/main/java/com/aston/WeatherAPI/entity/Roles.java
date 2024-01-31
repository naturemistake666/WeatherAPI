package com.aston.WeatherAPI.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
@Data
@Table(name = "roles")
public class Roles implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_role")
    private String nameRole;

    public Roles() {
    }

    @Override
    public String getAuthority() {
        return getNameRole();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roles role)) return false;
        return getId().equals(role.getId()) && getNameRole().equals(role.getNameRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameRole());
    }

}
