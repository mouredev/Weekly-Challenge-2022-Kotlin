/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package weeklychallenge2022;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.imageio.ImageIO;

/*
 * Reto #5
 * ASPECT RATIO DE UNA IMAGEN
 * Fecha publicación enunciado: 01/02/22
 * Fecha publicación resolución: 07/02/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea un programa que se encargue de calcular y el aspect ratio de una imagen a partir de una url.
 * - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
 * - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
/**
 *
 * @author braiso-22
 */
public class Challenge05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedImage image = null;
        try {
            URL url = new URL(introduceDatos("Introduce la url"));
            image = ImageIO.read(url);

            int width = image.getWidth();
            int height = image.getHeight();
            int MCD = maximoComunDivisor(width, height);

            String ratio = width / MCD + ":" + height / MCD;
            System.out.println(width + "x" + height + "px");
            System.out.println(ratio);
        } catch (MalformedURLException e) {
            System.out.println("La url está mal escrita o tiene un formato no válido");
        } catch (IOException e) {
            System.out.println("Error de lectura, intentelo de nuevo");
        } catch (NullPointerException e) {
            System.out.println("La url pasada no contiene una imagen o está mal formada");
        } catch (Exception e) {
            System.out.println("Error desconocido, contacte con el desarrollador: " + e.getMessage());
        }

    }

    private static int maximoComunDivisor(int width, int height) {
        if (height == 0) {
            return width;
        }
        return maximoComunDivisor(height, width % height);
    }

    private static String introduceDatos(String texto) {
        System.out.println(texto);
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

}
