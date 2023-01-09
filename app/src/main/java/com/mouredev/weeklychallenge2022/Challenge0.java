package com.mouredev.weeklychallenge2022;

public class Challenge0 {

    public static void main(String[] args) {

        fizzBuzz();

    }


    public static void fizzBuzz(){

        for(int i = 0 ; i <= 100; i++){

            boolean isFizz = i % 3 == 0;
            boolean isBuzz = i % 5 == 0;

            if(isFizz && isBuzz){
                System.out.println("fizzbuzz");
            }else if(isFizz){
                System.out.println("fizz");
            }else if(isBuzz){
                System.out.println("buzz");
            }else{
                System.out.println(i);
            }

        }

    }

}
