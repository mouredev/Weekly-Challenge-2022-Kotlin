const pokAtacante = prompt(`Selecciona Pokemon ATACANTE:
                         1= Agua
                         2= Fuego
                         3= Planta
                         4= Eléctrico
Por favor introduce solo numero del 1 al 4`);

const ataque = prompt(`Intoduce tu ataque
entre 1 y 100`)

const pokDefensor = prompt(`Selecciona Pokemon DEFENSOR:
                         1= Agua
                         2= Fuego
                         3= Planta
                         4= Eléctrico
Por favor introduce solo numero del 1 al 4`);

const defensa = prompt(`Introduce tu defensa
entre 1 y 100`)

if (pokAtacante == 1 && pokDefensor == 2) {
    alert('Pokemon Atacante de AGUA VS Pokemos Defensa de FUEGO')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 2)
} else if (pokAtacante == 1 && pokDefensor == 3) {
    alert('Pokemon Atacante de AGUA VS Pokemos Defensa de PLANTA')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 0.5)
} else if (pokAtacante == 1 && pokDefensor == 4) {
    alert('Pokemon Atacante de AGUA VS Pokemos Defensa de ELÉCTRICO')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 0.5)
} else if (pokAtacante == 1 && pokDefensor == 1) {
    alert('Pokemon Atacante de AGUA VS Pokemos Defensa de AGUA')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 1)
}

if (pokAtacante == 2 && pokDefensor == 1) {
    alert('Pokemon Atacante de FUEGO VS Pokemos Defensa de AGUA')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 0.5)
} else if (pokAtacante == 2 && pokDefensor == 2) {
    alert('Pokemon Atacante de FUEGO VS Pokemos Defensa de FUEGO')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 1)
} else if (pokAtacante == 2 && pokDefensor == 3) {
    alert('Pokemon Atacante de FUEGO VS Pokemos Defensa de PLANTA')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 2)
} else if (pokAtacante == 2 && pokDefensor == 4) {
    alert('Pokemon Atacante de FUEGO VS Pokemos Defensa de ELÉCTRICO')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 0.5)
}

if (pokAtacante == 3 && pokDefensor == 1) {
    alert('Pokemon Atacante de PLANTA VS Pokemos Defensa de AGUA')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 2)
} else if (pokAtacante == 3 && pokDefensor == 2) {
    alert('Pokemon Atacante de PLANTA VS Pokemos Defensa de FUEGO')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 0.5)
} else if (pokAtacante == 3 && pokDefensor == 3) {
    alert('Pokemon Atacante de PLANTA VS Pokemos Defensa de PLANTA')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 1)
} else if (pokAtacante == 3 && pokDefensor == 4) {
    alert('Pokemon Atacante de PLANTA VS Pokemos Defensa de ELÉCTRICO')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 0.5)
}

if (pokAtacante == 4 && pokDefensor == 1) {
    alert('Pokemon Atacante de ELÉCTRICO VS Pokemos Defensa de AGUA')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 2)
} else if (pokAtacante == 4 && pokDefensor == 2) {
    alert('Pokemon Atacante de ELÉCTRICO VS Pokemos Defensa de FUEGO')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 0.5)
} else if (pokAtacante == 4 && pokDefensor == 3) {
    alert('Pokemon Atacante de ELÉCTRICO VS Pokemos Defensa de PLANTA')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 0.5)
} else if (pokAtacante == 4 && pokDefensor == 4) {
    alert('Pokemon Atacante de ELÉCTRICO VS Pokemos Defensa de ELÉCTRICO')
    alert('El daño ha sido de: ' + 50 * (ataque / defensa) * 1)
}

