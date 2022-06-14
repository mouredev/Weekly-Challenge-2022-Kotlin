
public class Main {
	public static void main(String[] args) {
		
		System.out.println("");
		System.out.println("usando FOR");
		usandoFor();
		
		System.out.println("");
		System.out.println("usando while");
		usandoWhile();
		
		System.out.println("");
		System.out.println("usando Do-While");
		usandoDoWhile();
		
		

	}

	public static void usandoFor() {
		
		for(int indice=1; indice<=100; indice++) {
			System.out.println(indice);
		}
		
	}


	public static void usandoWhile() {
		
		int indice=1;
		while(indice<=100) {
			System.out.println(indice);
			indice++;
		}
		
	}


	public static void usandoDoWhile() {
		
		int indice=1;
		do {
			System.out.println(indice);
			indice++;
		}while(indice<=100);
	
	}


}