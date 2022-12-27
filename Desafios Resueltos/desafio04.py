def inicio():
    poligono(1,2,3)
    poligono(3,3,3,3)
    poligono(3,2,3,2)
    poligono(1,5,3,2)
    
    


def poligono(a,b,c, d = 0):
 if d == 0:
    area = (b*c)/2
    print("Area del triangulo",area)
    return area
 if a == b and b == c and c == d:
    area = a*b
    print("Area del cuadrado",area)
    return area
 elif (a == c and b == d) or (a == b and c == d):
     area = a*b
     print("Area del rectangulo",area)
     return area
 else:
        print("Error: Figura geometrica incorrecta")
        return

inicio()