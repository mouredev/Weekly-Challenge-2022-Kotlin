import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] fila = new int[10];

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(1, 9);
            fila[i] = n;
        }
        ArrayList<Boomerang> objetos = new ArrayList<>();


        for (int i = 0; i < fila.length; i++) {
            try {
                if ((fila[i] == fila[i + 2]) && (fila[i] != fila[i + 1])) {
                    objetos.add(new Boomerang(fila[i], fila[i + 1], fila[i + 2]));

                }

            } catch (ArrayIndexOutOfBoundsException ignored) {
                break;
            }
        }

        System.out.println("En el array " + Arrays.toString(fila) + " hay " + objetos.size() + " boomerang/s: ");
        for (Boomerang objeto : objetos) {
            System.out.println(Arrays.toString(objeto.getBoomerang()));
        }
    }
}

class Boomerang {
    public Boomerang(int a, int b, int c) {
        boomerang[0] = a;
        boomerang[1] = b;
        boomerang[2] = c;
    }

    private int[] boomerang = new int[3];

    public int[] getBoomerang() {
        return boomerang;
    }
}