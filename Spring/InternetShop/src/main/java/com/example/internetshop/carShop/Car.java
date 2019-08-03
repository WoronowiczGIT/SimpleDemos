package com.example.internetshop.carShop;

import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Builder
@Getter
public class Car {
    private Integer year;

    private String model;

    private Brand brand;

    private Integer mileage;

    private Integer id;
}
