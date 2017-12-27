package SGC.Gestioncolegio.AccesoDatos;

import Conector.EntidadAD;
import java.sql.Connection;

public class Curso_UsuarioAD extends EntidadAD{
    
    public Curso_UsuarioAD(Connection connection) {
        super(connection);
    }
    
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('cursos)"
        } catch (Exception e) {
        }
        
    }
    
    
}
