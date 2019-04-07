package SDA.Lambdas.functional_interface.Predicate;

import SDA.Lambdas.functional_interface.Function.User;

import java.time.LocalDate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Predicator {

    public static void main(String[] args) {

        Predicate<Integer> isEven = (Integer number) -> {
            if (number % 2 == 0) return true;
            return false;
        };
        Integer number = 5;
        System.out.println("is " + number + " even?" + isEven.test(number));


        Predicate<Integer> isLeapYear = (Integer year) -> {
            return LocalDate.of(year, 1, 1).isLeapYear();
        };
        System.out.println("is year 2020 a leapYear?: " + isLeapYear.test(2020));

        Predicate<User> isAdult = (User user) -> {
            return user.getAge() > 18;
        };
        User user = new User();
        user.setAge(25);
        System.out.println("is user Adult? " + isAdult.test(user));

        IntPredicate isGreaterThenTen = (x) -> {
            return x > 10;
        };

        Predicate<String> isNumberValid = (String phoneNr) -> {
            phoneNr = phoneNr.replace(" ", "");
            boolean hasPrefiks = phoneNr.substring(0, 3).contains("+48");
            boolean hasLength = phoneNr.substring(3).length() == 9;
            boolean hasNumbers = phoneNr.substring(3).chars().allMatch(Character::isDigit);
            return hasPrefiks && hasLength && hasNumbers;
        };
        System.out.println("is phone nr Valid?: " + isNumberValid.test("+48 222 222 232"));


    }
}
