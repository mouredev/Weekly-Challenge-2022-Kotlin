/*
Challenge #29 of https://www.twitch.tv/mouredev

"Sort array integers"

Author: LeonardoReichert@Github
		Twitch@RearlanFDX

Lenguage: C/C++

Notas:
En este reto me dispuse a probar un lenguaje que me fue dificil conocer (C++)
y que tengo ganas de aprender. Aunque ya usaba C, fue hace mucho tiempo.

Puedes ver el programa ejecutado en la imagen: https://i.ibb.co/fqxx1ZV/ggggggg.png
*/

#include <iostream>
#include <stdio.h>
#include <conio.h>




void print_ints(int * integers, int lenght){

	int i;
	for(i=0; i<lenght; i++){
		printf("%d ", integers[i]);
	}
}



void integers_sort(int * integers,
				   const unsigned int istart,
				   const unsigned int lenght,
				   const bool isMinToMax){
	
	unsigned int i; //start index
	unsigned int i2; //subindex
	int ntemp;
	
	//limit:
	unsigned int end = istart+lenght;
	
	for (i=istart; i < end; i++){
	
		for (i2=istart; i2 < end; i2++){
			
			//search sub index
			if ( (isMinToMax && integers[i] < integers[i2]) || 
				(!isMinToMax && integers[i] > integers[i2])	){
				
				//change value to value...
				ntemp = integers[i];
				integers[i] = integers[i2];
				integers[i2] = ntemp;
			}
		}
	}
}



int main(int argc, char** argv) {
	
	
	int myintegers[] = {
		100, 120, 1000, 6, -8, 90, 110, -12, 100, 232,
		};
	
	//identificamos la cantidad de numeros (se compila, no se calcula):
	static int quantity = sizeof(myintegers)/sizeof(int);
	
	//una copia | a copy:
	int myintegers_sorted[quantity];
	
	printf("Quantity integers %d\n", quantity);
	
	printf("\nThe initial integers: ");
	print_ints(myintegers, quantity);
	
	/* we will make a copy of original */
	memcpy((int*)myintegers_sorted, myintegers, quantity*sizeof(int*));
	/* hice una copia del array original dado que el reto es retornar un array ordenado
	 pero mi funcion de "ordenar" trabaja modificando directamente un array sin crear una copia */
	
	integers_sort((int*)myintegers_sorted, 0, quantity, true);
	printf("\nThe numbers sorted min to max: ");
	print_ints(myintegers_sorted, quantity);
	
	integers_sort((int*)myintegers_sorted, 0, quantity, false);
	printf("\nThe numbers sorted max to min: ");
	print_ints(myintegers_sorted, quantity);
	
	
	/* una pausa: */
	//getch(); // only for windows
	return 0;
}

