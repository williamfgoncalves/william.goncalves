
public class Estado {
    private long id;
    private String Nome;
    private String UF;
    private long IdPais;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public long getIdPais() {
        return IdPais;
    }

    public void setIdPais(long IdPais) {
        this.IdPais = IdPais;
    }
}
