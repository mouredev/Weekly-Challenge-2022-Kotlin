/*
Solucion al reto #37 en Typescript
No lo hago en JS ya que comence a estudiarTS esta semana 
y quisiera poner en practica los conceptos que aprendi.
*/

import { zeldaGames } from "./models/zeldaGames.model";
import { dateService } from "./services/dateService.service";

dateService.getDateDiff(
    zeldaGames.TLZ_Links_Awakening,
    zeldaGames.TLZ_Skyward_Sword
)

dateService.getRelaseDate(zeldaGames.The_Legend_of_Zelda)

/*
Instrucciones:
La clase dateService posee 2 metodos los cuales reciben
parametros del enum zeldaGames donde estan almacenados
los juegos y sus fechas, para así obtener los años y dias de diferencia
que hay entre los juegos seleccionados.

Puedes ejecutar el programa con el script " npm run start "
Y si quieres transpilarlo a JS tienes el " npm run build "

Muchas gracias por traer estos retos a la comunidad,
se agradecen un monton. Saludos desde Venezuela :)
*/