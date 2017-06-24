
package br.com.crescer.locadora_jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Funcionario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="geradorId")
    @SequenceGenerator(name="geradorId", sequenceName="SEQ_FUNCIONARIO", allocationSize = 1)
    private Long Id;
   
    @Column(nullable=false, length=60) 
    private String Nome;
    
    @Column(length=60)
    private String Bairro;
    
    @Column(length=60)
    private String Cidade;
    
    @Column(length=10)
    private String Numero_Casa;
    
    @Column(length=80)
    private String Rua;
    
    @Column(nullable = false, length=15)
    private String RG;
    
    @Column(length=100)
    private String Email;
    
    @Column(length=50)
    private String Telefone;
    
    @Column(length=50)
    private String Celular;
    
    private BigDecimal Salario;
    
    @Column(length=50)
    private String Funcao;
    
    @Column(length=11)
    private String CPF;
    
    @Temporal(TemporalType.DATE)
    private Date Nascimento;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getNumero_Casa() {
        return Numero_Casa;
    }

    public void setNumero_Casa(String Numero_Casa) {
        this.Numero_Casa = Numero_Casa;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public BigDecimal getSalario() {
        return Salario;
    }

    public void setSalario(BigDecimal Salario) {
        this.Salario = Salario;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getNascimento() {
        return Nascimento;
    }

    public void setNascimento(Date Nascimento) {
        this.Nascimento = Nascimento;
    }
}
