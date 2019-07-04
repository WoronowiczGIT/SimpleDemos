package com.company.traps;

public class PrivateOverride {
    private void f(){
        System.out.println("private method");
    }

    public static void main(String[] args) {

        PrivateOverride p1 = new PrivateOverride();
        p1.f();

        // private method is effectively final and you cant override them
        PrivateOverride p2 = new Child();
        p2.f();

        Child p3 = new Child();
        p3.f();
    }
}

class Child extends PrivateOverride{
    public void f(){
        System.out.println("public method");
    }
}
