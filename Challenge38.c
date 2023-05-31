

/*


Author: LeonardoReichert@github.com
		(RearlanFDX@Twitch)



MoureDev retos :
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 
 
 
 !Ejecucion del programa:
 Resultado de convertir 00001110111110 a entero: 958
 
 */
 
 


#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

typedef char BOOL;

BOOL bin2int(char * bin, unsigned int * out){
	
	
	unsigned int result=0;
	char c;
	
	for(int i=0; *(bin+i); i++)
	{
		//character iter:
		c = *(bin+i);
		
		// we need expand other digit - necesitamos expandir otro digito:
		//add 0 binary:
		result <<= 1;
		
		if (c == '1')
		{
			//change right 0 to 1 binary:
			result |= 1;
		}
		else if (c != '0')
		{
			//error
			return 0;
		}
		
	}
	
	
	*out = result;
	
	
	//succes:
	return 1;
}



int main(int argc, char *argv[]) {
	
	
	char * binary = "00001110111110";
	
	unsigned int result;
	
	if (bin2int(binary, &result))
	{
		printf("Resultado de convertir %s a entero: %d\n", binary, result);
	}else
	{
		printf("Error: verifica que los valores binarios sean 1 o 0 y no otro caracter...\n");	
	}
	
	
	//Resultado de convertir 00001110111110 a entero: 958
	return 0;
}

