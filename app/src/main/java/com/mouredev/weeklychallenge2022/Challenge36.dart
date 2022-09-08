/*
 * Reto #36
 * LOS ANILLOS DE PODER
 * Fecha publicación enunciado: 06/09/22
 * Fecha publicación resolución: 14/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales a Sauron
 * contra otras bondadosas que no quieren que el mal reine sobre sus tierras.
 * Cada raza tiene asociado un "valor" entre 1 y 5:
 * - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3), Númenóreanos (4), Elfos (5)
 * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2), Huargos (3), Trolls (5)
 * Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ejércitos:
 * - El resultado puede ser que gane el bien, el mal, o exista un empate. Dependiendo de la
 *   suma del valor del ejército y el número de integrantes.
 * - Cada ejército puede estar compuesto por un número de integrantes variable de cada raza.
 * - Tienes total libertad para modelar los datos del ejercicio.
 * Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
 */


void main() {
  EjercitoBondadoso losBuenos = EjercitoBondadoso(pelosos: 5, numenoreanos: 2, elfos: 1);
  EjercitoMalvado losMalos = EjercitoMalvado(surenos: 3, trolls: 2);

  losMalos.combatirCon(losBuenos);
}



class Ejercito {
  late int valor;
  late final String bando;

  void combatirCon(Ejercito enemigo) {
    if (bando == enemigo.bando) {
      print('Estos dos ejercitos son del mismo bando');
    } else if (valor == enemigo.valor) {
      print('Empate');
    } else {
      print('Ganó el ejercito del ${valor > enemigo.valor ? bando : enemigo.bando}');
    }
  }
}

class EjercitoMalvado extends Ejercito {
  EjercitoMalvado(
     {int surenos = 0,
      int orcos = 0,
      int goblins = 0,
      int huargos = 0,
      int trolls = 0}) {
    valor = 2 * surenos+ 2 * orcos + 2 * goblins + 3 * huargos + 5 * trolls;
    bando = 'mal';
  }
}

class EjercitoBondadoso extends Ejercito {
  EjercitoBondadoso(
     {int pelosos = 0,
      int suernos = 0,
      int enanos = 0,
      int numenoreanos = 0,
      int elfos = 0}) {
    valor = 1 * pelosos + 2 * suernos + 3 * enanos + 4 * numenoreanos + 5 * elfos;
    bando = 'bien';
  }
}
