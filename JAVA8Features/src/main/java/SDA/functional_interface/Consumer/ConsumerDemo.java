package SDA.functional_interface.Consumer;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {

    public void sortArray(Integer[] a){
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
        sortArray.accept(a);
    }

    public void ShowUser(User u){
        Consumer<User> showUser = (User user) -> {
            System.out.println("\nage " + user.getAge());
            System.out.println("id: "+ user.getId());
            System.out.println("name " + user.getName());
            System.out.println("lastname " + user.getLastName());
        };
        showUser.accept(u);
    }

    public void addToList(User u, List list){
        BiConsumer<User, List> addToList = (User user, List myList) -> myList.add(user);
        addToList.accept(u, list);
    }

    public void modifyUser(Map<Integer,User> m, User u){
        BiConsumer<Map, User> updateUser = (Map map, User modifiedUser) -> {
            for (Object key: map.keySet()) {
                if(key == modifiedUser.getId()){
                    map.put(key,modifiedUser);
                }
            }
        };
        updateUser.accept(m,u);
    }

}
