package dev.gruhart.factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Ingrese un numero\n");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        long factorial = new CalculaFactorial().calcula(Integer.parseInt(number));

        System.out.println("El factorial de "+number+" es "+factorial);
    }
}
