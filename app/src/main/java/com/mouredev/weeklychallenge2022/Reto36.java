package com.mouredev.weeklychallenge2022;
/*
 * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales
 * a Sauron contra otras bondadosas que no quieren que el mal reine
 * sobre sus tierras.
 * Cada raza tiene asociado un "valor" entre 1 y 5:
 * - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3),
 *   Númenóreanos (4), Elfos (5)
 * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2),
 *   Huargos (3), Trolls (5)
 * Crea un programa que calcule el resultado de la batalla entre
 * los 2 tipos de ejércitos:
 * - El resultado puede ser que gane el bien, el mal, o exista un empate.
 *   Dependiendo de la suma del valor del ejército y el número de integrantes.
 * - Cada ejército puede estar compuesto por un número de integrantes variable
 *   de cada raza.
 * - Tienes total libertad para modelar los datos del ejercicio.
 * Ej: 1 Peloso pierde contra 1 Orco
 *     2 Pelosos empatan contra 1 Orco
 *     3 Pelosos ganan a 1 Orco
 */

public class Reto36 {

    public enum RazasBondadosas {
        PELOSOS(1), SUREÑOS_BUENOS(2), ENANOS(3), NUMENOREANOS(4), ELFOS(5);

        private final int valor;

        RazasBondadosas(int valor) {
            this.valor = valor;
        }

        public int retornarNumero() {
            return valor;
        }

    }

    public enum RazasMalvadas {
        SUREÑOS_MALOS(2), ORCOS(2), GOBLINS(3), HUARGOS(3), TROLLS(5);

        private final int valor;

        RazasMalvadas(int valor) {
            this.valor = valor;
        }

        public int retornarNumero() {
            return valor;
        }
    }
    public static void main(String[] args) {
        
        int tipoEjercitoBueno, tipoEjercitoMalo, integrantesBuenos, integrantesMalos;
         
        RazasMalvadas[] razasMalvadas = new RazasMalvadas[5];
        razasMalvadas[0]= RazasMalvadas.GOBLINS;
        razasMalvadas[1]= RazasMalvadas.HUARGOS;
        razasMalvadas[2]= RazasMalvadas.ORCOS;
        razasMalvadas[3]= RazasMalvadas.SUREÑOS_MALOS;
        razasMalvadas[4]= RazasMalvadas.TROLLS;
        
        RazasBondadosas[] razasBondadosas = new RazasBondadosas[5];
        razasBondadosas[0]= RazasBondadosas.ELFOS;
        razasBondadosas[1]= RazasBondadosas.ENANOS;
        razasBondadosas[2]= RazasBondadosas.NUMENOREANOS;
        razasBondadosas[3]= RazasBondadosas.PELOSOS;
        razasBondadosas[4]= RazasBondadosas.SUREÑOS_BUENOS;
        
        integrantesBuenos = (int) (1 + Math.random()*10);
        tipoEjercitoBueno = (int) (Math.random()*5);
        integrantesMalos = (int) (1 + Math.random()*10);
        tipoEjercitoMalo = (int) (Math.random()*5);
        
        int puntuacionBuenos = razasBondadosas[tipoEjercitoBueno].retornarNumero() * integrantesBuenos;
        int puntuacionMalos = razasMalvadas[tipoEjercitoMalo].retornarNumero() * integrantesMalos;
        
        if (puntuacionBuenos > puntuacionMalos){
            System.out.println(integrantesBuenos + " " +
                    razasBondadosas[tipoEjercitoBueno].toString() + " gana contra " +
                    integrantesMalos + " " +
                    razasMalvadas[tipoEjercitoMalo].toString());}
        else if(puntuacionBuenos == puntuacionMalos){
            System.out.println(integrantesBuenos + " " +
                    razasBondadosas[tipoEjercitoBueno].toString() + " empata contra " +
                    integrantesMalos + " " +
                    razasMalvadas[tipoEjercitoMalo].toString());}
        else{
            System.out.println(integrantesBuenos + " " +
                    razasBondadosas[tipoEjercitoBueno].toString() + " pierde contra " +
                    integrantesMalos + " " +
                    razasMalvadas[tipoEjercitoMalo].toString());}
    }
}
