/*
 * Reto #36
 * LOS ANILLOS DE PODER
 * Fecha publicación enunciado: 06/08/22
 * Fecha publicación resolución: 14/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales a Sauron
 * contra otras bondadosas que no quieren que el mal reine sobre sus tierras.
 * Cada raza tiene asociado un "valor" entre 1 y 5:
 * - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3), Númenóreanos (4), Elfos (5)
 * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2), Huargos (3), Trolls (5)
 * Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ejércitos:
 * - El resultado puede ser que gane el bien, el mal, o exista un empate. Dependiendo de la
 *   suma del valor del ejército y el número de integrantes.
 * - Cada ejército puede estar compuesto por un número de integrantes variable de cada raza.
 * - Tienes total libertad para modelar los datos del ejercicio.
 * - El patrón a seguir para los argumentos es: X raza, Y raza, Z raza... pueden estar mezclados buenos con malos y se pueden repetir;
 * Ej: 2 Orco 1 Peloso 3 Huargo 13 SurenoBueno...
 * Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

#include <iostream>
#include <map>
using namespace std;

map<string, int> mapBueno{
    {"Peloso", 1},
    {"SurenoBueno", 2},
    {"Enano", 3},
    {"Numeroreano", 4},
    {"Elfo", 5},
};

map<string, int> mapMalo{{"SurenoMalo", 2}, {"Orco", 2}, {"Goblin", 2}, {"Huargo", 3}, {"Troll", 5}};

int cantidadBuenos = 0;

int cantidadMalos = 0;

void printWinner()
{
    if (cantidadBuenos == cantidadMalos)
    {
        cout << "Ha habido un empate entre los bandos. Los resultados son: " << cantidadBuenos << " | " << cantidadMalos << endl;
    }
    else
    {
        cout << "El bando " << (cantidadBuenos > cantidadMalos ? "bueno" : "malo") << " ha sido el ganador. Los resultados son: " << cantidadBuenos << " | " << cantidadMalos << endl;
    }
}

int main(int argc, char const *argv[])
{
    int currCantidad = 0;

    for (int i = 1; i < argc; i++)
    {
        if (i % 2 != 0)
        {
            currCantidad = atoi(argv[i]);
        }
        else
        {
            if (mapBueno.find(argv[i]) != mapBueno.end())
            {
                cantidadBuenos += currCantidad * mapBueno[argv[i]];
            }
            else if (mapMalo.find(argv[i]) != mapMalo.end())
            {
                cantidadMalos += currCantidad * mapMalo[argv[i]];
            }else{
                cout << "No se ha encontrado la raza: " << argv[i] << endl;
            }
        }
    }

    printWinner();

    return 0;
}
