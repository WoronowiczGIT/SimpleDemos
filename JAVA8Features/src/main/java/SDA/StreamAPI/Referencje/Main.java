package SDA.StreamAPI.Referencje;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("pan","jan","kot","");

        list.stream().forEach((String::toUpperCase));

        String tekst = "       Elo       ";
        Stream.of(tekst)
                .map((String::trim))
                .forEach(System.out::println);

        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        String emptyString = list.stream()
                .filter(String::isEmpty)
                .collect(Collectors.joining());

        System.out.println(emptyString+"<- tu nic nei bylo");
    }
}
