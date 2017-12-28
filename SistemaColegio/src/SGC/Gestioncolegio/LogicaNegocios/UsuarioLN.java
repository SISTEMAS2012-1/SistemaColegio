package SGC.Gestioncolegio.LogicaNegocios;

import Conector.Conexion;
import SGC.Gestioncolegio.AccesoDatos.UsuarioAD;
import SGC.Gestioncolegio.Entidades.Rol;
import SGC.Gestioncolegio.Entidades.Usuario;
import java.util.List;

public class UsuarioLN {
    public Usuario ConsultarUsuario(String nick,String pass,Rol rol) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            UsuarioAD usuarioAD = new UsuarioAD(conexion.getConnection());
            Usuario usuarioEncontrado = usuarioAD.ValidarLogin(nick, pass, rol);
            
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
        
    }
}
