/*
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

#include <iostream>
#include <math.h>
using namespace std;

int main(int argc, char const *argv[])
{

    int decimal = 0;

    if (argc == 2)
    {
        string binNum = argv[1];
        int j = 0;
        for (int i = binNum.length() - 1; i >= 0; i--)
        {
            if (binNum[i] == '1')
            {
                decimal += pow(2, j);
            }
            j++;
        }
        cout << "El número binario: " << argv[1] << " equivale al numero decimal: " << decimal << endl;
    }
    else
    {
        cout << "Revisa el enunciado y vuelve a pasar los argumentos correctamente." << endl;
    }

    return 0;
}
