using FestasCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FestasCrescer.Infraestrutura.Repositorios
{
    public class ReservaRepositorio
    {
        private Contexto Contexto = new Contexto();

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

        public dynamic ObterReservasPendentes()
        {
            var reservas = Contexto.Reservas.Where(x => x.DataEntregaRealizada == null)
                .Select(x => new
                {
                    x.Cliente,
                    x.Festa,
                    x.Pacote,
                    x.Opcionais,
                    x.DataReserva,
                    x.DataEntregaPrevista,
                    x.DataEntregaRealizada,
                    x.TotalValorEstimado,
                    x.TotalValorPago
                }).ToList();

            return reservas;
        }

        public Reserva ObterPorId(int id)
        {
            return Contexto.Reservas.FirstOrDefault(x => x.IdReserva == id);
        }

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

        public void Criar(Reserva reserva)
        {
            Contexto.Reservas.Add(reserva);
            Contexto.SaveChanges();
        }

        public Reserva Editar(Reserva reserva)
        {
            Contexto.Entry(reserva).State = EntityState.Modified;
            Contexto.SaveChanges();
            return reserva;
        }

        public Reserva Remover(int id)
        {
            var reserva = Contexto.Reservas.FirstOrDefault(x => x.IdReserva == id);
            Contexto.Reservas.Remove(reserva);
            Contexto.SaveChanges();
            return reserva;
        }

        public void Dispose()
        {
            Contexto.Dispose();
        }
    }
}
