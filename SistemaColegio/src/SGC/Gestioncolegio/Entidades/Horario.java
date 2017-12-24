package SGC.Gestioncolegio.Entidades;
public class Horario {
    private Integer IdHorario;
    private String DiaSemana;
    private String HoraInicio;
    private String HoraFin;
    private Curso oCurso;

    public Horario() {
    }

    public Horario(Integer IdHorario) {
        this.IdHorario = IdHorario;
    }

    public Horario(Integer IdHorario, String DiaSemana, String HoraInicio, String HoraFin, Curso oCurso) {
        this.IdHorario = IdHorario;
        this.DiaSemana = DiaSemana;
        this.HoraInicio = HoraInicio;
        this.HoraFin = HoraFin;
        this.oCurso = oCurso;
    }

    public Integer getIdHorario() {
        return IdHorario;
    }

    public void setIdHorario(Integer IdHorario) {
        this.IdHorario = IdHorario;
    }

    public String getDiaSemana() {
        return DiaSemana;
    }

    public void setDiaSemana(String DiaSemana) {
        this.DiaSemana = DiaSemana;
    }

    public String getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(String HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public String getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(String HoraFin) {
        this.HoraFin = HoraFin;
    }

    public Curso getoCurso() {
        return oCurso;
    }

    public void setoCurso(Curso oCurso) {
        this.oCurso = oCurso;
    }

    
}
