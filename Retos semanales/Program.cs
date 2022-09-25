using System;

namespace BinarioADecimal
{
    public class Program
    {
        public static void Main(string[] args)
        {
            string[] numsBinarios = new string[] { "0", "1", "10", "101", "10011", "10101011" };

            foreach (string numBinario in numsBinarios) 
            {
                Console.Write("Número binario: "+ numBinario+" ");
                try
                {
                    int resultado = convertirBinarioADecimal(numBinario);
                    Console.WriteLine("Número decimal: " + resultado);
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                }
            }
            
        }


        public static int convertirBinarioADecimal(string numeroBinario)
        {
            int res = 0;
            int bas2 = 1;
            char c = numeroBinario[numeroBinario.Length - 1];

            if (c != '0' && c != '1')
                throw new Exception("No es un número binario");

            if (c == '1')
            {
                res = 1;
            }

            for (int i = numeroBinario.Length - 2; 0 <= i; i--)
            {
                bas2 *= 2;
                c = numeroBinario[i];

                if (c != '0' && c != '1')
                    throw new Exception("No es un número binario");

                if (c == '1')
                {
                    res += bas2;
                }
            }

            return res;
        }
    }
}
