package SGC.Gestioncolegio.AccesoDatos;

import Conector.EntidadAD;
import SGC.Gestioncolegio.Entidades.Seccion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class SeccionAD extends EntidadAD{
    
    public SeccionAD(Connection connection) {
        super(connection);
    }
    
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('seccion_idseccion_seq') as idseccion;";
            
            Integer id = 0;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("idseccion");
                
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
    
    public List<Seccion> Consultar(String seccion) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idseccion";
            sql = sql + ",nomsec";
            sql = sql + " from seccion";
            sql = sql + " where";
            sql = sql + " nomsec like '%"+seccion + "%'";
            sql = sql + " order by";
            sql = sql + " nomsec asc";
            sql = sql + ";";
            
            List<Seccion> lista = new ArrayList<Seccion>();
            Seccion obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while(rs.next()){
                obj = new Seccion();
                obj.setIdSeccion(rs.getInt("idseccion"));
                obj.setNomSeccion(rs.getString("nomsec"));                
                
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
    
    public Seccion Consultar(Seccion seccion) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idseccion";
            sql = sql +" from seccion";
            sql = sql + " where";
            sql = sql + " idseccion <>" + (seccion.getIdSeccion()==null?"0":seccion.getIdSeccion().toString());
            sql = sql + " and (nomsec = '" + seccion.getNomSeccion()+ "')";
            sql = sql + ";";
            
            Seccion obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj = new Seccion();
                
                obj.setIdSeccion(rs.getInt("idseccion"));
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
    
    public void RegistrarSeccion(Seccion obj) throws Exception{
        try {
            obj.setIdSeccion(getId());
            
            String dml = "insert into seccion(";
            dml = dml + " idseccion";
            dml = dml + ",nomsec";
            dml = dml + ") values (";
            dml = dml + "'" + obj.getIdSeccion().toString()+"'";
            dml = dml + ",'" + obj.getNomSeccion()+"'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarSeccion(Seccion obj) throws Exception{
        try {
            String dml = "update seccion set";
            dml = dml + " nomsec = '"+obj.getNomSeccion()+"'";
            dml = dml + " where";
            dml = dml + " idseccion = "+obj.getIdSeccion().toString();
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
}
