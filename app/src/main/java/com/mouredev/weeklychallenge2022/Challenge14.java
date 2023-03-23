package com.mouredev.weeklychallenge2022;

public class Challenge14 {

    public static void main(String[] args) {

        System.out.println("8208 : " + isArmstrong(8208));
        System.out.println("0 : " + isArmstrong(0));
        System.out.println("-52 : " + isArmstrong(-52));
        System.out.println("152 : " + isArmstrong(152));

    }


    private static boolean isArmstrong(int num){

        if(num < 0){

            return false;

        }else {

            char[] auxNum  = String.valueOf(num).toCharArray();
            double pow = auxNum.length;
            int sum = 0;

            for (char c : auxNum) {

                int aux = (int) Math.pow(Double.parseDouble(String.valueOf(c)), pow);
                sum += aux;

            }

            return num == sum;
        }

    }
}
