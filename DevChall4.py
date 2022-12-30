'''
 * Crea una única función (importante que sólo sea una) que sea capaz
 * de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 '''

poligonos = ['triangulo', 'cuadrado', 'rectangulo']

def area(a, b, figura):
    if figura == 'triangulo':
        return (a * b) / 2
    elif figura == 'cuadrado' or figura == 'rectangulo':
        return a * b

figura = input('Escribe el nombre de la figura (Triangulo, Cuadrado, o Rectangulo): ').lower()
if figura in poligonos:
    a = int(input('Escribe el valor de a: '))
    b = int(input('Escribe el valor de b: '))
    resultado = area(a, b, figura)
    print(f'El área de la figura es: {resultado}')
else:
    print('La figura no es valida.')

