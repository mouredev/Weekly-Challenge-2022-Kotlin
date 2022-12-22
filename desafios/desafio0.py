int_limite = 1
string_fizz = "fizz"
string_buzz = "buzz"
while int_limite <=100:
    if int_limite%3 == 0 and int_limite%5 == 0: #Si el resto de la division da 0, el numero es multiplo de 3 y 5
        print(f"{string_fizz}{string_buzz}")
    elif int_limite%3 == 0 or int_limite%5 ==0:
        if int_limite%3 == 0:
            print(string_fizz)
        else:
            print(string_buzz)
    else:
        print(int_limite)
    int_limite = int_limite + 1