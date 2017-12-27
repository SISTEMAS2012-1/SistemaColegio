package SGC.Gestioncolegio.LogicaNegocios;

import Conector.Conexion;
import SGC.Gestioncolegio.AccesoDatos.CursoAD;
import SGC.Gestioncolegio.Entidades.Curso;
import java.util.List;

public class CursoLN {
    public List<Curso> ConsultarCurso(String curso) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            CursoAD cursoAD = new CursoAD(conexion.getConnection());
            List<Curso> lstCurso = cursoAD.Consultar(curso);
            
            return lstCurso;
        } catch (Exception e) {
            throw e;
        } finally {
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public Curso ConsultarCurso(Curso curso) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            CursoAD cursoAD = new CursoAD(conexion.getConnection());
            Curso cursoEncontrado = cursoAD.Consultar(curso);
            
            return cursoEncontrado;
        } catch (Exception e) {
            throw e;
        } finally {
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public void RegistrarCurso(Curso curso) throws Exception{
        Conexion conexion = null;        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            CursoAD cursoAD = new CursoAD(conexion.getConnection());
            cursoAD.RegistrarCurso(curso);
        } catch (Exception e) {
            throw e;
        } 
    }
    
    public void ModificarCurso(Curso curso) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            CursoAD cursoAD = new CursoAD(conexion.getConnection());
            cursoAD.ActualizarCurso(curso);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarCurso(Curso curso) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            CursoAD cursoAD = new CursoAD(conexion.getConnection());
            cursoAD.EliminarCurso(curso);
        } catch (Exception e) {
            throw e;
        }
    }
}
