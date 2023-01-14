package com.mouredev.weeklychallenge2022;

import java.util.ArrayList;
import java.util.Arrays;

public class Challenge24 {
    public static void main(String[] args) {

        withWhileLoop();

        withForLoop();

        withSimpleFor();

        withInverseLoop();

        withRecursion(1);

        withIntegerArray();

        withStringStream();

        withRandom();
    }

    private static void withWhileLoop() {
        int i = 1;
        while (i <= 100) {
            System.out.println(i);
            i++;
        }
    }

    private static void withForLoop() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }

    private static void withSimpleFor() {
        for (int i = 1; i <= 100; System.out.println(i++)) ;
    }

    private static void withInverseLoop() {
        for (int i = 100; i >= 1; i--) {
            System.out.println(101 - i);
        }
    }

    private static void withRecursion(int i) {
        if (i <= 100) {
            System.out.println(i);
            withRecursion(i + 1);
        }
    }

    private static void withIntegerArray() {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            array.add(i);
        }
        array.forEach(System.out::println);
    }

    private static void withStringStream() {
        String str = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34," +
                "35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67" +
                ",68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100";
        Arrays.stream(str.split(",")).map(Integer::parseInt).forEach(System.out::println);
    }

    private static void withRandom() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            int random = (int) (Math.random() * 100) + 1;
            if (Arrays.stream(array).anyMatch(j -> j == random)) {
                i--;
            } else {
                array[i] = random;
            }
        }
        Arrays.stream(array).sorted().forEach(System.out::println);
    }
}



