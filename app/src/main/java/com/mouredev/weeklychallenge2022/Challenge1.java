package com.mouredev.weeklychallenge2022;


import java.util.Arrays;

public class Challenge1 {


    public static void main(String[] args) {

        String word1 = "aMor";
        String word2 = "Roma";

        System.out.println(isAnagrama(word1, word2));

    }


    private static boolean isAnagrama(String word1, String word2){

        char[] aux = word1.toLowerCase().toCharArray();
        char[] aux2 = word2.toLowerCase().toCharArray();

        if(aux.length != aux2.length){
            return false;
        }

        Arrays.sort(aux);
        Arrays.sort(aux2);

        return (new String(aux).compareTo(new String(aux2)) == 0);

    }


}
