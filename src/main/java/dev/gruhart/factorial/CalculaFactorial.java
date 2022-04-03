package dev.gruhart.factorial;

public class CalculaFactorial {

    public int calcula(int i) {
        if (i>1) {
            int cursor = i;
            while(cursor > 1){
                return cursor * calcula(cursor-1);
            }
        }
        return 1;
    }
}
