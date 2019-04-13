package SDA.StreamAPI.ForEach;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Piotr", "Joanna", "Krzysztof", "Alibaba");

        list.stream().forEach((String s) -> {
            System.out.println(s);
        });
        list.stream().forEach((s) -> {
            System.out.println(s.length());
        });
        list.stream().forEach((s) -> {
            System.out.println(s + " jest parzyste " + (s.length() % 2 == 0));
        });


    }
}
