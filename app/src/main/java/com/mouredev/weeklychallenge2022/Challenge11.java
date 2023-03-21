package com.mouredev.weeklychallenge2022;

public class Challenge11 {

    public static void main(String[] args) {

        printNonCommon("Silvana", "casa");
        printNonCommon("Usa el canal de nuestro discord (https://mouredev.com/discord) \"\uD83D\uDD01reto-semanal\" para preguntas, dudas o prestar ayuda a la comunidad",
                "Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.");
    }


    private static void printNonCommon(String str1, String str2){

        System.out.println("out1: " + getNonCommon(str1, str2));
        System.out.println("out2: " + getNonCommon(str2, str1));

    }

    private static String getNonCommon(String str1, String str2){

        StringBuilder out1 = new StringBuilder();

        for (char st1: str1.toLowerCase().toCharArray()) {

            if(!str2.toLowerCase().contains(String.valueOf(st1))){
                out1.append(st1);

            }
        }

        return out1.toString();


    }

}
