package com.example.internetshop.demoService;
// install lombock plugin
// settings -> build ->compiler -> annotation processors -> enable processing
// add maven dependencies

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

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
public class Book {

    private Integer id;

    private String author;

    private String title;

    private Integer year;

    private Type type;
}
