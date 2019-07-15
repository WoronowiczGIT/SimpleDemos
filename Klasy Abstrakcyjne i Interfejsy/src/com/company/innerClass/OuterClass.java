package com.company.innerClass;

public class OuterClass {
    private int i = 1;

    public void printALL(){
        PrivClass pc = new PrivClass();
        System.out.println(" "+ i + pc.getP());
        System.out.println(" "+ i + new PubClass().getG());
    }
    // cant instantiate outside of outerclass
    private class PrivClass{
        private int p = 5;

        public int getP() {
            // Inner class got free access to all fields and method of outterclass
            System.out.println(i);
            return p;
        }
    }

    class PubClass{
        private int g = 7;
        public int getG(){
            System.out.println(i);
            return g;
        }
    }
}

class Test{
    public static void main(String[] args) {
        OuterClass o = new OuterClass();
        o.printALL();
        // If we want to instantiate sub class, we need to declare it static
        // therefore lose access to its outerclass,
        //OuterClass.PubClass pub = new OuterClass.PubClass();
    }
}


