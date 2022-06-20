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
 */
 
import java.util.Random;
import java.util.Arrays;

public class Reto25{
    
    public static void main(String[] args){
        validateGames(generateRandomGames(5));
        validateGames(generateRandomGames(8));
    }
    
    private static void validateGames(Pair<String, String>...games){
        int player1Count = 0, player2Count = 0;
        for(Pair<String, String> move : games){
            if(move.first() == "R"){
                if(move.second() == "P") player2Count++;
                else if(move.second() == "S") player1Count++;
            } else if(move.first() == "P"){
                if(move.second() == "S") player2Count++;
                else if(move.second() == "R") player1Count++;
            } else if(move.first() == "S"){
                if(move.second() == "R") player2Count++;
                else if(move.second() == "P") player1Count++;
            }
        }
        if(player1Count == player2Count) System.out.println("Tie");
        else if(player1Count > player2Count) System.out.println("Player 1");
        else System.out.println("Player 2");
    }
    
    //Genera juegos al azar (aleatoriamente)
    private static Pair<String, String>[] generateRandomGames(int maxAmount){
        Random r = new Random();
        String[] moves = {"R", "P", "S"};
        Pair<String, String>[] games = new Pair[maxAmount];
        for (int i = 0; i < games.length; i++) {
            games[i] = new Pair<String, String>(moves[r.nextInt(moves.length)], moves[r.nextInt(moves.length)]);
        }
        return games;
    }
    
}

//Clase Pair construida ya que en Java no existe.
class Pair<K, V>{
    
    private K first;
    private V second;
    
    public Pair(K first, V second){
        this.first = first;
        this.second = second;
    }
    
    public K first(){
        return first;
    }
    
    public V second(){
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
