// See https://aka.ms/new-console-template for more information

List<Tuple<string, string, double>> efectividades = new List<Tuple<string, string, double>>();
Pokemon pokemonAtacante = new Pokemon() { atacante = true };
Pokemon pokemonDefensor = new Pokemon() { atacante = false };

main();

#region Metodos

void main()
{
    Console.Clear();
    Console.WriteLine("¡Calcula el daño de tu ataque pokémon!");

    setEfectividad();

    escogerAtacanteDefensor(true, ref pokemonAtacante);
    escogerAtacanteDefensor(false, ref pokemonDefensor);

    calcularDamage();
}

void escogerAtacanteDefensor(bool esAtacante, ref Pokemon pokemon)
{
    if (esAtacante) Console.WriteLine("Escoge el tipo de pokémon atacante");
    else Console.WriteLine("Escoge el tipo de pokémon defensor");

    setTipoPokemon(ref pokemon);
    Console.Clear();
}

void setTipoPokemon(ref Pokemon pokemon)
{
    Console.WriteLine("1) Agua");
    Console.WriteLine("2) Fuego");
    Console.WriteLine("3) Planta");
    Console.WriteLine("4) Eléctrico");

    int seleccion;
    if (int.TryParse(Console.ReadLine(), out seleccion))
    {
        if (seleccion > 0 && seleccion < 5)
        {
            if (seleccion == 1) pokemon.tipo = "agua";
            else if (seleccion == 2) pokemon.tipo = "fuego";
            else if (seleccion == 3) pokemon.tipo = "planta";
            else if (seleccion == 4) pokemon.tipo = "electrico";
        }
        else
        {
            Console.WriteLine("Digite un número de la selección para continuar");
            setTipoPokemon(ref pokemon);
        }
    }
    else
    {
        Console.WriteLine("Necesita digitar un número para continuar");
        setTipoPokemon(ref pokemon);
    }
}

void setEfectividad()
{
    efectividades.Add(new Tuple<string, string, double>("agua", "agua", .5));
    efectividades.Add(new Tuple<string, string, double>("agua", "fuego", 2));
    efectividades.Add(new Tuple<string, string, double>("agua", "planta", .5));
    efectividades.Add(new Tuple<string, string, double>("agua", "electrico", 1));
    efectividades.Add(new Tuple<string, string, double>("fuego", "agua", .5));
    efectividades.Add(new Tuple<string, string, double>("fuego", "fuego", .5));
    efectividades.Add(new Tuple<string, string, double>("fuego", "planta", 2));
    efectividades.Add(new Tuple<string, string, double>("fuego", "electrico", 1));
    efectividades.Add(new Tuple<string, string, double>("planta", "agua", 2));
    efectividades.Add(new Tuple<string, string, double>("planta", "fuego", .5));
    efectividades.Add(new Tuple<string, string, double>("planta", "planta", .5));
    efectividades.Add(new Tuple<string, string, double>("planta", "electrico", 1));
    efectividades.Add(new Tuple<string, string, double>("electrico", "agua", 2));
    efectividades.Add(new Tuple<string, string, double>("electrico", "fuego", 1));
    efectividades.Add(new Tuple<string, string, double>("electrico", "planta", .5));
    efectividades.Add(new Tuple<string, string, double>("electrico", "electrico", .5));
}

void calcularDamage()
{
    Console.WriteLine("Atacando...");
    Console.WriteLine("Digite el poder del ataque (1-100):");

    double ataque = getAtaqueDefensa();
    Console.WriteLine("Digite el poder de la defensa (1-100):");
    double defensa = getAtaqueDefensa();
    double damage = 50 * (ataque / defensa) * getEfectividad(pokemonAtacante, pokemonDefensor);

    Console.WriteLine("***************************");
    Console.WriteLine($"Daño efectuado:{damage}");
    if (damage >= 100) Console.WriteLine("Has puesto a dormir a tu oponente");

    Console.WriteLine("***************************");
    Console.WriteLine("1) Ejecutar de nuevo");
    Console.WriteLine("Otro tecla) Salir");
    Console.WriteLine("--------------------------");
    if (Console.ReadLine() == "1") main();
}

double getEfectividad(Pokemon atacante, Pokemon defensor)
{
    return (efectividades.Find(e => e.Item1.ToUpper() == atacante.tipo.ToUpper() && e.Item2.ToUpper() == defensor.tipo.ToUpper())) != null ?
        efectividades.Find(e => e.Item1.ToUpper() == atacante.tipo.ToUpper() && e.Item2.ToUpper() == defensor.tipo.ToUpper()).Item3 : 0;
}

double getAtaqueDefensa()
{
    double valor = 0;

    if (double.TryParse(Console.ReadLine(), out valor))
    {
        if (valor < 1 || valor > 100)
        {
            Console.WriteLine("El rango debe estar entre 1 y 100");
            getAtaqueDefensa();
        }
    }
    else
    {
        Console.WriteLine("Necesita digitar un número para continuar");
        getAtaqueDefensa();
    }

    return valor;
}

#endregion

class Pokemon
{
    public string tipo { set; get; }
    // 1) Agua
    // 2) Fuego
    // 3) Planta
    // 4) Eléctrico

    public int vida = 100;
    public bool atacante { set; get; }
}