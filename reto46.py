def cordenadas(lista):
    mirar = 1
    x = 0
    y = 0

    for i in lista:
        if mirar == 1:
            y += i
        elif mirar == 2:
            x -= i
        elif mirar == 3:
            y -= i
        elif mirar == 4:
            x += i
            mirar = 0
        mirar += 1
    
    return f"Eje X={x} Eje Y={y}"

def main():
    print(cordenadas([10,5,-2]))
    print(cordenadas([12,25,-10,1]))
    print(cordenadas([5,3,3,3]))
    print(cordenadas([1,7,8,4,6]))
main()