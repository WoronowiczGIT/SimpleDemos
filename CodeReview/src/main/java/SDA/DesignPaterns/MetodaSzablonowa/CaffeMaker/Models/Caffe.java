package SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models;

import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.CaffeType;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.CaffeBeans;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.CaffeParameters.LiquorType;

public class Caffe {
    private CaffeBeans caffeBeans;
    private boolean hasMilk;
    private CaffeType CaffeType;
    private LiquorType liquorType;
    private String extraWishes;

    public Caffe(CaffeBeans caffeBeans, boolean hasMilk, CaffeType caffeType, LiquorType liquorType, String extraWishes) {
        this.caffeBeans = caffeBeans;
        this.hasMilk = hasMilk;
        CaffeType = caffeType;
        this.liquorType = liquorType;
        this.extraWishes = extraWishes;
    }
    public Caffe(){}

    public CaffeBeans getCaffeBeans() {
        return caffeBeans;
    }

    public void setCaffeBeans(CaffeBeans caffeBeans) {
        this.caffeBeans = caffeBeans;
    }

    public boolean isHasMilk() {
        return hasMilk;
    }

    public void setHasMilk(boolean hasMilk) {
        this.hasMilk = hasMilk;
    }

    public CaffeType getCaffeType() {
        return CaffeType;
    }

    public void setCaffeType(CaffeType caffeType) {
        CaffeType = caffeType;
    }

    public LiquorType getLiquorType() {
        return liquorType;
    }

    public void setLiquorType(LiquorType liquorType) {
        this.liquorType = liquorType;
    }

    public String getExtraWishes() {
        return extraWishes;
    }

    public void setExtraWishes(String extraWishes) {
        this.extraWishes = extraWishes;
    }
}
