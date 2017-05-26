using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LerFrases
{
    class Program
    {
        static void Main(string[] args)
        {
            String path = @"C:\Users\william.goncalves\Desktop\Frases.txt";
            Console.WriteLine("Digite a sua frase: ");
            var frase = Console.ReadLine();
            Console.WriteLine("Digite a seu autor: ");
            var autor = Console.ReadLine();

            List<String> frases = File.ReadAllLines(path).ToList();
            frases.Add($"{frase}({autor});");

            for (int i = 0; i < frases.Count; i++)
            {
                Console.WriteLine(frases[i]);
            }


            Console.WriteLine("Digite a sua palavra: ");
            var palavra = Console.ReadLine();

            foreach (string texto in frases)
            {
                if (texto.Contains(palavra))
                {
                    Console.WriteLine(palavra);
                }
            }

            Console.ReadKey();
        }   
    }
}
