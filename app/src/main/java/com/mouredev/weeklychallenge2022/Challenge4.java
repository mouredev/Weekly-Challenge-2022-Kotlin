/*
Reto #4
ÁREA DE UN POLÍGONO
Fecha publicación enunciado: 24/01/22
Fecha publicación resolución: 31/01/22
Dificultad: FÁCIL

Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
La función recibirá por parámetro sólo UN polígono a la vez.
Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
Imprime el cálculo del área de un polígono de cada tipo.
 */
package weeklychallenge2022;

//////////////////////////CLASE PRINCIPAL (MÉTODO MAIN)////////////////////////
public class Challenge4 {

    public static void main(String[] args) {

        Triangulo tr = new Triangulo(10, 5);
        Rectangulo rt = new Rectangulo(5, 7);
        Cuadrado cd = new Cuadrado(4);

        area(tr);
        area(rt);
        area(cd);

    }

    public static double area(Poligono x) {
        x.imprimirArea();
        return x.area();
    }
}

/////////////////////////////////////INTERFAZ//////////////////////////////////
interface Poligono {

    double area();

    void imprimirArea();
}

//////////////////////////////////CLASE TRIANGULO//////////////////////////////
class Triangulo implements Poligono {

    double base;
    double altura;

    public Triangulo() {
    }

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return ((base * altura) / 2);
    }

    @Override
    public void imprimirArea() {
        System.out.println("El área del triángulo es: " + area());
    }

    @Override
    public String toString() {
        return "Triangulo{" + "base=" + base + ", altura=" + altura + '}';
    }

}

////////////////////////////////CLASE RECTÁNGULO///////////////////////////////
class Rectangulo implements Poligono {

    double largo;
    double ancho;

    public Rectangulo() {
    }

    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    @Override
    public double area() {
        return largo * ancho;
    }

    @Override
    public void imprimirArea() {
        System.out.println("El área del rectángulo es: " + area());
    }

    @Override
    public String toString() {
        return "Rectangulo{" + "largo=" + largo + ", ancho=" + ancho + '}';
    }

}

/////////////////////////////////CLASE CUADRADO////////////////////////////////
class Cuadrado implements Poligono {

    double lado;

    public Cuadrado() {
    }

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public void imprimirArea() {
        System.out.println("El área del cuadrado es: " + area());
    }

    @Override
    public String toString() {
        return "Cuadrado{" + "lado=" + lado + '}';
    }
}
