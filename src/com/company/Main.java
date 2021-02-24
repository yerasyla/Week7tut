package com.company;

import java.util.List;

public abstract class Main implements Printable {

    public static void main(String[] args) {
	// write your code here

        Printable ppp = (p) -> System.out.println(p);
        ppp.print("Hi");

        Shape shape1 = new Circle(5);
        System.out.println("Added new Shape (Circle)");

        System.out.println("Enter login and password:");



        ShapeList<Rectangle> shapes = new ShapeList<>();
        //shapes.addShape(new Rectangle());
    }
}

interface Printable {
    void print(String obj);
}

class ShapeList <T> {
    private List<T> shapes;
    //public ShapeList(List<T> shapes){this.shapes = shapes; }

    public int getNumberOfCircles(){
        int number = 0;
        for (T shape: shapes) {
            if (shape instanceof Circle){
                number = number + 1;
            }
        }
        return number;
    }

    public void addShape(T shape){
        shapes.add(shape);

    }


}


abstract class Shape {
    private String color;
    private boolean filled;


    public Shape(){
        color = "red";
        filled = true;

    }

    public Shape (String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "A shape with color of " + getColor() + " and " + (this.isFilled() ? "filled" : "not filled") + ")";
    }
}

class Circle extends Shape {
    private double radius;

    public  Circle(){
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    //public void setRadius(double radius) {
    //    this.radius = radius;
    //}

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    public  double getPerimeter(){
        return 2 * Math.PI * radius;
    }



    @Override
    public String toString() {
        return "A Circle with radius=" + getRadius() + ", which is a subclass of " + super.toString();

    }
}

class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle(){
        width = 1.0;
        length = 1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea(){
        return width * length;
    }

    public double getPerimeter(){
        return 2*(width + length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width=" + width + " and length=" + length + ", which is a subclass of "+ super.toString() ;
    }
}

