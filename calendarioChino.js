/*
 * Enunciado: Crea un función, que dado un año, indique el elemento 
 * y animal correspondiente en el ciclo sexagenario del zodíaco chino.
 * - Info: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos
 *   madera, fuego, tierra, metal, agua y los animales rata, buey, tigre,
 *   conejo, dragón, serpiente, caballo, oveja, mono, gallo, perro, cerdo
 *   (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 */
const animales=   ['rata', 'buey', 'tigre','conejo', 'dragón','serpiente', 'caballo', 'oveja', 'mono', 'gallo', 'perro', 'cerdo']
const elementos = ['madera','madera', 'fuego','fuego', 'tierra','tierra', 'metal','metal', 'agua','agua'] 
let anhoABuscar = 1400
let anhoInicio = 1924
let indexAnimal=0
let indexElement = 0
function recorridoElemento(){
    if (indexElement<9){
        indexElement+=1
    }else{
        indexElement = 0;
    }
}
function calendarioChino (anhoABuscar){
    while (anhoABuscar != anhoInicio){
        for ( let indexAnimalRecorrido = 0; indexAnimalRecorrido < animales.length; indexAnimalRecorrido++) {
                if (anhoABuscar ===anhoInicio) {
                    indexAnimal = indexAnimalRecorrido
                    indexAnimalRecorrido = animales.length+1;                    
                }else{
                    anhoInicio+=1;
                    recorridoElemento()
                }              
        } 
    }
    console.log("El año buscado: ", anhoABuscar);
    console.log("Tu signo chino es: ", animales[indexAnimal], elementos[indexElement]);
}
if (anhoABuscar>=1924){
    calendarioChino(anhoABuscar)
}else{
    console.log("Año incorrecto: ");
}