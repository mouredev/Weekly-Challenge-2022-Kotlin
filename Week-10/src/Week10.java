/*
		 * Reto #10 EXPRESIONES EQUILIBRADAS Fecha publicación enunciado: 07/03/22 Fecha
		 * publicación resolución: 14/03/22 Dificultad: MEDIA
		 *
		 * Enunciado: Crea un programa que comprueba si los paréntesis, llaves y
		 * corchetes de una expresión están equilibrados. - Equilibrado significa que
		 * estos delimitadores se abren y cieran en orden y de forma correcta. -
		 * Paréntesis, llaves y corchetes son igual de prioritarios. No hay uno más
		 * importante que otro. - Expresión balanceada: { [ a * ( c + d ) ] - 5 } -
		 * Expresión no balanceada: { a * ( c + d ) ] - 5 }
		 *
		 * Información adicional: - Usa el canal de nuestro discord
		 * (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o
		 * prestar ayuda a la comunidad. - Puedes hacer un Fork del repo y una Pull
		 * Request al repo original para que veamos tu solución aportada. - Revisaré el
		 * ejercicio en directo desde Twitch el lunes siguiente al de su publicación. -
		 * Subiré una posible solución al ejercicio el lunes siguiente al de su
		 * publicación.
		 *
		 */

public class Week10 {

	public static void main(String[] args) {

		String cadenaNoBalanceada = "{ a * ( c + d ) ] - 5 }";

		System.out.println(cadenaBalanceada(cadenaNoBalanceada));

	}

	public static int contarCaracteres(String cadena, char caracter) {

		int count = 0;

		for (int i = 0; i < cadena.length(); i++) {

			if (caracter == cadena.charAt(i)) {

				count++;

			}

		}

		return count;

	}

	public static boolean numerosIguales(int num1, int num2) {

		boolean correcto = false;

		if (num1 != num2) {

			correcto = false;

		} else {

			correcto = true;
		}

		return correcto;

	}

	public static String cadenaBalanceada(String cadena) {

		int total1 = contarCaracteres(cadena, '{');
		int total2 = contarCaracteres(cadena, '}');
		int total3 = contarCaracteres(cadena, '(');
		int total4 = contarCaracteres(cadena, ')');
		int total5 = contarCaracteres(cadena, '[');
		int total6 = contarCaracteres(cadena, ']');

		boolean llavesBalanceadas, parentesisBalanceados, corchetesBalanceados;

		llavesBalanceadas = numerosIguales(total1, total2);
		parentesisBalanceados = numerosIguales(total3, total4);
		corchetesBalanceados = numerosIguales(total5, total6);

		if (llavesBalanceadas && parentesisBalanceados && corchetesBalanceados) {

			return "Cadena Balanceada.";

		} else {

			return "Cadena NO Balanceada.";

		}

	}

}
