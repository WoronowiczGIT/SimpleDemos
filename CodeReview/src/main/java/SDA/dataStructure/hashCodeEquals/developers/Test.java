package SDA.dataStructure.hashCodeEquals.developers;

import java.util.HashSet;

public class Test {


    public static void main(String[] args) {

        Developer dev1 = new Developer("Jan","Kowalski",Language.JAVA,25);
        Developer dev2 = new Developer("Jan","Kowalski",Language.JAVA,25);
        Developer dev3 = new Developer("Jan","Kowalski",Language.JAVA,25);

        HashSet<Developer> set = new HashSet();

        set.add(dev1);
        set.add(dev2);
        set.add(dev3);

        System.out.println(set.contains(new Developer("Jan","Kowalski",Language.JAVA,25)));
        for (Developer dev: set){
            System.out.println(dev.toString());
        }
    }
}
