package com.mouredev.weeklychallenge2022;

public class Challenge13 {

    public static void main(String[] args) {

        System.out.println("5: " +factorial(5));
        System.out.println("-5: " + factorial(-5));
        System.out.println("0: " + factorial(0));
        System.out.println("3:" + factorial(3));
        System.out.println("8: " + factorial(8));

    }


    private static int factorial(int n){

        if(n < 0){
            return 0;
        }else if(n <= 1){  //convención: si es 0 devuelve 1
            return 1;
        }else{
            //n! =  n * ( n - 1)!
            return n * (factorial( n - 1));
        }

    }

}
