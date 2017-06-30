/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.Models;

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
@Table(name = "USUARIOS", catalog = "", schema = "ANDROMEDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdusuario", query = "SELECT u FROM Usuarios u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email")
    , @NamedQuery(name = "Usuarios.findBySenha", query = "SELECT u FROM Usuarios u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuarios.findByNome", query = "SELECT u FROM Usuarios u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuarios.findByDatanascimento", query = "SELECT u FROM Usuarios u WHERE u.datanascimento = :datanascimento")
    , @NamedQuery(name = "Usuarios.findBySexo", query = "SELECT u FROM Usuarios u WHERE u.sexo = :sexo")})
public class Usuarios implements Serializable {
    
    private static final String SQ_NAME = "SQ_USUARIO";
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "IDUSUARIO")
    private Long idusuario;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SENHA", nullable = false, length = 100)
    private String senha;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATANASCIMENTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanascimento;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXO", nullable = false)
    private Character sexo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsolicitante")
    private List<Solicitacao> solicitacaoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsolicitado")
    private List<Solicitacao> solicitacaoList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<Amizades> amizadesList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idamigo")
    private List<Amizades> amizadesList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<Curtidas> curtidasList;

    public Usuarios() {
    }

    public Usuarios(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Usuarios(Long idusuario, String email, String senha, String nome, Date datanascimento, Character sexo) {
        this.idusuario = idusuario;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.sexo = sexo;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    @XmlTransient
    public List<Solicitacao> getSolicitacaoList() {
        return solicitacaoList;
    }

    public void setSolicitacaoList(List<Solicitacao> solicitacaoList) {
        this.solicitacaoList = solicitacaoList;
    }

    @XmlTransient
    public List<Solicitacao> getSolicitacaoList1() {
        return solicitacaoList1;
    }

    public void setSolicitacaoList1(List<Solicitacao> solicitacaoList1) {
        this.solicitacaoList1 = solicitacaoList1;
    }

    @XmlTransient
    public List<Amizades> getAmizadesList() {
        return amizadesList;
    }

    public void setAmizadesList(List<Amizades> amizadesList) {
        this.amizadesList = amizadesList;
    }

    @XmlTransient
    public List<Amizades> getAmizadesList1() {
        return amizadesList1;
    }

    public void setAmizadesList1(List<Amizades> amizadesList1) {
        this.amizadesList1 = amizadesList1;
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
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.aula7.Models.Usuarios[ idusuario=" + idusuario + " ]";
    }
    
}
