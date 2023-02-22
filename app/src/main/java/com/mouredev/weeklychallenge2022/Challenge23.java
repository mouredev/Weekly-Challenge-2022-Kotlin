package com.mouredev.weeklychallenge2022;

import java.util.*;

public class Challenge23 {
    public static void main(String[] args) {
        System.out.println(leastCommonMultiple(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(greatestCommonDivisor(60, 120, 480, 1440));
    }

    private static int leastCommonMultiple(Integer... numbers) {
        int leastCommonMultiple = 1;
        ArrayList<Integer> listOfNumbers = new ArrayList<>(Arrays.asList(numbers));

        // Save the common and non-common divisors to the higher exponent in a hashmap
        HashMap<Integer, Integer> actualDivisors = removeByExponents(listOfNumbers, true);

        // Iterate over the hashmap and multiply all the dividers powered to its exponents
        for (Integer key : actualDivisors.keySet()) {
            leastCommonMultiple *= Math.pow(key, actualDivisors.get(key));
        }
        return leastCommonMultiple;
    }

    private static int greatestCommonDivisor(Integer... numbers) {
        int greatestCommonDivisor = 1;
        ArrayList<Integer> listOfNumbers = new ArrayList<>(Arrays.asList(numbers));

        // Save the common divisors to the lower exponent in a hashmap
        HashMap<Integer, Integer> actualDivisors = removeNotCommonDivisors(removeByExponents(listOfNumbers, false), listOfNumbers);

        // Iterate over the hashmap and multiply all the dividers powered to its exponents
        for (Integer key : actualDivisors.keySet()) {
            greatestCommonDivisor *= Math.pow(key, actualDivisors.get(key));
        }
        return greatestCommonDivisor;
    }

    /**
     * Function that removes the duplicated divisors from a list of numbers
     * getting only the ones with higher or lower exponents
     * depending on the boolean param  and returns a hashmap with the divisors and their exponents
     *
     * @param listOfNumbers
     * @param lowerExponents
     * @return HashMap<Integer, Integer>
     */
    private static HashMap<Integer, Integer> removeByExponents(ArrayList<Integer> listOfNumbers, Boolean lowerExponents) {
        HashMap<Integer, Integer> exponents = new HashMap<>();
        // Loop through each number in the list
        for (Integer number : listOfNumbers) {

            // Saves the divisors in a hashmap
            HashMap<Integer, Integer> actualDivisors = getDivisors(number);

            // Iterate through the divisors of the number
            for (Integer key : actualDivisors.keySet()) {
                // If the divisor is already in the hashmap, check if it has to save the lower or the higher exponent
                if (exponents.containsKey(key)) {
                    if (lowerExponents) {
                        if (exponents.get(key) < actualDivisors.get(key)) {
                            exponents.put(key, actualDivisors.get(key));
                        }
                    } else {
                        if (exponents.get(key) > actualDivisors.get(key)) {
                            exponents.put(key, actualDivisors.get(key));
                        }
                    }
                } else {
                    // If the divisor is not in the hashmap, save it with the exponent 1
                    exponents.put(key, actualDivisors.get(key));
                }
            }
        }
        return exponents;
    }

    /**
     * Function that returns the common divisors of a  list of number in a hashmap
     * with the divisor as key and the exponent as value
     *
     * @param divisors
     * @param listOfNumbers
     * @return HashMap<Integer, Integer>
     */
    private static HashMap<Integer, Integer> removeNotCommonDivisors(HashMap<Integer, Integer> divisors, ArrayList<Integer> listOfNumbers) {
        for (Integer number : listOfNumbers) {
            Iterator<Map.Entry<Integer, Integer>> iterator;

            // Iterate through the divisors of the number and remove the ones that are not divisors of all the numbers
            for (iterator = divisors.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                Integer key = entry.getKey();
                if (number % key != 0) {
                    iterator.remove();
                }
            }
        }
        return divisors;
    }

    /**
     * Function that returns the divisors of a number in a hashmap with the divisor as key and the exponent as value
     *
     * @param number
     * @return HashMap<Integer, Integer>
     */
    private static HashMap<Integer, Integer> getDivisors(Integer number) {
        HashMap<Integer, Integer> divisors = new HashMap<>();
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                if (divisors.containsKey(i)) {
                    divisors.put(i, divisors.get(i) + 1);
                } else {
                    divisors.put(i, 1);
                }
                number /= i;
                i--;
            }

        }
        return divisors;
    }
}