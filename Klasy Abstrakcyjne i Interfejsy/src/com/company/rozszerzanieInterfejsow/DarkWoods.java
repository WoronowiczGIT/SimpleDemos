package com.company.rozszerzanieInterfejsow;

public class DarkWoods {
    public static void main(String[] args) {
     Dragon s = new Smaug();
     Vampire v = new Dracula();

     lurk(s);
     lurk(v);

     menace(s);
     menace(v);

    }
    public static void lurk(Monster m){
        m.attack();
    }

    public static void menace(Ghost g){
        g.scare();
    }
}
class Dracula implements Vampire{

    @Override
    public void killMortals() {
        System.out.println("vlad drink blood");
    }

    @Override
    public void scare() {
        System.out.println("vlad says boo");
    }

    @Override
    public void attack() {
        System.out.println("vlad bites");
    }
}
class Smaug implements Dragon {
    @Override
    public void attack() {
        System.out.println("tail swipe");
    }

    @Override
    public void destroy() {
        System.out.println("stopm");
    }

    @Override
    public void hordGold() {
        System.out.println(" $$$ :-)");
    }

    @Override
    public void scare() {
        System.out.println("ROAR");
    }
}

interface Ghost{
    void scare();
}
interface Monster{
    void attack();
}
interface BigMonster extends Monster{
    void destroy();
}
interface Dragon extends BigMonster, Ghost{
    void hordGold();
}
interface Vampire extends Monster, Ghost {
    void killMortals();
}