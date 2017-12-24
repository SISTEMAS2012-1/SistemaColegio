package SGC.Gestioncolegio.AccesoDatos;

import Conector.EntidadAD;
import SGC.Gestioncolegio.Entidades.Grado;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class GradoAD extends EntidadAD{
    
    public GradoAD(Connection connection) {
        super(connection);
    }
    
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('grado_idgrado_seq') as idgrado;";
            
            Integer id = 0;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("idgrado");
                
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
    
    public List<Grado> Consultar(String grado) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idgrado";
            sql = sql + ",nomgrado";
            sql = sql + ",nivel";
            sql = sql + " from grado";
            sql = sql + " where";
            sql = sql + " nomgrado like '%"+grado + "%'";
            sql = sql + " order by";
            sql = sql + " nomgrado asc";
            sql = sql + ";";
            
            List<Grado> lista = new ArrayList<Grado>();
            Grado obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while(rs.next()){
                obj = new Grado();
                obj.setIdGrado(rs.getInt("idgrado"));
                obj.setNomGrado(rs.getString("nomgrado"));
                obj.setNivel(rs.getString("nivel"));                
                
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
    
    public Grado Consultar(Grado grado) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idgrado";
            sql = sql + " from grado";
            sql = sql + " where";
            sql = sql + " idgrado <>" + (grado.getIdGrado()==null?"0":grado.getIdGrado().toString());
            sql = sql + " and (nomgrado = '" + grado.getNomGrado()+ "')";
            sql = sql + ";";
            
            Grado obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj = new Grado();
                
                obj.setIdGrado(rs.getInt("idgrado"));
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
    
    public void RegistrarGrado(Grado obj) throws Exception{
        try {
            obj.setIdGrado(getId());
            
            String dml = "insert into grado(";
            dml = dml + " idgrado";
            dml = dml + ",nomgrado";
            dml = dml + ",nivel";
            dml = dml + ") values (";
            dml = dml + "'" + obj.getIdGrado().toString()+"'";
            dml = dml + ",'" + obj.getNomGrado()+"'";
            dml = dml + ",'" + obj.getNivel()+"'";            
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarGrado(Grado obj) throws Exception{
        try {
            String dml = "update grado set";
            dml = dml + " nomgrado = '"+obj.getNomGrado()+"'";
            dml = dml + ",nivel = '"+obj.getNivel()+"'";
            dml = dml + " where";
            dml = dml + " idgrado = "+obj.getIdGrado().toString();
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
}
