package SGC.Gestioncolegio.LogicaNegocios;

import Conector.Conexion;
import SGC.Gestioncolegio.AccesoDatos.HorarioAD;
import SGC.Gestioncolegio.Entidades.Horario;
import java.util.List;

public class HorarioLN {
    public void RegistrarHorario(Horario horario) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            HorarioAD horarioAD = new HorarioAD(conexion.getConnection());
            horarioAD.RegistrarHorario(horario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarHorario(Horario horario) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            HorarioAD horarioAD = new HorarioAD(conexion.getConnection());
            horarioAD.EliminarHorario(horario);
        } catch (Exception e) {
            throw e;
        }
    }
}
