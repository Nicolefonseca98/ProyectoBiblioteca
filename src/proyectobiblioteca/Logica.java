
package proyectobiblioteca;

import java.util.ArrayList;
import java.util.List;


public class Logica {
    
    static List<Cliente> listaCliente = new ArrayList<Cliente>();
    
    
    public void agregarUsuario(String nombreUnico, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion, String tipoUsuario) {
        
        /*
        * Cada condición compara el tipo de usuario que se ingresa 
        * y lo guarda en la Lista listaCliente
        */
        
        if (tipoUsuario.equalsIgnoreCase("Usuario")){
            Cliente c = new Usuario(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            listaCliente.add(c);
            
        }
        else if(tipoUsuario.equalsIgnoreCase("Autor")) {
            Cliente c = new Autor(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            listaCliente.add(c);
            
        }
        else if(tipoUsuario.equalsIgnoreCase("Bibliotecario")) {
            Cliente c = new Bibliotecario(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            listaCliente.add(c);
            
        }
        
        System.out.println(listaCliente.toString()); 
               
    }
    
    public void modificarUsuario(String nombreUsuario, String nuevoUsuario, String nuevaContraseña) {
        
        if (existeUsuario(nombreUsuario)) {
            
            Cliente nombreViejo = getCliente(nombreUsuario);
            Cliente contraseñaVieja = getCliente(nombreUsuario);
            nombreViejo.setNombreUnico(nuevoUsuario);
            contraseñaVieja.setContraseña(nuevaContraseña);
            
        }
        
        System.out.println(listaCliente.toString());

    }
    
    public boolean existeUsuario(String nombreUsuario) {
        
        for (int i = 0; i <= listaCliente.size() - 1; i++) {
            Cliente cl = (Cliente) listaCliente.get(i);
            String nombre = cl.getNombreUnico();
            if (nombre.equalsIgnoreCase(nombreUsuario)) {
                return true;
            }
        }
        System.out.println(listaCliente.toString());
        return false;
        
    }
    
    public Cliente getCliente(String nombreUsuario) {
        for (int i = 0; i <= listaCliente.size() - 1; i++) {
            Cliente c = (Cliente) listaCliente.get(i);
            if (c.getNombreUnico().equalsIgnoreCase(nombreUsuario)) {
                return c;
            }
        }
        
        return null;
    }
    
}
