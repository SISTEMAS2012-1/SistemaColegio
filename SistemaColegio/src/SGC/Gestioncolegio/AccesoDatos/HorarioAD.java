package SGC.Gestioncolegio.AccesoDatos;

import Conector.EntidadAD;
import SGC.Gestioncolegio.Entidades.Horario;
import java.sql.Connection;

public class HorarioAD extends EntidadAD{
    
    public HorarioAD(Connection connection) {
        super(connection);
    }
    
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('horario_idhora_seq') as idhora;";
            
            Integer id = 0;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("idhora");
                
                if(rs.wasNull()){
                    id = 0;
                }
            }
            return id;
        } catch (Exception e) {
            throw e;
        } finally {
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
        }
    }
    
    public void RegistrarHorario(Horario obj) throws Exception{
        try {
            obj.setIdHorario(getId());
            
            String dml = "insert into horario(";
            dml = dml + " idhora";
            dml = dml + ",diasemana";
            dml = dml + ",horini";
            dml = dml + ",horfin";
            dml = dml + ",idcurso";
            dml = dml + ") values (";
            dml = dml + "'"+obj.getIdHorario()+"'";
            dml = dml + ",'"+obj.getDiaSemana()+"'";
            dml = dml + ",'"+obj.getHoraInicio()+"'";
            dml = dml + ",'"+obj.getHoraFin()+"'";
            dml = dml + ",'"+obj.getoCurso().getIdCurso()+"'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);                   
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarHorario(Horario obj) throws Exception{
        try {
            String dml = "delete from horario";
            dml = dml + " where";
            dml = dml + " idhora = '"+obj.getIdHorario().toString()+"'";
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
}
