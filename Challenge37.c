/*

Author: LeonardoReichert@github.com
		RearlanFDX@Twitch




From MoureDev:
 * Reto #37
 * LOS LANZAMIENTOS DE "THE LEGEND OF ZELDA"
 * Fecha publicación enunciado: 14/09/22
 * Fecha publicación resolución: 19/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¡Han anunciado un nuevo "The Legend of Zelda"! Se llamará "Tears of the Kingdom"
 * y se lanzará el 12 de mayo de 2023.
 * Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos "The Legend of Zelda" de la historia?
 * Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda que tú selecciones.
 * - Debes buscar cada uno de los títulos y su día de lanzamiento (si no encuentras el día exacto
 *   puedes usar el mes, o incluso inventártelo)
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.






----------------------------
!Ejecucion del programa:

Calculando datos desde fecha1 hasta fecha2:

Fecha de Zelda1:
Anio: 2020
Mes: 5
Dias: 20

Fecha de Zelda2:
Anio: 2025
Mes: 11
Dias: 21

Ha pasado 5 anios y 186 dias.
*/


#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>




typedef struct{
	unsigned int year;
	unsigned int month;
	unsigned int day;
	
}DATE3;

typedef char BOOL;


void PrintDate3(DATE3 p){
	printf("Anio: %d\nMes: %d\nDias: %d\n", p.year, p.month, p.day);
}


BOOL CalcTimeDif(DATE3 from, DATE3 to, int * out_years, int * out_days){
	
	/*now transform time to seconds*/
	struct tm tmfrom;
	memset(&tmfrom, 0, sizeof(struct tm));
	
	tmfrom.tm_year = from.year - 1900;
	tmfrom.tm_mon = from.month-1;
	tmfrom.tm_mday = from.day;
	
	struct tm tmto;
	memset(&tmto, 0, sizeof(struct tm));
	
	tmto.tm_year = to.year - 1900;
	tmto.tm_mon = to.month-1;
	tmto.tm_mday = to.day;
	
	time_t seconds1 = mktime(&tmfrom);
	time_t seconds2 = mktime(&tmto);
	
	if ( (seconds1 == -1 || seconds2 == -2) || (seconds2 < seconds1)){
		return 0; //error
		}
	//succes transform the time's to seconds
	
	time_t diff = (time_t)difftime(seconds2, seconds1);
	
	short days = diff / 60 / 60 / 24;
	
	*out_years = days / 365;
	*out_days = days%365;
	
	return 1;
}


int main(int argc, char *argv[]) {
	
	printf("Calculando datos desde fecha1 hasta fecha2: \n");
	
	DATE3 dZelda1;
	dZelda1.year = 2020;
	dZelda1.month = 5;
	dZelda1.day = 20;
	
	printf("\nFecha de Zelda1: \n");
	PrintDate3(dZelda1);

	DATE3 dZelda2;
	dZelda2.year = 2025;
	dZelda2.month = 11;
	dZelda2.day = 21;
	printf("\nFecha de Zelda2: \n");
	PrintDate3(dZelda2);
	
	//passed times:
	int years, days;
	
	if ( CalcTimeDif(dZelda1, dZelda2, &years, &days))
	{
	 	printf("\nHa pasado %d anios y %d dias.\n", years, days);
	
	}else
	{
		printf("\nHa ocurrido un error al calcular las fechas, verifica que la segunda no sea menor o sean fechas incorrectas.\n");
	}
	
	return 0;
}
