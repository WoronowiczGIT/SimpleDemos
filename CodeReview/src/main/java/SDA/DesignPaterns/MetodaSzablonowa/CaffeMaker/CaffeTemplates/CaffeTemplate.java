package SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.CaffeTemplates;

import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.CaffeType;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.CaffeBeans;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.LiquorType;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.Caffe;

public abstract class CaffeTemplate {

   public Caffe getOrder() {
        Caffe caffe = new Caffe();

        CaffeBeans caffeBeans = setCoffeeBeans();
        boolean hasMilk = setHasMilk();
        CaffeType caffeType = setCoffeeType();
        LiquorType liquorType = setLiquorType();
        String extraWishes = setExtraWishes();

        caffe.setCaffeBeans(caffeBeans);
        caffe.setHasMilk(hasMilk);
        caffe.setCaffeType(caffeType);
        caffe.setLiquorType(liquorType);
        caffe.setExtraWishes(extraWishes);

        return caffe;
    }

    abstract CaffeBeans setCoffeeBeans();

    abstract boolean setHasMilk();

    abstract CaffeType setCoffeeType();

    abstract LiquorType setLiquorType();

    abstract String setExtraWishes();
}
