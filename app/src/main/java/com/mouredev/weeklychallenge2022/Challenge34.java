package com.mouredev.weeklychallenge2022;

import java.util.ArrayList;
import java.util.List;

public class Challenge34 {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(4);
        integers.add(6);
        integers.add(9);
        integers.add(12);

        List<Integer> missing = findMissingNumbers(integers);

        for (Integer integer : missing) {
            System.out.println(integer);
        }
    }

    public static List<Integer> findMissingNumbers(List<Integer> integers){
        List<Integer> missing = new ArrayList<>();

        for(int i=0; i < integers.size()-1; i++){

            if( integers.get(i) >= integers.get(i+1) ){
                System.out.println("Array is not ordered or has repeated integers");
                missing.clear();
                return missing;
            }

            if( integers.get(i+1) - integers.get(i) != 1 ){

                Integer missingNumber = integers.get(i) + 1;

                while(missingNumber < integers.get(i+1)){
                    missing.add(missingNumber);
                    missingNumber++;
                }
            }
        }

        return missing;
    }
}
