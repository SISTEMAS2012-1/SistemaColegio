package SGC.Gestioncolegio.Entidades;
public class Curso {
    private Integer IdCurso;
    private String NomCurso;
    private String Fechin;
    private String Fechter;
    private Turno oTurno;

    public Curso() {
    }

    public Curso(Integer IdCurso) {
        this.IdCurso = IdCurso;
    }

    public Curso(Integer IdCurso, String NomCurso, String Fechin, String Fechter, Turno oTurno) {
        this.IdCurso = IdCurso;
        this.NomCurso = NomCurso;
        this.Fechin = Fechin;
        this.Fechter = Fechter;
        this.oTurno = oTurno;
    }

    public Integer getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(Integer IdCurso) {
        this.IdCurso = IdCurso;
    }

    public String getNomCurso() {
        return NomCurso;
    }

    public void setNomCurso(String NomCurso) {
        this.NomCurso = NomCurso;
    }

    public String getFechin() {
        return Fechin;
    }

    public void setFechin(String Fechin) {
        this.Fechin = Fechin;
    }

    public String getFechter() {
        return Fechter;
    }

    public void setFechter(String Fechter) {
        this.Fechter = Fechter;
    }

    public Turno getoTurno() {
        return oTurno;
    }

    public void setoTurno(Turno oTurno) {
        this.oTurno = oTurno;
    }

    
}
