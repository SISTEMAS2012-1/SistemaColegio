package SGC.Gestioncolegio.Entidades;
public class Usuario {
    private Integer IdUsu;
    private String CodUsu;
    private String ApepatUsu;
    private String ApematUsu;
    private String NomUsu;
    private String GenUsu;
    private String EdadUsu;
    private String DirUsu;
    private String ColProc;
    private String Nick;
    private String Pass;
    private Usuario Usuario_IdUsu;
    private Rol oRol;

    public Usuario() {
    }

    public Usuario(Integer IdUsu) {
        this.IdUsu = IdUsu;
    }

    public Usuario(Integer IdUsu, String CodUsu, String ApepatUsu, String ApematUsu, String NomUsu, String GenUsu, String EdadUsu, String DirUsu, String ColProc, String Nick, String Pass, Usuario Usuario_IdUsu, Rol oRol) {
        this.IdUsu = IdUsu;
        this.CodUsu = CodUsu;
        this.ApepatUsu = ApepatUsu;
        this.ApematUsu = ApematUsu;
        this.NomUsu = NomUsu;
        this.GenUsu = GenUsu;
        this.EdadUsu = EdadUsu;
        this.DirUsu = DirUsu;
        this.ColProc = ColProc;
        this.Nick = Nick;
        this.Pass = Pass;
        this.Usuario_IdUsu = Usuario_IdUsu;
        this.oRol = oRol;
    }

    public Integer getIdUsu() {
        return IdUsu;
    }

    public void setIdUsu(Integer IdUsu) {
        this.IdUsu = IdUsu;
    }

    public String getCodUsu() {
        return CodUsu;
    }

    public void setCodUsu(String CodUsu) {
        this.CodUsu = CodUsu;
    }

    public String getApepatUsu() {
        return ApepatUsu;
    }

    public void setApepatUsu(String ApepatUsu) {
        this.ApepatUsu = ApepatUsu;
    }

    public String getApematUsu() {
        return ApematUsu;
    }

    public void setApematUsu(String ApematUsu) {
        this.ApematUsu = ApematUsu;
    }

    public String getNomUsu() {
        return NomUsu;
    }

    public void setNomUsu(String NomUsu) {
        this.NomUsu = NomUsu;
    }

    public String getGenUsu() {
        return GenUsu;
    }

    public void setGenUsu(String GenUsu) {
        this.GenUsu = GenUsu;
    }

    public String getEdadUsu() {
        return EdadUsu;
    }

    public void setEdadUsu(String EdadUsu) {
        this.EdadUsu = EdadUsu;
    }

    public String getDirUsu() {
        return DirUsu;
    }

    public void setDirUsu(String DirUsu) {
        this.DirUsu = DirUsu;
    }

    public String getColProc() {
        return ColProc;
    }

    public void setColProc(String ColProc) {
        this.ColProc = ColProc;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String Nick) {
        this.Nick = Nick;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public Usuario getUsuario_IdUsu() {
        return Usuario_IdUsu;
    }

    public void setUsuario_IdUsu(Usuario Usuario_IdUsu) {
        this.Usuario_IdUsu = Usuario_IdUsu;
    }

    public Rol getoRol() {
        return oRol;
    }

    public void setoRol(Rol oRol) {
        this.oRol = oRol;
    }

    
}
