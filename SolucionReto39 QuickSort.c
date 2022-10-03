/*

Author: LeonardoReichert@Github.com
		(RearlanFDX@Twitch)


from MoureDev@Twitch:
 * Reto #39
 * TOP ALGORITMOS: QUICK SORT
 * Fecha publicación enunciado: 27/09/22
 * Fecha publicación resolución: 03/10/22
 * Dificultad: MEDIA
 *
 * Enunciado: Implementa uno de los algoritmos de ordenación más famosos: el "Quick Sort",
 * creado por C.A.R. Hoare.
 * - Entender el funcionamiento de los algoritmos más utilizados de la historia nos ayuda a
 *   mejorar nuestro conocimiento sobre ingeniería de software. Dedícale tiempo a entenderlo,
 *   no únicamente a copiar su implementación.
 * - Esta es una nueva serie de retos llamada "TOP ALGORITMOS", donde trabajaremos y entenderemos
 *   los más famosos de la historia.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *


-------------------------------------------------------
Notas del autor de la solucion: 

En que nos metiste Moure ? :D
Me ha costado que el algorimo haga lo que queria, probe varias formas y al final resulto y me diverti.

-------------------------------------------------------
Ejecucion del programa: 

Longitud array random: 20
Array random desordenado: 25 3 98 80 21 5 65 7 89 61 28 8 91 29 11 44 70 71 30 25
array ordenado: 3 5 7 8 11 21 25 25 28 29 30 44 61 65 70 71 80 89 91 98
Presione una tecla para continuar . . .

*/


#include <stdio.h>
#include <stdlib.h>
#include <time.h>



void print_array(char * prompt, int * array, unsigned int lenght){
	
	printf(prompt);
	
	for(int i=0; i<lenght; i++){
		printf(" %d", array[i]);
	}
	
	printf("\n");
}


int arrayIsSorted(int * array, unsigned int lenght){
	for(int j=0; j < lenght-1; j++){
			if (array[j] > array[j+1]){
				
				printf("\7");
				
				return 0;
				}
			}
	return 1;
}



	/* videos de investigacion:
		https://www.youtube.com/watch?v=UIBaYOUs8K8
		https://www.youtube.com/watch?v=ljfaHg5pCZ4
		https://www.youtube.com/watch?v=bBvnW5xP2rk
	*/
	

int sort_quicksort(int * array, int lenght)
{
	
	if(lenght < 2){ return 0; }
	
	int temp;
	
	int iPiv = (lenght-1) / 2;
	int vPiv = array[iPiv];
	
	int iLeft = 0;
	int iRight = lenght-1;
	
	int countChanges = 0;
	
	while ( iLeft <= iRight )
	{
		//printf("iL:%d=%d iR:%d=%d\n", iLeft, array[iLeft], iRight, array[iRight]);
		while(array[iLeft] < vPiv)
		{
			iLeft++;
		}
		while(array[iRight] > vPiv)
		{
			iRight--;
		}
		
		if (iRight < iLeft){ break; }
		
		if (array[iLeft] != array[iRight])
		{
			temp = array[iLeft];
			array[iLeft] = array[iRight];
			array[iRight] = temp;
			//printf("\t\thacemos un cambio %d por %d \n", array[iRight], array[iLeft]);
				
			countChanges++;
		}
		iLeft++;
		iRight--;
	}
	
	
	if ( iRight+1 )
	{	
		//printf("a la izquierda: ");
		countChanges += sort_quicksort(array, iRight+1); //excluyendo piv
	}
	
	if( iLeft < (lenght-1) )
	{	
		//printf("a la derecha: ");
		countChanges += sort_quicksort(array+iLeft, lenght-iLeft);
	}
	
	return countChanges;	
}

int randrange(int min, int to){
	
	return rand()%(to-min)+min;
	
}


void arrayRandom(int * out, unsigned int lenght){
	
	int i;
	for(i=0; i<lenght; i++)
	{
		out[i] = randrange(1, 100);
	}
}




int main(int argc, char *argv[]) {
	
	srand(time(0));
	
	int array1[25];
	
	int lenght = randrange(3, 25);
	arrayRandom(array1, lenght);
	
	printf("Longitud array random: %d\n", lenght);
	print_array("Array random desordenado:", array1, lenght);

	int countChanges = sort_quicksort(array1, lenght);
	
	char isSorted = arrayIsSorted(array1, lenght);
	
	if (! isSorted){
		printf("Eso no deberia pasar nunca, el array no esta ordenado.\n");
		return 1;
		}
	
	printf("%d cambios realizados\n", countChanges);
	
	print_array("array ordenado:", array1, lenght);
	
	system("pause");
	
	return 0;
}

