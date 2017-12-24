package SGC.Gestioncolegio.AccesoDatos;

import Conector.EntidadAD;
import java.sql.Connection;

public class UsuarioAD extends EntidadAD{
    
    public UsuarioAD(Connection connection) {
        super(connection);
    }
    
    public Integer getId() throws Exception{
        try {
            String sql = "select nextval('usuario_idusu_seq') as idusu";
            
            Integer id = 0;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("idusu");
                
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
    
}
