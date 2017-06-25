package br.com.crescer.locadora_jpa;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class Locacao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOCACAO")
    @SequenceGenerator(name = "SEQ_LOCACAO", sequenceName = "SEQ_LOCACAO", allocationSize=1)
    private Long Id;
    
    @Column(name = "VALOR_INICIAL")
    private BigDecimal Valor_Total;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario Funcionario;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_VIDEO")
    private Video Video;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public BigDecimal getValor_Total() {
        return Valor_Total;
    }

    public void setValor_Total(BigDecimal Valor_Total) {
        this.Valor_Total = Valor_Total;
    }

    public Funcionario getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(Funcionario Funcionario) {
        this.Funcionario = Funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video Video) {
        this.Video = Video;
    }
}
