package SGC.Gestioncolegio.Entidades;
public class Turno {
    private Integer IdTurno;
    private String Turno;
    private Grado oGrado;
    private Seccion oSeccion;

    public Turno() {
    }

    public Turno(Integer IdTurno) {
        this.IdTurno = IdTurno;
    }

    public Turno(Integer IdTurno, String Turno, Grado oGrado, Seccion oSeccion) {
        this.IdTurno = IdTurno;
        this.Turno = Turno;
        this.oGrado = oGrado;
        this.oSeccion = oSeccion;
    }

    public Integer getIdTurno() {
        return IdTurno;
    }

    public void setIdTurno(Integer IdTurno) {
        this.IdTurno = IdTurno;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String Turno) {
        this.Turno = Turno;
    }

    public Grado getoGrado() {
        return oGrado;
    }

    public void setoGrado(Grado oGrado) {
        this.oGrado = oGrado;
    }

    public Seccion getoSeccion() {
        return oSeccion;
    }

    public void setoSeccion(Seccion oSeccion) {
        this.oSeccion = oSeccion;
    }

    
}
