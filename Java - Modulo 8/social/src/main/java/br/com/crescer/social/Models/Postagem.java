/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author William
 */
@Entity
@Table(name = "POSTAGEM", catalog = "", schema = "ANDROMEDA2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postagem.findAll", query = "SELECT p FROM Postagem p")
    , @NamedQuery(name = "Postagem.findByIdpostagem", query = "SELECT p FROM Postagem p WHERE p.idpostagem = :idpostagem")
    , @NamedQuery(name = "Postagem.findByTexto", query = "SELECT p FROM Postagem p WHERE p.texto = :texto")
    , @NamedQuery(name = "Postagem.findByUrlimagem", query = "SELECT p FROM Postagem p WHERE p.urlimagem = :urlimagem")
    , @NamedQuery(name = "Postagem.findByDatapostagem", query = "SELECT p FROM Postagem p WHERE p.datapostagem = :datapostagem")})
public class Postagem implements Serializable {

    private static final String SQ_NAME = "SQ_POSTAGEM";
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "IDPOSTAGEM", nullable = false)
    private Long idpostagem;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "TEXTO", nullable = false, length = 500)
    private String texto;
    
    @Size(max = 300)
    @Column(name = "URLIMAGEM", length = 300)
    private String urlimagem;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATAPOSTAGEM", nullable = false)
    @JsonFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datapostagem;
    
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpostagem")
    private List<Curtida> curtidaList;

    public Postagem() {
    }

    public Postagem(Long idpostagem) {
        this.idpostagem = idpostagem;
    }

    public Postagem(Long idpostagem, String texto, Date datapostagem) {
        this.idpostagem = idpostagem;
        this.texto = texto;
        this.datapostagem = datapostagem;
    }

    public Long getIdpostagem() {
        return idpostagem;
    }

    public void setIdpostagem(Long idpostagem) {
        this.idpostagem = idpostagem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUrlimagem() {
        return urlimagem;
    }

    public void setUrlimagem(String urlimagem) {
        this.urlimagem = urlimagem;
    }

    public Date getDatapostagem() {
        return datapostagem;
    }

    public void setDatapostagem(Date datapostagem) {
        this.datapostagem = datapostagem;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public List<Curtida> getCurtidaList() {
        return curtidaList;
    }

    public void setCurtidaList(List<Curtida> curtidaList) {
        this.curtidaList = curtidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpostagem != null ? idpostagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postagem)) {
            return false;
        }
        Postagem other = (Postagem) object;
        if ((this.idpostagem == null && other.idpostagem != null) || (this.idpostagem != null && !this.idpostagem.equals(other.idpostagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.Models.Postagem[ idpostagem=" + idpostagem + " ]";
    }
    
}
