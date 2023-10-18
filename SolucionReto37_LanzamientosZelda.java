import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolucionReto37_LanzamientosZelda {
	public static void main(String[] args) {

		Map<String, String> listaDeJuegos = new HashMap<>();
		listaDeJuegos.put("The Legend of Zelda", "1986-02-21");
		listaDeJuegos.put("A Link to the Past", "1991-11-21");
		listaDeJuegos.put("Ocarina of Time", "1998-09-27");
		listaDeJuegos.put("Majora's Mask", "2000-01-27");
		listaDeJuegos.put("The Wind Waker", "2002-09-14");
		listaDeJuegos.put("Twilight Princess", "2006-11-24");
		listaDeJuegos.put("Skyward Sword", "2011-11-20");
		listaDeJuegos.put("Breath of the Wild", "2017-02-03");

		// Siguiente forma de presentar datos del map usando bucle for
		System.out.println(">>>>Reto #37: LOS LANZAMIENTOS DE \"THE LEGEND OF ZELDA\"<<<<");
		for (Map.Entry<String, String> pares : listaDeJuegos.entrySet()) {
			System.out.println(String.format("NOMBRE: %-20.20s FECHA: %s", pares.getKey(), pares.getValue()));
		}

		Scanner sc = new Scanner(System.in);
		System.out.print("\nIntroduzca el 1º nombre de juego: ");
		String juego1 = sc.nextLine();
		System.out.print("Introduzca el 2º nombre de juego: ");
		String juego2 = sc.nextLine();
		sc.close();

		System.out.println(tiempoTrancurridoJuegos(juego1, juego2, listaDeJuegos));

	}

	static String tiempoTrancurridoJuegos(String juego1, String juego2, Map<String, String> datos) {
		String fechaJuego1;
		String fechaJuego2;
		String result = "";

		if (datos.containsKey(juego1) && datos.containsKey(juego2)) {

			fechaJuego1 = datos.get(juego1);
			fechaJuego2 = datos.get(juego2);

			// Obtener una instancia de LocalTime a partir de la fecha dada en String
			LocalDate dameDate1 = LocalDate.parse(fechaJuego1);
			LocalDate dameDate2 = LocalDate.parse(fechaJuego2);

			/**
			 * Aqui use la clase Período que utiliza las unidades año, mes y día para
			 * representar un período de tiempo. Podemos obtener un objeto Período como la
			 * diferencia entre dos fechas utilizando el método between
			 */
			Period tiempoTrancurrido = Period.between(dameDate1, dameDate2);
			int años = tiempoTrancurrido.getYears();
			int meses = tiempoTrancurrido.getMonths();
			int dias = tiempoTrancurrido.getDays();

			result = "\n\tFechas Correspondientes:\n<< " + fechaJuego1 + " >>\t<< " + fechaJuego2 + " >>\n Han pasado: "
					+ años + " Años " + meses + " Meses y " + dias + " Dias";

		}
		return result;
	}

}
