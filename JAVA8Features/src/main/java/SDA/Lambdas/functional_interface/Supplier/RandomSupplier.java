package SDA.Lambdas.functional_interface.Supplier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class RandomSupplier {

    public static void main(String[] args) {


        Supplier<Integer> getRandomNumber = () -> {
            Random random = new Random();
            Integer result = random.nextInt(100);
            return result;
        };
        System.out.println("random number: " + getRandomNumber.get());

        Supplier<LocalDate> getActualDate = () ->{
            return LocalDate.now();
        };
        System.out.println(getActualDate.get());

        Supplier<String> getDDMMRR = () -> {
            String day = Integer.toString(LocalDate.now().getDayOfMonth());
            String month = Integer.toString(LocalDate.now().getMonthValue());
            String year = Integer.toString(LocalDate.now().getYear());
            return day+"-"+month+"-"+year;
        };
        System.out.println(getDDMMRR.get());

        Supplier<String> formattedDate = ()->{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd;M;YYY");
            String date = formatter.format(LocalDate.now());
            return date;
        };
        System.out.println("date in another format: " + formattedDate.get());



        Supplier<DayOfWeek> getDayOfWeek = () -> {
            return LocalDate.now().getDayOfWeek();
        };
        System.out.println(getDayOfWeek.get().toString());

        Supplier<List> getTenRandomNumbers = ()->{
            Random random = new Random();
            List<Integer> list = new ArrayList<>();
            while(list.size() <10){
                list.add(random.nextInt(99)+1);
            }
            return list;
        };
        System.out.println(getTenRandomNumbers.get());


    }
}
