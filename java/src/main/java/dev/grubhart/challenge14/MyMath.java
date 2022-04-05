package dev.grubhart.challenge14;

public class MyMath {


    public boolean isArmstrongNumbber(int i) {


        //usamos la parte entera del logaritmo en base 10 y a ese valor le sumamos 1
        // para obtener el numero de digitos
        //
        // una alternativa seria usar divisiones consecutivas entre 10 pero lleva
        // a un incremento de operaciones de forma lineal de este modo es solo una llamada
        // para esta parte
        int numberOfDigits = (int) Math.floor(Math.log10(i))+1;

        if (numberOfDigits>1){
            return false;
        }else
            return true;
    }
}
