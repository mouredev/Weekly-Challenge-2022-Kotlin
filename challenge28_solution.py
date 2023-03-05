
#User Twitch: RearlanFDX
#Github: LeonardoReichert
#Lenguaje usado: Python
#
#Reto #28 de MoureDev
#MAQUINA EXPENDEDORA
#
#2022-07-12 02:49:24
#solo necesitamos ejecutarlo para probar el programa



circulating_coins = [5, 10, 50, 100, 200];




class MachineExpender:
    def __init__(self, name):
        self.products = {};
        self.name = name;

        
    def putProduct(self, num, name, price):
        """ set or update products by num """
        self.products[num] = (name, price);
        
        
    def _validateCashCoins(self, coins):
        #los miembros con prefijo _ no aparecen en help(obj)
        """ internal method, validate user cash money """
        return not False in [c in circulating_coins for c in coins];


    def expendProduct(self, num, user_coins):
        """
        return (err: string,
                product name: string,
                cashback: list,
                )

        err: "" == succes
        """

        if not self._validateCashCoins(user_coins):
            return "Invalid coins", "", user_coins;
        
        elif not num in self.products:
            return "Invalid product", "", user_coins;
        
        name, price = self.products[num];

        user_cash = sum(user_coins);

        if price > user_cash:
            return "Enough cash, need more cash", "", user_coins;

        #vuelto, cashback:
        totalback = user_cash - price;

        #las monedas que la maquina puede devolver:
        optionalcoins = circulating_coins.copy();

        coinsback = [];
        while sum(coinsback) < totalback:
            #proxima moneda mas grande:
            coin = max(optionalcoins);

            #se prueba la moneda con la suma actual de monedas
            if sum(coinsback)+coin > totalback:
                #la suma si es mayor la cantidad a devolver
                optionalcoins.remove(coin);
                #se descarta y no se continua con ella
                continue;

            #efectiva, se la anyade a la suma
            coinsback.append(coin);

        #succes, exito
        return "", name, coinsback;

    def __str__(self):
        """ str(MachineExpender) help for humans, show all products """

        show = "Machine: %s\n" % self.name;

        if not self.products:
            return show+" - no have products on this machine.";
        
        show += "Number | Name | Price\n";

        for num in self.products:
            name, price = self.products[num];
            show += " #%05d | \"%s\" | $%d\n" % (num, name, price);
        
        return show;




if __name__ == "__main__":
    from random import choice, randrange;

    print("Welcome to challenge #28 :)");

    #los productos de prueba son:
    #patatas fritas
    #gaseosa - soda
    #cafe
    #chocolate

    products = ["Potato chips",
                "Soda",
                "Coffe",
                "Chocolate",
                ];

    #creamos la maquina:
    machine = MachineExpender("RearlanFDX expender");
    
    #anyadimos productos
    #los precios en la maquina seran random en esta "prueba":

    idNum = 0;
    for name in products:
        idNum += 1;
        
        price = 0;
        for i in range(randrange(1, 3)):
            #una o dos veces
            #elegimos un a moneda random para sumar al precio:
            price += choice(circulating_coins);

        machine.putProduct(idNum, name, price);
        
    #hemos creado la maquina y anyadido los productos
    #ahora vamos a crear menu:
    
    print(machine);
    #<- muestra los productos y precios
    

    state = True;
    while state:
        num = int(input("Enter number of product [1-%d]: " % len(products)));

        print("Ok, now please enter the coins");

        mycoins = [];

        coin = int(input("Enter a first coin on machine as %s: " % str(circulating_coins) ));
        mycoins.append(coin);
        while coin:
            coin = input(" ..more coins? enter or press only [Enter] to finish: ");

            if coin:
                mycoins.append(int(coin));
        
        err, product, mycoins = machine.expendProduct(num, mycoins);

        if not err:
            print("Succes!");
            print("Product:", product);
        else:
            print("Machine error: %s" % err);
            
        print("Your coins:", mycoins);
            
        state = input("continue? enter \"y\": ") == "y";
        
        
    print("Good bye, adios ! ");






