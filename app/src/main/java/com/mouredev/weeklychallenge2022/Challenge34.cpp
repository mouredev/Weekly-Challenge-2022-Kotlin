//package com.mouredev.weeklychallenge2022

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

using namespace std;

int main(int argc, char** argv) {
	
	//std::cout<<"Typer you array list: \n";
	//std::cin>>array;
	
	int number[]={1,2,3,4,9};
	int numberfin[]={};
	int aux=0;
	int pos=0;
	for(int i=0;i<6;i++){
		aux=number[i+1];
		pos=i;
		while((aux-number[pos])>1){
			number[pos+1]=number[pos]+1;
			pos++;
			if(number[pos+1]==aux){
				break
			}
			number[pos+1]=aux;
		
		}
		
	//	number[pos+1]=aux;
//	numberfin[i]=number[i];
	
		
	}
		
			
	for(int i=0;i<9;i++){
		cout<<number[i];
	}
	
	return 0;
}
