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
@Table(name = "SOLICITACAO", catalog = "", schema = "ANDROMEDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitacao.findAll", query = "SELECT s FROM Solicitacao s")
    , @NamedQuery(name = "Solicitacao.findByIdsolicitacao", query = "SELECT s FROM Solicitacao s WHERE s.idsolicitacao = :idsolicitacao")
    , @NamedQuery(name = "Solicitacao.findBySituacao", query = "SELECT s FROM Solicitacao s WHERE s.situacao = :situacao")})
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSOLICITACAO", nullable = false)
    private Long idsolicitacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SITUACAO", nullable = false)
    private Character situacao;
    @JoinColumn(name = "IDSOLICITANTE", referencedColumnName = "IDUSUARIO", nullable = false)
    @ManyToOne(optional = false)
    private Usuarios idsolicitante;
    @JoinColumn(name = "IDSOLICITADO", referencedColumnName = "IDUSUARIO", nullable = false)
    @ManyToOne(optional = false)
    private Usuarios idsolicitado;

    public Solicitacao() {
    }

    public Solicitacao(Long idsolicitacao) {
        this.idsolicitacao = idsolicitacao;
    }

    public Solicitacao(Long idsolicitacao, Character situacao) {
        this.idsolicitacao = idsolicitacao;
        this.situacao = situacao;
    }

    public Long getIdsolicitacao() {
        return idsolicitacao;
    }

    public void setIdsolicitacao(Long idsolicitacao) {
        this.idsolicitacao = idsolicitacao;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Usuarios getIdsolicitante() {
        return idsolicitante;
    }

    public void setIdsolicitante(Usuarios idsolicitante) {
        this.idsolicitante = idsolicitante;
    }

    public Usuarios getIdsolicitado() {
        return idsolicitado;
    }

    public void setIdsolicitado(Usuarios idsolicitado) {
        this.idsolicitado = idsolicitado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsolicitacao != null ? idsolicitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.idsolicitacao == null && other.idsolicitacao != null) || (this.idsolicitacao != null && !this.idsolicitacao.equals(other.idsolicitacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.aula7.Models.Solicitacao[ idsolicitacao=" + idsolicitacao + " ]";
    }
    
}
