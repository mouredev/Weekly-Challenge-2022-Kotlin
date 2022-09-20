
convertBinaryToDecimal("1011001");//89
convertBinaryToDecimal("101101");//45
convertBinaryToDecimal("1101");//13
convertBinaryToDecimal("100000000");//256

static void convertBinaryToDecimal(string binary)
{
    if (binary.Length < 1)
    {
        Console.WriteLine("You need to provide a binary number");
        return;
    }

    double total = 0;
    int powCount = binary.Length - 1;

    for (int i = 0; i < binary.Length; i++)
    {
        /*
         * d = (b x 2 ^ pow(n)) + (b x 2 ^ pow(n - 1)) ...
         * d = decimal
         * b = binary element or number
         * n = pow using total number of binary number - 1, so you reach 0 at the end 
         */
        total += (Convert.ToInt32(binary[i].ToString()) * getPow(powCount));
        powCount -= 1;
    }

    Console.WriteLine($"Binary number '{binary}' to decimal is: '{total}'");
    Console.ReadKey();
}

static double getPow(int powCount)
{
    double pow = 2;// Default value
    double result = pow;

    if (powCount > 0)
    {
        for (int i = 1; i < powCount; i++)
            result *= pow;
    }
    else result = 1;

    return result;
}
