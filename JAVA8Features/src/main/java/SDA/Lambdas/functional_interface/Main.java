package SDA.Lambdas.functional_interface;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<Integer,String> evenOdd = (Integer number) ->{
            if(number%2==0){
                return "even";
            }else return  "odd";
        };
        System.out.println(evenOdd.apply(25));


        Function<Float,Double> converterCtoK = (Float celc)-> (celc + 273.15);
        System.out.println(converterCtoK.apply(25f));

        Function<User,String> userToCSV = (User user)->{
            String result = "";
            result += user.getName()+";";
            result += user.getLastName()+";";
            result += user.getAge()+";";
            result += user.getPosition()+";";
            return result;
        };

        User user1 = new User();
        user1.setAge(25);
        user1.setName("jan");
        user1.setLastName("janowski");
        user1.setPosition(Position.DESIGNER);
        System.out.println(userToCSV.apply(user1));

        String[] userArray = {"olek","bolek","25"};
        Function<String[],User> csvToUser = (String[] array)->{
            User user = new User();
            user.setName(array[0]);
            user.setLastName(array[1]);
            user.setAge(Integer.parseInt(array[2]));
            return user;
        };
        System.out.println(csvToUser.apply(userArray).getAge());




    }


}
