package SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.CaffeTemplates;

import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.CaffeType;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.CaffeBeans;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.LiquorType;

public class LatteButWithoutMilk extends CaffeTemplate {
    @Override
    CaffeBeans setCoffeeBeans() {
        return CaffeBeans.ROBUSTA;
    }

    @Override
    boolean setHasMilk() {
        return false;
    }

    @Override
    CaffeType setCoffeeType() {
        return CaffeType.AMERICANA;
    }

    @Override
    LiquorType setLiquorType() {
        return LiquorType.NOLIQUOR;
    }

    @Override
    String setExtraWishes() {
        return "Another idiot";
    }
}
