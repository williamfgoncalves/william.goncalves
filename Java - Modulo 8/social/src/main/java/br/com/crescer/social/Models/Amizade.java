/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.Models;

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
@Table(name = "AMIZADE", catalog = "", schema = "ANDROMEDA2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amizade.findAll", query = "SELECT a FROM Amizade a")
    , @NamedQuery(name = "Amizade.findByIdamizade", query = "SELECT a FROM Amizade a WHERE a.idamizade = :idamizade")
    , @NamedQuery(name = "Amizade.findBySituacao", query = "SELECT a FROM Amizade a WHERE a.situacao = :situacao")})
public class Amizade implements Serializable {
    
    private static final String SQ_NAME = "SQ_AMIZADE";
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "IDAMIZADE", nullable = false)
    private Long idamizade;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "SITUACAO", nullable = false)
    private Character situacao;
    
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idusuario;
    
    @JoinColumn(name = "IDAMIGO", referencedColumnName = "IDUSUARIO", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idamigo;

    public Amizade() {
    }

    public Amizade(Long idamizade) {
        this.idamizade = idamizade;
    }

    public Amizade(Long idamizade, Character situacao) {
        this.idamizade = idamizade;
        this.situacao = situacao;
    }

    public Long getIdamizade() {
        return idamizade;
    }

    public void setIdamizade(Long idamizade) {
        this.idamizade = idamizade;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario getIdamigo() {
        return idamigo;
    }

    public void setIdamigo(Usuario idamigo) {
        this.idamigo = idamigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idamizade != null ? idamizade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amizade)) {
            return false;
        }
        Amizade other = (Amizade) object;
        if ((this.idamizade == null && other.idamizade != null) || (this.idamizade != null && !this.idamizade.equals(other.idamizade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.Models.Amizade[ idamizade=" + idamizade + " ]";
    }
    
}
