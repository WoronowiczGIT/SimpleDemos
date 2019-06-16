package SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.CaffeTemplates;

import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.CaffeType;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.CaffeBeans;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.LiquorType;

public class IGotTheBiggestHangover extends CaffeTemplate {
    @Override
    CaffeBeans setCoffeeBeans() {
        return CaffeBeans.ARABICA;
    }

    @Override
    boolean setHasMilk() {
        return false;
    }

    @Override
    CaffeType setCoffeeType() {
        return CaffeType.ESPRESSO;
    }

    @Override
    LiquorType setLiquorType() {
        return LiquorType.VODKA;
    }

    @Override
    String setExtraWishes() {
        return "Shot of vodka on the side + cucumber";
    }
}
