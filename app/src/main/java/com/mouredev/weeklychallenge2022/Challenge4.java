/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

// triangulo = (base x altura / 2)
// cuadrado = lado x lado
// rectangulo = base x altura

public class Challenge4 {
    public static void main(String[] args) {

        double sides_array[] = new double[3];
        
        sides_array[0] = 2d;
		sides_array[1] = 3d;
		sides_array[2] = 4d;
        System.out.println("El area del triangulo es: " + calculoArea(sides_array));
    }
    /**
     * Recive the length of the sides of the polygon in an array, in a square 1 side, in a rectangle 2 sides and on a triangle 3 sides.
     * @param sides_arr
     * @return //return a double with the area of the polygon
     */
    static double calculoArea (double sides_arr[]){
        double result;
        System.out.println(sides_arr.length);
        if (sides_arr.length == 3) {
            result = (Math.sqrt(
                    (sides_arr[0]+sides_arr[1]+ sides_arr[2])*
                    (sides_arr[1]+ sides_arr[2]-sides_arr[0])*
                    (sides_arr[0]+ sides_arr[2]-sides_arr[1])*
                    (sides_arr[0]+ sides_arr[1]-sides_arr[2])
                ))/4;
            
        }else if (sides_arr.length == 2) {
            result = sides_arr[0] * sides_arr[1];
        } else {
            result = sides_arr[0] * sides_arr[0];
        }
        return result;
    }
}
