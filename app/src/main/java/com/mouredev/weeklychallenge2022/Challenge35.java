package com.mouredev.weeklychallenge2022;

import java.util.HashMap;
import java.util.Map;

public class Challenge35 {

    public static void main(String[] args) {

        getDamage("Grass", "Fire", 50, 20);
    }

    public static void getDamage(String attackerPokemon, String defenderPokemon, double attack, double defend){

        double effectiveness;
        double damage;

        Map<String, Map<String, Double>> battle = new HashMap<>();
        battle.put("Water", Map.of("Water", 0.5,"Fire", 2.0, "Grass", 0.5, "Electric", 1.0));
        battle.put("Fire", Map.of("Water", 0.5,"Fire", 0.5, "Grass", 2.0, "Electric", 1.0));
        battle.put("Grass", Map.of("Water", 2.0,"Fire", 0.5, "Grass", 0.5, "Electric", 1.0));
        battle.put("Electric", Map.of("Water", 2.0,"Fire", 1.0, "Grass", 0.5, "Electric", 0.5));

        if(battle.containsKey(attackerPokemon)){

            if(battle.get(attackerPokemon).containsKey(defenderPokemon)){
                System.out.println(battle.get(attackerPokemon).get(defenderPokemon));
                effectiveness = battle.get(attackerPokemon).get(defenderPokemon);
                damage = 50 * (attack / defend) * effectiveness;
                System.out.println("Damage: " + damage);
            }
        }
    }
}
