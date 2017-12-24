package SGC.Gestioncolegio.Entidades;
public class Grado {
    private Integer IdGrado;
    private String NomGrado;
    private String Nivel;

    public Grado() {
    }

    public Grado(Integer IdGrado) {
        this.IdGrado = IdGrado;
    }

    public Grado(Integer IdGrado, String NomGrado, String Nivel) {
        this.IdGrado = IdGrado;
        this.NomGrado = NomGrado;
        this.Nivel = Nivel;
    }

    public Integer getIdGrado() {
        return IdGrado;
    }

    public void setIdGrado(Integer IdGrado) {
        this.IdGrado = IdGrado;
    }

    public String getNomGrado() {
        return NomGrado;
    }

    public void setNomGrado(String NomGrado) {
        this.NomGrado = NomGrado;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }

    
}
