def elementos_zodiaco_chino(ano):

    elementos = ['madera', 'fuego', 'tierra', 'metal', 'agua']
    animales = ['rata', 'buey', 'tigre', 'conejo', 'dragón', 'serpiente', 'caballo', 'oveja', 'mono', 'gallo', 'perro', 'cerdo']

    offset = ano - 1984 % 60

    elemento = elementos[offset % (len(elementos) * 2) // 2]
    animal = animales[offset % len(animales)]

    return elemento, animal


if __name__ == '__main__':
    for ano in range(1924, 1984):
        print(ano, elementos_zodiaco_chino(ano))

