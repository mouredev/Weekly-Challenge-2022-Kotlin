// Kind of Race, Good / Evil / Both, power 
List<Tuple<string, string, int>> races = new List<Tuple<string, string, int>>();
Run();

void Run()
{
    SetRace();
    Fight(ChooseArmy(true), ChooseArmy(false));
}

void SetRace()
{
    races.Add(new Tuple<string, string, int>("Pelosos", "Good", 1));
    races.Add(new Tuple<string, string, int>("Sureños", "Both", 2));
    races.Add(new Tuple<string, string, int>("Enanos", "Good", 3));
    races.Add(new Tuple<string, string, int>("Númenóreanos", "Good", 4));
    races.Add(new Tuple<string, string, int>("Elfos", "Good", 5));
    races.Add(new Tuple<string, string, int>("Orcos", "Evil", 2));
    races.Add(new Tuple<string, string, int>("Goblins", "Evil", 2));
    races.Add(new Tuple<string, string, int>("Huargos", "Evil", 3));
    races.Add(new Tuple<string, string, int>("Trolls", "Evil", 5));
}

int ChooseArmy(bool GoodArmy)
{
    int powerTotal = 0;
    int powerRace = 0;
    string TypeArmy = "";
    if (GoodArmy)
    {
        Console.WriteLine("Add the Good Army");
        TypeArmy = "Good";
    }
    else
    {
        Console.WriteLine("Add the Evil Army");
        TypeArmy = "Evil";
    }

    foreach (Tuple<string, string, int> Tuple in races)
    {
        powerRace = 0;
        if (Tuple.Item2 == TypeArmy || Tuple.Item2 == "Both")
        {
            Console.WriteLine($"Ingrese la cantidad de '{Tuple.Item1}' a luchar:");
            powerRace = Convert.ToInt32(Console.ReadLine()) * Tuple.Item3;
        }
        powerTotal += powerRace;
    }
    Console.Clear();
    return powerTotal;
}

void Fight(int powerGoodArmy, int powerEvilArmy)
{
    Console.WriteLine($"Good army power:{powerGoodArmy} VS Evil army power:{powerEvilArmy}");
    if (powerGoodArmy > powerEvilArmy) Console.WriteLine("Good Army Wins!! Medieval Earth is safe!! 👍");
    else if (powerGoodArmy < powerEvilArmy) Console.WriteLine("Evil Army Wins!! The world is over!! 👎");
    else Console.WriteLine("It's a draw!!! What a Fight!! ⚔️");
    Console.ReadLine();
}
