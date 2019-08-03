package com.example.internetshop.carShop;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import javax.validation.constraints.*;

@Validated
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCarDto {

    @NotNull
    @Min(1800)
    private Integer year;

    @NotNull
    @Size(min = 2, max = 10)
    private String model;

    @NotNull
    private Brand brand;

    @NotNull
    @Max(200000)
    private Integer mileage;

}
