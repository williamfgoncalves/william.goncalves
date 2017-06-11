using FestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.SqlServer;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Repositorios
{
    public class ReservaRepositorio
    {
        private Contexto Contexto = new Contexto();

        //obter reservas sem distincao
        public dynamic Obter()
        {
            var reservas = Contexto.Reservas
                .Select(x => new
                {
                    NomeCliente = x.Cliente.NomeCliente,
                    NomeFesta = x.Festa.NomeFesta,
                    NomePacote = x.Pacote.NomePacote,
                    DataReserva = x.DataReserva,
                    DataEntregaPrevista = x.DataEntregaPrevista,
                    DataEntregaRealizada = x.DataEntregaRealizada,
                    ValorEstimado = x.TotalValorEstimado,
                    ValorPagar = x.TotalValorPago
                }).ToList();

            return reservas;
        }

        //obtem reservas ultimos trinta dias
        public dynamic obterUltimosDias()
        {
            var reservas = Contexto.Reservas.Where(x => x.DataEntregaRealizada != null &&
                DbFunctions.AddDays(x.DataEntregaRealizada, 30) >= DateTime.Now)
                .Select(x => new
                {
                    NomeCliente = x.Cliente.NomeCliente,
                    NomeFesta = x.Festa.NomeFesta,
                    NomePacote = x.Pacote.NomePacote,
                    DataReserva = x.DataReserva,
                    DataEntregaRealizada = x.DataEntregaRealizada,
                    ValorPagar = x.TotalValorPago
                }).OrderByDescending(x =>  x.DataEntregaRealizada)
                .ToList();
            return reservas;
        }

        public dynamic obterMaisAntigosOrdenado()
        {
            var reservas = Contexto.Reservas.Where(x => x.DataEntregaRealizada == null && x.DataEntregaPrevista < DateTime.Now).OrderByDescending(x => SqlFunctions.DateDiff("dd", x.DataEntregaPrevista, DateTime.Now))
                .Include("Cliente").Include("Festa").Include("Pacote").Include("Opcionais")
                .Select(x => new { NomeFesta = x.Festa.NomeFesta, NomeCliente = x.Cliente.NomeCliente, NomePacote = x.Pacote.NomePacote, NumeroDiasAtrasado = SqlFunctions.DateDiff("dd", x.DataEntregaPrevista, DateTime.Now) }) 
                .ToList();
            return reservas;
        }

        //Obter reservas pendentes
        public dynamic ObterReservasPendentes()
        {
            var reservas = Contexto.Reservas.Where(x => x.DataEntregaRealizada == null)
                .Include("Cliente").Include("Festa").Include("Pacote").Include("Opcionais").ToList();
            return reservas;
        }

        //obter reserva por id
        public Reserva ObterPorId(int id)
        {
            return Contexto.Reservas.Include("Cliente").Include("Festa").Include("Pacote").Include("Opcionais").FirstOrDefault(x => x.IdReserva == id);
        }

        //montar objeto reserva
        public Reserva MontarObjeto(int IdFesta, int IdCliente, int IdPacote, List<int> Opcionais, decimal TotalValorEstimado, DateTime DataReserva, DateTime DataEntregaPrevista)
        {
            var festa = Contexto.Festas.FirstOrDefault(x => x.IdFesta == IdFesta);
            var cliente = Contexto.Clientes.FirstOrDefault(x => x.IdCliente == IdCliente);
            var pacote = Contexto.Pacotes.FirstOrDefault(x => x.IdPacote == IdPacote);
            var opcionais = new List<Opcional>();
            foreach (var item in Opcionais)
            {
                var opcional = Contexto.Opcionais.FirstOrDefault(x => x.IdOpcional == item);
                if(opcionais != null)
                {
                    opcionais.Add(opcional);
                }
            }
            var reserva = new Reserva();
            reserva = new Reserva(festa, cliente, pacote, opcionais, reserva.gerarValorTotal(pacote.ValorDiariaPacote, reserva.gerarValorOpcionais(opcionais), DataReserva, DataEntregaPrevista), DataReserva, DataEntregaPrevista);
            return reserva;
        }

        //criar uma reserva
        public void Criar(Reserva reserva)
        {
            Contexto.Reservas.Add(reserva);
            Contexto.SaveChanges();
        }

        //editar uma reserva
        public Reserva Editar(Reserva reserva)
        {
            Contexto.Entry(reserva).State = EntityState.Modified;
            Contexto.SaveChanges();
            return reserva;
        }

        //remover uma reserva
        public Reserva Remover(int id)
        {
            var reserva = Contexto.Reservas.FirstOrDefault(x => x.IdReserva == id);
            Contexto.Reservas.Remove(reserva);
            Contexto.SaveChanges();
            return reserva;
        }

        //dar dispose
        public void Dispose()
        {
            Contexto.Dispose();
        }
    }
}
