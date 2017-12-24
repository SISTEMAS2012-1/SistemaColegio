package SGC.Gestioncolegio.AccesoDatos;

import Conector.EntidadAD;
import SGC.Gestioncolegio.Entidades.Grado;
import SGC.Gestioncolegio.Entidades.Seccion;
import SGC.Gestioncolegio.Entidades.Curso;
import SGC.Gestioncolegio.Entidades.Turno;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CursoAD extends EntidadAD{
    
    public CursoAD(Connection connection) {
        super(connection);
    }
    
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('nomcurso_idnomcurso_seq') as idnomcurso;";
            
            Integer id = 0;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("idnomcurso");
                
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
    
    public List<Curso> Consultar(String curso) throws Exception{
        try {
            String sql = "select";
            sql = sql + " curso.idcurso";
            sql = sql + ",curso.nomcurso";
            sql = sql + ",curso.fechin";
            sql = sql + ",curso.fechter";
            sql = sql + ",turno.idturno";            
            sql = sql + " from curso";
            sql = sql + " inner join turno on curso.idturno = turno.idturno";
            sql = sql + " where";
            sql = sql + " nomcurso like '%"+curso + "%'";
            sql = sql + " order by";
            sql = sql + " nomcurso asc";
            sql = sql + ";";
            
            List<Curso> lista = new ArrayList<Curso>();
            Curso obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while(rs.next()){
                obj = new Curso();
                obj.setIdCurso(rs.getInt("idcurso"));
                obj.setNomCurso(rs.getString("nomcurso"));                
                obj.setFechin(rs.getString("fechin"));
                obj.setFechter(rs.getString("fechter"));                
                obj.setoTurno(new Turno(rs.getInt("idturno")));
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
    
    public Curso Consultar(Curso curso) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idcurso";
            sql = sql + " from nomcurso";
            sql = sql + " where";
            sql = sql + " idnomcurso <>" + (curso.getIdCurso()==null?"0":curso.getIdCurso().toString());
            sql = sql + " and (nomcurso = '" + curso.getNomCurso()+ "')";
            sql = sql + ";";
            
            Curso obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj = new Curso();
                
                obj.setIdCurso(rs.getInt("idcurso"));
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
    
    public void RegistrarCurso(Curso obj) throws Exception{
        try {
            obj.setIdCurso(getId());
            
            String dml = "insert into curso(";
            dml = dml + " idcurso";
            dml = dml + ",nomcurso";
            dml = dml + ",fechin";
            dml = dml + ",fechter";
            dml = dml + ",idturno";
            dml = dml + ") values (";
            dml = dml + "'" + obj.getIdCurso().toString()+"'";
            dml = dml + ",'" + obj.getNomCurso()+"'";
            dml = dml + ",'" + obj.getFechin()+"'";
            dml = dml + ",'" + obj.getFechter()+"'";
            dml = dml + ",'" + obj.getoTurno().getIdTurno() + "'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ActualizarCurso(Curso obj) throws Exception{
        try {
            String dml = "update curso set";
            dml = dml + " nomcurso = '"+obj.getNomCurso()+"'";
            dml = dml + ",fechin = '"+obj.getFechin()+"'";
            dml = dml + ",fechter = '"+obj.getFechter()+"'";
            dml = dml + ",idturno = '"+obj.getoTurno().getIdTurno()+"'";
            dml = dml + " where";
            dml = dml + " idcurso = "+obj.getIdCurso().toString();
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void EliminarCurso(Curso obj) throws Exception{
        try {
         String dml = "delete from curso";
         dml = dml + " where";
         dml = dml + " idcurso  = '" +obj.getIdCurso() + "'";
         dml = dml + ";";
        } catch (Exception e) {
            throw e;
        }        
    }
}
