package com.company.innerClass;

public class DotNew {

    class Inner{}

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        // creating instance of an inner class
        DotNew.Inner dinner = dn.new Inner();
    }
}
