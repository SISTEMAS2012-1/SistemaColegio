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
            String sql = "select nextval('usuario_idusu_seq') as idusu;";
            
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
//Consultar Usuario por Rol
    public Usuario ConsultarUsuario(String nombre) throws Exception{
        try {
            String sql = "select * from usuario ";
            sql = sql+ " where ";
            sql = sql + "nomusu like '"+nombre+"%'";
            sql = sql + ";";
            Usuario obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while(rs.next()){
                obj = new Usuario();
                
                obj.setIdUsu(rs.getInt("idusu"));
                obj.setCodUsu(rs.getString("codusu"));
                obj.setNomUsu(rs.getString("nomusu"));
                obj.setApepatUsu(rs.getString("apepatusu"));
                obj.setApematUsu(rs.getString("apematusu"));
                obj.setRol(rs.getString("rol"));
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
//Consultar Usuario a Ingresar    
    public Usuario ValidarLogin(String nick, String pass) throws Exception{
        try {
            String sql = "select * from usuario";
            sql = sql + " where";
            sql = sql + " nick = '"+nick+"'";
            sql = sql + " and pass = '"+pass+"'";
//            sql = sql + " and rol = '"+rol+"'";
            sql = sql + " ;";
            
            Usuario obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while(rs.next()){
                obj = new Usuario();
                
                obj.setIdUsu(rs.getInt("idusu"));
                obj.setCodUsu(rs.getString("codusu"));
                obj.setApepatUsu(rs.getString("apepatusu"));
                obj.setApematUsu(rs.getString("apematusu"));
                obj.setNomUsu(rs.getString("nomusu"));                                                
                obj.setNick(rs.getString("nick"));
                obj.setPass(rs.getString("pass"));
                obj.setRol(rs.getString("rol"));
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
            dml = dml + ",rol";
            dml = dml + ") values (";
            dml = dml + "'"+obj.getIdUsu().toString()+"'";
            dml = dml + ",'SECRETARIA'";
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
            dml = dml + ",'ALUMNO'";
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
            dml = dml + ",'SECRETARIA'";
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
            dml = dml + ",'PROFESOR'";
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
            dml = dml + ",'DIRECTOR'";
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
            dml = dml + ",'DIRECTOR'";
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
            dml = dml + ",'SECRETARIA'";
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
            dml = dml + " usuario_idusu = 'SECRETARIA'";
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
            dml = dml + ",idrol = 'ALUMNO'";
            dml = dml + ",estado = 'HABILITADO'";
            dml = dml + ",telefono = '"+obj.getTelefono()+"'";
            dml = dml + ",correo = '"+obj.getCorreo()+"'";
            dml = dml + ",imagen = '"+obj.getImagen()+"'";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"' and idrol = 'ALUMNO' and estado = 'HABILITADO' and usuario_idusuario='SECRETARIA'";
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
            dml = dml + " usuario_idusu = 'SECRETARIA'";
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
            dml = dml + ",idrol = 'PROFESOR'";
            dml = dml + ",estado = 'HABILITADO'";
            dml = dml + ",telefono = '"+obj.getTelefono()+"'";
            dml = dml + ",correo = '"+obj.getCorreo()+"'";
            dml = dml + ",imagen = '"+obj.getImagen()+"'";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"' and idrol = 'PROFESOR' and estado = 'HABILITADO' and usuario_idusuario='SECRETARIA'";
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
            dml = dml + ",idrol = 'DIRECTOR'";
            dml = dml + ",estado = 'HABILITADO'";
            dml = dml + ",telefono = '"+obj.getTelefono()+"'";
            dml = dml + ",correo = '"+obj.getCorreo()+"'";
            dml = dml + ",imagen = '"+obj.getImagen()+"'";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"' and idrol = 'DIRECTOR' and estado = 'HABILITADO' and usuario_idusuario='1'";
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
            dml = dml + " usuario_idusu = 'DIRECTOR'";
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
            dml = dml + ",idrol = 'SECRETARIA'";
            dml = dml + ",estado = 'HABILITADO'";
            dml = dml + ",telefono = '"+obj.getTelefono()+"'";
            dml = dml + ",correo = '"+obj.getCorreo()+"'";
            dml = dml + ",imagen = '"+obj.getImagen()+"'";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"' and idrol = 'SECRETARIA' and estado = 'HABILITADO' and usuario_idusuario='DIRECTOR'";
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
