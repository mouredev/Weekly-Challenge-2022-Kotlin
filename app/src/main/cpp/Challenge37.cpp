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
#include <map>
#include <ctime>
#include <string>
using namespace std;

map<string, string> zeldaGames;

void initZeldaGames()
{
    zeldaGames["01. The Legend of Zelda"] = "21/02/1986";
    zeldaGames["02. Zelda II: The Adventure of Link"] = "14/01/1987";
    zeldaGames["03. The Legend of Zelda: A Link to the Past"] = "21/11/1991";
    zeldaGames["04. The Legend of Zelda: Link's Awakening"] = "06/06/1993";
    zeldaGames["05. The Legend of Zelda: Ocarina of Time"] = "21/11/1998";
    zeldaGames["06. The Legend of Zelda: Majora's Mask"] = "27/04/2000";
    zeldaGames["07. The Legend of Zelda: Oracle of Seasons"] = "27/01/2001";
    zeldaGames["08. The Legend of Zelda: Oracle of Ages"] = "27/02/2001";
    zeldaGames["09. The Legend of Zelda: A Link to the Past & Four Swords"] = "14/02/2002";
    zeldaGames["10. The Legend of Zelda: The Wind Waker"] = "13/12/2002";
    zeldaGames["11. The Legend of Zelda: Four Swords Adventures"] = "18/03/2004";
    zeldaGames["12. The Legend of Zelda: The Minish Cap"] = "04/11/2004";
    zeldaGames["13. The Legend of Zelda: Twilight Princess"] = "02/12/2006";
    zeldaGames["14. The Legend of Zelda: Phantom Hourglass"] = "23/06/2007";
    zeldaGames["15. The Legend of Zelda: Spirit Tracks"] = "23/12/2009";
    zeldaGames["16. The Legend of Zelda: Skyward Sword"] = "23/11/2011";
    zeldaGames["17. The Legend of Zelda: A Link Between Worlds"] = "26/12/2013";
    zeldaGames["18. The Legend of Zelda: Tri Force Heroes"] = "22/10/2015";
    zeldaGames["19. The Legend of Zelda: Breath of the Wild"] = "03/03/2017";
    zeldaGames["20. The Legend of Zelda: Tears of the Kingdom"] = "12/05/2023";
}

int printZeldaGames()
{
    string key;
    string val;
    int howMany = 0;
    for (auto const &[key, val] : zeldaGames)
    {
        howMany++;
        cout << key
             << " "
             << '|'
             << " "
             << val
             << std::endl;
    }

    return howMany;
}

string selectKeyOrValue(int index, bool selKey)
{
    int i = 0;
    for (auto const &[key, val] : zeldaGames)
    {
        i++;
        if (index == i)
        {
            if (selKey)
            {
                return key;
            }
            else
            {
                return val;
            }
        }
    }
}

string selectValue(int index)
{
    int i = 0;
    for (auto const &[key, val] : zeldaGames)
    {
        i++;
        if (index == i)
        {
            return key;
        }
    }
}

string dateSubtract(string dateMore, string dateLess){

    int day = stoi(dateMore.substr(0,2));
    int month = stoi(dateMore.substr(3,2));
    int year = stoi(dateMore.substr(6,4));
    struct tm b = {0,0,0,day,month,year - 1900};

    day = stoi(dateLess.substr(0,2));
    month = stoi(dateLess.substr(3,2));
    year = stoi(dateLess.substr(6,4));
    struct tm a = {0,0,0,day,month,year - 1900};

    time_t x = mktime(&a);
    time_t y = mktime(&b);
    if ( x != (time_t)(-1) && y != (time_t)(-1) )
    {
        int difference = difftime(y, x) / (60 * 60 * 24);
        int initDiff = difference;
        int years = difference / 365;
        difference = difference - years * 365;
        int months = difference / 30;
        difference = difference - months * 30;
        int days = difference;
        string prettyDiff = "La diferencia entre los dos juegos es de: " + to_string(years) + " año/s, " + to_string(months) + " mes/es, " + to_string(days) + " día/s | Total de: " + to_string(initDiff) + " día/s.";
        return prettyDiff;
    }

}

int main(int argc, char const *argv[])
{
    initZeldaGames();

    int select1 = 0;
    int select2 = 0;

    cout << "Calculadora de años, meses y días entre el lanzamiento de un Zelda y otro. Las fechas serán segun su lanzamiento en Japón." << endl;
    cout << "--------------------------------------------------------------------------------------------------------------------------" << endl;
    cout << endl;

    int howMany = printZeldaGames();
    cout << endl;
    cout << "Selecciona el primer juego (1-" << howMany << "): ";
    cin >> select1;

    string gameName1 = selectKeyOrValue(select1, true);
    string gameRelease1 = selectKeyOrValue(select1, false);

    cout << string(100, '\n');

    cout << "Primera selección: " << gameName1 << " | " << gameRelease1 << endl;
    cout << endl;
    howMany = printZeldaGames();
    cout << endl;
    cout << "Selecciona el segundo juego (1-" << howMany << "): ";
    cin >> select2;

    string gameName2 = selectKeyOrValue(select2, true);
    string gameRelease2 = selectKeyOrValue(select2, false);

    if (select1 == select2)
    {
        cout << "Has seleccionado el mismo juego dos veces. Revisa el ejercicio y pasa los argumentos correctamente." << endl;
    }
    else
    {
        string dateSubtractStr = "";

        if (select1 > select2)
        {
            dateSubtractStr = dateSubtract(gameRelease1, gameRelease2);
        }
        else
        {
            dateSubtractStr = dateSubtract(gameRelease2, gameRelease1);
        }

        cout << "Primera selección: " << gameName1 << " | " << gameRelease1 << endl;
        cout << "Segunda selección: " << gameName2 << " | " << gameRelease2 << endl;
        cout << endl;

        cout << dateSubtractStr << endl;
    }

    return 0;
}
