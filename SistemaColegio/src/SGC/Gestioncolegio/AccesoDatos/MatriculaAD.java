package SGC.Gestioncolegio.AccesoDatos;

import Conector.EntidadAD;
import java.sql.Connection;

public class MatriculaAD extends EntidadAD{
    
    public MatriculaAD(Connection connection) {
        super(connection);
    }
    
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('matricula_idmat_seq') as idmat;";
            
            Integer id = 0;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("idmat");
                
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
}
