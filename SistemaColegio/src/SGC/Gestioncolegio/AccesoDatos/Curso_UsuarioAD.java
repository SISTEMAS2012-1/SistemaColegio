package SGC.Gestioncolegio.AccesoDatos;

import Conector.EntidadAD;
import java.sql.Connection;
import SGC.Gestioncolegio.Entidades.Curso_Usuario;

public class Curso_UsuarioAD extends EntidadAD{
    
    public Curso_UsuarioAD(Connection connection) {
        super(connection);
    }
    
    
    public void RegistrarCurso_Usuario(Curso_Usuario obj) throws Exception{
        try {
            String dml = "insert into curso_usuario(";
            dml = dml + " idcurso";
            dml = dml + ",idusuario";
            dml = dml + ") values (";
            dml = dml + " '" + obj.getIdCurso().toString()+"'";
            dml = dml + ",'" + obj.getIdUsuario().toString() + "'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void ModificarCurso_Usuario(Curso_Usuario obj) throws Exception{
        try {
            String dml = "update curso_usuario set";
            dml = dml + " where";
            dml = dml + " idcurso = '"+obj.getIdCurso().toString()+"' and idusuario = '"+obj.getIdUsuario().toString()+"'";
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
}
