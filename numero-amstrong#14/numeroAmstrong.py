#  ¿ES UN NÚMERO DE ARMSTRONG?
#  * Fecha publicación enunciado: 04/04/22
#  * Fecha publicación resolución: 11/04/22
#  * Dificultad: FÁCIL
#  *
#  * Enunciado: Escribe una función que calcule si un número dado es un número de Amstrong (o también llamado narcisista).

def numeroAmstrong():

    numero = int(input('Introduce un número: '))
    
    #El número indicado por el usuario se pasa a str y se calcula cuantos dígitos lo componen, este será el valor de la potencia
    potencia = len(str(numero))

    #Declaración variables
    x = []
    sum = 0
    
    #Rellena una list con cada dígito que compone el número
    for j in str(numero):
            x.append(j)
    
    #Convierte la list de str a int
    int_x =list(map(int, x))
    
    #Cálculo de cada dígito elevado a la potencia del todal de digitos más la suma entre estos
    for h in int_x:
        cal_potencia = h ** potencia
        sum = cal_potencia + sum
    
    
    if sum == numero:
        print(f'El {numero} es un número de Amstrong')
    
    else:

        print(f'El {numero} NO es un número de Amstrong')
    

numeroAmstrong()
