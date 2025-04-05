"""
#15-¿CUÁNTOS DÍAS?
/*
 * Crea una función que calcule y retorne cuántos días hay entre dos cadenas
 * de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se
 *   lanzará una excepción.
 */
"""

#importamos date desde la bbiblioteca datetime
from datetime import date

def calculadora(var_1, var_2):

    try: #comprueba que funciona
        dia = int(var_1[0:2]) # a traves del index de la cadena de texto formamos la fecha correctamente
        mes = int(var_1[3:5])
        año = int(var_1[6:10])
        fecha_1 = date (año,mes,dia)
    
        dia = int(var_2[0:2])
        mes = int(var_2[3:5])
        año = int(var_2[6:10])
        fecha_2 = date (año,mes,dia)
                    

        print (fecha_1.strftime("%d/%m/%Y"))

        print (fecha_2.strftime("%d/%m/%Y"))
        

        diferencia = abs(fecha_1 - fecha_2) #calculamos la diferencia de dias y en terminos absolutos con "abs"
        
        return diferencia.days
    except:
        diferencia = "error en el formato de la fecha"
        return diferencia

print (calculadora ("16/11/2024", "16/11/2025" ))
