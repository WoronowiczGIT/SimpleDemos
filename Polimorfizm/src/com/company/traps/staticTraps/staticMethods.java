package com.company.traps.staticTraps;

/**
 * static methods depend on class not on object
 */

public class staticMethods {
    public static void main(String[] args) {
        SuperStaticClass s = new ChildStaticClass();
        s.dynamicGet();
        s.staticGet();
    }
}

class SuperStaticClass{
    public static void staticGet(){
        System.out.println("call static super method");
    }
    public void dynamicGet(){
        System.out.println("call dynamic super method");
    }
}
class ChildStaticClass extends SuperStaticClass{
    public static void staticGet(){
        System.out.println("call static sub method");
    }
    public void dynamicGet(){
        System.out.println("call dynamic sub method");
    }
}
