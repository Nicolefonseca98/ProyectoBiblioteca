
package proyectobiblioteca;

import java.util.ArrayList;
import java.util.List;


public class Logica {
    
    //Listas de cada tipo de usuario
    List<Usuario> listaUsuario = new ArrayList<Usuario>();
    List<Bibliotecario> listaBibliotecario = new ArrayList<Bibliotecario>();
    List<Autor> listaAutor = new ArrayList<Autor>();
    List<Cliente> listaCliente = new ArrayList<Cliente>();
    
    
    public void agregarUsuario(String nombreUnico, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion, String tipoUsuario) {
        
        /*
        * Cada condición compara el tipo de usuario que se ingresa 
        * y lo guarda en su lista respectiva
        */
        
        if (tipoUsuario.equalsIgnoreCase("Usuario")){
            Usuario u = new Usuario(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            listaUsuario.add(u);
            
        }
        else if(tipoUsuario.equalsIgnoreCase("Autor")) {
            Autor a = new Autor(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            listaAutor.add(a);
            
        }
        else if(tipoUsuario.equalsIgnoreCase("Bibliotecario")) {
            Bibliotecario b = new Bibliotecario(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            listaBibliotecario.add(b);
            
        }
        
        /*
        * Agrega cada lista a la lista general
        * ListaCliente
        */
        listaCliente.addAll(listaUsuario);
        listaCliente.addAll(listaAutor);
        listaCliente.addAll(listaBibliotecario);
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
