package SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.CaffeTemplates;

import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.CaffeType;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.CaffeBeans;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.LiquorType;

public class RudesheimerCaffe extends CaffeTemplate {
    @Override
    CaffeBeans setCoffeeBeans() {
        return CaffeBeans.ARABICA;
    }

    @Override
    boolean setHasMilk() {
        return true;
    }

    @Override
    CaffeType setCoffeeType() {
        return CaffeType.CAFFELATTE;
    }

    @Override
    LiquorType setLiquorType() {
        return LiquorType.COGNAC;
    }

    @Override
    String setExtraWishes() {
        return "lot of whipped cream and chocolate";
    }
}
