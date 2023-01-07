"""
package com.mouredev.weeklychallenge2022

/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
"""

def normalizatexto(texto):
    texto = texto.lower()
    texto = texto.replace("á","a")
    texto = texto.replace("é","e")
    texto = texto.replace("í","i")
    texto = texto.replace("ó","o")
    texto = texto.replace("ú","u")
    return texto


def vocalmasrepetida(dict):
    maximo = max(dict, key=dict.get)
    if dict[maximo]==0:
        return None
    else:
        return maximo


def cuentavocal(texto):
    dict = {"a":0,"e":0,"i":0,"o":0,"u":0}
    lista = list(texto)

    for i in lista:
        vocales = ("a","e","i","o","u")
        if i in vocales:
            dict[i]+=1
    return dict


if __name__=="__main__":
    texto = input("Ingresa una oración: ")
    texto = normalizatexto(texto)
    totalvocales = cuentavocal(texto)
    max = vocalmasrepetida(totalvocales)
    if max==None:
        print ("No hay vocales en la oración")
    else:
        print (f'La vocal más repetida es la: "{max}" y se repite {totalvocales[max]} veces en la oración')