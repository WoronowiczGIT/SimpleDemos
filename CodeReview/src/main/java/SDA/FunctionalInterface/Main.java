package SDA.FunctionalInterface;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();

        m.drawSquare(2);
        m.drawTanenbaum(8, 'x');
        m.showTime();
        m.showRandomDay();
        m.isEven(new Integer[]{1, 2, 3});
        m.isAllEven(new Integer[]{2, 2, 3});
        Car c = new Car();
        c.name = "mazda";
        c.type = "combi";
        c.color = "red";

        m.printCar(c);
        m.stringToDate("22:1:1987");

    }

    // Consumer
    public void drawSquare(Integer value) {
        Consumer<Integer> drawer = v -> {
            for (int i = 0; i < v; i++) {
                System.out.println();
                for (int j = 0; j < v; j++) {
                    System.out.print("*");
                }
            }
        };

        drawer.accept(value);
    }

    public void drawTanenbaum(Integer value, Character symbol) {
        BiConsumer<Integer, Character> drawer = (v, c) -> {
            for (int i = 0; i <= v; i++) {
                System.out.println();

                for (int j = 0; j < v; j++) {
                    if (j < v - i) {
                        System.out.print(" ");
                    } else
                        System.out.print(c);
                }
                for (int j = 1; j < i; j++) {
                    System.out.print(c);
                }
            }
        };
        drawer.accept(value, symbol);
    }

    //Suplier
    public void showTime() {
        Supplier<String> supply = () -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            return LocalDateTime.now().format(formatter);
        };
        System.out.println("\n" + supply.get());
    }

    public void showRandomDay() {
        Supplier<DayOfWeek> print = () -> {
            Random r = new Random();
            int number = r.nextInt(6) + 1;
            switch (number) {
                case 1:
                    return DayOfWeek.MONDAY;
                case 2:
                    return DayOfWeek.TUESDAY;
                case 3:
                    return DayOfWeek.WEDNESDAY;
                case 4:
                    return DayOfWeek.THURSDAY;
                case 5:
                    return DayOfWeek.FRIDAY;
                case 6:
                    return DayOfWeek.SATURDAY;
                case 7:
                    return DayOfWeek.SUNDAY;
                default:
                    return null;
            }
        };
        System.out.println("\n" + print.get());
    }

    // Predicate
    public void isEven(Integer[] numbers) {
        Predicate<Integer[]> isEven = (n) -> {
            Integer sum = 0;
            for (Integer number : n) {
                sum += number;
            }
            return sum % 2 == 0;
        };
        System.out.println(isEven.test(numbers));
    }

    public void isAllEven(Integer[] numbers) {
        Predicate<Integer[]> areEven = (n) -> {
            Boolean result = true;
            for (Integer number : n) {
                if (number % 2 != 0) result = false;
            }
            return result;
        };
        System.out.println("\n" + areEven.test(numbers));
    }
    // Function
    public void printCar(Car car) {
        Function<Car, String> map = (c) -> {
            String result = "";
            result += "color: " + c.color;
            result += ", type: " + c.type;
            result += ", name " + c.name;

            return result;
        };
        System.out.println(map.apply(car));
    }

    public void stringToDate(String string){
        Function<String, LocalDate> convert = (s)->{
            String[] stream = s.split(":");
            Integer day = Integer.parseInt(stream[0]);
            Integer month = Integer.parseInt(stream[1]);
            Integer year = Integer.parseInt(stream[2]);

            LocalDate date = LocalDate.of(year,month,day);
            return date;
        };
        System.out.println("\n"+convert.apply(string));
    }

}



