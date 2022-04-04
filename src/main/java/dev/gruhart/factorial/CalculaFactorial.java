package dev.gruhart.factorial;

public class CalculaFactorial {

    public Integer calcula(Integer i) {

        if(i<0)
            return null; // manejando negativos

        if(i > 1){
            return i * calcula(i-1);
        }
        return 1;
    }
}
