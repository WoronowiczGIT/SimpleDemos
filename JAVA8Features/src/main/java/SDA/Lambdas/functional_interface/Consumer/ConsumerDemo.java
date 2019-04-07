package SDA.Lambdas.functional_interface.Consumer;

import SDA.Lambdas.functional_interface.Function.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        ConsumerDemo cd = new ConsumerDemo();

        //Sort Array
        Consumer<Integer[]> sortArray = (Integer[] array) -> {
            int counter = 0;
            while (counter < array.length) {
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                    }
                }
                counter++;
            }
        };

        Integer[] tab = {3, 4, 2, 1};
        cd.showArray(tab);
        sortArray.accept(tab);
        cd.showArray(tab);

        //Display Credentials
        User myUser = new User();
        myUser.setAge(25);
        myUser.setName("elo");
        myUser.setLastName("Moricone");

        Consumer<User> showUser = (User user) ->{
            System.out.println("\nage "+user.getAge());
            System.out.println("name "+user.getName());
            System.out.println("lastname "+user.getLastName());
        };

        showUser.accept(myUser);
        // Add to List
        List<User> list = new ArrayList<>();

        BiConsumer<User,List> addtoList = (User user, List myList) ->{
            myList.add(user);
        };
        addtoList.accept(myUser,list);
        System.out.println("i just added "+list.get(0).getName()+" to my list");





    }

    public void showArray(Integer[] array) {
        System.out.println();
        for (Integer i : array
        ) {
            System.out.print(i + " ");
        }
    }
}
