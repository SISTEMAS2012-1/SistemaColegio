package SGC.Gestioncolegio.AccesoDatos;

import Conector.Conexion;
import Conector.EntidadAD;

import SGC.Gestioncolegio.Entidades.Usuario;
import SGC.Gestioncolegio.Presentacion.Usuarios;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    public String getCodigo() throws Exception{
        try {
            String sql = "select lpad(cast(case when min(cast(codigo as integer)) is null then 1 else (min(cast(codigo as integer)) + 1) end as character varying),4,'0') as codigo from usuario";
//            String sql  = "select lpad(cast(case when max(cast(codigo as integer)) is null then 1 when (max(cast(codigo as integer)) + 1) is null then 2 else(min(cast(codigo as integer)) + 1) end as character varying),4,'0') as codigo from alumno";
            String codigo = "";
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                codigo = rs.getString("codigo");
                
                if(rs.wasNull()){
                    codigo = "0001";
                }
            }
            return codigo;
        } catch (Exception e) {
            throw e;
        }
            finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
        }
    }
    
//Consultar Usuario
    public Usuario ConsultarUsuario(Usuario usuario) throws Exception{
        try {
            String sql = "select ";
            sql = sql+ " idusu ";
            sql = sql+ " from usuario ";
            sql = sql + " where";
            sql = sql + " idusu <> " + (usuario.getIdUsu() == null?"0":usuario.getIdUsu().toString());
            sql = sql + " and (codusu = '"+ usuario.getCodUsu()+"'";
            sql = sql + " and apepatusu = '"+ usuario.getApepatUsu()+"'";
            sql = sql + " and apematusu = '"+ usuario.getApematUsu()+"'";
            sql = sql + " or nomusu = '"+ usuario.getApepatUsu()+"')";
            sql = sql + ";";
            Usuario obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while(rs.next()){
                obj = new Usuario();
                
                obj.setIdUsu(rs.getInt("idusu"));
                
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

    
//Generacion de Codigo del Alumno
    public String GenerarCodigo() throws Exception{
//        Usuarios ousuarios = new Usuarios();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String apepat = Usuarios.txtApepat.getText().trim().toUpperCase().substring(0,1);
        String cadena = "0" + year+ getCodigo() + apepat;
        return cadena;
    }    
//Consultar Usuario id
    public Usuario ConsultarUsuario(Integer id) throws Exception{
        try {
            String sql = "select ";            
            sql = sql + " idusu";
            sql = sql + ",codusu";
            sql = sql + ",apepatusu";
            sql = sql + ",apematusu";
            sql = sql + ",nomusu";
//            sql = sql + ",concat(apepatusu,' ',apematusu,' ',nomusu) as nomusu";
            sql = sql + ",genusu";
            sql = sql + ",edadusu";
            sql = sql + ",dirusu";
            sql = sql + ",colegioprocusu";
            sql = sql + ",nick";
            sql = sql + ",pass";
            sql = sql + ",telefono";
            sql = sql + ",correo";
            sql = sql + " from usuario ";
            sql = sql + " where ";
            sql = sql + " idusu = " + id.toString();
            sql = sql + ";";
            Usuario obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while(rs.next()){
                obj = new Usuario();
                
                obj.setIdUsu(rs.getInt("idusu"));
//                obj.setUsuario_IdUsu(rs.getString("usuario_idusu"));
                obj.setCodUsu(rs.getString("codusu"));                
                obj.setApepatUsu(rs.getString("apepatusu"));
                obj.setApematUsu(rs.getString("apematusu"));
                obj.setNomUsu(rs.getString("nomusu"));
                obj.setGenUsu(rs.getString("genusu"));
                obj.setEdadUsu(rs.getString("edadusu"));
                obj.setDirUsu(rs.getString("dirusu"));
                obj.setColProc(rs.getString("colegioprocusu"));
                obj.setNick(rs.getString("nick"));
                obj.setPass(rs.getString("pass"));
                obj.setTelefono(rs.getString("telefono"));
                obj.setCorreo(rs.getString("correo"));
                
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
//Consultar Usuario Alumno por Nombre
    public List<Usuario> ConsultarUsuarioAlumno(String nombre) throws Exception{
        try {
            String sql = "select ";
            sql = sql + " idusu";
            sql = sql + ",codusu";
            sql = sql + ",apepatusu";
            sql = sql + ",apematusu";
            sql = sql + ",nomusu";
//            sql = sql + ",concat(apepatusu,' ',apematusu,' ',nomusu) as nomusu";
            sql = sql + ",genusu";
            sql = sql + ",colegioprocusu";
            sql = sql + ",nick";
            sql = sql + ",pass";
            sql = sql + " from usuario ";
            sql = sql + " where ";
            sql = sql + " (apepatusu like '"+nombre+"%'"+" or nomusu like '"+nombre+"%') and rol='ALUMNO'";
            sql = sql + " order by";
            sql = sql + " nomusu asc";
            sql = sql + ";";
            
//            String sql = "select * from usuario where nomusu like '"+nombre+"%' and rol = 'ALUMNO' order by nomusu asc";
            List<Usuario> lista = new ArrayList<Usuario>();
            
            Usuario obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while(rs.next()){
                obj = new Usuario();
                
                obj.setIdUsu(rs.getInt("idusu"));
//                obj.setUsuario_IdUsu(rs.getString("usuario_idusu"));
                obj.setCodUsu(rs.getString("codusu"));                
                obj.setApepatUsu(rs.getString("apepatusu"));
                obj.setApematUsu(rs.getString("apematusu"));
                obj.setNomUsu(rs.getString("nomusu"));
                obj.setGenUsu(rs.getString("genusu"));
//                obj.setEdadUsu(rs.getString("edadusu"));
//                obj.setDirUsu(rs.getString("dirusu"));
                obj.setColProc(rs.getString("colegioprocusu"));
                obj.setNick(rs.getString("nick"));
                obj.setPass(rs.getString("pass"));
//                obj.setEstado(rs.getString("estado"));
//                obj.setTelefono(rs.getString("telefono"));
//                obj.setCorreo(rs.getString("correo"));
//                obj.setImagen(rs.getString("imagen"));
//                obj.setRol(rs.getString("rol"));
                
                lista.add(obj);
            }
            return lista;
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
    
//Consultar Usuario Profesor por Nombre
    public List<Usuario> ConsultarUsuarioProfesor(String nombre) throws Exception{
        try {
            String sql = "select ";
            sql = sql + " idusu";
            sql = sql + ",codusu";
            sql = sql + ",apepatusu";
            sql = sql + ",apematusu";
            sql = sql + ",nomusu";
//            sql = sql + ",concat(apepatusu, ,apematusu, ,nomusu) as nomusu";
            sql = sql + ",genusu";
//            sql = sql + ",colegioprocusu";
            sql = sql + ",nick";
            sql = sql + ",pass";
            sql = sql + " from usuario ";
            sql = sql + " where ";
            sql = sql + " (apepatusu like '"+nombre+"%'"+" or nomusu like '"+nombre+"%') and rol='PROFESOR'";
            sql = sql + " order by";
            sql = sql + " nomusu asc";
            sql = sql + ";";
            
//            String sql = "select * from usuario where nomusu like '"+nombre+"%' and rol = 'ALUMNO' order by nomusu asc";
            List<Usuario> lista = new ArrayList<Usuario>();
            
            Usuario obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while(rs.next()){
                obj = new Usuario();
                
                obj.setIdUsu(rs.getInt("idusu"));
//                obj.setUsuario_IdUsu(rs.getString("usuario_idusu"));
                obj.setCodUsu(rs.getString("codusu"));                
                obj.setApepatUsu(rs.getString("apepatusu"));
                obj.setApematUsu(rs.getString("apematusu"));
                obj.setNomUsu(rs.getString("nomusu"));
                obj.setGenUsu(rs.getString("genusu"));
//                obj.setEdadUsu(rs.getString("edadusu"));
//                obj.setDirUsu(rs.getString("dirusu"));
//                obj.setColProc(rs.getString("colegioprocusu"));
                obj.setNick(rs.getString("nick"));
                obj.setPass(rs.getString("pass"));
//                obj.setEstado(rs.getString("estado"));
//                obj.setTelefono(rs.getString("telefono"));
//                obj.setCorreo(rs.getString("correo"));
//                obj.setImagen(rs.getString("imagen"));
//                obj.setRol(rs.getString("rol"));
                
                lista.add(obj);
            }
            return lista;
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
                obj.setUsuario_IdUsu(rs.getString("usuario_idusu"));
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
            obj.setCodigo(getCodigo());
            obj.setCodUsu(GenerarCodigo());
            
            String dml = "insert into usuario(";
            dml = dml + " idusu";
            dml = dml + ",usuario_idusu";
            dml = dml + ",codigo";
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
            dml = dml + ",'"+obj.getCodigo()+"'";
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
//            dml = dml + ",'ALUMNO'";
            dml = dml + ",'"+obj.getRol()+"'";
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
            dml = dml + ",rol";
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
//            dml = dml + ",'PROFESOR'";
            dml = dml + ",'"+obj.getRol()+"'";
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
            dml = dml + ",rol";
            dml = dml + ") values (";
            dml = dml + "'"+obj.getIdUsu().toString()+"'";
            dml = dml + ",'ADMINISTRADOR'";
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
//            dml = dml + ",'DIRECTOR'";
            dml = dml + ",'"+obj.getRol()+"'";
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
            dml = dml + ",rol";
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
//            dml = dml + ",'"+obj.getColProc()+"'";
            dml = dml + ",'"+obj.getNick()+"'";
            dml = dml + ",'"+obj.getPass()+"'";
//            dml = dml + ",'SECRETARIA'";
            dml = dml + ",'"+obj.getRol()+"'";
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
            String dml = " update usuario set ";
            dml = dml + " usuario_idusu = 'SECRETARIA'";
//            dml = dml + ",codigo = '"+obj.getCodigo()+"'";
//            dml = dml + ",codusu = '"+obj.getCodUsu()+"'";
            dml = dml + ",apepatusu = '"+obj.getApepatUsu()+"'";
            dml = dml + ",apematusu = '"+obj.getApematUsu()+"'";
            dml = dml + ",nomusu = '"+obj.getNomUsu()+"'";
            dml = dml + ",genusu = '"+obj.getGenUsu()+"'";
            dml = dml + ",edadusu = '"+obj.getEdadUsu()+"'";
            dml = dml + ",dirusu = '"+obj.getDirUsu()+"'";
            dml = dml + ",colegioprocusu = '"+obj.getColProc()+"'";
            dml = dml + ",nick = '"+obj.getNick()+"'";
            dml = dml + ",pass = '"+obj.getPass()+"'";
            dml = dml + ",rol = 'ALUMNO'";
//            dml = dml + ",estado = 'HABILITADO'";
            dml = dml + ",telefono = '"+obj.getTelefono()+"'";
            dml = dml + ",correo = '"+obj.getCorreo()+"'";
            dml = dml + ",imagen = '"+obj.getImagen()+"'";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"' and rol = 'ALUMNO' and estado = 'HABILITADO' and usuario_idusu='SECRETARIA'";
            dml = dml + ";";
//              String dml = "update usuario set nomusu = '"+obj.getNomUsu()+"' where idusu='"+obj.getIdUsu().toString()+"' and rol = 'ALUMNO' and estado='HABILITADO' and usuario_idusu='SECRETARIA';";  
            
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
            dml = dml + ",rol = 'PROFESOR'";
            dml = dml + ",estado = 'HABILITADO'";
            dml = dml + ",telefono = '"+obj.getTelefono()+"'";
            dml = dml + ",correo = '"+obj.getCorreo()+"'";
            dml = dml + ",imagen = '"+obj.getImagen()+"'";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"' and rol = 'PROFESOR' and estado = 'HABILITADO' and usuario_idusuario='SECRETARIA'";
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
            dml = dml + " usuario_idusu = 'ADMINISTRADOR'";
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
            dml = dml + ",rol = 'DIRECTOR'";
            dml = dml + ",estado = 'HABILITADO'";
            dml = dml + ",telefono = '"+obj.getTelefono()+"'";
            dml = dml + ",correo = '"+obj.getCorreo()+"'";
            dml = dml + ",imagen = '"+obj.getImagen()+"'";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"' and rol = 'DIRECTOR' and estado = 'HABILITADO' and usuario_idusuario='ADMINISTRADOR'";
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
            dml = dml + ",rol = 'SECRETARIA'";
            dml = dml + ",estado = 'HABILITADO'";
            dml = dml + ",telefono = '"+obj.getTelefono()+"'";
            dml = dml + ",correo = '"+obj.getCorreo()+"'";
            dml = dml + ",imagen = '"+obj.getImagen()+"'";
            dml = dml + " where";
            dml = dml + " idusu = '"+obj.getIdUsu().toString()+"' and rol = 'SECRETARIA' and estado = 'HABILITADO' and usuario_idusuario='DIRECTOR'";
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
