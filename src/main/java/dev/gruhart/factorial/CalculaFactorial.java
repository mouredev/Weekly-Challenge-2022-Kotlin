package dev.gruhart.factorial;

public class CalculaFactorial {

    public int calcula(int i) {

        while(i > 1){
            return i * calcula(i-1);
        }
        return 1;
    }
}
