package com.company.wielobazoweDziedziczenie;

public class Adventure {
    public static void main(String[] args) {
        Hero h = new Hero();
        h.fly();
        h.fight();
    }
}

interface CanFly{ void fly();}

interface CanFight{ void fight();}

class Character{
    public void fight(){ System.out.println("karate Chop"); }
}
class Hero extends Character implements CanFight, CanFly{
    @Override
    public void fly() { System.out.println("fly high"); }
}
