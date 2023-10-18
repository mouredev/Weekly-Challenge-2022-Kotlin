/*
Lenguage C
Challenge 34 [from MoureDev]

MoureDev:
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una funcion que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.


Author of code:
LeonardoReichert@github.com
RearlanFDX@Twitch


Results of this programa:
--------------------------------
Numbers array 1:
1 5 8 20 25
Numbers out of array 1:
2 3 4 6 7 9 10 11 12 13 14 15 16 17 18 19 21 22 23 24
Presione una tecla para continuar . . .
--------------------------------
*/

#include <stdio.h>
#include <stdlib.h>


void print_array(const char * title, int * array, int lenght){
	
	int i;
	
	printf("%s\n", title);
	
	for(i=0; i<lenght; i++){
		printf("%d ", *(array+i));
		}
		
	printf("\n");
}


int * GetOthersNumbers(const int * numbers, int * lenght, int * err){
	
	/*
	parametros:
	> un puntero a array de numeros enteros
	> un puntero con la longitud del array entregado,
		< recibe la longitud del nuevo array devuelto por la funcion
	> un puntero a int err para recibir un error al terminar la funcion
	
	Return:
	< devuelve un puntero a un array dinamico de los valores faltantes
		(si tiene exito)
	*/
	
	int i;
	int nBefore = *(numbers); //first
	int need_add=0;
	
	
	// first time, validate array and calculate lenght of a new array
	for (i=1; i<*lenght; i++){
		if (*(numbers+i) <= nBefore){
			//error, not sorted or repeated
			*err = 1;
			return 0;
			}
		else if ((*(numbers+i)-nBefore) > 1){
			need_add += *(numbers+i)-nBefore-1;
			}
			
		nBefore = *(numbers+i);
		}
		
	if (!need_add){
		// no need more, array is perfect
		*err = 2;
		return 0;
		}
	
	int * out = (int*)malloc(sizeof(int)*need_add);
	int i2=0;
	
	if (!out){
		//memory error
		*err = 3;
		return 0;
		}
	
	nBefore = *(numbers); //first
	for(i=1; i<*lenght; i++){
		
		while(++nBefore < *(numbers+i) )
			*(out+i2++) = nBefore;
			
		nBefore = *(numbers+i);
		}
		
	*lenght = need_add;
	
	return out;
}


void print_error(int err){
	switch(err){
		case 1:
			printf("Error: Integers need sorted and not repeat\n");
			break;
		case 2:
			printf("Error: Array is sorted correctly, No need more\n");
			break;
		case 3:
			printf("Error: No have memory\n");
			break;
	}
}



int main(int argc, char *argv[]) {
	
	int lenght = 5;
	int numbers[] = {1, 5, 8, 20, 25};
	
	int error=0;
	
	print_array("Numbers array 1: ", numbers, lenght);
	
	int * ints_completed = GetOthersNumbers(numbers, &lenght, &error);
	
	if(!error){
		
		print_array("Numbers out of array 1: ", ints_completed, lenght);
		
		free(ints_completed);
		}
	else{
		print_error(error);
		}
	
	/* windows: */
	system("pause");
	return 0;
}

