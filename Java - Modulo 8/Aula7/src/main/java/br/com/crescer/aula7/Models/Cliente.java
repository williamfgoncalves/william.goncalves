
package br.com.crescer.aula7.Models;

import java.io.Serializable;
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
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
    @SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE", allocationSize=1)
    private Long Id;
   
    @Column(name="NOME", nullable=false) 
    private String Nome;
    
    @Column(name="CPF")
    private String CPF;
    
    @Column(name="RG", nullable = false)
    private String RG;
    
    @Column(name="RUA")
    private String Rua;
   
    @Column(name="BAIRRO")
    private String Bairro;
    
    @Column(name="CIDADE")
    private String Cidade;
    
    @Column(name="NUMERO_CASA")
    private String Numero_Casa;
    
    @Column(name="EMAIL")
    private String Email;
    
    @Column(name="TELEFONE")
    private String Telefone;
    
    @Column(name="CELULAR")
    private String Celular;
    
    @Column(name="NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date Nascimento;

    public Cliente(){
        
    }

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
