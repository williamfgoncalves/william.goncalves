/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author William
 */
@Entity
@Table(name = "AMIZADES", catalog = "", schema = "ANDROMEDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amizades.findAll", query = "SELECT a FROM Amizades a")
    , @NamedQuery(name = "Amizades.findByIdamizades", query = "SELECT a FROM Amizades a WHERE a.idamizades = :idamizades")})
public class Amizades implements Serializable {

    private static final String SQ_NAME = "SQ_AMIZADES";
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDAMIZADES", nullable = false)
    private Long idamizades;
    
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO", nullable = false)
    @ManyToOne(optional = false)
    private Usuarios idusuario;
    
    @JoinColumn(name = "IDAMIGO", referencedColumnName = "IDUSUARIO", nullable = false)
    @ManyToOne(optional = false)
    private Usuarios idamigo;

    public Amizades() {
    }

    public Amizades(Long idamizades) {
        this.idamizades = idamizades;
    }

    public Long getIdamizades() {
        return idamizades;
    }

    public void setIdamizades(Long idamizades) {
        this.idamizades = idamizades;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }

    public Usuarios getIdamigo() {
        return idamigo;
    }

    public void setIdamigo(Usuarios idamigo) {
        this.idamigo = idamigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idamizades != null ? idamizades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amizades)) {
            return false;
        }
        Amizades other = (Amizades) object;
        if ((this.idamizades == null && other.idamizades != null) || (this.idamizades != null && !this.idamizades.equals(other.idamizades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.aula7.Models.Amizades[ idamizades=" + idamizades + " ]";
    }
    
}
