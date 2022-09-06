/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

#include <iostream>
#include <algorithm>
using namespace std; 

bool checkInt(char const *input){
    char* p;
    long converted = strtol(input, &p, 10);
    if (*p) {
        return false;
    }
    else {
        return true;
    }
}

bool checkRepeated(int *arr, int size){
    return (unique(arr, arr + size) != arr + size);
}

int main(int argc, char const *argv[])
{
    int *intArray = new int[argc];
    for(int i = 1; i < argc; i++){
        if(!checkInt(argv[i])){
            cout << "ERROR: Invalid argument. Arguments must be integers." << endl;
            return -1;
        }
        intArray[i - 1] = atoi(argv[i]);
    }

    sort(intArray, intArray + argc);

    if(checkRepeated(intArray, argc)){
        cout << "ERROR: Invalid argument. Arguments must not be repeated." << endl;
        return -1;
    }

    cout << "Los números que faltan entre el mayor y el menor son: " << endl;

    bool printedFirst = false;

    for(int i = 0; i < argc; i++){
        for(int j = intArray[i]; j < intArray[i+1] - 1; j++){
            if(printedFirst){
                cout << " | ";
            }
            cout << j + 1;
            printedFirst = true;
        }
    }
    cout << endl;

    return 0;
}
