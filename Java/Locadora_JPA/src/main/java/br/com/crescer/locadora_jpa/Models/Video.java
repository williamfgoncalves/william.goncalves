package br.com.crescer.locadora_jpa.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Video implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VIDEO")
    @SequenceGenerator(name = "SEQ_VIDEO", sequenceName = "SEQ_VIDEO", allocationSize=1)
    private Long Id;
    
    @Column(name = "VALOR")
    private BigDecimal Valor;
    
    @Column(name = "DURACAO", length = 50)
    private String Duracao;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_GENERO")
    private Genero Genero;
    
    @Column(name = "NOME")
    private String Nome;
    
    @Column(name = "QUANTIDADE_ESTOQUE")
    private int Quantidade_Estoque;
    
    @Column(name = "DATA_LANCAMENTO")
    private Date Data_Lancamento;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public BigDecimal getValor() {
        return Valor;
    }

    public void setValor(BigDecimal Valor) {
        this.Valor = Valor;
    }

    public String getDuracao() {
        return Duracao;
    }

    public void setDuracao(String Duracao) {
        this.Duracao = Duracao;
    }

    public Genero getGenero() {
        return Genero;
    }

    public void setGenero(Genero Genero) {
        this.Genero = Genero;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getQuantidade_Estoque() {
        return Quantidade_Estoque;
    }

    public void setQuantidade_Estoque(int Quantidade_Estoque) {
        this.Quantidade_Estoque = Quantidade_Estoque;
    }

    public Date getData_Lancamento() {
        return Data_Lancamento;
    }

    public void setData_Lancamento(Date Data_Lancamento) {
        this.Data_Lancamento = Data_Lancamento;
    }
}
