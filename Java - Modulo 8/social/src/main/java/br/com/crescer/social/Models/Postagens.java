/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "POSTAGENS", catalog = "", schema = "ANDROMEDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postagens.findAll", query = "SELECT p FROM Postagens p")
    , @NamedQuery(name = "Postagens.findByIdpostagem", query = "SELECT p FROM Postagens p WHERE p.idpostagem = :idpostagem")
    , @NamedQuery(name = "Postagens.findByDatapostagem", query = "SELECT p FROM Postagens p WHERE p.datapostagem = :datapostagem")
    , @NamedQuery(name = "Postagens.findByTexto", query = "SELECT p FROM Postagens p WHERE p.texto = :texto")
    , @NamedQuery(name = "Postagens.findByUrlimagem", query = "SELECT p FROM Postagens p WHERE p.urlimagem = :urlimagem")})
public class Postagens implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPOSTAGEM", nullable = false, precision = 19, scale = 0)
    private BigDecimal idpostagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATAPOSTAGEM", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datapostagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "TEXTO", nullable = false, length = 500)
    private String texto;
    @Size(max = 300)
    @Column(name = "URLIMAGEM", length = 300)
    private String urlimagem;
    @JoinColumn(name = "IDCURTIDA", referencedColumnName = "IDCURTIDA")
    @ManyToOne
    private Curtidas idcurtida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpostagem")
    private List<Curtidas> curtidasList;

    public Postagens() {
    }

    public Postagens(BigDecimal idpostagem) {
        this.idpostagem = idpostagem;
    }

    public Postagens(BigDecimal idpostagem, Date datapostagem, String texto) {
        this.idpostagem = idpostagem;
        this.datapostagem = datapostagem;
        this.texto = texto;
    }

    public BigDecimal getIdpostagem() {
        return idpostagem;
    }

    public void setIdpostagem(BigDecimal idpostagem) {
        this.idpostagem = idpostagem;
    }

    public Date getDatapostagem() {
        return datapostagem;
    }

    public void setDatapostagem(Date datapostagem) {
        this.datapostagem = datapostagem;
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

    public Curtidas getIdcurtida() {
        return idcurtida;
    }

    public void setIdcurtida(Curtidas idcurtida) {
        this.idcurtida = idcurtida;
    }

    @XmlTransient
    public List<Curtidas> getCurtidasList() {
        return curtidasList;
    }

    public void setCurtidasList(List<Curtidas> curtidasList) {
        this.curtidasList = curtidasList;
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
        if (!(object instanceof Postagens)) {
            return false;
        }
        Postagens other = (Postagens) object;
        if ((this.idpostagem == null && other.idpostagem != null) || (this.idpostagem != null && !this.idpostagem.equals(other.idpostagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.Models.Postagens[ idpostagem=" + idpostagem + " ]";
    }
    
}
