package com.mouredev.weeklychallenge2022;

public class Challenge16 {

    public static void main(String[] args) {

        String sentence = "¿ hola ?, alguien por ahí??";
        System.out.println(capitalize(sentence));

    }

    private static String capitalize(String word){

        String normalized = word.replaceAll("[^a-zA-Zá-úÁ-Ú]", " ");
        String[] auxSplit = normalized.split(" ");

        for (String s : auxSplit) {

            String letter = (s.length() > 0) ? String.valueOf(s.toCharArray()[0]) : "";
            String capitalizedWord = s.replaceFirst(letter, letter.toUpperCase());

            normalized = normalized.replace(s, capitalizedWord);

        }

        return normalized;

    }
}
