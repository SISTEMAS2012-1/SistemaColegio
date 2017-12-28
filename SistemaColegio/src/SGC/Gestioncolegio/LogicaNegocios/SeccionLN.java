package SGC.Gestioncolegio.LogicaNegocios;


import Conector.Conexion;
import SGC.Gestioncolegio.AccesoDatos.SeccionAD;
import SGC.Gestioncolegio.Entidades.Seccion;
import java.util.List;

public class SeccionLN {
    public List<Seccion> ConsultarSeccion(String seccion) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            SeccionAD seccionAD = new SeccionAD(conexion.getConnection());
            List<Seccion> lstseccion = seccionAD.Consultar(seccion);
            
            return lstseccion;
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
    
    public Seccion consultarSeccion(Seccion seccion) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            SeccionAD seccionAD = new SeccionAD(conexion.getConnection());
            Seccion seccionEncontrada = seccionAD.Consultar(seccion);
            
            return seccionEncontrada;
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
    
    public void RegistrarSeccion(Seccion seccion) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            SeccionAD seccionAD = new SeccionAD(conexion.getConnection());
            seccionAD.RegistrarSeccion(seccion);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarSeccion(Seccion seccion) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            SeccionAD seccionAD = new SeccionAD(conexion.getConnection());
            seccionAD.ActualizarSeccion(seccion);
            
        } catch (Exception e) {
            throw e;
        }
    }
}

