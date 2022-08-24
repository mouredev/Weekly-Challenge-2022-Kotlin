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
	
	int number[5]={1,5,8,9,10};
	int numberfin[]={};
	int aux;
	int pos;
	for(int i=0;i<5;i++){
		aux=number[i+1];
		pos=i;
		while((number[pos]+1)<number[pos+1]){
			number[pos+1]=number[pos]+1;
			pos++;
			number[pos+2]=aux;
			
		}
	numberfin[i]=number[i];
	
		
	}
		
			
	for(int i=0;i<10;i++){
		cout<<numberfin[i];
	}
	
	return 0;
}
