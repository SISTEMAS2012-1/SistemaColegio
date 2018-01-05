package SGC.Gestioncolegio.LogicaNegocios;

import Conector.Conexion;
import SGC.Gestioncolegio.AccesoDatos.UsuarioAD;
import SGC.Gestioncolegio.Entidades.Usuario;
import java.util.List;

public class UsuarioLN {
    private static String user;
    private static String pass;
    
    public Usuario ConsultarUsuario(Usuario usuario) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            Usuario usuarioEncontrado = usuarioAD.ConsultarUsuario(usuario);
            
            return usuarioEncontrado;
        } catch (Exception e) {
            throw e;
        } finally {
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public Usuario ConsultarUsuariosAlumnos(Integer id) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            Usuario usuario = usuarioAD.ConsultarUsuario(id);
            
            return usuario;
        } catch (Exception e) {
            throw e;
        } finally {
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public List<Usuario> ConsultarUsuariosAlumnos(String nombre) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            List<Usuario> lstUsuarios = usuarioAD.ConsultarUsuarioAlumno(nombre);
            
            return lstUsuarios;
        } catch (Exception e) {
            throw e;
        } finally {
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public List<Usuario> ConsultarUsuariosProfesor(String nombre) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            List<Usuario> lstUsuarios = usuarioAD.ConsultarUsuarioProfesor(nombre);
            
            return lstUsuarios;
        } catch (Exception e) {
            throw e;
        } finally {
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public Usuario ConsultarUsuario(String nick,String pass) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            Usuario usuarioEncontrado = usuarioAD.ValidarLogin(nick, pass);
            
            return usuarioEncontrado;
        } catch (Exception e) {
            throw e;
        } finally {
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public void RegistrarUsuarioAlumno(Usuario usuario) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            usuarioAD.RegistrarUsuarioAlumno(usuario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarUsuarioProfesor(Usuario usuario) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            usuarioAD.RegistrarUsuarioProfesor(usuario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarSecretaria(Usuario usuario) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            usuarioAD.RegistrarUsuarioSecretaria(usuario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void RegistrarDirector(Usuario usuario) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            usuarioAD.RegistrarUsuarioDirector(usuario);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ModificarUsuarioAlumno(Usuario usuario) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            usuarioAD.ModificarAlumno(usuario);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    public void ModificarUsuarioProfesor(Usuario usuario) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            usuarioAD.ModificarProfesor(usuario);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    public void ModificarUsuarioSecretaria(Usuario usuario) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            usuarioAD.ModificarSecretaria(usuario);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    public void ModificarUsuarioDirector(Usuario usuario) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            usuarioAD.ModificarDirector(usuario);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    public void EliminarUsuarioAlumno(Usuario usuario) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            usuarioAD.EliminarAlumno(usuario);
        } catch (Exception e) {
            throw e;
        }        
    }

    public static String getUser() {
        return user;
    }
    
    public static String getPass() {
        return pass;
    }

    public static void setUser(String usuario, String clave) {
        user = usuario;
        pass = clave;
    }
}
