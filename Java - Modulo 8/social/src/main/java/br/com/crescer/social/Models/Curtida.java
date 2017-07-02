/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author William
 */
@Entity
@Table(name = "CURTIDA", catalog = "", schema = "ANDROMEDA2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curtida.findAll", query = "SELECT c FROM Curtida c")
    , @NamedQuery(name = "Curtida.findByIdcurtida", query = "SELECT c FROM Curtida c WHERE c.idcurtida = :idcurtida")})
public class Curtida implements Serializable {

    private static final String SQ_NAME = "SQ_CURTIDA";
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "IDCURTIDA", nullable = false)
    private Long idcurtida;
    
    @JsonIgnore
    @JoinColumn(name = "IDPOSTAGEM", referencedColumnName = "IDPOSTAGEM", nullable = false)
    @ManyToOne(optional = false)
    private Postagem idpostagem;
    
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Curtida() {
    }

    public Curtida(Long idcurtida) {
        this.idcurtida = idcurtida;
    }

    public Long getIdcurtida() {
        return idcurtida;
    }

    public void setIdcurtida(Long idcurtida) {
        this.idcurtida = idcurtida;
    }

    public Postagem getIdpostagem() {
        return idpostagem;
    }

    public void setIdpostagem(Postagem idpostagem) {
        this.idpostagem = idpostagem;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
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
        if (!(object instanceof Curtida)) {
            return false;
        }
        Curtida other = (Curtida) object;
        if ((this.idcurtida == null && other.idcurtida != null) || (this.idcurtida != null && !this.idcurtida.equals(other.idcurtida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.Models.Curtida[ idcurtida=" + idcurtida + " ]";
    }
    
}
