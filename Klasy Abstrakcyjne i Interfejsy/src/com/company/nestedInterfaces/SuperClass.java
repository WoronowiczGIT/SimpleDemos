package com.company.nestedInterfaces;

public class SuperClass {
    public static void main(String[] args) {
        Hero h = new SpiderMan();
        System.out.println(Hero.name);
        h.doHeroic();

        AntiHero antiHero = new AntiHero();
        antiHero.causeHavoc();
        antiHero.stayIdle();
    }

    interface Hero {
        String name = "super Hero";
        void doHeroic();
    }

    protected interface Citizen {
        String id = "John";
        void stayIdle();
    }
    // cant implement private interfaces outside of a defining class
    private interface Villain {
        String nickname = "Tom";
        void causeHavoc();
    }
    // To make instance of a class, that implements private interface, class must be declared static
    static class AntiHero implements Villain, Citizen{
        @Override
        public void stayIdle() {
            System.out.println("pretend all good");
        }

        @Override
        public void causeHavoc() {
            System.out.println("mug people");
        }
    }
}
class OutsideClass{
    public static void main(String[] args) {
        SuperClass.AntiHero a = new SuperClass.AntiHero();
        a.stayIdle();
        a.causeHavoc();
    }
}

class AvarageJoe implements SuperClass.Citizen {
    @Override
    public void stayIdle() {
        System.out.println("doing nothing");
    }
}
class SpiderMan implements SuperClass.Hero {
    @Override
    public void doHeroic() {
        System.out.println("swing on a web");
    }
}
