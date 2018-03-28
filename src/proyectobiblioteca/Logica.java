
package proyectobiblioteca;

import java.util.ArrayList;
import java.util.List;


public class Logica {
    
    public void agregarUsuario(String nombreUnico, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion) {
        
        Usuario u = new Usuario(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion);
        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        listaUsuario.add(u);
        
        System.out.println(listaUsuario.toString());
               
    }
    
}
