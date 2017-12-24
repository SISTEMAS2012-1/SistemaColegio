package SGC.Gestioncolegio.Entidades;
public class Seccion {
    private Integer IdSeccion;
    private String NomSeccion;

    public Seccion() {
    }

    public Seccion(Integer IdSeccion) {
        this.IdSeccion = IdSeccion;
    }

    public Seccion(Integer IdSeccion, String NomSeccion) {
        this.IdSeccion = IdSeccion;
        this.NomSeccion = NomSeccion;
    }

    public Integer getIdSeccion() {
        return IdSeccion;
    }

    public void setIdSeccion(Integer IdSeccion) {
        this.IdSeccion = IdSeccion;
    }

    public String getNomSeccion() {
        return NomSeccion;
    }

    public void setNomSeccion(String NomSeccion) {
        this.NomSeccion = NomSeccion;
    }
    
     
    
}
