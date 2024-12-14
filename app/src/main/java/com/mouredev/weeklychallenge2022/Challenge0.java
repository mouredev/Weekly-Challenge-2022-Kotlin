package com.mouredev.weeklychallenge2022;

/**
 * Solución Reto #0
 * "El famoso FizzBuzz"
 * Lenguaje: Java
 * @author JoseSerpaCode
 */

public class Challenge0 {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            
            final int MULTIPLO_3 = i%3;
            final int MULTIPLO_5 = i%5;
            
            String nums = (MULTIPLO_5 == 0 && MULTIPLO_3 == 0) ? "fizzbuzz" 
              : (MULTIPLO_5 == 0) ? "buzz" 
              : (MULTIPLO_3 == 0) ? "fizz" 
              : String.valueOf(i);
            System.out.println(nums);
        }
    }
}
