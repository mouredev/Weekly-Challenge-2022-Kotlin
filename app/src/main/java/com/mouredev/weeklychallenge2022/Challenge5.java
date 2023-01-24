import javax.imageio.*;
import java.awt.*;
import java.net.URL;
import java.io.IOException;
/*
 * Reto #5
 * ASPECT RATIO DE UNA IMAGEN
 * Fecha publicación enunciado: 01/02/22
 * Fecha publicación resolución: 07/02/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea un programa que se encargue de calcular el aspect ratio de una imagen a partir de una url.
 * - Nota: Esta prueba no se puede resolver con el playground online de Kotlin. Se necesita Android Studio.
 * - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
 * - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

public class Challenge5 {

    public static void main(String[] args) {
        int imageWidth, imageHeight;
        Image image = null;
        try {
            URL url = new URL(
                    "https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png");
            image = ImageIO.read(url);
            imageWidth = image.getWidth(null);
            imageHeight = image.getHeight(null);
            System.out.println("El ratio de imagen es: " + ratioCalc(imageWidth, imageHeight));
            //System.out.println("El ratio de imagen es: " + ratioCalc(1920, 1080));
        } catch (IOException e) {
            System.out.println("No se ha encontrado la imagen.");
        }
    }

    private static String ratioCalc(int imgWidth, int imgHeight) {
        Double imageW = 0d, imageH = 0d, imageWdecimal = 0d, resultdecimal = 0d, result = 0d;
        for (int i = 1; i < 1000; i++) {
            imageW = Double.valueOf(imgWidth) / i;
            imageWdecimal = Math.floor(Double.valueOf(imgWidth) / i);

            if (imageW - imageWdecimal == 0) {

                result = imgHeight / (Double.valueOf(imgWidth) / i);
                resultdecimal = Math.floor(imgHeight / (Double.valueOf(imgWidth) / i));

                imageH = Double.valueOf(imgHeight) / i;
                if (resultdecimal - result == 0) {
                    return i + ":" + result.intValue();
                }
            }
        }
        return "No tiene ratio aceptable.";
    }
}
