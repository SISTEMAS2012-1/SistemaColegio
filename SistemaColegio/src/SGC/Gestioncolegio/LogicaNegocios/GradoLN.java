package SGC.Gestioncolegio.LogicaNegocios;

import Conector.Conexion;
import SGC.Gestioncolegio.AccesoDatos.GradoAD;
import SGC.Gestioncolegio.Entidades.Grado;
import java.util.List;

public class GradoLN {
    public List<Grado> ConsultarGrado(String curso) throws Exception{
        Conexion conexion = null;
        
        try {
         conexion = new Conexion();
         conexion.Abrir(true);
         
            GradoAD gradoAD = new GradoAD(conexion.getConnection());
            List<Grado> lstGrado = gradoAD.Consultar(curso);
            
            return lstGrado;
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
    
    public Grado ConsultarGrado(Grado grado) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            GradoAD gradoAD = new GradoAD(conexion.getConnection());
            Grado gradoEncontrado = gradoAD.Consultar(grado);
            
            return gradoEncontrado;
        } catch (Exception e) {
            throw e;
        }       
    }
}
