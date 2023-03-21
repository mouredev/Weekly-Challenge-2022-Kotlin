package com.mouredev.weeklychallenge2022;

import java.text.Normalizer;

public class Challenge12 {

    public static void main(String[] args) {

        String text = "Adivina ya te opina, ya ni miles origina, ya ni cetro me domina, ya ni monarcas, a repaso ni mulato carreta, acaso nicotina, " +
                "ya ni cita vecino, anima cocina, pedazo gallina, " +
                "cedazo terso nos retoza de canilla goza, de pánico camina, ónice vaticina, ya ni tocino saca, a terracota luminosa pera, " +
                "sacra nómina y ánimo de mortecina, ya ni giros elimina, ya ni poeta, ya ni vida";
        String text2 = "¿es palíndromo?";

        System.out.println("Es palíndromo: " + (isPalindrome(text) ? "Si" : "No"));
        System.out.println("Es palíndromo: " + (isPalindrome(text2) ? "Si" : "No"));
        System.out.println("Es palíndromo: " + (isPalindrome("‚¿¡8Ana8-+") ? "Si" : "No"));
        System.out.println("Es palíndromo: " + (isPalindrome("Ana lleva al oso la avellana.") ? "Si" : "No"));

    }

    private static boolean isPalindrome(String text){


        String normalized = Normalizer.normalize(text.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll( "[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]", "")
                .replaceAll("\\s", "");

        String textReversed = new StringBuilder(normalized).reverse().toString();

        return normalized.equalsIgnoreCase(textReversed);
    }

}
