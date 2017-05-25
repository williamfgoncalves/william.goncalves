using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demonstracao_1
{
    class Program
    {
        static void Main(string[] args)
        {
            /*
            Pessoa pessoa = new Pessoa(); //maneira roots para instanciar
            var pessoa2 = new Pessoa(); // boa maneira de instanciar uma variavel pessoa

            pessoa.id = 1;
            pessoa.Nome = $"William {pessoa.id}"; // concatenar com interpolate
            pessoa.DataNascimento = new DateTime(1996, 04, 06); // data de nascimento

            Console.WriteLine("Nome:" + pessoa.Nome); // imprimir o nome
            Console.ReadKey(); // para o console até apertar alguma tecla

            if (pessoa.Nome == null)
            {
                Console.WriteLine("Valor Nulo");
            }
            else
            {
                Console.WriteLine("Nao é nulo");
            }
            // usar ? em alguma propriedade, ela pode aceitar nulo;
            // int id? {get, set} agora, id pode receber  null
            //ctrl + k + d

            Console.WriteLine("Informe seu peso: ");
            var peso = Console.ReadLine(); // read line le o dado e converte em string
            Console.WriteLine("Informe sua altura: ");
            var altura = Console.ReadLine();// read line le o dado e converte em string
                                            // precisamos converter para poder usar dentro da funcao que recebe double
            var pesoEntrada = 0D;
            if (!double.TryParse(peso, out pesoEntrada))
                Console.WriteLine("Peso INVALIDO!!");

            var alturaEntrada = double.Parse(altura);
            var calculo = new CalculoImc(pesoEntrada, alturaEntrada);
            var imc = calculo.calcularSeuIMC();
            Console.WriteLine("Seu IMC é de: " + imc);
            Console.ReadKey();
            */
            // existe o try parse que faz com que ele tente converter algo e retorna um true ou false
            // se der false, voce pode exibir uma mensagem;
            // DIGITE: FOR - cria um for automatico
            //DIGITE: PROPG - cria um atributo com get publico e set privado;
            //DIGITE: SWITCH - Cria um switch automatico;
            // 

    var entradas = new int[] { }; // criacao de um array;
    while(true){
        var linhaLida = Console.ReadLine();
        if(linhaLida == "exit")
        {
            break;    
        }

        var nrEntradas = entradas.Length;
        var entradasAux = new int[nrEntradas + 1];
        for (int i = 0; i<nrEntradas; i++)
        {
            entradasAux[i] = entradas[i];
        }
        entradasAux[nrEntradas] = int.Parse(linhaLida);
        entradas = entradasAux;
    }          

    foreach (var entrada in entradas)
    {
        Console.WriteLine(entrada);
    }

//======================================================================

// no C# existe o list
// para adicionar use  um add;
// Exemplo com listas ========>
List<int> entradasList = new List<int>();

while (true)
{
    Console.WriteLine("Digite um numero: ");
    var num = Console.ReadLine();
    if (num == "exit")
    {
        break;
    }
    var numero = int.Parse(num);
    entradasList.Add(numero);
}

foreach (int i in entradasList)
{
    Console.WriteLine("Numero: " + i);
}
Console.ReadKey();
}
}
}
