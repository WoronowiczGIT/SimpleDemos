package SDA.dataStructure.extractUnique;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class extractUnique {

    List<Integer> list = Arrays.asList(1,2,3,34,3,3,2,4,11,23,3,212,2,321,2,2242,42,232,123);
    Set<Integer> mySet = new HashSet<>();

    public int countUnique(){
        mySet.addAll(list);
        return mySet.size();
    }

    public static void main(String[] args) {
        extractUnique e = new extractUnique();
        System.out.println("unique elements: "+e.countUnique());
        System.out.println("total size: "+e.list.size());
    }
}
