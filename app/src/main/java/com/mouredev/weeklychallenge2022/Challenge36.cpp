#include <iostream>
#include <string>
#include <map>

using namespace std;

//Headers
void batalla (map<string, int> &ejercitoBondadoso, map<string, int> &ejercitoMalvado);
int getValorDelEjercito (map<string, int> &ejercito);

map<string, int> valorRazas = {{ "pelosos", 1 },{ "sureniosBuenos", 2 },{ "enanos", 3 },{ "numenoreanos", 4 },{ "elfos", 5 },{ "sureniosMalos", 2 },{ "orcos", 2 },{ "goblins", 2 },{ "huargos", 3 },{ "trolls", 5 }};


//Body
int main (int argc, char const *argv[]) 
{
    map<string, int> demoArmy = {{ "pelosos", 4 },{ "enanos", 9 }};
    map<string, int> demoArmy2 = {{ "sureniosMalos", 4 },{ "orcos", 9 }};

    batalla(demoArmy, demoArmy2);
    return 0;
}


void batalla (map<string, int> &ejercitoBondadoso, map<string, int> &ejercitoMalvado)
{
    if (getValorDelEjercito(ejercitoBondadoso) > getValorDelEjercito(ejercitoMalvado)){
        cout << "El ejercito bondadoso ha ganado." << endl;
    }

    else if (getValorDelEjercito(ejercitoBondadoso) < getValorDelEjercito(ejercitoMalvado)){
        cout << "El ejercito malvado ha ganado." << endl;
    }

    else
        cout << "Los ejercitos han empatado." << endl;
}


int getValorDelEjercito (map<string, int> &ejercitoBondadoso)
{
    int valor = 0;

    for ( const auto &p : ejercitoBondadoso )
    {
        if (!valorRazas.count( p.first ))
            continue;

        valor += p.second * valorRazas.at(p.first);
    }
    return valor;
}
