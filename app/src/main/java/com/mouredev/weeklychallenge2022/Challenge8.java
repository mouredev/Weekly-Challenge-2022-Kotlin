package com.mouredev.weeklychallenge2022;

public class Challenge8 {

    public static void main(String[] args) {

        System.out.println(decimalToBinaryNumber(17));

    }


    private static String decimalToBinaryNumber(int number){

        StringBuilder binaryNumber = new StringBuilder();

        while(number > 0){

            binaryNumber.insert(0, number % 2);
            number = number/2;

        }

        return binaryNumber.toString();
    }
}
