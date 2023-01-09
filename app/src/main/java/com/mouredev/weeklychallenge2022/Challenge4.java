package com.mouredev.weeklychallenge2022;

public class Challenge4 {


    public static void main(String[] args) {


        System.out.println(new Triangle(2, 5).area());
        System.out.println(new Square(2).area());
        System.out.println(new Rectangle(2, 5).area());


    }


    private static class Polygon {

        public double area(){
            return 0.0;
        }

    }

    public static class Triangle extends Polygon{

        private double a;
        private double b;


        public Triangle(double base, double height) {

            this.a = base;
            this.b = height;

        }

        @Override
        public double area(){

            return (a*b)/2;

        }

    }

    public static class Square extends Polygon{

        private double a;


        public Square(double side){

            this.a = side;

        }

        @Override
        public double area(){

            return a*a;

        }


    }

    public static class Rectangle extends Polygon{

        private double a;
        private double b;

        public Rectangle(double side, double side2){

            this.a = side;
            this.b = side2;

        }

        @Override
        public double area(){

            return a*b;
        }


    }

}
