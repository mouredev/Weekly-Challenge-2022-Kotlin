/*

Author: LeonardoReichert@Github.com

RearlanFDX @ Twitch



Saludos a MoureDev ! :-)
 * Reto #36
 * LOS ANILLOS DE PODER
 * Fecha publicación enunciado: 06/09/22
 * Fecha publicación resolución: 14/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales a Sauron
 * contra otras bondadosas que no quieren que el mal reine sobre sus tierras.
 * Cada raza tiene asociado un "valor" entre 1 y 5:
 
 * - Razas bondadosas: Pelosos (1),
 			Sureños buenos (2), Enanos (3), Númenóreanos (4), Elfos (5)
 			
 * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2),
 					Huargos (3), Trolls (5)
 					
 * Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ejércitos:
 * - El resultado puede ser que gane el bien, el mal, o exista un empate. Dependiendo de la
 *   suma del valor del ejército y el número de integrantes.
 * - Cada ejército puede estar compuesto por un número de integrantes variable de cada raza.
 * - Tienes total libertad para modelar los datos del ejercicio.
 * Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>



#define MAX_NAMES 5
#define MAX_GROUPS 2

const char RACE_NAMES[MAX_GROUPS][MAX_NAMES][20] = {
{"Pelosos", "Surenyos buenos", "Enanos", "Numenoreanos", "Elfos"}, //buenos - goods
{"Surenyos malos", "Orcos", "Goblins", "Huargos", "Trolls"}, //malos - evils
};


const int RACE_VALS[MAX_GROUPS][MAX_NAMES] = {
{1,2,3,4,5}, // buenos - goods	
{2,2,2,3,5}, // malos - evils
};

//const int ID_GROUP_GOOD = 0;
//const int ID_GROUP_EVIL = 1;


const char GROUP_NAMES[MAX_GROUPS][20] = {
"Bondadosos",
"Malvados",
};




int randrange(int min, int to){
	return min + rand()%(to-min);	
}



int GetRandomIdRaces(int array_group[], int count){
	
	int i;
	for(i=0; i < count; i++){
		array_group[i] = randrange(0, MAX_NAMES); // a new random member of group
	}
		
	return i;
}


int maxFromArray(int array[], int count, int * index){
	int max=array[0];
	*index = 0;
	for(int i=0; i<count; i++){
		if( array[i] > max ){
			max = array[i];
			*index = i;
		}
	}
	return max;
}


int countValFromArray(int array[], int lenght, int val){
	int count=0;
	for(int i=0; i<lenght; i++){
		if(array[i] == val){
			count++;
		}
	}
	return count;
}




int main(int argc, char *argv[]){
	
	
//init seed random:
srand(time(0));


//2 groups:
const int maxGroups = MAX_GROUPS;
const int minMembers = 3;
const int maxMembers = 5;


//races:
int resultMembersIds[maxGroups][maxMembers];
int pointsBattle[maxGroups];


printf("Generando resultados random :)\nSaludos a MoureDev@twitch \n\n");

int iGroup;
for(iGroup=0; iGroup<maxGroups; iGroup++)
{
	printf("[ #%d Grupo: %s ]\n", iGroup+1, GROUP_NAMES[iGroup]);
	
	int countMembers = GetRandomIdRaces(resultMembersIds[iGroup], randrange(minMembers, maxMembers+1));
	pointsBattle[iGroup] = 0;
	for(int iMember=0; iMember<countMembers; iMember++)
	{
		int iRace = resultMembersIds[iGroup][iMember];
		int memberPower = RACE_VALS[iGroup][iRace];
				
		pointsBattle[iGroup] += memberPower;
			
		printf(" #%d Miembro: %s (power: %d)\n", iMember+1, RACE_NAMES[iGroup][iRace], memberPower);
	}
	
	printf("[Poder del grupo: %d] \n", pointsBattle[iGroup]);
	printf("\n"); //separator
}

// results:

printf(" - Resultados del juego -\n");

int maxPoint = maxFromArray(pointsBattle, maxGroups, &iGroup);

if( (countValFromArray(pointsBattle,maxGroups,maxPoint) < 2) ){
	//no hay empate - not tied
	printf("Los grupos ganadores son %s !\n",  GROUP_NAMES[iGroup]);
}
else{
	//hay empate - tied
	printf("Es empate!");
}


return 0; //exit
}





/*
Resultados (1) del programa:

Generando resultados random :)
Saludos a MoureDev@twitch

[ #1 Grupo: Bondadosos ]
 #1 Miembro: Surenyos buenos (power: 2)
 #2 Miembro: Numenoreanos (power: 4)
 #3 Miembro: Numenoreanos (power: 4)
[Poder del grupo: 10]

[ #2 Grupo: Malvados ]
 #1 Miembro: Goblins (power: 2)
 #2 Miembro: Goblins (power: 2)
 #3 Miembro: Goblins (power: 2)
 #4 Miembro: Surenyos malos (power: 2)
[Poder del grupo: 8]

 - Resultados del juego -
Los grupos ganadores son Bondadosos !

--------------------------------
Process exited after 0.03997 seconds with return value 0
Presione una tecla para continuar . . .




Resultados (2) del programa:
Generando resultados random :)
Saludos a MoureDev@twitch

[ #1 Grupo: Bondadosos ]
 #1 Miembro: Pelosos (power: 1)
 #2 Miembro: Enanos (power: 3)
 #3 Miembro: Numenoreanos (power: 4)
 #4 Miembro: Numenoreanos (power: 4)
[Poder del grupo: 12]

[ #2 Grupo: Malvados ]
 #1 Miembro: Trolls (power: 5)
 #2 Miembro: Goblins (power: 2)
 #3 Miembro: Trolls (power: 5)
[Poder del grupo: 12]

 - Resultados del juego -
Es empate!
--------------------------------
Process exited after 0.04774 seconds with return value 0
Presione una tecla para continuar . . .

*/

