using System;
using System.Collections.Generic;

namespace morse
{
    public class Program
    {
        public static List<character> info = new List<character>();

        static void Main(string[] args)
        {
            character.charInfo();
            //string palabramorse = "-- --- ..- .-. .  -.. . ...-";
            string palabramorse = "chavo";

            if (wordAnalyze(palabramorse) == true) process(true, palabramorse.ToLower());
            else process(false, palabramorse);

            Console.ReadKey();
        }

        private static bool wordAnalyze(string data)
        {
            if (data.Contains("-")) return false;
            else return true;
        }

        private static void process(bool process, string data)
        {
            string conversion = "";
            if (process == true)
            {
                for (int i = 0; i < data.Length; i++)
                {
                    if (!data.Substring(i, 1).Equals(" "))
                    {
                        if(data.Substring(i, 1).Equals("c") && data.Substring(i+1, 1).Equals("h"))
                        {
                            conversion += info.Find(X => X.latin == data.Substring(i, 2)).morse.ToString();
                            i++;
                        }
                        else
                        {
                            conversion += info.Find(X => X.latin == data.Substring(i, 1)).morse.ToString();
                        }
                        conversion += " ";
                    }
                    else
                    {
                        conversion += " ";
                    }
                }
            }
            else
            {
                string[] clear = data.Split(" ");
                for (int i = 0; i < clear.Length; i++)
                {
                    if (clear[i].Contains("-") || clear[i].Contains("."))
                    {
                        conversion += info.Find(X => X.morse == clear[i]).latin.ToString();
                    }
                    else
                    {
                        conversion += " ";
                    }
                }
            }
            Console.WriteLine(conversion);
        }
    }

    public class character
    {
        public string latin { get; set; }
        public string morse { get; set; }

        public static void charInfo()
        {
            string abecedario = "a b c ch d e f g h i j k l m n ñ o p q r s t u v w x y z 0 1 2 3 4 5 6 7 8 9 . , ? \" /";
            string abedceMorse = ".- -.. -.-. ---- -.. . ..-. --. .... .. .--- -.- .-.. -- -. --.-- --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. ----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----. .-.-.- --..-- ..--.. .-..-. -..-.";

            string[] normal = abecedario.Split(" ");
            string[] clave = abedceMorse.Split(" ");

            for(int i = 0; i < clave.Length; i++)
            {
                Program.info.Add(new character() { latin = normal[i], morse = clave[i]});
            }
        }
    }

}

