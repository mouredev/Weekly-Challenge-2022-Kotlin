
'''/*
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, 
 * crea una función que calcule y retorne todos los que faltan entre
 * el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 */
'''

def missing(arra: list):
    assert type(arra) is list, "No es array"
    arra = list(set(arra))    
    x = min(arra)
    y = max(arra)    
    new_arr =[n for n in range(x,y) if n not in arra]
    print (new_arr)    

def run():    
    missing([5,15,3,10,8,6,9,15,3,2,10])

if __name__ == '__main__':run()