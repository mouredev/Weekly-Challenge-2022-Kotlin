#Reto #33: CICLO SEXAGENARIO CHINO

def chi_year(a):
    
    a = int(a) % 12

    if a == 0:
        animal = "Mono"
    if a == 1:
        animal = "Gallo"
    if a == 2:
        animal = "Perro"
    if a == 3:
        animal = "Cerdo"
    if a == 4:
        animal = "Rata"
    if a == 5:
        animal = "Buey"
    if a == 6:
        animal = "Tigre"
    if a == 7:
        animal = "Conejo"
    if a == 8:
        animal = "Dragón"
    if a == 9:
        animal = "Serpiente"
    if a == 10:
        animal = "Caballo"
    if a == 11:
        animal = "Cabra"
                
    return animal

def metal_year(a):
    if a == "0" or a == "1":
        metal = "Metal"
    if a == "2" or a == "3":
        metal = "Agua"
    if a == "4" or a == "5":
        metal = "Madera"
    if a == "6" or a == "7":
        metal = "Fuego"
    if a == "8" or a == "9":
        metal = "Tierra"

    return metal

print("Ingrese año: ")
input_year = input()

animal = chi_year(input_year)
metal = metal_year(input_year[len(input_year) -1])

print(animal + " , " + metal)
