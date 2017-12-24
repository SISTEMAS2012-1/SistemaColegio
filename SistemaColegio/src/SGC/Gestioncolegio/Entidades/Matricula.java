package SGC.Gestioncolegio.Entidades;
public class Matricula {
    private Integer IdMatricula;
    private Usuario oUsuario;
    private Curso oCurso;

    public Matricula() {
    }

    public Matricula(Integer IdMatricula) {
        this.IdMatricula = IdMatricula;
    }

    public Matricula(Integer IdMatricula, Usuario oUsuario, Curso oCurso) {
        this.IdMatricula = IdMatricula;
        this.oUsuario = oUsuario;
        this.oCurso = oCurso;
    }

    public Integer getIdMatricula() {
        return IdMatricula;
    }

    public void setIdMatricula(Integer IdMatricula) {
        this.IdMatricula = IdMatricula;
    }

    public Usuario getoUsuario() {
        return oUsuario;
    }

    public void setoUsuario(Usuario oUsuario) {
        this.oUsuario = oUsuario;
    }

    public Curso getoCurso() {
        return oCurso;
    }

    public void setoCurso(Curso oCurso) {
        this.oCurso = oCurso;
    }
    
    
}
