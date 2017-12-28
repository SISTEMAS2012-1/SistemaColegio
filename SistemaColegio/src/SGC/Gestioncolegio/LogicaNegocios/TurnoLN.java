package SGC.Gestioncolegio.LogicaNegocios;

import Conector.Conexion;
import SGC.Gestioncolegio.AccesoDatos.TurnoAD;
import SGC.Gestioncolegio.Entidades.Turno;
import java.util.List;

public class TurnoLN {
    public List<Turno> ConsultarTurno(String turno) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            TurnoAD turnoAD = new TurnoAD(conexion.getConnection());
            List<Turno> lstTurno = turnoAD.Consultar(turno);
            
            return lstTurno;           
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
    
    public Turno ConsultarTurno(Turno turno) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            TurnoAD turnoAD = new TurnoAD(conexion.getConnection());
            Turno turnoEncontrado = turnoAD.Consultar(turno);
            
            return turnoEncontrado;
        } catch (Exception e) {
            throw e;
        } finally {
            if(conexion !=  null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public void RegistrarTurno(Turno turno) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            TurnoAD turnoAD = new TurnoAD(conexion.getConnection());
            turnoAD.RegistrarTurno(turno);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarTurno(Turno turno) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            TurnoAD turnoAD = new TurnoAD(conexion.getConnection());
            turnoAD.ActualizarTurno(turno);
        } catch (Exception e) {
            throw e;
        }
    }
}
