package SGC.Gestioncolegio.AccesoDatos;

import Conector.EntidadAD;
import SGC.Gestioncolegio.Entidades.Rol;
import SGC.Gestioncolegio.Entidades.Usuario;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
    
//Consultar Usuario a Ingresar    
    public Usuario ValidarLogin(String nick, String pass, Rol rol) throws Exception{
        try {
            String sql = "select ";
            sql = sql + " usuario.idusu";
            sql = sql + ",usuario.codusu";
            sql = sql + ",usuario.apepatusu";
            sql = sql + ",usuario.apematusu";
            sql = sql + ",usuario.nomusu";
            sql = sql + ",rol.idrol";
            sql = sql + ",rol.nomrol";
            sql = sql + " from usuario";
            sql = sql + " inner join rol on usuario.idrol  = rol.idrol";
            sql = sql + " where";
            sql = sql + " usuario.nick = '"+nick+"'";
            sql = sql + " and pass = '"+pass+"'";
            sql = sql + " and rol.idrol = '"+rol.getIdRol()+"'";
            sql = sql + " ;";
            
            Usuario obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while(rs.next()){
                obj = new Usuario();
                
                obj.setIdUsu(rs.getInt("usuario.idusu"));
                obj.setCodUsu(rs.getString("usuario.codusu"));
                obj.setApepatUsu(rs.getString("usuario.apepatusu"));
                obj.setApematUsu(rs.getString("usuario.apematusu"));
                obj.setNomUsu(rs.getString("usuario.nomusu"));                
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
      
// REGISTRAR USUARIOS
    // REGISTRAR ALUMNO    
    public void RegistrarUsuarioAlumno(Usuario obj) throws Exception{
        try {
            obj.setIdUsu(getId());
            
            String dml = "insert into usuario(";
            dml = dml + " idusu";
            dml = dml + ",usuario_idusu";
            dml = dml + ",codusu";
            dml = dml + ",apepatusu";
            dml = dml + ",apematusu";
            dml = dml + ",nomusu";
            dml = dml + ",genusu";
            dml = dml + ",edadusu";
            dml = dml + ",dirusu";
            dml = dml + ",estado";
            dml = dml + ",telefono";
            dml = dml + ",correo";
            dml = dml + ",imagen";
            dml = dml + ",colegioprocusu";
            dml = dml + ",nick";
            dml = dml + ",pass";
            dml = dml + ",idrol";
            dml = dml + ") values (";
            dml = dml + "'"+obj.getIdUsu().toString()+"'";
            dml = dml + ",'4'";
            dml = dml + ",'"+obj.getCodUsu()+"'";
            dml = dml + ",'"+obj.getApepatUsu()+"'";
            dml = dml + ",'"+obj.getApematUsu()+"'";
            dml = dml + ",'"+obj.getNomUsu()+"'";
            dml = dml + ",'"+obj.getGenUsu()+"'";
            dml = dml + ",'"+obj.getEdadUsu()+"'";
            dml = dml + ",'"+obj.getDirUsu()+"'";
            dml = dml + ",'HABILITADO'";
            dml = dml + ",'"+obj.getTelefono()+"'";
            dml = dml + ",'"+obj.getCorreo()+"'";
            dml = dml + ",'"+obj.getImagen()+"'";
            dml = dml + ",'"+obj.getColProc()+"'";
            dml = dml + ",'"+obj.getNick()+"'";
            dml = dml + ",'"+obj.getPass()+"'";
            dml = dml + ",'2'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);                     
        } catch (Exception e) {
            throw e;
        }
    }
    // REGISTRAR PROFESOR
    public void RegistrarUsuarioProfesor(Usuario obj) throws Exception{
        try {
            obj.setIdUsu(getId());
            
            String dml = "insert into usuario(";
            dml = dml + " idusu";
            dml = dml + ",usuario_idusu";
//            dml = dml + ",codusu";
            dml = dml + ",apepatusu";
            dml = dml + ",apematusu";
            dml = dml + ",nomusu";
            dml = dml + ",genusu";
            dml = dml + ",edadusu";
            dml = dml + ",dirusu";
            dml = dml + ",estado";
            dml = dml + ",telefono";
            dml = dml + ",correo";
            dml = dml + ",imagen";
//            dml = dml + ",colegioprocusu";
            dml = dml + ",nick";
            dml = dml + ",pass";
            dml = dml + ",idrol";
            dml = dml + ") values (";
            dml = dml + "'"+obj.getIdUsu().toString()+"'";
            dml = dml + ",'4'";
//            dml = dml + ",'"+obj.getCodUsu()+"'";
            dml = dml + ",'"+obj.getApepatUsu()+"'";
            dml = dml + ",'"+obj.getApematUsu()+"'";
            dml = dml + ",'"+obj.getNomUsu()+"'";
            dml = dml + ",'"+obj.getGenUsu()+"'";
            dml = dml + ",'"+obj.getEdadUsu()+"'";
            dml = dml + ",'"+obj.getDirUsu()+"'";
            dml = dml + ",'HABILITADO'";
            dml = dml + ",'"+obj.getTelefono()+"'";
            dml = dml + ",'"+obj.getCorreo()+"'";
            dml = dml + ",'"+obj.getImagen()+"'";
//            dml = dml + ",'"+obj.getColProc()+"'";
            dml = dml + ",'"+obj.getNick()+"'";
            dml = dml + ",'"+obj.getPass()+"'";
            dml = dml + ",'3'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);                     
        } catch (Exception e) {
            throw e;
        }
    }
    
    // REGISTRAR DIRECTOR
    public void RegistrarUsuarioDirector(Usuario obj) throws Exception{
        try {
            obj.setIdUsu(getId());
            
            String dml = "insert into usuario(";
            dml = dml + " idusu";
            dml = dml + ",usuario_idusu";
//            dml = dml + ",codusu";
            dml = dml + ",apepatusu";
            dml = dml + ",apematusu";
            dml = dml + ",nomusu";
            dml = dml + ",genusu";
            dml = dml + ",edadusu";
            dml = dml + ",dirusu";
            dml = dml + ",estado";
            dml = dml + ",telefono";
            dml = dml + ",correo";
            dml = dml + ",imagen";
//            dml = dml + ",colegioprocusu";
            dml = dml + ",nick";
            dml = dml + ",pass";
            dml = dml + ",idrol";
            dml = dml + ") values (";
            dml = dml + "'"+obj.getIdUsu().toString()+"'";
            dml = dml + ",'1'";
//            dml = dml + ",'"+obj.getCodUsu()+"'";
            dml = dml + ",'"+obj.getApepatUsu()+"'";
            dml = dml + ",'"+obj.getApematUsu()+"'";
            dml = dml + ",'"+obj.getNomUsu()+"'";
            dml = dml + ",'"+obj.getGenUsu()+"'";
            dml = dml + ",'"+obj.getEdadUsu()+"'";
            dml = dml + ",'"+obj.getDirUsu()+"'";
            dml = dml + ",'HABILITADO'";
            dml = dml + ",'"+obj.getTelefono()+"'";
            dml = dml + ",'"+obj.getCorreo()+"'";
            dml = dml + ",'"+obj.getImagen()+"'";
//            dml = dml + ",'"+obj.getColProc()+"'";
            dml = dml + ",'"+obj.getNick()+"'";
            dml = dml + ",'"+obj.getPass()+"'";
            dml = dml + ",'5'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);                     
        } catch (Exception e) {
            throw e;
        }
    }
    
    // REGISTRAR SECRETARIA
    public void RegistrarUsuarioSecretaria(Usuario obj) throws Exception{
        try {
            obj.setIdUsu(getId());
            
            String dml = "insert into usuario(";
            dml = dml + " idusu";
            dml = dml + ",usuario_idusu";
//            dml = dml + ",codusu";
            dml = dml + ",apepatusu";
            dml = dml + ",apematusu";
            dml = dml + ",nomusu";
            dml = dml + ",genusu";
            dml = dml + ",edadusu";
            dml = dml + ",dirusu";
            dml = dml + ",estado";
            dml = dml + ",telefono";
            dml = dml + ",correo";
            dml = dml + ",imagen";
//            dml = dml + ",colegioprocusu";
            dml = dml + ",nick";
            dml = dml + ",pass";
            dml = dml + ",idrol";
            dml = dml + ") values (";
            dml = dml + "'"+obj.getIdUsu().toString()+"'";
            dml = dml + ",'5'";
//            dml = dml + ",'"+obj.getCodUsu()+"'";
            dml = dml + ",'"+obj.getApepatUsu()+"'";
            dml = dml + ",'"+obj.getApematUsu()+"'";
            dml = dml + ",'"+obj.getNomUsu()+"'";
            dml = dml + ",'"+obj.getGenUsu()+"'";
            dml = dml + ",'"+obj.getEdadUsu()+"'";
            dml = dml + ",'"+obj.getDirUsu()+"'";
            dml = dml + ",'HABILITADO'";
            dml = dml + ",'"+obj.getTelefono()+"'";
            dml = dml + ",'"+obj.getCorreo()+"'";
            dml = dml + ",'"+obj.getImagen()+"'";
            dml = dml + ",'"+obj.getColProc()+"'";
            dml = dml + ",'"+obj.getNick()+"'";
            dml = dml + ",'"+obj.getPass()+"'";
            dml = dml + ",'4'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);                     
        } catch (Exception e) {
            throw e;
        }
    }
    
// MODIFICAR USUARIOS
    // MODIFICAR ALUMNO        
    public void ModificarAlumno(Usuario obj) throws Exception{
        try {
            String dml = "update usuario set";
            dml = dml + " usuario_idusu = '4'";
            dml = dml + ",codusu = '"+obj.getCodUsu()+"'";
            dml = dml + ",apepatusu = '"+obj.getApepatUsu()+"'";
            dml = dml + ",apematusu = '"+obj.getApematUsu()+"'";
            dml = dml + ",nomusu = '"+obj.getNomUsu()+"'";
            dml = dml + ",genusu = '"+obj.getGenUsu()+"'";
            dml = dml + ",edadusu = '"+obj.getEdadUsu()+"'";
            dml = dml + ",dirusu = '"+obj.getDirUsu()+"'";
            dml = dml + ",colegioprocusu = '"+obj.getColProc()+"'";
            dml = dml + ",nick = '"+obj.getNick()+"'";
            dml = dml + ",pass = '"+obj.getPass()+"'";
            dml = dml + ",idrol = '2'";
            dml = dml + ",estado = 'HABILITADO'";
            dml = dml + ",telefono = '"+obj.getTelefono()+"'";
            dml = dml + ",correo = '"+obj.getCorreo()+"'";
            dml = dml + ",imagen = '"+obj.getImagen()+"'";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"' and idrol = '2' and estado = 'HABILITADO' and usuario_idusuario='4'";
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);            
        } catch (Exception e) {
            throw e;
        }
    }
    
    // MODIFICAR PROFESOR      
    public void ModificarProfesor(Usuario obj) throws Exception{
        try {
            String dml = "update usuario set";
            dml = dml + " usuario_idusu = '4'";
            dml = dml + ",codusu = '"+obj.getCodUsu()+"'";
            dml = dml + ",apepatusu = '"+obj.getApepatUsu()+"'";
            dml = dml + ",apematusu = '"+obj.getApematUsu()+"'";
            dml = dml + ",nomusu = '"+obj.getNomUsu()+"'";
            dml = dml + ",genusu = '"+obj.getGenUsu()+"'";
            dml = dml + ",edadusu = '"+obj.getEdadUsu()+"'";
            dml = dml + ",dirusu = '"+obj.getDirUsu()+"'";
//            dml = dml + ",colegioprocusu = '"+obj.getColProc()+"'";
            dml = dml + ",nick = '"+obj.getNick()+"'";
            dml = dml + ",pass = '"+obj.getPass()+"'";
            dml = dml + ",idrol = '3'";
            dml = dml + ",estado = 'HABILITADO'";
            dml = dml + ",telefono = '"+obj.getTelefono()+"'";
            dml = dml + ",correo = '"+obj.getCorreo()+"'";
            dml = dml + ",imagen = '"+obj.getImagen()+"'";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"' and idrol = '3' and estado = 'HABILITADO' and usuario_idusuario='4'";
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);            
        } catch (Exception e) {
            throw e;
        }
    }
    
    // MODIFICAR DIRECTOR      
    public void ModificarDirector(Usuario obj) throws Exception{
        try {
            String dml = "update usuario set";
            dml = dml + " usuario_idusu = '1'";
            dml = dml + ",codusu = '"+obj.getCodUsu()+"'";
            dml = dml + ",apepatusu = '"+obj.getApepatUsu()+"'";
            dml = dml + ",apematusu = '"+obj.getApematUsu()+"'";
            dml = dml + ",nomusu = '"+obj.getNomUsu()+"'";
            dml = dml + ",genusu = '"+obj.getGenUsu()+"'";
            dml = dml + ",edadusu = '"+obj.getEdadUsu()+"'";
            dml = dml + ",dirusu = '"+obj.getDirUsu()+"'";
//            dml = dml + ",colegioprocusu = '"+obj.getColProc()+"'";
            dml = dml + ",nick = '"+obj.getNick()+"'";
            dml = dml + ",pass = '"+obj.getPass()+"'";
            dml = dml + ",idrol = '5'";
            dml = dml + ",estado = 'HABILITADO'";
            dml = dml + ",telefono = '"+obj.getTelefono()+"'";
            dml = dml + ",correo = '"+obj.getCorreo()+"'";
            dml = dml + ",imagen = '"+obj.getImagen()+"'";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"' and idrol = '5' and estado = 'HABILITADO' and usuario_idusuario='1'";
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);            
        } catch (Exception e) {
            throw e;
        }
    }
    
    // MODIFICAR SECRETARIA    
    public void ModificarSecretaria(Usuario obj) throws Exception{
        try {
            String dml = "update usuario set";
            dml = dml + " usuario_idusu = '5'";
            dml = dml + ",codusu = '"+obj.getCodUsu()+"'";
            dml = dml + ",apepatusu = '"+obj.getApepatUsu()+"'";
            dml = dml + ",apematusu = '"+obj.getApematUsu()+"'";
            dml = dml + ",nomusu = '"+obj.getNomUsu()+"'";
            dml = dml + ",genusu = '"+obj.getGenUsu()+"'";
            dml = dml + ",edadusu = '"+obj.getEdadUsu()+"'";
            dml = dml + ",dirusu = '"+obj.getDirUsu()+"'";
//            dml = dml + ",colegioprocusu = '"+obj.getColProc()+"'";
            dml = dml + ",nick = '"+obj.getNick()+"'";
            dml = dml + ",pass = '"+obj.getPass()+"'";
            dml = dml + ",idrol = '4'";
            dml = dml + ",estado = 'HABILITADO'";
            dml = dml + ",telefono = '"+obj.getTelefono()+"'";
            dml = dml + ",correo = '"+obj.getCorreo()+"'";
            dml = dml + ",imagen = '"+obj.getImagen()+"'";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"' and idrol = '4' and estado = 'HABILITADO' and usuario_idusuario='5'";
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);            
        } catch (Exception e) {
            throw e;
        }
    }
// ELIMINAR USUARIOS    
    public void EliminarAlumno(Usuario obj) throws Exception{
        try {
            String dml = "delete from usuario";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"'";
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
}
