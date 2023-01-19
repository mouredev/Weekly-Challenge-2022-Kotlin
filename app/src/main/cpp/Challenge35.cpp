#include <iostream>
using namespace std;

/*
 * Reto #35
 * BATALLA POKÉMON
 * Fecha publicación enunciado: 29/08/22
 * Fecha publicación resolución: 06/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
 * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
 * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
 * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
 * - El programa recibe los siguientes parámetros:
 *  - Tipo del Pokémon atacante.
 *  - Tipo del Pokémon defensor.
 *  - Ataque: Entre 1 y 100.
 *  - Defensa: Entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

// Matriz de efectividad (orden alfabético A, E, F, P)
float effectMatrix[4][4] = {
    {0.5, 1, 2, 0.5}, 
    {2, 0.5, 1, 0.5}, 
    {0.5, 1, 0.5, 2}, 
    {2, 1, 0.5, 0.5}};

string att_type = "";
string def_type = "";
int att = 0;
int def = 0;


float calcAttack(int att, int def, float eff){ 
    return 50 * ((float) att / (float) def) * eff;
}

int selectorChar(string att){
    switch(att[0]){
        case 'A': return 0;
        case 'E': return 1;
        case 'F': return 2;
        case 'P': return 3;
    }
    return 0;
}

float calcEff(string att, string def){

    int selCharAtt = selectorChar(att);
    int selCharDef = selectorChar(def);

    return effectMatrix[selCharAtt][selCharDef];
}

int main(int argc, char const *argv[])
{

    if(argc == 5){
        att_type = argv[1];
        def_type = argv[2];
        att = stoi(argv[3]);
        def = stoi(argv[4]);

        float effectivity = calcEff(att_type, def_type);
        float hit = calcAttack(att, def, effectivity);
        cout << "El daño calculado es de: " << hit << " PS" << endl;
        return 0;
    }else{
        cout << "No se han pasado los argumentos correctamente, revisa el enunciando. Argumentos recibidos: " << argc << endl;
        return -1;
    }

    return 0;
}

