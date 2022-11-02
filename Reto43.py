#!/usr/bin/env python
# -*- coding: utf-8 -*-

__author__ = "Alex Lema Seoane"

# Reto #43: TRUCO O TRATO
#  * Enunciado: Este es un reto especial por Halloween.
#  * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco
#  * o Trato" y un listado (array) de personas con las siguientes propiedades:
#  * - Nombre de la niña o niño
#  * - Edad
#  * - Altura en centímetros
#  *
#  * Si las personas han pedido truco, el programa retornará sustos (aleatorios)
#  * siguiendo estos criterios:
#  * - Un susto por cada 2 letras del nombre por persona
#  * - Dos sustos por cada edad que sea un número par
#  * - Tres sustos por cada 100 cm de altura entre todas las personas
#  * - Sustos: 🎃 👻 💀 🕷 🕸 🦇
#  *
#  * Si las personas han pedido trato, el programa retornará dulces (aleatorios)
#  * siguiendo estos criterios:
#  * - Un dulce por cada letra de nombre
#  * - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
#  * - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
#  * - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
 
# Imports 

import random

# Constantes

lista_sustos = ["🎃" ,"👻" ,"💀" ,"🕷" ,"🕸" ,"🦇"]

lista_dulces = ["🍰","🍬" ,"🍡" ,"🍭" ,"🍪" ,"🍫" ,"🧁" ,"🍩"]

# Funciones Sustos

def sustos_nombre(persona):
    nombre = persona[0]
    largo_nombre = len(nombre)/2
    return int(largo_nombre)

def sustos_edad(persona):
    edad = persona[1]
    contador_pares = 0
    try:
        for numero in edad:
            numero = int(numero)
            if (numero % 2) == 0:
                contador_pares = contador_pares + 1
            return (2 * contador_pares)
    except:
        print("Introduce un número para la edad por favor")
        exit()

def sustos_altura(persona):
    altura = persona[2]
    try:
        altura = int(altura)
        sustos = (3 * int(altura / 100))
        return sustos
    except:
        print("Introduce un número para la altura por favor")
        exit()  
    
# Funciones Dulces 

def dulces_nombre(persona):
    nombre = persona[0]
    return int(len(nombre))

def dulces_edad(persona):
    edad = persona[1]
    try:
        edad = int(edad)
        if edad > 10:
            dulces = 3
        else:
            dulces = int(edad / 3)
        return dulces
    except:
        print("Introduce un número para la edad por favor")
        exit()

def dulces_altura(persona):
    altura = persona[2]
    try:
        altura = int(altura)
        if altura > 150:
            dulces = 6
        else:
            dulces = int(altura / 50)
        return dulces
    except:
        print("Introduce un número para la altura por favor")
        exit()

# Pedir truco o trato
while True:
    try:
        menu = input("Truco o Trato: ")
        if menu in ["Truco","Trato"]:
            break
        else:
            print("Escribe Truco o Trato por favor")
    except:
        print("Algo ha fallado")

# Pedir informacion de Persona
persona = []

nombre_persona = input("Nombre: ")
persona.append(nombre_persona)

edad_persona = input("Edad: ")
persona.append(edad_persona)

altura_persona = input("Altura en centímetros: ")
persona.append(altura_persona)


# Programa principal 

if menu == "Truco":
    suma_sustos = sustos_nombre(persona) + sustos_edad(persona) + sustos_altura(persona)
    for i in range(suma_sustos):
        print(random.choice(lista_sustos))

elif menu == "Trato":
    suma_dulces = dulces_nombre(persona) + dulces_edad(persona) + dulces_altura(persona)
    for i in range(suma_dulces):
        print(random.choice(lista_dulces))
 
else:
    print("Algo ha fallado")