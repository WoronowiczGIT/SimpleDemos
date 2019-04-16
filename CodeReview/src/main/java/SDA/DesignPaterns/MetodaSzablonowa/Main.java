package SDA.DesignPaterns.MetodaSzablonowa;

import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.CaffeTemplates.CaffeTemplate;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.CaffeTemplates.RudesheimerCaffe;
import SDA.DesignPaterns.MetodaSzablonowa.CaffeMaker.Models.Caffe;

public class Main {
    public static void main(String[] args) {

        Caffe orderedCoffe = new RudesheimerCaffe().getOrder();

        System.out.println(orderedCoffe.getExtraWishes());

    }

}
