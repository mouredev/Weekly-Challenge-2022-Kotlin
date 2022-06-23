package com.mouredev.weeklychallenge2022

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

public class Portfolio25 {
    public static void main(String[] args) {
        gamesArray partidoActual =new gamesArray();
        System.out.println(partidoActual.getMarcador());
        System.out.println(partidoActual.gameResult());
    }
}
//La clase Game es la que contendrá el par de jugadas de player1 y player2, de cada ronda.
class Game{
    private char Player1;
    private char Player2;
    private int Advantage; //esta variable define quien gana en cada juego.
    //Constructor de clase en blanco, insertaremos los valores con setGame, que es un setter que declara el resultado de Player1 y Player2
    public Game(){
        System.out.println(getPlayer1()+" "+getPlayer2());
    }
    //setters
    public void setPlayer1(char player1) {
        this.Player1 = player1;
    }
    public void setPlayer2(char player2) {
        this.Player2 = player2;
    }
    public void setAdvantage() {
        if(getPlayer1()==getPlayer2()){
            this.Advantage = 0;
        }
        else if  (getPlayer1()=='r' && getPlayer2()=='s'||
                getPlayer1()=='s' && getPlayer2()=='p'||
                getPlayer1()=='p' && getPlayer2()=='r'){
            this.Advantage = 1;
        }
        else{
            this.Advantage = -1;
        }
    }
    //getters
    public char getPlayer1() {
        return Player1;
    }
    public char getPlayer2() {
        return Player2;
    }
    public int getAdvantage() {
        return Advantage;
    }
    //Este método devuelve la elección del jugador (cualquiera), usando el random, pasándolo a base 3 y el resto define el valor.
    // No usé el round a pelo porque me da que la matemática otorga más probabilidad a un número que a los otros.
    // de 0 a 0,44 redondea 0, de 0,45 a 1,44 redondea 1 y de 1,45 a 2 redondea 2... saldrían muchos más 1
    public char getJugada(){
        int tirada = (int)(Math.round((Math.random()*2)%3));
        return switch (tirada) {
            case 0 -> 'r';
            case 1 -> 'p';
            case 2 -> 's';
            default -> 'x';
        };
    }
    //Establecemos las jugadas del Player1 y Player2
    public void setGame(){
        Game HaKenBo = new Game();
        HaKenBo.setPlayer1(getJugada());
        HaKenBo.setPlayer2(getJugada());
        HaKenBo.setAdvantage();
    }
}
// Creamos el conjunto de jugadas a petición del usuario usamos un int, así que de 1 a (2^31)-1 vamos ha establecer un máximo de 1000
class gamesArray{

    private int Marcador;
    //Constructor del Conjunto de juegos, con la petición de tamaño a través de Terminal.
    public gamesArray(){
        ArrayList <Game> Match = new ArrayList<>();
        int MatchSize;
        this.Marcador = 0;

        Scanner sc=new Scanner(System.in);
        System.out.println("¿Cuantas veces jugarán el Player1 contra Player2?\n[Introduzca un valor entre 1 y 1000]");
        MatchSize=sc.nextInt();
        for (int i = 0; i < MatchSize; i++) {
            Game RockPaperScisors = new Game();
            RockPaperScisors.setGame();
            Match.add(RockPaperScisors);
            this.Marcador=this.Marcador+RockPaperScisors.getAdvantage();
        }
    }
    //Creamos el marcador total del partido.
    public int getMarcador() {
        return Marcador;
    }
    public String gameResult(){
        if(Marcador>0){
            return ("Player1 WINS");
        }else
        if(Marcador<0){
            return ("Player2 WINS");
        }else{
            return ("TIE");
        }
    }
}