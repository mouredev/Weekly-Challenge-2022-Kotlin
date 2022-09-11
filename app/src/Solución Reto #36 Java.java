
public class Reto36LosAnillosDePoder {

	/**
	 * Atributos de clase
	 */
	private int cantBuenos;
	private String razaBuena;
	private int cantMalos;
	private String razaMala;

	/**
	 * Constructor de clase
	 * 
	 * @param cantBuenos
	 * @param razaBuena
	 * @param cantMalos
	 * @param razaMala
	 */
	public Reto36LosAnillosDePoder(int cantBuenos, String razaBuena, int cantMalos, String razaMala) {
		this.cantBuenos = cantBuenos;
		this.razaBuena = razaBuena;
		this.cantMalos = cantMalos;
		this.razaMala = razaMala;
	}

	/**
	 * Método que retorna el numero de integrantes buenos
	 * 
	 * @return the cantBuenos
	 */
	public int getCantBuenos() {
		return cantBuenos;
	}

	/**
	 * Método que retorna el numero de integrantes malos
	 * 
	 * @return the cantMalos
	 */
	public int getCantMalos() {
		return cantMalos;
	}

	@Override
	public String toString() {
		return cantBuenos + " " + razaBuena.toUpperCase() + "  " + calculaBatalla() + "  " + cantMalos + " "
				+ razaMala.toUpperCase();
	}

	/**
	 * @return el calculo total del ataque de Personajes Buenas
	 */
	private int totalAtaqueBuenos(String nombreRazaB) {

		int resu = 0;

		for (RazasBondadosas raza : RazasBondadosas.values()) {
			if (raza.toString().equals(nombreRazaB.toUpperCase())) {
				resu = getCantBuenos() * raza.getPoderBatalla();
			}
		}

		return resu;
	}

	/**
	 * @return el calculo total del ataque de Personajes Malos
	 */
	private int totalAtaqueMalos(String nombreRazaM) {

		int resu = 0;

		for (RazasMalvadas raza : RazasMalvadas.values()) {
			if (raza.toString().equals(nombreRazaM.toUpperCase())) {
				resu = getCantMalos() * raza.getPoderBatalla();
			}
		}

		return resu;
	}

	/**
	 * 
	 * @return me retorna un string indicandome uno de los tres resultado que estan
	 *         contenidos en el array resultado
	 */
	public String calculaBatalla() {

		String[] resultado = { "Pierde", "Empatan", "Ganan" };
		int valPosiResultado = 0;
		int valAtaqueBuenos = totalAtaqueBuenos(razaBuena.toUpperCase());
		int valAtaqueMalos = totalAtaqueMalos(razaMala.toUpperCase());

		if (valAtaqueBuenos > valAtaqueMalos) {
			valPosiResultado = 2;
		}
		if (valAtaqueBuenos == valAtaqueMalos) {
			valPosiResultado = 1;
		}

		// String.valueOf(valAtaqueBuenos) + " " + String.valueOf(valAtaqueMalos);
		return resultado[valPosiResultado];
	}

	/**
	 * Enum en el cual tengo una lista de constates de personajes buenos
	 */
	public enum RazasMalvadas {

		SUREÑOS_MALOS(2), ORCOS(2), GOBLINS(2), HUARGOS(3), TROLLS(5);

		private int poderBatalla;

		RazasMalvadas(int poderBatalla) {
			// TODO Auto-generated constructor stub
			this.poderBatalla = poderBatalla;
		}

		/**
		 * @return the poderBatalla
		 */
		public int getPoderBatalla() {
			return poderBatalla;
		}

	}

	/**
	 * Enum en el cual tengo una lista de constates de personajes malos
	 *
	 */
	public enum RazasBondadosas {

		PELOSOS(1), SUREÑOS_BUENOS(2), ENANOS(3), NUMERONEANOS(4), ELFOS(5);

		private int poderBatalla;

		RazasBondadosas(int poderBatalla) {
			// TODO Auto-generated constructor stub
			this.poderBatalla = poderBatalla;
		}

		/**
		 * @return the poderBatalla
		 */
		public int getPoderBatalla() {
			return poderBatalla;
		}

	}

	/**
	 * Método principal o main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reto36LosAnillosDePoder Batalla1 = new Reto36LosAnillosDePoder(1, "pelosos", 1, "orcos");
		Reto36LosAnillosDePoder Batalla2 = new Reto36LosAnillosDePoder(2, "pelosos", 1, "orcos");
		Reto36LosAnillosDePoder Batalla3 = new Reto36LosAnillosDePoder(3, "pelosos", 1, "orcos");
		System.out.println("\t>>>BATALLAS<<< \n");
		System.out.println(Batalla1);
		System.out.println(Batalla2);
		System.out.println(Batalla3);

	}

}
