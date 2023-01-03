package Reto46;

public class DondeEstaElRobot {

	public static void main (String[] args) {
		
		int [] num= {-4, -3, 7, 8, 6, -7, -9};
		
		UbicacionFinal ubicacion=new UbicacionFinal(num);
	}
}

class UbicacionFinal {
	
	public UbicacionFinal(int [] input) {
		
		correcionSigno(input);
		
		for (int i = 0; i < input.length; i++){
			
			if( i %2==0) {
				
				Y+=input[i];
			}else {
				
				X+=input[i];
			}
		
		}
		
		System.out.println("La ubicacion final del robot es: " + "X: " + X +" Y: " + Y);
	}
	
	public static void  correcionSigno (int [] num) {
			
			for (int i = 0; i < num.length; i++){
				
				if (cuadrante==4) {
				
					cuadrante=0;
				}else if(cuadrante==2) {
					
					num[i]=num[i]*-1;
					
				}else if(cuadrante==3) {
					
					num[i]=num[i]*-1;
				}
				
				cuadrante++;
								
		}
		
	}
	
	static int cuadrante = 1;
	
	int X=0;
	
	int Y=0;
}
