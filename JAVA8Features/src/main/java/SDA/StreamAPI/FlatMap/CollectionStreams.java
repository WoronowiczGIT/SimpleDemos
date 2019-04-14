package SDA.StreamAPI.FlatMap;

import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionStreams {


    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1); queue.add(2); queue.add(3); queue.add(6);
        queue.stream().forEach(integer -> System.out.println(integer));

        Object[] arrayFromQueue = queue.stream().map(integer -> integer+1).toArray();
        System.out.println(arrayFromQueue[1]);

    }
}
