package SDA.StreamAPI.Filter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,9,8);

        list.stream()
                .filter((value)->value<5)
                .forEach((integer)-> System.out.println(integer+1));

        list.stream()
                .filter((integer -> integer%2==0))
                .forEach((integer -> System.out.println("is even: "+integer)));

        list.stream()
                .filter((integer -> integer%2!=0)).forEach((integer -> System.out.println("is odd: "+integer)));

        class Rectangle{
            int a;
            int b;

            public Rectangle(int a, int b) {
                this.a = a;
                this.b = b;
            }
        }
        List<Rectangle> rectangles = Arrays.asList(new Rectangle(2,2), new Rectangle(3,5),new Rectangle(4,4));

        rectangles.stream()
                .map(rectangle -> rectangle.a*rectangle.b)
                .filter(integer -> integer>10)
                .forEach(integer -> System.out.println(integer));

        rectangles.stream()
                .filter(rectangle -> rectangle.a*rectangle.b>10)
                .forEach(rectangle -> System.out.println(rectangle));

        rectangles.stream()
                .filter(rectangle -> rectangle.a ==rectangle.b)
                .forEach(rectangle -> System.out.println(rectangle+" is square"));







    }
}
