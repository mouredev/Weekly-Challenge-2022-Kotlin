/*
 * Reto #44
 * BUMERANES
 * Fecha publicación enunciado: 02/10/22
 * Fecha publicación resolución: 07/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que retorne el número total de bumeranes de un array de números
 * enteros e imprima cada uno de ellos.
 * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números seguidos, en el que el
 *   primero y el último son iguales, y el segundo es diferente. Por ejemplo [2, 1, 2].
 * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2] y [4, 2, 4]).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

template<typename T, size_t n>
void print_array(T const(& arr)[n])
{
    if (n > 0)
    {
        cout << '[';
        for (size_t i = 0; i < n; i++) {
            cout << arr[i] << ((i != n - 1) ? ", " : "");
        }
        cout << ']' << endl;  
    }
}

void check_bumeranes(int array_bumeranes[], size_t size)
{
    vector<vector<int>> bumeranes;
    if (size >= 3)  // Verificar que hay al menos 3 elementos para que pueda haber al menos 1 búmeran
    {
        for (size_t i = 0; i <= size - 3; i++)
        {
            if (array_bumeranes[i] == array_bumeranes[i + 2]
            && array_bumeranes[i] != array_bumeranes[i + 1])
            {
                vector<int> bumeran = {array_bumeranes[i], array_bumeranes[i + 1], array_bumeranes[i + 2]};
                bumeranes.push_back(bumeran);
            }
        }
    }

    cout << "Numero de bumeranes: " << bumeranes.size() << endl;

    for (vector<int> bumeran : bumeranes)
    {
        if (bumeran.size() >= 3)
        {
            cout << "[" << bumeran[0] << ", " << bumeran[1] << ", " << bumeran[2] << "]";
        }
    }
    cout << endl << endl;
}

int main()
{
    int bumeranes1[] = {2, 1, 2, 3, 3, 4, 2, 4};
    int bumeranes2[] = {2, 1, 2, 1, 3, 4, 2, 4};
    int bumeranes3[] = {4, 5, 6, 7, 6, 9, 5, 3, 4, 3, 4, 7, 8, 1, 8, 2, 3, 1};

    print_array(bumeranes1);
    check_bumeranes(bumeranes1, sizeof(bumeranes1)/sizeof(bumeranes1[0]));

    print_array(bumeranes2);
    check_bumeranes(bumeranes2, sizeof(bumeranes2)/sizeof(bumeranes2[0]));

    print_array(bumeranes3);
    check_bumeranes(bumeranes3, sizeof(bumeranes3)/sizeof(bumeranes3[0]));
}
