package com.mouredev.weeklychallenge2022;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge9 {

    public static void main(String[] args) {

        String codeMorse = coder("Hello Word, 1000 hello");
        System.out.println(codeMorse);
        System.out.println(coder(codeMorse));

    }


    private static String coder(String text){

        StringBuilder code = new StringBuilder();
        String regex = "^[a-zA-Z0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        String[] auxText = text.toUpperCase().split(" ");
        Matcher matcher = pattern.matcher(auxText[0]);

        Map<String, String> morseCode = new HashMap<>();
        morseCode.put("0", "—————"); morseCode.put("1", "·————"); morseCode.put("2", "··———"); morseCode.put("3", "···——");
        morseCode.put("4", "····—"); morseCode.put("5", "·····"); morseCode.put("6", "—····"); morseCode.put("7", "——···");
        morseCode.put("8", "———··"); morseCode.put("9", "————·");

        morseCode.put(".", "·—·—·—"); morseCode.put(";", "——··——"); morseCode.put("?", "··——··");
        morseCode.put("\"", "·—··—·"); morseCode.put("/", "—··—·");

        morseCode.put("A", "·—"); morseCode.put("B", "—···"); morseCode.put("C", "—·—·"); morseCode.put("CH", "————");
        morseCode.put("D", "—··"); morseCode.put("E", "·"); morseCode.put("F", "··—·"); morseCode.put("G", "——·");
        morseCode.put("H", "····"); morseCode.put("I", "··"); morseCode.put("J", "·———"); morseCode.put("K", "—·—");
        morseCode.put("L", "·—··"); morseCode.put("M", "——"); morseCode.put("N", "—·"); morseCode.put("Ñ", "——·——");
        morseCode.put("O", "———"); morseCode.put("P", "·——·"); morseCode.put("Q", "——·—"); morseCode.put("R", "·—·");
        morseCode.put("S", "···"); morseCode.put("T", "—"); morseCode.put("U", "··—"); morseCode.put("V", "···—");
        morseCode.put("W", "·——"); morseCode.put("X", "—··—"); morseCode.put("Y", "—·——"); morseCode.put("Z", "——··");


        if(matcher.matches()){


            for (String word : auxText ) {

                char[] auxWord = word.toCharArray();

                for (char c : auxWord) {

                    String key = String.valueOf(c);
                    String value = morseCode.get(key);
                    if(value != null){
                        code.append(value);
                        code.append(" ");
                    }

                }

                code.append("  ");

            }


        }else{

            String[] auxWords = text.split("  ");

            for (String aux : auxWords){

                String[] letters = aux.split(" ");

                for (String auxLetter: letters) {

                    for (Map.Entry<String, String> entry : morseCode.entrySet()) {
                        String k = entry.getKey();
                        String v = entry.getValue();

                        if (auxLetter.equalsIgnoreCase(v)) {
                            code.append(k);
                        }

                    }

                }

                code.append(" ");

            }

        }

        return code.toString();
    }

}
