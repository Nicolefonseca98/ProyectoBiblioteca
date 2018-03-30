
package proyectobiblioteca;

import Dominio.Cliente;
import Dominio.Bibliotecario;
import Dominio.Autor;
import Dominio.Libro;
import Dominio.Memoria;
import Dominio.Obra;
import Dominio.Periodico;
import Dominio.Revista;
import Dominio.Tesis;
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
 
    public void agregarObra(String titulo, String fechaIngreso, String autor, String isbn, String tema, String subtema, String issn, String edición,
                            String resumen, String summary, String fechaPublicación, String conferencia, String tipoObra) {
        
        if (tipoObra.equalsIgnoreCase("Libro")){
            Obra o = new Libro(isbn, tema, subtema, titulo, fechaIngreso, autor);
            libroLista.add(o);
            
        }
        else if(tipoObra.equalsIgnoreCase("Revista")) {
            Obra o = new Revista(issn, edición, titulo, fechaIngreso, autor);
            revistaLista.add(o);
            
        }
        else if(tipoObra.equalsIgnoreCase("Tesis")) {
            Obra o = new Tesis(resumen, summary, titulo, fechaIngreso, autor);
            tesisLista.add(o);
        }
        else if(tipoObra.equalsIgnoreCase("Periódico")) {
            Obra o = new Periodico(issn, edición, fechaPublicación, titulo, fechaIngreso, autor);
            periodicosLista.add(o);
        }
        else if(tipoObra.equalsIgnoreCase("Memoria")) {
            Obra o = new Memoria(resumen, summary, conferencia, titulo, fechaIngreso, autor);
            memoriasLista.add(o);
        }
        
        System.out.println(libroLista.toString());
        System.out.println(revistaLista.toString()); 
        System.out.println(tesisLista.toString()); 
        System.out.println(periodicosLista.toString()); 
        System.out.println(memoriasLista.toString()); 
     
    }
    
}
