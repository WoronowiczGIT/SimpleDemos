package filters;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MyDate {
    public static void main(String[] args) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate d = LocalDate.parse("22.09.1987",f);
        System.out.println(d);

        LocalDate today = LocalDate.now();

        System.out.println(Period.between(d,today).getYears());
    }
}
