/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author William
 */
@Entity
@Table(name = "USUARIO", catalog = "", schema = "ANDROMEDA2", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"EMAIL"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuario.findByDatanascimento", query = "SELECT u FROM Usuario u WHERE u.datanascimento = :datanascimento")
    , @NamedQuery(name = "Usuario.findBySexo", query = "SELECT u FROM Usuario u WHERE u.sexo = :sexo")
    , @NamedQuery(name = "Usuario.findByUrlfoto", query = "SELECT u FROM Usuario u WHERE u.urlfoto = :urlfoto")})
public class Usuario implements Serializable {
    
    private static final String SQ_NAME = "SQ_USUARIO";
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "IDUSUARIO", nullable = false)
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
    
    @Size(max = 500)
    @Column(name = "URLFOTO", length = 500)
    private String urlfoto;
    
    @JsonIgnore
    @OneToMany(mappedBy = "idusuario")
    private List<Postagem> postagemList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<Curtida> curtidaList;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idamigo")
    private List<Amizade> amizadeList;

    public Usuario() {
    }

    public Usuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Long idusuario, String email, String senha, String nome, Date datanascimento, Character sexo) {
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

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    @XmlTransient
    public List<Postagem> getPostagemList() {
        return postagemList;
    }

    public void setPostagemList(List<Postagem> postagemList) {
        this.postagemList = postagemList;
    }

    @XmlTransient
    public List<Curtida> getCurtidaList() {
        return curtidaList;
    }

    public void setCurtidaList(List<Curtida> curtidaList) {
        this.curtidaList = curtidaList;
    }

    @XmlTransient
    public List<Amizade> getAmizadeList() {
        return amizadeList;
    }

    public void setAmizadeList(List<Amizade> amizadeList) {
        this.amizadeList = amizadeList;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.Models.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
