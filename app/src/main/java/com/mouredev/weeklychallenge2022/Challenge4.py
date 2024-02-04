#/*
# * Crea una única función (importante que sólo sea una) que sea capaz
#* de calcular y retornar el área de un polígono.
#* - La función recibirá por parámetro sólo UN polígono a la vez.
#* - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
#* - Imprime el cálculo del área de un polígono de cada tipo.
#*/

#OPCIÓN CADENA
def area(poligono):
    while True:
        if poligono == "Triangulo":
            num1 = float(input("Dime la base: "))
            num2 = float(input("Dime la altura: "))
            print(f"El área del triángulo es {(num1 * num2) / 2}")
        elif poligono == "Cuadrado":
            num1 = float(input("Dime el lado del cuadrado "))
            print(f"El área del cuadrado introducido es {num1 * num1}")
        elif poligono == "Rectangulo":
            num1 = float(input("Dime un lado: "))
            num2 = float(input("Dime el otro lado: "))
            print(f"El área del rectángulo introducido es {num1 * num2}")
        else:
            print("Polígono incorrecto. Me salgo")
        break

poligono = input("Dime el polígono (Triangulo, Cuadrado y Rectangulo) del que quieres calcular su área: ")
area(poligono)
