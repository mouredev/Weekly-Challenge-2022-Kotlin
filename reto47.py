#Crear una funcion que reciba como parametro un texto
#Crear una lista de las vocales
#Recorrer esa lista y preguntar cuantas veces se repite dicha vocal en la lista
#hacer uso de la funcion max o crear una funcion que recorrar el numero maximo
string = "sdfcyafewee"
def search_vocal_more_repit(texto: str):
  list_vocal  = ["a","e","i","o","u","A","E","I","O","U","á","é","í","ó","ú","Á","É","Í","Ó","Ú"]
  my_dict = dict()
  val_return=""
  for vocal in list_vocal:
    if texto.count(vocal) >0:
      my_dict[vocal]=texto.count(vocal)
  
  if len(my_dict)==0:
    val_return=""
  else:
    val_return=max(my_dict,key=my_dict.get)
  return val_return

print(search_vocal_more_repit(string))