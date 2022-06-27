/*
 * Reto #26
 * CUADRADO Y TRIÁNGULO 2D
 * Fecha publicación enunciado: 27/06/22
 * Fecha publicación resolución: 07/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
 * - EXTRA: ¿Eres capaz de dibujar más figuras?
 */

public class Reto26{
    
    public static void main(String[] args){
        Square square = new Square(5);
        square.printShape();
        Triangle triangle = new Triangle(5);
        triangle.printShape();
        Diamond d = new Diamond(5);
        d.printShape();
    }
    
}

class Square implements Shape {
    private int size;

    public Square(int size){
        this.size = size;
    }

    @Override
    public void printShape(){
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++) System.out.print("*");
            System.out.println();
        }
    }
}

class Triangle implements Shape {
    
    private int base;

    public Triangle(int base) {
        this.base = base;
    }
    
    @Override
    public void printShape(){
        for (int i = 1; i <= base; i++) {
            for(int j = i; j < base; j++) System.out.print(" ");
            for(int k = 1; k < (i*2); k++) System.out.print("*");
            System.out.println();
        }
    }
}

//Rombo
class Diamond implements Shape {
    private int size;

    public Diamond(int size) {
        this.size = size;
    }

    @Override
    public void printShape() {
        new Triangle(size).printShape();
        for (int i = size -1; i >= 1; i--) {
            for(int j = i; j < size; j++) System.out.print(" ");
            for(int k = 1; k < (i*2); k++) System.out.print("*");
            System.out.println();
        }
    }
}

interface Shape{
    void printShape();
}
