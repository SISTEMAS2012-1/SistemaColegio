package SGC.Gestioncolegio.AccesoDatos;

import Conector.EntidadAD;
import SGC.Gestioncolegio.Entidades.Semestre;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class SemestreAD extends EntidadAD{
    
    public SemestreAD(Connection connection) {
        super(connection);
    }
    
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('semestre_idsemest_seq') as idsemest;";
            
            Integer id = 0;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("idsemest");
                
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
    
    public List<Semestre> Consultar(String semestre) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idsemest";
            sql = sql + ",semest";
            sql = sql + ",fechin";
            sql = sql + ",fechte";
            sql = sql + " from semestre";
            sql = sql + " where";
            sql = sql + " semest like '%"+semestre + "%'";
            sql = sql + " order by";
            sql = sql + " semest asc";
            sql = sql + ";";
            
            List<Semestre> lista = new ArrayList<Semestre>();
            Semestre obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while(rs.next()){
                obj = new Semestre();
                obj.setId(rs.getInt("idsemest"));
                obj.setSemestre(rs.getString("semest"));
                obj.setFechini(rs.getString("fechin"));
                obj.setFechte(rs.getString("fechte"));
                
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
    
    public Semestre Consultar(Semestre semestre) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idsemest";
            sql = sql + " from semestre";
            sql = sql + " where";
            sql = sql + " idsemest <>" + (semestre.getId()==null?"0":semestre.getId().toString());
            sql = sql + " and (semest = '" + semestre.getSemestre() + "')";
            sql = sql + ";";
            
            Semestre obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj = new Semestre();
                
                obj.setId(rs.getInt("idsemest"));
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
    
    public void RegistrarSemestre(Semestre obj) throws Exception{
        try {
            obj.setId(getId());
            
            String dml = "insert into semestre(";
            dml = dml + " idsemest";
            dml = dml + ",semest";
            dml = dml + ",fechin";
            dml = dml + ",fechte";
            dml = dml + ") values (";
            dml = dml + "'" + obj.getId().toString()+"'";
            dml = dml + ",'" + obj.getSemestre()+"'";
            dml = dml + ",'" + obj.getFechini()+"'";
            dml = dml + ",'" + obj.getFechte()+"'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarSemestre(Semestre obj) throws Exception{
        try {
            String dml = "update semestre set";
            dml = dml + " semest = '"+obj.getSemestre()+"'";
            dml = dml + ",fechin = '"+obj.getFechini()+"'";
            dml = dml + ",fechte = '"+obj.getFechte()+"'";
            dml = dml + " where";
            dml = dml + " idsemest = "+obj.getId().toString();
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
}
