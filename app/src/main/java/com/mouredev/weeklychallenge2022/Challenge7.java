package com.mouredev.weeklychallenge2022;

import java.util.HashMap;
import java.util.Map;

public class Challenge7 {

    public static void main(String[] args) {

        String text = "Hola: mundo, hola!!!";

        String[] sentence = text
                .toLowerCase()
                .replaceAll("[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]", "")
                .split(" ");

        Map<String, Integer> countWords = new HashMap<>();

        for (String word: sentence ) {

            if(countWords.containsKey(word)){
                int value = countWords.get(word);
                countWords.put(word, value+1);
            }else{
                countWords.put(word, 1);
            }
        }

        countWords.forEach((key, value) -> System.out.println(key + ": " + value));



    }

}
