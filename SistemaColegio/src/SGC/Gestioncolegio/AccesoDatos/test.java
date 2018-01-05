package SGC.Gestioncolegio.AccesoDatos;

import Conector.Conexion;
import SGC.Gestioncolegio.Entidades.Usuario;
import SGC.Gestioncolegio.LogicaNegocios.UsuarioLN;

public class test {
    public static void main(String[] args) {
        try {
            Conexion con = new Conexion();
            UsuarioLN usuarioLN = new UsuarioLN();
            UsuarioAD usuarioAD = new UsuarioAD(con.getConnection());
            Usuario usuario = new Usuario();
            Integer id = 25;
            String nombre = "JUAN CARLOS";
            usuario.setIdUsu(id);            
            usuario.setNomUsu(nombre);
//            System.out.println(usuario.getNomUsu());
            usuarioLN.ModificarUsuarioAlumno(usuario);
            System.out.println("Usuario modificado correctamente");
            
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
}
