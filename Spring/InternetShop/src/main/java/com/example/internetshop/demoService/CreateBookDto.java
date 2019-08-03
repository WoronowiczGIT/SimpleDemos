package com.example.internetshop.demoService;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


// tworzy konstruktor argumentowy
@AllArgsConstructor
//tworzy contructor bezargumentowy
@NoArgsConstructor
//tworzy buildera
@Builder
//tworzy gettery
@Getter
//setter
@Setter
// klasa wymaga validacji
@Validated
public class CreateBookDto {
    @NotNull
    @Size(min = 2)
    private String author;
    @NotNull
    @Size(min = 2)
    private String title;
    @Min(1900)
    @Max(2019)
    @NotNull
    private Integer year;
    @NotNull
    private Type type;
}
