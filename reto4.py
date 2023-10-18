'''
*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 */
 '''
def cal_area(var1:float, var2:float=0, type:str= "s"):
  area:float=0
  name_type=""
  if type== "t":
    area= (var1 * var2) / 2
    name_type="Triángulo"
  elif type== "r":
    area= (var1 * var2)
    name_type="Rectángulo"
  elif type== "s":
    area= (var1 * var1)
    name_type="Cuadrado"
  print(f"El área de {name_type} es {area}")
cal_area(10.0, 5.0,"t")
cal_area(5.0, 7.0,"r")
cal_area(4.0,type="s")