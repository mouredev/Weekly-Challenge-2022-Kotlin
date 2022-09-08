// * Reto #36
// * LOS ANILLOS DE PODER
// * Fecha publicación enunciado: 06/09/22
// * Fecha publicación resolución: 14/09/22
// * Dificultad: MEDIA
// *
// * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales a Sauron
// * contra otras bondadosas que no quieren que el mal reine sobre sus tierras.
// * Cada raza tiene asociado un "valor" entre 1 y 5:
// * - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3), Númenóreanos (4), Elfos (5)
// * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2), Huargos (3), Trolls (5)
// * Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ejércitos:
// * - El resultado puede ser que gane el bien, el mal, o exista un empate. Dependiendo de la
// *   suma del valor del ejército y el número de integrantes.
// * - Cada ejército puede estar compuesto por un número de integrantes variable de cada raza.
// * - Tienes total libertad para modelar los datos del ejercicio.
// * Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
// *
// * Información adicional:
// * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
// *   para preguntas, dudas o prestar ayuda a la comunidad.
// * - Tienes toda la información sobre los retos semanales en
// *   https://retosdeprogramacion.com/semanales2022.
 
#include <iostream>
#include <string>
#include <map>

using namespace std;

//Headers
void batalla (map<string, int> &ejercitoBondadoso, map<string, int> &ejercitoMalvado);
int getValorDelEjercito (map<string, int> &ejercito);

map<string, int> valorRazas = {{ "pelosos", 1 },{ "sureniosBuenos", 2 },{ "enanos", 3 },{ "numenoreanos", 4 },{ "elfos", 5 },{ "sureniosMalos", 2 },{ "orcos", 2 },{ "goblins", 2 },{ "huargos", 3 },{ "trolls", 5 }};


//Body
int main (int argc, char const *argv[]) 
{
    map<string, int> demoArmy = {{ "pelosos", 4 },{ "enanos", 9 }};
    map<string, int> demoArmy2 = {{ "sureniosMalos", 4 },{ "orcos", 9 }};
    
    batalla(demoArmy, demoArmy2);
    return 0;
}


void batalla (map<string, int> &ejercitoBondadoso, map<string, int> &ejercitoMalvado)
{
    if (getValorDelEjercito(ejercitoBondadoso) > getValorDelEjercito(ejercitoMalvado)){
        cout << "El ejercito bondadoso ha ganado." << endl;
    }

    else if (getValorDelEjercito(ejercitoBondadoso) < getValorDelEjercito(ejercitoMalvado)){
        cout << "El ejercito malvado ha ganado." << endl;
    }

    else
        cout << "Los ejercitos han empatado." << endl;
}


int getValorDelEjercito (map<string, int> &ejercitoBondadoso)
{
    int valor = 0;

    for ( const auto &p : ejercitoBondadoso )
    {
        if (!valorRazas.count( p.first ))
            continue;

        valor += p.second * valorRazas.at(p.first);
    }
    return valor;
}