package Configuracion;

import java.util.ResourceBundle;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.Preferences;

public class Registro {
    private static ResourceBundle configuracionEstatica = ResourceBundle.getBundle("Configuracion.Variables");
    private static Preferences configuracionDinamica = Preferences.userRoot().node("/SGC");
    
    public static String getValor(String clave){
        String valor;
        
        if(!configuracionDinamica.get(clave,"").isEmpty()){
            valor = configuracionDinamica.get(clave, "");
        }else{
            valor = configuracionEstatica.getString(clave +  "_defecto");
        }
        return valor;
    }
    
    public static void setValor(String clave, String valor){
        configuracionDinamica.put(clave, valor);
    }
}
