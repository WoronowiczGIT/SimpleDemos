package SDA.functional_interface.Predicate;

import SDA.functional_interface.Function.User;

import java.time.LocalDate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Predicator {

    public boolean isLeapYear(Integer yr) {
        Predicate<Integer> isLeapYear = (Integer year) -> {
            return LocalDate.of(year, 1, 1).isLeapYear();
        };
        return isLeapYear.test(yr);
    }

    public Boolean isEven(Integer nr){
        Predicate<Integer> isEven = (Integer number) -> {
            if (number % 2 == 0) return true;
            return false;
        };
        return isEven.test(nr);
    }

    public Boolean isAdult(User u){
        Predicate<User> isAdult = (User user) -> {
            return user.getAge() > 18;
        };
        return isAdult.test(u);
    }

    public Boolean isGreaterThenTen(Integer n){
        IntPredicate isGreaterThenTen = (x) -> {
            return x > 10;
        };
        return isGreaterThenTen.test(n);
    }

    public Boolean isNumberValid(String n){
        Predicate<String> isNumberValid = (String phoneNr) -> {
            phoneNr = phoneNr.replace(" ", "");
            boolean hasPrefiks = phoneNr.substring(0, 3).contains("+48");
            boolean hasLength = phoneNr.substring(3).length() == 9;
            boolean hasNumbers = phoneNr.substring(3).chars().allMatch(Character::isDigit);
            return hasPrefiks && hasLength && hasNumbers;
        };
        return isNumberValid.test(n);
    }

}
