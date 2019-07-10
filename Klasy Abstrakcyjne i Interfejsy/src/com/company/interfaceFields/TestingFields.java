package com.company.interfaceFields;

public class TestingFields {
    public static void main(String[] args) {
        Implementation i1 = new Implementation();
        Implementation i2 = new Implementation();
        i1.print();
        i2.print();

    }
}

// interfaces cant share same field name
interface interfaceOne {
    int a = 1;

    void setA(int a1);

}

interface interfaceTwo {
    int b = 2;
}

class Implementation implements interfaceOne, interfaceTwo {

    public void print() {
        System.out.println(a);
        System.out.println(b);
    }

    @Override
    public void setA(int a1) {
        //    error - cant change final variable
        //        a = a1;
    }

}
