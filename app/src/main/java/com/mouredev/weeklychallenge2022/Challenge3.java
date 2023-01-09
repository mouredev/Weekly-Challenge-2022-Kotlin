package com.mouredev.weeklychallenge2022;

public class Challenge3 {

    public static void main(String[] args) {

        int number = 1;

        while (number <= 100){

            if(isPrimeNumber(number)){
                System.out.println(number);
            }

            number++;
        }

    }

    private static boolean isPrimeNumber(int number){

        if(number <= 1){
            return false;
        }

        int cont = 0;

        for(int i = number; i > 1; i--){

            if(number % i == 0){

                cont++;

            }

        }

        return cont == 1;

    }


}
