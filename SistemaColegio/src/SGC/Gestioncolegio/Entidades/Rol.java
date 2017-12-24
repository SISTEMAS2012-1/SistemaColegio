package SGC.Gestioncolegio.Entidades;
public class Rol {
    private Integer IdRol;
    private String NomRol;

    public Rol() {
    }

    public Rol(Integer IdRol) {
        this.IdRol = IdRol;
    }

    public Rol(Integer IdRol, String NomRol) {
        this.IdRol = IdRol;
        this.NomRol = NomRol;
    }

    public Integer getIdRol() {
        return IdRol;
    }

    public void setIdRol(Integer IdRol) {
        this.IdRol = IdRol;
    }

    public String getNomRol() {
        return NomRol;
    }

    public void setNomRol(String NomRol) {
        this.NomRol = NomRol;
    }
    
    
    
}
