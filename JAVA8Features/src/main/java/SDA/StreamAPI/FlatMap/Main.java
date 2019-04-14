package SDA.StreamAPI.FlatMap;

import SDA.StreamAPI.Map.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Flat map spłaszcza strukturę, w odroznieniu od zwyklej mapy zwraca spłaszczony strumien danych
        List<List<String>> superListString = Arrays.asList(Arrays.asList("a","b"),Arrays.asList("c","d"));

        superListString.stream()
                .flatMap((List<String> list)-> list.stream())
                .forEach((s)-> System.out.println(s));

        List<List<Integer>> superListInteger = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5,6));

        superListInteger.stream()
                .flatMap((List<Integer> list) -> list.stream())
                .forEach((Integer n)-> System.out.print(n+" "));

        List<User> users = Arrays.asList(new User(new String[]{"Jaś","Paś"},11),new User(new String[]{"Daj","Paj"}, 22));
        List<String> names = users.stream()
                .flatMap((user) -> Stream.of(user.getName()))
                .collect(Collectors.toList());
        System.out.println(names);

        class Rectangle{
            int a;
            int b;
            public Rectangle(int a, int b) {
                this.a = a;
                this.b = b;
            }
        }
        List<Rectangle> rectanglesList = Arrays.asList(new Rectangle(2,3),new Rectangle(5,5));
        List<Integer> areas = rectanglesList.stream()
                .flatMap((Rectangle r)-> Stream.of(r.a*r.b))
                .collect(Collectors.toList());
        System.out.println(areas);





    }
}
