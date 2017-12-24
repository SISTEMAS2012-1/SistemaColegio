package SGC.Gestioncolegio.Entidades;
public class Semestre {
    private Integer Id;
    private String Semestre;
    private String Fechini;
    private String Fechte;

    public Semestre() {
    }

    public Semestre(Integer Id) {
        this.Id = Id;
    }

    public Semestre(Integer Id, String Semestre, String Fechini, String Fechte) {
        this.Id = Id;
        this.Semestre = Semestre;
        this.Fechini = Fechini;
        this.Fechte = Fechte;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getSemestre() {
        return Semestre;
    }

    public void setSemestre(String Semestre) {
        this.Semestre = Semestre;
    }

    public String getFechini() {
        return Fechini;
    }

    public void setFechini(String Fechini) {
        this.Fechini = Fechini;
    }

    public String getFechte() {
        return Fechte;
    }

    public void setFechte(String Fechte) {
        this.Fechte = Fechte;
    }
    
    
}
