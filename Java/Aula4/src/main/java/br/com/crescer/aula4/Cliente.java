
package br.com.crescer.aula4;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable{

    @Id
    @Basic(optional = false)
    @Column(name="ID_CLIENTE")
    private Long Id;
    
    @Basic(optional = false)
    @Column(name="NM_CLIENTE")
    private String Nome;

    public Long getID() {
        return Id;
    }

    public void setID(Long Id) {
        this.Id = Id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
}
