// Reto #35
// BATALLA POKÉMON
// Fecha publicación enunciado: 29/08/22
// Fecha publicación resolución: 06/09/22
// Dificultad: MEDIA
// 
// Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
// - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
// - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
// - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
// - El programa recibe los siguientes parámetros:
// - Tipo del Pokémon atacante.
// - Tipo del Pokémon defensor.
// - Ataque: Entre 1 y 100.
// - Defensa: Entre 1 y 100.

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define AGUA 0
#define FUEGO 1
#define PLANTA 2
#define ELECTRICO 3

char *tipos[4] = {"Agua", "Fuego", "Planta", "Electrico"};
char *efect_strings[3] = {"No es muy efectivo...", "Efecto Normal", "Es SUPER-EFECTIVO!"};
float tiposEfectividad[4][4] = {{0.5, 2, 0.5, 1}, {0.5, 0.5, 2, 1}, {2, 0.5, 0.5, 1}, {2, 1, 0.5, 0.5}};
int pokAtaca, pokDefiende, ataque, defensa;
float efectividad, damage;

char *strlower(char *string);

int main(int argc, char **argv) {
    if (argc == 5) {
        if (!strcmp(strlower(argv[1]), "agua")) pokAtaca = AGUA;
        else if (!strcmp(strlower(argv[1]), "fuego")) pokAtaca = FUEGO;
        else if (!strcmp(strlower(argv[1]), "planta")) pokAtaca = PLANTA;
        else if (!strcmp(strlower(argv[1]), "electrico")) pokAtaca = ELECTRICO;
        else {
            puts("ERROR: Parámetros no válidos");
            exit(-1);
        }
        if (!strcmp(strlower(argv[2]), "agua")) pokDefiende = AGUA;
        else if (!strcmp(strlower(argv[2]), "fuego")) pokDefiende = FUEGO;
        else if (!strcmp(strlower(argv[2]), "planta")) pokDefiende = PLANTA;
        else if (!strcmp(strlower(argv[2]), "electrico")) pokDefiende = ELECTRICO;
        else {
            puts("ERROR: Parámetros no válidos");
            exit(-1);
        }
        ataque = atoi(argv[3]);
        defensa = atoi(argv[4]);
        if ((ataque < 1 || ataque > 100) || (defensa <1 || defensa > 100)){
            puts("ERROR: Parámetros no válidos");
            exit(-1);
        }   
    }
    else {
        puts("ERROR: Parámetros no válidos");
        exit(-1);
    }
    
    efectividad = tiposEfectividad[pokAtaca][pokDefiende];
    damage = 50 * ((float)ataque / defensa) * efectividad;

    printf("\nAtaque Pokemon\n");
    printf("==============\n");
    printf("Ataca:    %s - ATK: %d\n", tipos[pokAtaca], ataque);
    printf("Defiende: %s - DEF: %d\n", tipos[pokDefiende], defensa);
    printf("Daño: %0.2f - %s\n\n", damage, efect_strings[(int)efectividad]);

    return 0;
}


// Utilidades //
char *strlower(char *string) {
    char *p = string;

    for(; *p; ++p) *p = tolower(*p);
    return string;
}
