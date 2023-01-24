import java.util.Arrays;
import java.util.List;

public class SegundoMayor {
    /**
     * Implementación de menor complejidad (complejidad lineal) solo se recorre una vez la lista
     * y se dejan los 2 mayores encontrados. En caso de encontrar un mayor pasara el mayor actual
     * detectado al segundo lugar.
     * <p>
     * Si ordernaramos el array y lo recorrieramos hasta detectar un cambio tambíen lo encontrariamos
     * pero la complejidad dejaría de ser lineal.
     *
     */
    public static void main(String[] args) {
        Double[] numbers = {1.5, 2.0, 11.0, 3.0, 5.0, 11.0, 9.0, 3.0, 3.0009, 2.03, 2.05, 9.0000001};
        Double[] mayores = {-1.0, -1.0};

        List<Double> listNumbers = Arrays.asList(numbers);
        List<Double> listMayores = Arrays.asList(mayores);

        listNumbers.forEach(
                (final Double number) -> {
                    double primeroMayor = listMayores.get(0);
                    double segundoMayor = listMayores.get(1);

                    if(number!=primeroMayor && number!=segundoMayor){
                        if (number > primeroMayor) {
                            listMayores.set(0, number);
                            listMayores.set(1, primeroMayor);
                        } else if (number > segundoMayor) {
                            listMayores.set(1, number);
                        }
                    }
                }
        );

        if (listMayores.get(1) != null) {
            System.out.println("Segundo Mayor " + listMayores.get(1));
        }
    }
}
