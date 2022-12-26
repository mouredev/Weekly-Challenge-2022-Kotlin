package com.example.weekly_challenge_2022_java;

/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 */
public class Challenge4 {
    public static void main(String[] args) {

        area(new Cuadrado(3, 4));
        area(new Triangulo(34,4));

    }

    public static double area(poligono po) {
        po.print();
        return po.area();
    }

}

interface poligono {
    double area();

    void print();
}


class Cuadrado implements poligono {

    double ladoA;
    double ladoB;

    public Cuadrado(double ladoA, double ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    @Override
    public double area() {
        return this.ladoA * this.ladoB;
    }

    @Override
    public void print() {
        System.out.println("El area del cuadrado es: " + area());
    }

}

class Triangulo implements poligono {

    double altura;
    double base;

    public Triangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double area() {
        return this.base * this.altura;
    }

    @Override
    public void print() {
        System.out.println("El area del triangulo es: " + area());
    }
}
