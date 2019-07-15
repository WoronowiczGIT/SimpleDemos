package com.company.traps.staticTraps;

public class staticFields {

    public static void main(String[] args) {
        SuperClass s = new SubClass();
        System.out.println("upcasting sub -> super");
        System.out.println("field: "+s.value +" method: "+ s.getValue());

        System.out.println("no casting");
        SubClass s2 = new SubClass();
        System.out.println("field: "+s2.value +" method: "+ s2.getValue()+ " super: "+s2.getSuperValue());
        }
}

/**
 * Fields are not polimorphic, in case of double names, we call drirectly the fields of super class,
 * although methods are polimorphic, so they call the field dependant of the method.
 */

class SuperClass{
    public int value = 0;
    public int getValue (){return value;}
}

class SubClass extends SuperClass{
    public int value = 1;
    public int getValue() {return value;}
    public int getSuperValue(){return super.value;}
}
