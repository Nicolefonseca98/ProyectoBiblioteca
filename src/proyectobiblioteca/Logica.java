
package proyectobiblioteca;

import Dominio.Cliente;
import Dominio.Bibliotecario;
import Dominio.Autor;
import Dominio.Usuario;
import Listas.Listas;


public class Logica extends Listas{
       
    
    public void agregarUsuario(String nombreUnico, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion, String tipoUsuario) {
        
        /*
        * Cada condición compara el tipo de usuario que se ingresa 
        * y lo guarda en la Lista listaCliente
        */
        
        if (tipoUsuario.equalsIgnoreCase("Usuario")){
            Cliente c = new Usuario(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            clienteLista.add(c);
            
        }
        else if(tipoUsuario.equalsIgnoreCase("Autor")) {
            Cliente c = new Autor(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            clienteLista.add(c);
            
        }
        else if(tipoUsuario.equalsIgnoreCase("Bibliotecario")) {
            Cliente c = new Bibliotecario(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            clienteLista.add(c);
            
        }
        
        System.out.println(clienteLista.toString()); 
     
    }
    
    public void modificarUsuario(String nombreUsuario, String nuevoUsuario, String nuevaContraseña) {
        
        if (existeUsuario(nombreUsuario)) {
            
            Cliente nombreViejo = getCliente(nombreUsuario);
            Cliente contraseñaVieja = getCliente(nombreUsuario);
            nombreViejo.setNombreUnico(nuevoUsuario);
            contraseñaVieja.setContraseña(nuevaContraseña);
            
        }
        
        System.out.println(clienteLista.toString());

    }
    
    public boolean existeUsuario (String nombreUsuario) {
        
        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            Cliente cl = (Cliente) clienteLista.get(i);
            String nombre = cl.getNombreUnico();
            if (nombre.equalsIgnoreCase(nombreUsuario)) {
                return true;
            }
        }
        System.out.println(clienteLista.toString());
        return false;
    }
    
    
    public Cliente getCliente(String nombreUsuario) {
        
        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            Cliente c = (Cliente) clienteLista.get(i);
            if (c.getNombreUnico().equalsIgnoreCase(nombreUsuario)) {
                return c;
            }
        }
        
        return null;
    }
    
    public void borrarUsuario(String nombreUsuario) {

        if (existeUsuario(nombreUsuario)) {
            Cliente c = (Cliente) getCliente(nombreUsuario);

            clienteLista.remove(c);
        }
        
        System.out.println(clienteLista.toString());
        
    } //Fin borrarUsuario()
 
}
