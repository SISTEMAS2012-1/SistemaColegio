package SGC.Gestioncolegio.Entidades;
public class Usuario {
    private Integer IdUsu;
    private String Usuario_IdUsu;
    private String Codigo;
    private String CodUsu;
    private String ApepatUsu;
    private String ApematUsu;
    private String NomUsu;
    private String GenUsu;
    private String DirUsu;
    private String EdadUsu;    
    private String ColProc;
    private String Nick;
    private String Pass;    
    private String Rol;
    private String Estado;
    private String Telefono;
    private String Correo;
    private String Imagen;

    public Usuario() {
    }

    public Usuario(Integer IdUsu) {
        this.IdUsu = IdUsu;
    }

    public Usuario(Integer IdUsu, String Usuario_IdUsu, String Codigo, String CodUsu, String ApepatUsu, String ApematUsu, String NomUsu, String GenUsu, String DirUsu, String EdadUsu, String ColProc, String Nick, String Pass, String Rol, String Estado, String Telefono, String Correo, String Imagen) {
        this.IdUsu = IdUsu;
        this.Usuario_IdUsu = Usuario_IdUsu;
        this.Codigo = Codigo;
        this.CodUsu = CodUsu;
        this.ApepatUsu = ApepatUsu;
        this.ApematUsu = ApematUsu;
        this.NomUsu = NomUsu;
        this.GenUsu = GenUsu;
        this.DirUsu = DirUsu;
        this.EdadUsu = EdadUsu;
        this.ColProc = ColProc;
        this.Nick = Nick;
        this.Pass = Pass;
        this.Rol = Rol;
        this.Estado = Estado;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Imagen = Imagen;
    }

    public Integer getIdUsu() {
        return IdUsu;
    }

    public void setIdUsu(Integer IdUsu) {
        this.IdUsu = IdUsu;
    }

    public String getUsuario_IdUsu() {
        return Usuario_IdUsu;
    }

    public void setUsuario_IdUsu(String Usuario_IdUsu) {
        this.Usuario_IdUsu = Usuario_IdUsu;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
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

    public String getDirUsu() {
        return DirUsu;
    }

    public void setDirUsu(String DirUsu) {
        this.DirUsu = DirUsu;
    }

    public String getEdadUsu() {
        return EdadUsu;
    }

    public void setEdadUsu(String EdadUsu) {
        this.EdadUsu = EdadUsu;
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

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    
}
