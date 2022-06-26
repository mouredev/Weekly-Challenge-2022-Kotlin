package com.mouredev.weeklychallenge2022;

/*
 * Reto #25
 * PIEDRA, PAPEL, TIJERA
 * Fecha publicación enunciado: 20/06/22
 * Fecha publicación resolución: 27/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que calcule quien gana más partidas al piedra, papel, tijera.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La función recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "R" (piedra), "P" (papel) o "S" (tijera).
 * - Ejemplo. Entrada: [("R","S"), ("S","R"), ("P","S")]. Resultado: "Player 2".
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
import java.util.*;


public class Challenge25 {
    public static void main(String[] args) {
        partido miPartido = new partido();
        //  System.out.println(miPartido.getMarcador());
        System.out.println(miPartido.resultadoPartido());
    }
}
class juego{
    private char Player1;
    private char Player2;
    public juego(){
    }
    //setters
    public void setPlayer1(char player1) {
        Player1 = player1;
    }
    public void setPlayer2(char player2) {
        Player2 = player2;
    }
    //getters
    public char getPlayer1() {
        return Player1;
    }
    public char getPlayer2() {
        return Player2;
    }
    //Establecemos la elección random de piedra papel o tijeras.
    public char getJugada() {
        int tirada = (int) (Math.round((Math.random() * 2) % 3));
        return switch (tirada) {
            case 0 -> 'r';
            case 1 -> 'p';
            case 2 -> 's';
            default -> 'x';
        };
    }
    //Creamos un juego de Player1 vs Player2 de manera aleatoria.
    public void setJuego(){
        this.setPlayer1(getJugada());
        this.setPlayer2(getJugada());
    }
    //Establecemos el ganador del juego, retornando un 1 si gana Player1, -1 si gana Player2 y 0 si es empate.
    public int getVentaja(){
        if
        (getPlayer1()==getPlayer2()){
            return 0;
        }
        else if
        (getPlayer1()=='r' && getPlayer2()=='s'||
                        getPlayer1()=='s' && getPlayer2()=='p'||
                        getPlayer1()=='p' && getPlayer2()=='r'){
            return 1;
        }
        else
        {
            return -1;
        }
    }
}

class partido{
    private int Marcador;

    partido(){
        ArrayList <juego> HaKenBo = new ArrayList<>();
        int MatchSize;
        this.Marcador = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántas veces quieres que juegen el Player1 contra el Player2?\n [Inserta valores entre 1 y 10.000]");
        MatchSize=sc.nextInt();

        for (int i = 0; i < MatchSize; i++) {
            juego pPT =new juego();                 //pPT = piedraPapelTijeras.
            pPT.setJuego();
            this.Marcador=this.Marcador+pPT.getVentaja();
            //System.out.println("P1: "+pPT.getPlayer1()+" P2: "+pPT.getPlayer2()+" Ventaja: "+pPT.getVentaja()); //Esta linea plotea los juegos  individualmente.
            HaKenBo.add(pPT);
        }
    }

    public int getMarcador() {
        return Marcador;
    }
    public String resultadoPartido(){
        if (Marcador>0){
            return "Player1";
        }
        else if (Marcador<0){
            return "Player2";
        }
        return "Tie";
    }
}