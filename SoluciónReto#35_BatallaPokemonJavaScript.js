const pokemon_agua_efectividad = {fuego: 2, agua: 1, planta: 1, electrico: 0.5};
const pokemon_fuego_efectividad = {fuego: 1, agua: 0.5, planta: 2,electrico: 0.5};
const pokemon_planta_efectividad = {fuego: 0.5, agua: 1,planta: 1,electrico: 2};
const pokemon_electrico_efectividad = {fuego: 1, agua: 2, planta: 0.5,electrico: 1};

function attackPokemon(tipoAttack, tipoDefence, valAttack, valDefence) {
  switch (tipoAttack.toLowerCase()) {
    case "agua":
      if (valAttack <= 100 && valAttack >= 1) {
        switch (tipoDefence.toLowerCase()) {
          case "fuego":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: " + tipoDefence);
              danio = 50 * (valAttack / valDefence) * pokemon_agua_efectividad[tipoDefence];
              console.log("Daño infringido: " + danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          case "agua":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Agua contra Agua");
              danio = 50 * (valAttack / valDefence) * pokemon_agua_efectividad[tipoDefence];
              console.log("Daño infringido: " + danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          case "planta":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Agua contra planta");
              danio = 50 * (valAttack / valDefence) * pokemon_agua_efectividad[tipoDefence];
              console.log(danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          case "electrico":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Agua contra electrico");
              danio = 50 * (valAttack / valDefence) * pokemon_agua_efectividad[tipoDefence];
              console.log(danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          default:
            console.log("Lo lamentamos, el Pokemon defensor de Tipo " + tipoDefence + ", no puede ser evaluado.");
        }
      } else console.log("El valor del Ataque: debe estar entre 1 y 100");
      break;

    case "fuego":
      if (valAttack <= 100 && valAttack >= 1) {
        switch (tipoDefence.toLowerCase()) {
          case "fuego":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: " + tipoDefence);
              danio = 50 * (valAttack / valDefence) * pokemon_fuego_efectividad[tipoDefence];
              console.log("Daño infringido: " + danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          case "agua":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: " + tipoDefence);
              danio = 50 * (valAttack / valDefence) * pokemon_fuego_efectividad[tipoDefence];
              console.log("Daño infringido: " + danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          case "planta":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: " + tipoDefence);
              danio = 50 * (valAttack / valDefence) * pokemon_fuego_efectividad[tipoDefence];
              console.log(danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          case "electrico":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: "+ tipoDefence);
              danio = 50 * (valAttack / valDefence) * pokemon_fuego_efectividad[tipoDefence];
              console.log(danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          default:
            console.log(
              "Lo lamentamos, el Pokemon defensor de Tipo " +
                tipoDefence +
                ", no puede ser evaluado."
            );
        }
      } else console.log("El valor del Ataque: debe estar entre 1 y 100");
      break;

    case "planta":
      if (valAttack <= 100 && valAttack >= 1) {
        switch (tipoDefence.toLowerCase()) {
          case "fuego":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: " + tipoDefence);
              danio = 50 * (valAttack / valDefence) * pokemon_planta_efectividad[tipoDefence];
              console.log("Daño infringido: " + danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          case "agua":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: " + tipoDefence);
              danio = 50 *(valAttack / valDefence) * pokemon_planta_efectividad[tipoDefence];
              console.log("Daño infringido: " + danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          case "planta":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: " + tipoDefence);
              danio = 50 * (valAttack / valDefence) * pokemon_planta_efectividad[tipoDefence];
              console.log(danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          case "electrico":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: " + tipoDefence);
              danio = 50 * (valAttack / valDefence) * pokemon_planta_efectividad[tipoDefence];
              console.log(danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          default:
            console.log(
              "Lo lamentamos, el Pokemon defensor de Tipo " +
                tipoDefence +
                ", no puede ser evaluado."
            );
        }
      } else console.log("El valor del Ataque: debe estar entre 1 y 100");
      break;

    case "electrico":
      if (valAttack <= 100 && valAttack >= 1) {
        switch (tipoDefence.toLowerCase()) {
          case "fuego":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: " + tipoDefence);
              danio = 50 * (valAttack / valDefence) * pokemon_electrico_efectividad[tipoDefence];
              console.log("Daño infringido: " + danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          case "agua":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: " + tipoDefence);
              danio = 50 * (valAttack / valDefence) * pokemon_electrico_efectividad[tipoDefence];
              console.log("Daño infringido: " + danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          case "planta":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: " + tipoDefence);
              danio = 50 * (valAttack / valDefence) * pokemon_electrico_efectividad[tipoDefence];
              console.log(danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          case "electrico":
            if (valDefence <= 100 && valDefence >= 1) {
              console.log("Atacante: " + tipoAttack + " vs Defensa: " + tipoDefence);
              danio = 50 * (valAttack / valDefence) * pokemon_electrico_efectividad[tipoDefence];
              console.log(danio);
            } else
              console.log("El valor de la Defensa: debe estar entre 1 y 100");
            break;

          default:
            console.log(
              "Lo lamentamos, el Pokemon defensor de Tipo " +
                tipoDefence +
                ", no puede ser evaluado."
            );
        }
      } else console.log("El valor del Ataque: debe estar entre 1 y 100");
      break;
    default:
      console.log("Lo lamentamos, el Pokemon atacante de Tipo " + tipoAttack +", no puede ser evaluado."
      );
  }
  
  attackPokemon("electrico", "fuego", 30, 10);
}
