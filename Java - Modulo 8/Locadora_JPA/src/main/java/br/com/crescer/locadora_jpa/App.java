package br.com.crescer.locadora_jpa;

import br.com.crescer.locadora_jpa.DAO.ClienteDao;
import br.com.crescer.locadora_jpa.Models.Funcionario;
import br.com.crescer.locadora_jpa.DAO.FuncionarioDao;
import br.com.crescer.locadora_jpa.DAO.GeneroDao;
import br.com.crescer.locadora_jpa.DAO.LocacaoDao;
import br.com.crescer.locadora_jpa.DAO.VideoDao;
import br.com.crescer.locadora_jpa.Models.Cliente;
import br.com.crescer.locadora_jpa.Models.Genero;
import br.com.crescer.locadora_jpa.Models.Locacao;
import br.com.crescer.locadora_jpa.Models.Video;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args) throws ParseException {
//        FuncionarioDao f = new FuncionarioDao();
//        List<Funcionario> fl = new ArrayList<>();
//        
//        Funcionario func = new Funcionario();
//        BigDecimal bd = new BigDecimal(500);
//       
//        func.setNome("William");
//        func.setBairro("São José");
//        func.setCidade("Novo Hamburgo");
//        func.setNumero_Casa("55");
//        func.setRua("Rua do Colono");
//        func.setRG("5108924076");
//        func.setEmail( "william.fernando92@gmail.com");
//        func.setCelular("51994037371");
//        func.setSalario(bd);
//        func.setFuncao("Estagiario");
//        func.setCPF("03566659096");
//        f.save(func);

//      fl = f.findAll();
//        
//      for(Funcionario fco : fl){
//          f.remove(fco);
//      }
//        func = f.loadById(new Long(14));
//        System.out.println(func.getNome());
//        
//        f.closeConnection();
//        GeneroDao g = new GeneroDao();
//        Genero gen = new Genero();
//        gen.setDescricao("Terror");
//        g.save(gen);
//        g.closeConnection();
//        String data = "06/04/1996";
//        SimpleDateFormat simpleDataFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = simpleDataFormat.parse(data);
//        
//        GeneroDao g = new GeneroDao();
//        VideoDao v = new VideoDao();
//        Video vdo = new Video();
//        vdo.setNome("Sexta Feira 13");
//        vdo.setValor(new BigDecimal(12));
//        vdo.setDuracao("120 min");
//        vdo.setGenero(g.loadById(1L));
//        vdo.setQuantidade_Estoque(2);
//        vdo.setData_Lancamento(date);
//        v.save(vdo);
//        g.closeConnection();
//        v.closeConnection();
//        String data = "06/04/1996";
//        SimpleDateFormat simpleDataFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = simpleDataFormat.parse(data);
//
//        ClienteDao c = new ClienteDao();
//        Cliente cli = new Cliente();
//        cli.setNome("William");
//        cli.setBairro("São Jorge");
//        cli.setCPF("03566659096");
//        cli.setCidade("Novo Hamburgo");
//        cli.setEmail("william.fernando92@gmail.com");
//        cli.setCelular("994037371");
//        cli.setNumero_Casa("55");
//        cli.setRG("5108924076");
//        cli.setRua("Rua do colono");
//        cli.setTelefone("35907700");
//        cli.setNascimento(date);
//        c.save(cli);
//        c.closeConnection();

        String data = "27/06/2017";
        SimpleDateFormat simpleDataFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDataFormat.parse(data);
        
        VideoDao v = new VideoDao();
        ClienteDao c = new ClienteDao();
        FuncionarioDao f = new FuncionarioDao();
        LocacaoDao l = new LocacaoDao();
        
        Locacao loc = new Locacao();
        
        loc.setValor_Total(new BigDecimal(35));
        loc.setFuncionario(f.loadById(14L));
        loc.setCliente(c.loadById(1L));
        loc.setVideo(v.loadById(1L));
        loc.setData_Devolucao(date);
        l.save(loc);
        
        l.closeConnection();
        c.closeConnection();
        f.closeConnection();
        v.closeConnection();
    }
}
