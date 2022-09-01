package com.challenge;

/*
 * Reto #35
 * BATALLA POKÉMON
 * Fecha publicación enunciado: 29/08/22
 * Fecha publicación resolución: 06/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
 * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
 * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
 * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
 * - El programa recibe los siguientes parámetros:
 *  - Tipo del Pokémon atacante.
 *  - Ataque: Entre 1 y 100.
 *  - Tipo del Pokémon defensor.
 *  - Defensa: Entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final String DENSITY =
            " -.',~\"_:;^r>*?|/Licl7vz1xt{}]Ffujy2SoaZemwXPEhk6$9qKOdHDR8MWgN#BQ@";
    private static final String SPRITES_POKEMON_D_PNG = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/%d.png";

    public static void main(String[] args) {

        printTitle();

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Inicia la batalla!");
            System.out.println("""
                    Pokemons disponibles
                    1.-Venasaur(Planta)     5.-Leafeon(Planta)
                    2.-Charizard(Fuego)     6.-Flareon(Fuego)
                    3.-Blastoise(Agua)      7.-Vaporeon(Agua)
                    4.-Pikachu(Electrico)   8.-Jolteon(Electrico)
                    """);

            System.out.println("Primer pokemon");
            Pokemon pokemon01 = selectPokemon(scanner);

            System.out.println("Segundo pokemon");
            Pokemon pokemon02 = selectPokemon(scanner);

            System.out.printf("%s vs %s%n", pokemon01.getNombre(), pokemon02.getNombre());
            printPokemons(pokemon01, pokemon02);

            Turno turnoSpec = new Turno();
            int turno = 0;

            do {
                if ((turno++) % 2 == 0) {
                    procesarTurno(pokemon01, pokemon02, turnoSpec);
                } else {
                    procesarTurno(pokemon02, pokemon01, turnoSpec);
                }
            } while (!turnoSpec.isTermino());

            System.out.printf("%s no puede continuar, el ganador es %s%n", turnoSpec.getPerdedor(), turnoSpec.getGanador());


        } catch (IllegalArgumentException | IllegalStateException | IOException ex) {
            System.err.println("Preparate para los problemas");
            System.err.println(ex.getMessage());
        }

    }

    private static void procesarTurno(Pokemon atacante, Pokemon defensor, Turno turno) {
        float ataque01 = atacante.pokemonAtaca(defensor);

        System.out.printf("%s a atacado a %s y a inflingido %.2f%n", atacante.getNombre(), defensor.getNombre(), ataque01);
        int pokemon2NuevoHp = defensor.getHp() - Math.round(ataque01);
        if (pokemon2NuevoHp <= 0) {
            String ganador = atacante.getNombre();
            String perdedor = defensor.getNombre();
            turno.setGanador(ganador);
            turno.setPerdedor(perdedor);
            turno.setTermino(Boolean.TRUE);
        }
        defensor.setHp(pokemon2NuevoHp);
        System.out.printf("A %s le quedan %d de Hp %n", defensor.getNombre(), defensor.getHp());

    }


    private static void printTitle() {
        System.out.println("""
                                                  ,'\\
                    _.----.        ____         ,'  _\\   ___    ___     ____
                _,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.
                \\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |
                 \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |
                   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |
                    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |
                     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |
                      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |
                       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |
                        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |
                                                `'                            '-._|
                """);
    }

    public static Pokemon selectPokemon(Scanner scanner) {
        int opcionPokemon = scanner.nextInt();
        return switch (opcionPokemon) {
            case 1 -> createVenasaur(scanner);
            case 2 -> createCharizard(scanner);
            case 3 -> createBlastoise(scanner);
            case 4 -> createPikachu(scanner);
            case 5 -> createLeafeon(scanner);
            case 6 -> createFlareon(scanner);
            case 7 -> createVaporeon(scanner);
            case 8 -> createJolteon(scanner);
            default -> throw new IllegalStateException("Unexpected value: " + opcionPokemon);
        };
    }


    private static Pokemon createVenasaur(Scanner scanner) {
        return crearPokemon(scanner, "Venasaur", 3, 1);
    }

    private static Pokemon createCharizard(Scanner scanner) {
        return crearPokemon(scanner, "Charizard", 6, 3);
    }

    private static Pokemon createBlastoise(Scanner scanner) {
        return crearPokemon(scanner, "Blastoise", 9, 2);
    }

    private static Pokemon createPikachu(Scanner scanner) {
        return crearPokemon(scanner, "Pikachu", 25, 0);
    }

    private static Pokemon createLeafeon(Scanner scanner) {
        return crearPokemon(scanner, "Leafeon", 470, 1);
    }

    private static Pokemon createFlareon(Scanner scanner) {
        return crearPokemon(scanner, "Flareon", 136, 3);
    }

    private static Pokemon createVaporeon(Scanner scanner) {
        return crearPokemon(scanner, "Vaporeon", 134, 2);
    }

    private static Pokemon createJolteon(Scanner scanner) {
        return crearPokemon(scanner, "Jolteon", 135, 0);
    }

    private static Pokemon crearPokemon(Scanner scanner, String nombrePokemon, int numero, int tipoNum) {
        System.out.printf("Has selecionado a %s%n", nombrePokemon);
        Tipo tipo = obtenerTipo(tipoNum);
        int ataque = obtenerValorEntreRangos(scanner, "ataque");
        int defensa = obtenerValorEntreRangos(scanner, "defensa");
        return new Pokemon(numero, nombrePokemon, tipo, ataque, defensa);
    }

    private static int obtenerValorEntreRangos(Scanner scanner, String atributo) {
        System.out.printf("De cuanto es su %s?%n", atributo);
        int valor = scanner.nextInt();
        if (valor < 1 || valor > 100)
            throw new IllegalArgumentException("Solo se puede asignar un valor entre 1 y 100");
        return valor;
    }

    private static Tipo obtenerTipo(int tipo) {
        return switch (tipo) {
            case 0 -> TipoElectrico.INSTANCE;
            case 1 -> TipoPlanta.INSTANCE;
            case 2 -> TipoAgua.INSTANCE;
            case 3 -> TipoFuego.INSTANCE;
            default -> throw new IllegalStateException("Valor inesperado: " + tipo);
        };
    }

    private interface Tipo {
        float efectividad(Tipo tipo);

        default String tipoId() {
            return this.getClass().getSimpleName();
        }
    }

    private static class TipoAgua implements Tipo {

        public static Tipo INSTANCE = getSingleton();
        private static Tipo _INSTANCE = null;

        private TipoAgua() {
        }

        public static Tipo getSingleton() {
            if (_INSTANCE == null) {
                _INSTANCE = new TipoAgua();
            }
            return _INSTANCE;
        }

        @Override
        public float efectividad(Tipo tipo) {
            return switch (tipo.tipoId()) {
                case "TipoAgua", "TipoFuego" -> 0.5f;
                case "TipoElectrico", "TipoPlanta" -> 2;
                default -> 0;
            };
        }
    }

    private static class TipoElectrico implements Tipo {
        public static Tipo INSTANCE = getSingleton();
        private static Tipo _INSTANCE = null;

        private TipoElectrico() {
        }

        public static Tipo getSingleton() {
            if (_INSTANCE == null) {
                _INSTANCE = new TipoElectrico();
            }
            return _INSTANCE;
        }

        @Override
        public float efectividad(Tipo tipo) {
            return switch (tipo.tipoId()) {
                case "TipoAgua", "TipoFuego", "TipoPlanta" -> 1;
                case "TipoElectrico" -> 0.5f;
                default -> 0;
            };
        }
    }

    private static class TipoFuego implements Tipo {
        public static Tipo INSTANCE = getSingleton();
        private static Tipo _INSTANCE = null;

        private TipoFuego() {
        }

        public static Tipo getSingleton() {
            if (_INSTANCE == null) {
                _INSTANCE = new TipoFuego();
            }
            return _INSTANCE;
        }

        @Override
        public float efectividad(Tipo tipoAtaque) {
            return switch (tipoAtaque.tipoId()) {
                case "TipoAgua" -> 2;
                case "TipoElectrico" -> 1;
                case "TipoFuego", "TipoPlanta" -> 0.5f;
                default -> 0;
            };
        }
    }

    private static class TipoPlanta implements Tipo {
        public static Tipo INSTANCE = getSingleton();
        private static Tipo _INSTANCE = null;

        private TipoPlanta() {
        }

        public static Tipo getSingleton() {
            if (_INSTANCE == null) {
                _INSTANCE = new TipoPlanta();
            }
            return _INSTANCE;
        }

        @Override
        public float efectividad(Tipo tipo) {
            return switch (tipo.tipoId()) {
                case "TipoAgua", "TipoElectrico", "TipoPlanta" -> 0.5f;
                case "TipoFuego" -> 2;
                default -> 0;
            };
        }
    }

    private static final class Turno {
        private String ganador;
        private String perdedor;
        private boolean termino;

        public String getGanador() {
            return ganador;
        }

        public void setGanador(String ganador) {
            this.ganador = ganador;
        }

        public String getPerdedor() {
            return perdedor;
        }

        public void setPerdedor(String perdedor) {
            this.perdedor = perdedor;
        }

        public boolean isTermino() {
            return termino;
        }

        public void setTermino(boolean termino) {
            this.termino = termino;
        }
    }

    private static final class Pokemon {
        private final int numero;
        private final String nombre;
        private final Tipo tipo;
        private final int ataque;
        private final int defensa;
        private int hp;

        private Pokemon(int numero, String nombre, Tipo tipo, int ataque, int defensa) {
            this.numero = numero;
            this.nombre = nombre;
            this.tipo = tipo;
            this.ataque = ataque;
            this.defensa = defensa;
            this.hp = defensa * 3;
        }

        public float pokemonAtaca(Pokemon defensor) {
            // * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
            // * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
            float defensaDefensor = defensor.getDefensa();
            Tipo tipoDefensor = defensor.getTipo();
            float efectividad = tipoDefensor.efectividad(tipo);
            return 50 * ((float) this.getAtaque() / defensaDefensor) * efectividad;
        }

        public int getNumero() {
            return numero;
        }

        public String getNombre() {
            return nombre;
        }

        public Tipo getTipo() {
            return tipo;
        }

        public int getAtaque() {
            return ataque;
        }

        public int getDefensa() {
            return defensa;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Pokemon) obj;
            return this.numero == that.numero &&
                    Objects.equals(this.nombre, that.nombre) &&
                    Objects.equals(this.tipo, that.tipo) &&
                    this.ataque == that.ataque &&
                    this.defensa == that.defensa;
        }

        @Override
        public int hashCode() {
            return Objects.hash(numero, nombre, tipo, ataque, defensa);
        }

        @Override
        public String toString() {
            return "Pokemon[" +
                    "numero=" + numero + ", " +
                    "nombre=" + nombre + ", " +
                    "tipo=" + tipo + ", " +
                    "ataque=" + ataque + ", " +
                    "defensa=" + defensa + ']';
        }

    }

    private static char[][] getPokemonImage(String url) throws IOException {
        BufferedImage imageRgb = ImageIO.read(new URL(url));

        float compress = 1.2f;
        int width = (int) (imageRgb.getWidth() / compress);
        int height = (int) (imageRgb.getHeight() / compress);

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bi.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(imageRgb, 0, 0, width, height, null);
        graphics2D.dispose();

        int h = bi.getHeight();
        int w = bi.getWidth();
        char[][] imageChars = new char[h][w];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int pixelValue = bi.getRGB(x, y);
                Color pixelColor = new Color(pixelValue);
                int red = pixelColor.getRed();
                int green = pixelColor.getGreen();
                int blue = pixelColor.getBlue();
                int gray = (red + green + blue) / 3;
                imageChars[y][x] = getDensity(gray);
            }
        }
        return imageChars;
    }

    private static char getDensity(int value) {
        int charValue = (int) Math.round(DENSITY.length() / 255.0 * value);
        charValue = Math.max(charValue, 0);
        charValue = Math.min(charValue, DENSITY.length() - 1);
        return DENSITY.charAt(charValue);
    }

    private static void printPokemons(Pokemon pokemon01, Pokemon pokemon02) throws IOException {

        char[][] pokemon1 = getPokemonImage(String.format(SPRITES_POKEMON_D_PNG, pokemon01.getNumero()));
        char[][] pokemon2 = getPokemonImage(String.format(SPRITES_POKEMON_D_PNG, pokemon02.getNumero()));
        char[][] all = new char[pokemon1.length][];

        for (int i = 0; i < pokemon1.length; i++) {
            all[i] = new char[pokemon1[i].length + pokemon2[i].length];
            System.arraycopy(pokemon1[i], 0, all[i], 0, pokemon1[i].length);
            System.arraycopy(pokemon2[i], 0, all[i], pokemon1[i].length, pokemon2[i].length);
        }

        for (char[] row : all) {
            String str = String.valueOf(row);
            if (str.trim().length() != 0) {
                System.out.println(str);
            }
        }
    }
}