/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author William
 */
@Entity
@Table(name = "CURTIDAS", catalog = "", schema = "ANDROMEDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curtidas.findAll", query = "SELECT c FROM Curtidas c")
    , @NamedQuery(name = "Curtidas.findByIdcurtida", query = "SELECT c FROM Curtidas c WHERE c.idcurtida = :idcurtida")})
public class Curtidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCURTIDA", nullable = false)
    private Long idcurtida;
    @OneToMany(mappedBy = "idcurtida")
    private List<Postagens> postagensList;
    @JoinColumn(name = "IDPOSTAGEM", referencedColumnName = "IDPOSTAGEM", nullable = false)
    @ManyToOne(optional = false)
    private Postagens idpostagem;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO", nullable = false)
    @ManyToOne(optional = false)
    private Usuarios idusuario;

    public Curtidas() {
    }

    public Curtidas(Long idcurtida) {
        this.idcurtida = idcurtida;
    }

    public Long getIdcurtida() {
        return idcurtida;
    }

    public void setIdcurtida(Long idcurtida) {
        this.idcurtida = idcurtida;
    }

    @XmlTransient
    public List<Postagens> getPostagensList() {
        return postagensList;
    }

    public void setPostagensList(List<Postagens> postagensList) {
        this.postagensList = postagensList;
    }

    public Postagens getIdpostagem() {
        return idpostagem;
    }

    public void setIdpostagem(Postagens idpostagem) {
        this.idpostagem = idpostagem;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcurtida != null ? idcurtida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curtidas)) {
            return false;
        }
        Curtidas other = (Curtidas) object;
        if ((this.idcurtida == null && other.idcurtida != null) || (this.idcurtida != null && !this.idcurtida.equals(other.idcurtida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.aula7.Models.Curtidas[ idcurtida=" + idcurtida + " ]";
    }
    
}
