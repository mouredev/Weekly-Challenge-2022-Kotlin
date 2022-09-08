#include <iostream>

using namespace std;

/*
 * Reto #36
 * LOS ANILLOS DE PODER
 * Fecha publicaci√≥n enunciado: 06/09/22
 * Fecha publicaci√≥n resoluci√≥n: 14/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¬°La Tierra Media est√° en guerra! En ella luchar√°n razas leales a Sauron
 * contra otras bondadosas que no quieren que el mal reine sobre sus tierras.
 * Cada raza tiene asociado un "valor" entre 1 y 5:
 * - Razas bondadosas: Pelosos (1), Sure√±os buenos (2), Enanos (3), N√∫men√≥reanos (4), Elfos (5)
 * - Razas malvadas: Sure√±os malos (2), Orcos (2), Goblins (2), Huargos (3), Trolls (5)
 * Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ej√©rcitos:
 * - El resultado puede ser que gane el bien, el mal, o exista un empate. Dependiendo de la
 *   suma del valor del ej√©rcito y el n√∫mero de integrantes.
 * - Cada ej√©rcito puede estar compuesto por un n√∫mero de integrantes variable de cada raza.
 * - Tienes total libertad para modelar los datos del ejercicio.
 * Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
 *
 * Informaci√≥n adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "üîÅreto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la informaci√≥n sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
 
 
 
int main(int argc, char** argv) {

	int n=0,n2=0,pelosos=0,surenos=0,surenos_mal=0,enanos=0,num=0,elfos=0,orcos=0,goblins=0,huargos=0,trolls=0;
	
	while(n!=6){
		
	cout<<"Digita el numero de las correspondientes razas bondadosas que van a luchar? "<<endl;
	cout<<"1. Pelosos "<<endl;
	cout<<"2. SureÒos "<<endl;
	cout<<"3. Enanos "<<endl;
	cout<<"4. N˙menÛreanos  "<<endl;
	cout<<"5. Elfos "<<endl;
	cout<<"6. Continuar con seleccion de oponentes "<<endl;
	cin>>n;

	system("cls");
	switch (n){
	
		case 1: cout<<"Ingrese la cantidad de Pelosos que luchar·n?: "<<endl;
				cin>>pelosos;
				pelosos=pelosos*1;
				system("cls");
			break;
		case 2:
				cout<<"Ingrese la cantidad de Pelosos que SureÒos?: "<<endl;
				cin>>surenos;
				surenos=surenos*2;
				system("cls");
			break;
		case 3:
				cout<<"Ingrese la cantidad de Pelosos que Enanos?: "<<endl;
				cin>>enanos;
				enanos=enanos*3;
				system("cls");
				
			break;
		case 4:
				cout<<"Ingrese la cantidad de Pelosos que N˙menÛreanos?: "<<endl;
				cin>>num;
				num=num*4;
				system("cls");
			break;
		case 5:
				cout<<"Ingrese la cantidad de Pelosos que Elfos?: "<<endl;
				cin>>elfos;
				elfos=elfos*5;
				system("cls");
			break;
		
		default:
			break;	
}

}
	
	while(n2!=6){
	
	
		cout<<"Que razas malvadas van a luchar? "<<endl;
	cout<<"1. SureÒos "<<endl;
	cout<<"2. Orcos "<<endl;
	cout<<"3. Goblins "<<endl;
	cout<<"4. Huargos  "<<endl;
	cout<<"5. Trolls "<<endl;
	cout<<"6. Ir a la batalla "<<endl;
	cin>>n2;
		system("cls");
		switch (n2){
	
		case 1: cout<<"Ingrese la cantidad de SureÒos que luchar·n?: "<<endl;
				cin>>surenos_mal;
				surenos_mal=surenos_mal*2;
				system("cls");
			break;
		case 2:
				cout<<"Ingrese la cantidad de Orcos que luchar·n?: "<<endl;
				cin>>orcos;
				orcos=orcos*2;
				system("cls");
			break;
		case 3:
				cout<<"Ingrese la cantidad de Goblins que luchar·n?: "<<endl;
				cin>>goblins;
				goblins=goblins*2;
				system("cls");
				
			break;
		case 4:
				cout<<"Ingrese la cantidad de Huargos que luchar·n?: "<<endl;
				cin>>huargos;
				huargos=huargos*3;
				system("cls");
			break;
		case 5:
				cout<<"Ingrese la cantidad de Trolls que luchar·n?: "<<endl;
				cin>>trolls;
				trolls=trolls*5;
				system("cls");
			break;
		
		default:
			break;	
}

}


	int buenos,mal;
	
	buenos=pelosos+surenos+enanos+num+elfos;
	mal=surenos_mal+orcos+goblins+huargos+trolls;
	
	if(buenos>mal){
		cout<<"EL BIEN GANA!!! "<<endl;
				
		}	
	if(buenos<mal){
		cout<<"EL MAL GANA!!! "<<endl;
				
		}
	if(buenos==mal){
		cout<<"EMPATE!!! "<<endl;
				
		}

	
	return 0;
}
