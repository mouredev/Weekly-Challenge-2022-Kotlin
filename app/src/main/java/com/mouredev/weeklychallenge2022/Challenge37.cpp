/*
 * Reto #37
 * LOS LANZAMIENTOS DE "THE LEGEND OF ZELDA"
 * Fecha publicación enunciado: 14/09/22
 * Fecha publicación resolución: 19/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¡Han anunciado un nuevo "The Legend of Zelda"! Se llamará "Tears of the Kingdom"
 * y se lanzará el 12 de mayo de 2023.
 * Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos "The Legend of Zelda" de la historia?
 * Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda que tú selecciones.
 * - Debes buscar cada uno de los títulos y su día de lanzamiento (si no encuentras el día exacto
 *   puedes usar el mes, o incluso inventártelo)
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

#include <iostream>
#include <string>

using namespace std;

struct date{
    int day;
    int month;
    int year;
};


date subtractTwoDates(date &firstDate, date &secondDate)
{
    date subtractedDate;

    //calc
    subtractedDate.year = secondDate.year - firstDate.year;
    subtractedDate.month = secondDate.month - firstDate.month;
    subtractedDate.day = secondDate.day - firstDate.day;

    //case if dd is negative i.e. current dd is less than birth date
    if(subtractedDate.day<0)
    {
       subtractedDate.month--;
       subtractedDate.day+=30;
    }

    //case if mm is negative i.e. current mm is less than birth  date
    if (subtractedDate.month<0)
    {
        subtractedDate.year--;
        subtractedDate.month+=12;
    }

    return subtractedDate;
}


class ZeldaGame
{
    public:
    date releaseDate;
    string title;

    ZeldaGame(date releaseDate, string title)
    {
        this->releaseDate = releaseDate;
        this->title = title;
    }
};


int main(int argc, char *argv[])
{
    date minishCapReleaseDate;
    minishCapReleaseDate.day = 12; minishCapReleaseDate.month = 3; minishCapReleaseDate.year = 2003;
    ZeldaGame minishCap(minishCapReleaseDate, "minishCap");

    date ocarinaReleaseDate;
    ocarinaReleaseDate.day = 9; ocarinaReleaseDate.month = 7; ocarinaReleaseDate.year = 1998;
    ZeldaGame ocarina(ocarinaReleaseDate, "minishCap");

    date result = subtractTwoDates(ocarina.releaseDate, minishCap.releaseDate);

    return 0;
}