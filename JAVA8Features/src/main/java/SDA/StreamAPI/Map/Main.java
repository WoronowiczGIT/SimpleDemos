package SDA.StreamAPI.Map;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Piotr", "Joanna", "Krzysztof", "Alibaba");

        List<User> users = Arrays.asList(
                new User(new String[]{"pierwszy"}, 25),
                new User(new String[]{"drugi"}, 35),
                new User(new String[]{"trzeci"}, 15),
                new User(new String[]{"czwarty"}, 55));

        users.stream().map((User user) -> user.age)
                .forEach((Integer age) -> System.out.println(age));

        List<Car> cars = Arrays.asList(new Car("VW", 100), new Car("BMW", 125));
        cars.stream().forEach((car -> System.out.println(car.speed)));

        List<String> upperCase = list.stream()
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(upperCase);

        List<Integer> integerList = Arrays.asList(100, 200, 300);
        integerList = integerList.stream()
                .map((Integer in) -> in + 10)
                .collect(Collectors.toList());
        System.out.println(integerList);

        List<String> dateStringList = Arrays.asList("12:34", "9:05");
        List<LocalTime> dateList = dateStringList.stream()
                .map((String s) -> {
                    String[] time = s.split(":");
                    Integer hour = Integer.parseInt(time[0]);
                    Integer minute = Integer.parseInt(time[1]);
                    return LocalTime.of(hour, minute);
                }).collect(Collectors.toList());
        System.out.println(dateList);

        List<String> newList = list.stream()
                .filter((s) -> s.length() > 5)
                .sorted().distinct()
                .collect(Collectors.toList());
        System.out.println(newList);

        int result = list.stream()
                .mapToInt(value -> value.length())
                .sum();
        System.out.println(result);
    }
}
