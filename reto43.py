#
# Enunciado: Este es un reto especial por Halloween.
# Deberemos crear un programa al que le indiquemos si queremos realizar "Truco
# o Trato" y un listado (array) de personas con las siguientes propiedades:
# - Nombre de la niña o niño
# - Edad
# - Altura en centímetros
#
# Si las personas han pedido truco, el programa retornará sustos (aleatorios)
# siguiendo estos criterios:
# - Un susto por cada 2 letras del nombre por persona
# - Dos sustos por cada edad que sea un número par
# - Tres sustos por cada 100 cm de altura entre todas las personas
# - Sustos: 🎃 👻 💀 🕷 🕸 🦇
#
# Si las personas han pedido trato, el programa retornará dulces (aleatorios)
# siguiendo estos criterios:
# - Un dulce por cada letra de nombre
# - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
# - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
# - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
#
import random


class Persona:
    def __init__(self, nombre, edad, altura):
        self.nombre = nombre
        self.edad = edad
        self.altura = altura


class Jugar:
    def __init__(self):
        self.lista_chicos = []
        self.lista_sustos = ["🎃", "👻", "💀", "🕷", "🕸", "🦇", ]
        self.lista_dulces = ["🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"]
        self.modo_juego = ""

    def truco_trato(self):
        opcion = 0
        while opcion != 3:
            print(f'\n--------------')
            print("1 - Truco")
            print("2 - Trato")
            print("3 - Salir")
            print("--------------")
            opcion = int(input("Ingrese una opción: "))
            if opcion == 1:
                self.modo_juego = "truco"
                self.inicio_juego()
            elif opcion == 2:
                self.modo_juego = "trato"
                self.inicio_juego()

        if opcion == 3:
            quit()

    def inicio_juego(self):
        self.lista_chicos.clear()
        num_per = input("Número de niños: ")
        for _ in range(int(num_per)):
            nombre = input("Nombre: ")
            edad = input("Edad: ")
            altura = input("Altura: ")
            per = Persona(nombre, edad, altura)
            self.lista_chicos.append(per)

        if self.modo_juego == "truco":
            self.truco()
        else:
            self.trato()

    def truco(self):
        #  Letras
        letras = 0
        for x in range(len(self.lista_chicos)):
            for _ in self.lista_chicos[x].nombre:
                letras += 1
        valor_letras = int(letras / 2)
        print(f'\nTotal letras: {letras}')
        for _ in range(valor_letras):
            print(random.choice(self.lista_sustos), end=" ")

        # Edad
        for x in range(len(self.lista_chicos)):
            edad = int(self.lista_chicos[x].edad)
            print(f'\nEdad: {self.lista_chicos[x].nombre}  {edad}')
            if (edad % 2) == 0:
                for _ in range(2):
                    print(random.choice(self.lista_sustos), end=" ")

        # Altura
        total_altura = 0
        for x in range(len(self.lista_chicos)):
            total_altura += int(self.lista_chicos[x].altura)
        valor_altura = int(total_altura / 100)
        print(f'\nAltura total en cm: {total_altura}')
        for _ in range(int(valor_altura * 3)):
            print(random.choice(self.lista_sustos), end=" ")

    def trato(self):
        # Letras
        letras = 0
        for x in range(len(self.lista_chicos)):
            for _ in self.lista_chicos[x].nombre:
                letras += 1
        print(f'\nTotal letras: {letras}')
        for _ in range(letras):
            print(random.choice(self.lista_dulces), end=" ")

        # Edad
        for x in range(len(self.lista_chicos)):
            edad = int(self.lista_chicos[x].edad)
            print(f'\nEdad: {self.lista_chicos[x].nombre}  {edad}')
            if edad > 10:
                edad = 10
            valor_edad = int(edad / 3)
            if valor_edad <= 10:
                for _ in range(valor_edad):
                    print(random.choice(self.lista_dulces), end=" ")

        # Altura
        for x in range(len(self.lista_chicos)):
            altura = int(self.lista_chicos[x].altura)
            print(f'\nAltura: {self.lista_chicos[x].nombre} {altura}')
            if altura > 150:
                altura = 150
            altura = int(altura / 50)
            for _ in range(altura * 2):
                print(random.choice(self.lista_dulces), end=" ")


if __name__ == "__main__":
    juego = Jugar()
    juego.truco_trato()