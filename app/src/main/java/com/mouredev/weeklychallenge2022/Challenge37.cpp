#include <iostream>
#include <cmath>
#include <cstdlib>
using namespace std;
/*
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
 *
 */
 

 	int Ocarina_of_Time[3]={21,11,1998};
	int Majoras_Mask[3]={27,4,2000};
	int A_link_to_the_past[3]={21,11,1991};	
	int Four_sword[3]={18,3,2004};
	int The_Minish_Cap[3]={4,11,2004};
	int Twilight[3]={19,11,2006};
	int The_Adventure_of_Link[3]={14,1,1987};
	int Phantom_Hourglass[3]={23,6,2007};
	int Spirit_Tracks[3]={7,12,2009};
	int Links_Awakening[3]={20,9,2019};
	int Skyward_Sword[3]={18,11,2011};
	int Oracle_of_Ages[3]={27,2,2001};
	int Oracle_of_Seasons[3]={27,2,2001};
	int Wind_Waker[3]={13,12,2002};
	int Link_Between_Worlds[3]={22,11,2013};
	int Tri_Force_Heroes[3]={22,10,2015};
	int Breath_of_the_Wild[3]={3,3,2017};
	int Tears_of_the_Kingdom[3]={12,5,2023};

	 
 int copia(int opcion[], int opt1[]){
 	for(int i=0;i<3;i++){
 		opt1[i]=opcion[i];
	 }
	 return opt1[3];
 }
 int menu(){
 		int n,n2;
	cout<<"1. Ocarina of Time - 21/11/1998"<<endl;
	cout<<"2. Majoras Mask - 27/04/2000"<<endl;
	cout<<"3. A link to the past - 21/11/1991"<<endl;
	cout<<"4. The wind waker - 13/12/2002"<<endl;
	cout<<"5. Four sword - 18/03/2004"<<endl;
	cout<<"6. The Minish Cap - 04/11/2004"<<endl;
	cout<<"7. Twilight - 19/11/2006"<<endl;
	cout<<"8. The Adventure of Link - 14/01/1987"<<endl;
	cout<<"9. Phantom Hourglass - 23/06/2007"<<endl;
	cout<<"10. Spirit Tracks - 7/12/2009"<<endl;
	cout<<"11. Links_Awakening - 20/09/2019"<<endl;
	cout<<"12. Skyward Sword - 18/11/2011"<<endl;
	cout<<"13. Oracle of Ages - 27/02/2001"<<endl;
	cout<<"14. Oracle of Seasons - 27/02/2001"<<endl;
	cout<<"15. Link Between Worlds - 22/11/2013"<<endl;
	cout<<"16. Tri Force Heroes - 22/10/2015"<<endl;
	cout<<"17. Breath_of_the_Wild - 03/03/2011"<<endl;
	cout<<"18. Tears of the Kingdom - 12/05/2023"<<endl;
	cin>>n;
	
	return n;
 }
 int seleccion(int n,int opt1[]){
 	
 	
 	switch(n){
		case 1:
			opt1[3]=copia(Ocarina_of_Time,opt1);
			break;
		case 2:
			opt1[3]=copia(Majoras_Mask,opt1);
			break;
		case 3:
			opt1[3]=copia(A_link_to_the_past,opt1);
			break;
		case 4:
			opt1[3]=copia(Wind_Waker,opt1);
			break;
		case 5:
			opt1[3]=copia(Four_sword,opt1);
			break;
		case 6:
			opt1[3]=copia(The_Minish_Cap,opt1);
			break;
		case 7:
			opt1[3]=copia(Twilight,opt1);
			break;
		case 8:
			opt1[3]=copia(The_Adventure_of_Link,opt1);
			break;
		case 9:
			opt1[3]=copia(Phantom_Hourglass,opt1);
			break;
		case 10:
			opt1[3]=copia(Spirit_Tracks,opt1);
			break;
		case 11:
			opt1[3]=copia(Links_Awakening,opt1);
			break;
		case 12:
			opt1[3]=copia(Skyward_Sword,opt1);
			break;
		case 13:
			opt1[3]=copia(Oracle_of_Ages,opt1);
			break;
		case 14:
			opt1[3]=copia(Oracle_of_Seasons,opt1);
			break;
		case 15:
			opt1[3]=copia(Link_Between_Worlds,opt1);
			break;
	
		case 16:
			opt1[3]=copia(Tri_Force_Heroes,opt1);
			break;
		case 17:
			opt1[3]=copia(Breath_of_the_Wild,opt1);
			break;
			
		case 18:
			opt1[3]=copia(Tears_of_the_Kingdom,opt1);
			break;
		default:
			cout<<"introduce una opcion correcta"<<endl;
	}
	return opt1[3];
 }
 
int main(int argc, char** argv) {
	int n,n2;
	int aux1[3],aux2[3];
	
	cout<<"\t Selecciona un titulo"<<endl;
	n=menu();
	system("cls");
	aux1[3]=seleccion(n,aux1);

	
	cout<<"\t Selecciona el segundo titulo para comparar las fechas"<<endl;
	n2=menu();
	system("cls");
	aux2[3]=seleccion(n2,aux2);

	
	
	int dias = (abs(aux1[1]-aux2[1])*30+abs((aux1[0]-aux2[0])));
	cout<<"Los dos titulos tienen: "<<abs(aux1[2]-aux2[2])<<" anios y "<< dias<<" dias de diferencia" ;
	
	
	
	
	return 0;
}
