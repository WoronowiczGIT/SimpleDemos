package com.company.init;

/**
 * We need to guarantee a correct initialization of every super class -> call every constructor
 */
public class InitOrder {
    public static void main(String[] args) {
        Sandwitch s = new Sandwitch();
    }
}
class Meal{
    Meal(){ System.out.println("Meal"); }
}
class Bread{
    Bread(){ System.out.println("Bread"); }
}
class Cheese{
    Cheese(){ System.out.println("Cheese"); }
}

class Lunch extends Meal{
    Lunch(){System.out.println("Lunch");}
}

class PortableLunch extends Lunch{
    PortableLunch(){ System.out.println("Portable Lunch"); }
}

class Sandwitch extends PortableLunch{
    private Bread  bread = new Bread();
    private Cheese cheese = new Cheese();
    public Sandwitch(){
        System.out.println("making sandwitch");
    }
}
