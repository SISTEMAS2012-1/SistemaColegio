package SGC.Gestioncolegio.Entidades;
public class Curso_Usuario {
    private Integer IdCurso;
    private Integer IdUsuario;

    public Curso_Usuario(Integer IdCurso, Integer IdUsuario) {
        this.IdCurso = IdCurso;
        this.IdUsuario = IdUsuario;
    }

    public Integer getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(Integer IdCurso) {
        this.IdCurso = IdCurso;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    
    
}
