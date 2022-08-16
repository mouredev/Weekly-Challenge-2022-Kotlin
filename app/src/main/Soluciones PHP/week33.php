/*
* Reto #33
* CICLO SEXAGENARIO CHINO
* Fecha publicación enunciado: 15/08/22
* Fecha publicación resolución: 22/08/22
* Dificultad: MEDIA
*
* Enunciado: Crea un función, que dado un año, indique el elemento y animal correspondiente
* en el ciclo sexagenario del zodíaco chino.
* - Información: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
* - El ciclo sexagenario se corresponde con la combinación de los elementos madera,
*   fuego, tierra, metal, agua y los animales rata, buey, tigre, conejo, dragón, serpiente,
*   caballo, oveja, mono, gallo, perro, cerdo (en este orden).
* - Cada elemento se repite dos años seguidos.
* - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
*
* Información adicional:
* - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
* - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
*
*/

<?php
for($year = 1950; $year < 2050; $year++){
    showElementAndAnimal($year);
}


function showElementAndAnimal($year){
    $initialYear = 1984;
    $arrayElements = ['madera','fuego','tierra','metal','agua'];
    $arrayAnimals = ['rata', 'buey', 'tigre', 'conejo', 'dragón', 'serpiente','caballo', 'oveja', 'mono', 'gallo', 'perro', 'cerdo'];

    $element = getFromArrayNumberPeriods($arrayElements,$year,$initialYear);
    $animal = getFromArrayNumberPeriods($arrayAnimals,$year,$initialYear);

    echo 'Para el año '.$year.' el elemento es '.$element.' y el animal '.$animal.PHP_EOL;
}

function getFromArrayNumberPeriods($array, $year, $initialYear){
    return $array[getPeriods(count($array)*2, $year, $initialYear)];
}

function getPeriods($yearsCicle, $year, $initialYear){
    if($year >= $initialYear) {
        $numberPeriods = floor((($year - $initialYear)%$yearsCicle) / 2);
    }else{
        $numberPeriods = (floor(($yearsCicle-($initialYear - $year)%$yearsCicle) /2))%($yearsCicle/2);
    }
    return $numberPeriods;
}
