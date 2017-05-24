using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demonstracao_1
{
    public class Pessoa
    {
        //USAR O PROP DOIS TABS 
        public string Nome { get; set; }
        public int? id { get; set; }
        public DateTime DataNascimento { get; set; }

        public const double PI = 3.14; // varivel constante;
        public readonly double PIread; // somente leitura;

        // quando constante o compilador, nunca busca o seu valor e pode ser chamado diretamente;
        // quando usamos readonly o compilador busca o valor ese chamarmos ela, nao podemos setar seu valor;
        //quando readonly podemos setar o valor dentro do construtor do classe;
        // mas nunca conseguimos setar o valor do readonly dentro do metodo;
        // atributos private, somente detnro da classe;
        public Pessoa()
        {
            PIread = 3.14;
            // aqui podemos setar o valor do readonly, pois estamos no construtor
        }
        public double dizerPi()
        {
            //PIread = 16.3; nao podemos setar o valor do readonly, pois esse é um metodo classe 
            return 2.12;
        }

    }
}
