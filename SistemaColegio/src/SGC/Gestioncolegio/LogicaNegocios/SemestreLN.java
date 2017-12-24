package SGC.Gestioncolegio.LogicaNegocios;

import Conector.Conexion;
import SGC.Gestioncolegio.AccesoDatos.SemestreAD;
import SGC.Gestioncolegio.Entidades.Semestre;
import java.util.List;

public class SemestreLN {
    public List<Semestre> ConsultarSemestre(String semestre) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            SemestreAD semestreAD = new SemestreAD(conexion.getConnection());
            List<Semestre> lstsemestre = semestreAD.Consultar(semestre);
            
            return lstsemestre;
        } catch (Exception e) {
            throw e;
        } finally{
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public Semestre ConsultarSemestre(Semestre semestre) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            SemestreAD semestreAD = new SemestreAD(conexion.getConnection());
            Semestre semestreEncontrado = semestreAD.Consultar(semestre);
            
            return semestreEncontrado;
        } catch (Exception e) {
            throw e;
        } finally{
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public void RegistrarSemestre(Semestre semestre) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            SemestreAD semestreAD = new SemestreAD(conexion.getConnection());
            semestreAD.RegistrarSemestre(semestre);
        } catch (Exception e) {
            throw e;
        }finally{
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public void ActualizarSemestre(Semestre semestre) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            SemestreAD semestreAD = new SemestreAD(conexion.getConnection());
            semestreAD.ActualizarSemestre(semestre);
        } catch (Exception e) {
            throw e;
        }finally{
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
}
