"""
 Enunciado: ¡La Tierra Media está en guerra! 
 En ella lucharán razas leales a Sauron contra otras bondadosas que no quieren que el mal reine sobre sus tierras.
 Cada raza tiene asociado un "valor" entre 1 y 5:
 - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3), Númenóreanos (4), Elfos (5)
 - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2), Huargos (3), Trolls (5)
 Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ejércitos:
 - El resultado puede ser que gane el bien, el mal, o exista un empate. 
   Dependiendo de la suma del valor del ejército y el número de integrantes.
 - Cada ejército puede estar compuesto por un número de integrantes variable de cada raza.
 - Tienes total libertad para modelar los datos del ejercicio.
 Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
 """


class Bondadosos:
    def pelosos(self, n):
        return 1 * n

    def surenos_buenos(self, n):
        return 2 * n

    def enanos(self, n):
        return 3 * n

    def numenoreanos(self, n):
        return 4 * n

    def elfos(self, n):
        return 5 * n


class Malvados:
    def surenos_malos(self, n):
        return 2 * n

    def orcos(self, n):
        return 2 * n

    def goblins(self, n):
        return 2 * n

    def huargos(self, n):
        return 3 * n

    def trolls(self, n):
        return 5 * n


bondadosos = Bondadosos()
malvados = Malvados()
battle = 0

print(
    "===========\nBondadosos:\nPelosos: 1 de daño\nSureños buenos: 2 de daño\nEnanos: 3 de daño\nNumenoreanos: 4 de daño\nElfos: 5 de daño\n==========="
)
battle += bondadosos.pelosos(int(input("Número de pelosos: ")))
battle += bondadosos.surenos_buenos(int(input("Número de sureños buenos: ")))
battle += bondadosos.enanos(int(input("Número de enanos: ")))
battle += bondadosos.numenoreanos(int(input("Número de numenoreanos: ")))
battle += bondadosos.elfos(int(input("Número de elfos: ")))

print(
    "===========\nMalvados:\nSureños malos: 2 de daño\nOrcos: 2 de daño\nGoblins: 2 de daño\nHuargos: 3 de daño\nTrolls: 5 de daño\n==========="
)

battle -= malvados.surenos_malos(int(input("Número de sureños malos: ")))
battle -= malvados.orcos(int(input("Número de orcos: ")))
battle -= malvados.goblins(int(input("Número de goblins: ")))
battle -= malvados.huargos(int(input("Número de huargos: ")))
battle -= malvados.trolls(int(input("Número de trolls: ")))

print("")

if battle > 0:
    print("Gana el bien")
elif battle < 0:
    print("Gana el mal")
else:
    print("Empate")
