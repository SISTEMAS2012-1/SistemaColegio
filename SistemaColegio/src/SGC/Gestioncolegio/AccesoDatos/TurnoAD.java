package SGC.Gestioncolegio.AccesoDatos;

import Conector.EntidadAD;
import SGC.Gestioncolegio.Entidades.Grado;
import SGC.Gestioncolegio.Entidades.Seccion;
import SGC.Gestioncolegio.Entidades.Turno;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TurnoAD extends EntidadAD{
    
    public TurnoAD(Connection connection) {
        super(connection);
    }
    
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('turno_idturno_seq') as idturno;";
            
            Integer id = 0;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("idturno");
                
                if(rs.wasNull()){
                    id = 0;
                }
            }
            return id;
        } catch (Exception e) {
            throw e;
        } finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
        }
    }
    
    public List<Turno> Consultar(String turno) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idturno";
            sql = sql + ",turno";
            sql = sql + ",idgrado";
            sql = sql + ",idseccion";
            sql = sql + " from turno";
            sql = sql + " where";
            sql = sql + " turno like '%"+turno + "%'";
            sql = sql + " order by";
            sql = sql + " turno asc";
            sql = sql + ";";
            
            List<Turno> lista = new ArrayList<Turno>();
            Turno obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while(rs.next()){
                obj = new Turno();
                obj.setIdTurno(rs.getInt("idturno"));
                obj.setTurno(rs.getString("turno"));                
                obj.setoGrado(new Grado(rs.getInt("idgrado")));
                obj.setoSeccion(new Seccion(rs.getInt("idseccion")));                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }finally{
            if(rs != null){
                rs.close();
            }
            
            if(ps != null){
                ps.close();
            }
        }
    }
    
    public Turno Consultar(Turno turno) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idturno";
            sql = sql +" from turno";
            sql = sql + " where";
            sql = sql + " idturno <>" + (turno.getIdTurno()==null?"0":turno.getIdTurno().toString());
            sql = sql + " and (turno = '" + turno.getTurno()+ "')";
            sql = sql + ";";
            
            Turno obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj = new Turno();
                
                obj.setIdTurno(rs.getInt("idturno"));
            }
            
            return obj;
            
        } catch (Exception e) {
            throw e;
        } finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
        }       
    }
    
    public void RegistrarTurno(Turno obj) throws Exception{
        try {
            obj.setIdTurno(getId());
            
            String dml = "insert into turno(";
            dml = dml + " idturno";
            dml = dml + ",turno";
            dml = dml + ",idgrado";
            dml = dml + ",idseccion";
            dml = dml + ") values (";
            dml = dml + "'" + obj.getIdTurno().toString()+"'";
            dml = dml + ",'" + obj.getTurno()+"'";
            dml = dml + ",'" + obj.getoGrado().getIdGrado()+"'";
            dml = dml + ",'" + obj.getoSeccion().getIdSeccion()+"'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarTurno(Turno obj) throws Exception{
        try {
            String dml = "update turno set";
            dml = dml + " turno = '"+obj.getTurno()+"'";
            dml = dml + ",idgrado = '"+obj.getoGrado().getIdGrado()+"'";
            dml = dml + ",idseccion = '"+obj.getoSeccion().getIdSeccion()+"'";
            dml = dml + " where";
            dml = dml + " idturno = "+obj.getIdTurno().toString();
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
}
