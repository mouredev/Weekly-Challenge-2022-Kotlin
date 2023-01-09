package com.mouredev.weeklychallenge2022;

public class Challenge6 {

    public static void main(String[] args) {

        String word = "Hola mundo";

        char[] wordCharArray = word.toCharArray();

        StringBuilder reverseWord = new StringBuilder();

        for(int i = wordCharArray.length - 1; i >= 0; i --){

            reverseWord.append(wordCharArray[i]);

        }

        System.out.println(reverseWord);

    }
}
