int_limite = 1
string_fizz = "fizz"
string_buzz = "buzz"
while int_limite <=100:
    if int_limite%3 == 0 and int_limite%5 == 0: #Si el resto de la division da 0, el numero es multiplo de 3 y 5
        print(f"{string_fizz}{string_buzz}")
    elif int_limite%3 == 0 or int_limite%5 ==0:#Consulta si hay un multiplo de 3 o 5
        if int_limite%3 == 0:#Si es multiplo de 3 hace fizz
            print(string_fizz)
        else:#si no, buzz
            print(string_buzz)
    else:#Si no hay multiplos, imprime el numero
        print(int_limite)
    int_limite = int_limite + 1#Hace avanzar al contador