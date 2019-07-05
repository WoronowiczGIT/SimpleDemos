package com.company.traps;

public class polimorpicConstructor{

}
class Shape {
    void draw(){
        System.out.println("draw some shape");
    }
    Shape(){
        System.out.println("before method");
        draw();
        System.out.println("after method");
    }
}
class Circle extends Shape{
    private int radius = 1;
    Circle(int radius){
        this.radius = radius;
        System.out.println("draw Circle, radius: "+radius);
    }
    void draw(){
        System.out.println("draw Circle, radius: "+radius);
    }
}
class test{
    public static void main(String[] args) {
        new Circle(5);
    }
}
