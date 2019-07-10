package com.company.innerClass;

public class DotThis {
    public InnerClass getInner(){
        return new InnerClass();
    }

    class InnerClass {
        public DotThis createParent(){
            return DotThis.this;
        }
        //Multiple levels are allowed
        class Deep{
            public DotThis createParent(){
                return DotThis.this;
            }
        }
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.InnerClass ic = dt.getInner();
        // create parent from a child
        DotThis dt2 = ic.createParent();
    }
}
