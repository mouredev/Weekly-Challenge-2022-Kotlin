package dev.grubhart.challenge14;

public class MyMath {


    public Boolean isArmstrongNumbber(int number) {

        if(number<0)
            return null;

        //usamos la parte entera del logaritmo en base 10 y a ese valor le sumamos 1
        // para obtener el numero de digitos
        //
        // una alternativa seria usar divisiones consecutivas entre 10 pero lleva
        // a un incremento de operaciones de forma lineal, de este modo es solo una llamada
        // para obtener este valor
        int numberOfDigits = (int) Math.floor(Math.log10(number))+1;

        if (numberOfDigits>1){
           // return number== getSumOfArmDigitsIterative(number, numberOfDigits);
            return number== getSumOfArmDigitsRecursive(number, numberOfDigits);
        }else
            return true;

    }

    private int getSumOfArmDigitsIterative(int number, int numberOfDigits) {
        int sumOfArmDigits = 0;
        int tempNumber = number;

        for (int j = 0; j< numberOfDigits; j++){
            int mod=tempNumber%10;
            tempNumber= (int) Math.ceil(tempNumber/10);
            sumOfArmDigits= sumOfArmDigits+(int) Math.pow(mod, numberOfDigits);
        }
        return sumOfArmDigits;
    }

    private int getSumOfArmDigitsRecursive(int number, int numberOfDigits) {

        if (number<10){
            return (int) Math.pow(number,numberOfDigits);
        }
        else{// separado por legibilidad
            int unidades = number%10;
            int decenas = (int) Math.ceil(number/10);
            return (int) (Math.pow(unidades,numberOfDigits) + getSumOfArmDigitsRecursive(decenas,numberOfDigits));
        }

    }
}
