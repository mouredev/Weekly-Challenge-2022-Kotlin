/*
 * Enunciado: Crea un programa que calcule el daño de un ataque durante
 * una batalla Pokémon.
 * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
 * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
 * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico 
 *   (buscar su efectividad)
 * - El programa recibe los siguientes parámetros:
 *  - Tipo del Pokémon atacante.
 *  - Tipo del Pokémon defensor.
 *  - Ataque: Entre 1 y 100.
 *  - Defensa: Entre 1 y 100.
 */

const validateTypes = (atkType, defType) =>{
  const types = ['agua', 'fuego', 'planta', 'electrico']
  if(types.includes(atkType.toLowerCase()) && types.includes(defType.toLowerCase())){
    return;
  }
  else {
    throw new Error('Los tipos permitidos son: agua, fuego, planta y electrico.');
  }
}

const validateStrings = (atkType, defType)=>{
  if(typeof atkType !== "string" || typeof defType !== "string") {
    throw new Error('Los tipos de pokemon deben ser cadenas de texto');
    }
}

const validateNums = (atk, def) =>{
  if(typeof atk !== "number" || typeof def !== "number"){
    throw new Error('Ataque y defensa DEBEN ser Numeros!')
  }
  if((atk > 0 && atk < 101) && (def > 0 && def < 101)){
    return true;
  } else {
    throw new Error('El atk y la def deben ser números entre 1 y 100');
  }
}

const validateParams = (atkType, defType, atk, def) =>{
  let isValid = true
  try {
    validateStrings(atkType, defType)
    validateTypes(atkType, defType)
    validateNums(atk, def)
    return isValid
  } catch (error) {
    console.error('Error!',error.message)
    isValid = false
    return isValid
  }
}

//Calculating effectiveness
const calculateEffectivness = (atkType, defType) =>{
  let attacker = atkType.toLowerCase();
  let defender = defType.toLowerCase();
  if (attacker === defender){
    return 0.5
  }
  else if( attacker === 'fuego' ){
    switch (defender) {
      case 'agua':
        return 0.5
        break;
      case 'planta':
        return 2
        break;
      case 'electrico':
        return 1
        break;
      default:
        break;
    }
  }
  else if( attacker === 'agua' ){
    switch (defender) {
      case 'fuego':
        return 2
        break;
      case 'planta':
        return 0.5
        break;
      case 'electrico':
        return 1
        break;
      default:
        break;
    }
  }
  else if( attacker === 'planta' ){
    switch (defender) {
      case 'fuego':
        return 0.5
        break;
      case 'agua':
        return 2
        break;
      case 'electrico':
        return 1
        break;
      default:
        break;
    }
  }
  else if( attacker === 'electrico' ){
    switch (defender) {
      case 'fuego':
        return 1
        break;
      case 'agua':
        return 2
        break;
      case 'planta':
        return 0.5
        break;
      default:
        break;
    }
  }
}
const textEffectiveness = (effectiveness)=>{
  switch (effectiveness) {
    case 0.5:
      return 'no es muy muy efectivo.'
      break;
    case 1:
      return 'es un daño normal'
      break;
    case 2:
      return 'es SUPER EFECTIVO!'
      break;
    default:
      break;
  }
}
const calculateDamage = (atkType, defType, atk, def)=>{
  let canContinue = validateParams(atkType, defType, atk, def)
  if (canContinue){
    let effectiveness = calculateEffectivness(atkType, defType)
    let textEffect = textEffectiveness(effectiveness)
    let damage = 50 * (atk / def) * effectiveness
    console.log(`El tipo atacante es ${atkType}, el tipo defensor es ${defType}, el ataque es ${atk}, la defensa es ${def}, el daño causado es: ${damage} y ${textEffect}`)
  }
}

calculateDamage( 'fuego', 'planta', 55, 36 )