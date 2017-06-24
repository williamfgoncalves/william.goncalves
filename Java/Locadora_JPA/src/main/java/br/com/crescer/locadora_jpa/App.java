
package br.com.crescer.locadora_jpa;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        FuncionarioDao f = new FuncionarioDao();
        Funcionario func = new Funcionario();
        BigDecimal bd = new BigDecimal(500);
        
        func.setNome("William");
        func.setBairro("São José");
        func.setCidade("Novo Hamburgo");
        func.setNumero_Casa("55");
        func.setRua("Rua do Colono");
        func.setRG("5108924076");
        func.setEmail( "william.fernando92@gmail.com");
        func.setCelular("51994037371");
        func.setSalario(bd);
        func.setFuncao("Estagiario");
        func.setCPF("03566659096");
        
        f.save(func);
    }
}
