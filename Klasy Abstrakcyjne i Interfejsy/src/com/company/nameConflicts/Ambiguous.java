package com.company.nameConflicts;

public class Ambiguous {
    public static void main(String[] args) {
        KnifeFight s = new Knight();
        s.fight();

        StreetFighter sf = new StreetFighter();
        sf.fight();
        sf.fight(25);
    }
}

interface SwordFight{
    void fight();
}
interface GunFight{
    void fight(int i);
}
interface KnifeFight{
    void fight();
}
class Knight implements SwordFight, KnifeFight{
    @Override
    public void fight() {
        System.out.println("Slice n Dice");
    }
}
class StreetFighter extends Fighter implements KnifeFight{
    // Fighter already implements all methods(it treats Knife and Sword as a same),
    // so unless you want to override, you can leave it as it is
}
class Fighter implements SwordFight, GunFight{
    @Override
    public void fight() {
        System.out.println("slash");
    }

    @Override
    public void fight(int i) {
        System.out.println("pew pew "+ i);
    }
}
