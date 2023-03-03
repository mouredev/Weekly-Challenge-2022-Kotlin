package com.mouredev.weeklychallenge2022;

import java.util.Arrays;
import java.util.List;

//Dado un listado de números, encuentra el SEGUNDO más grande.
public class Reto32 {
    public static void main(String[] args) {
        //Lista de numeros
        List<Integer> numeros = Arrays.asList(5,10,6,8,11);
        //Ordenando de mayor a menor
        numeros.sort((a,b) -> a<b?1:a==b?0:-1);
        
        System.out.println("El segundo mayor es:" + numeros.get(1));

        //out: El segundo mayor es:10

    }
}