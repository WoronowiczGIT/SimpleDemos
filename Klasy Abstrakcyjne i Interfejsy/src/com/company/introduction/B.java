package com.company.introduction;

public class B extends A {
String tekst;


   public B(String tekst){
        this.tekst = tekst;
    }

    @Override
    public String przywitanie(String tekst) {
        return "Czesc "+tekst;
    }


}
