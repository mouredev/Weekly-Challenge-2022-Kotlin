package com.mouredev.weeklychallenge2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge10 {

    public static void main(String[] args) {


        System.out.println(isBalanced( "{a + b [c] * (2x2)}}}}"));
        System.out.println(isBalanced("{ [ a * ( c + d ) ] - 5 }"));
        System.out.println(isBalanced("{ a * ( c + d ) ] - 5 }"));
        System.out.println(isBalanced("{a^4 + (((ax4)}"));
        System.out.println(isBalanced("{ ] a * ( c + d ) + ( 2 - 3 )[ - 5 }"));
        System.out.println(isBalanced("{{{{{{(}}}}}}"));
        System.out.println(isBalanced("(a"));

    }

    private static boolean isBalanced(String expression){

        Map<String, String> symbols = new HashMap<>();
        symbols.put("{", "}");
        symbols.put("[", "]");
        symbols.put("(", ")");

        List<String> symbol = new ArrayList<>();

        for (char exp: expression.toCharArray()) {

            boolean containsKey = symbols.containsKey(String.valueOf(exp));
            boolean containsValue = symbols.entrySet().stream().anyMatch(x -> x.getValue().equalsIgnoreCase(String.valueOf(exp)));

            if(containsKey || containsValue){

                if(containsKey){
                    symbol.add(String.valueOf(exp));

                }else if(symbol.isEmpty() || !String.valueOf(exp).equalsIgnoreCase(symbols.get(symbol.remove(symbol.size() - 1)))){
                    return false;
                }

            }
        }


        return symbol.isEmpty();

    }
}
