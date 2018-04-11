
package proyectobiblioteca;

import Dominio.Cliente;
import Dominio.Bibliotecario;
import Dominio.Autor;
import Dominio.Libro;
import Dominio.Memoria;
import Dominio.Obra;
import Dominio.Periodico;
import Dominio.PrestarLibro;
import Dominio.Revista;
import Dominio.Tesis;
import Dominio.Usuario;
import Listas.Listas;
import org.apache.commons.codec.digest.DigestUtils;

public class Logica extends Listas {
       
    public void agregarUsuario(String nombreUnico, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion, String tipoUsuario) {
     
        String contraseñaEncriptada = DigestUtils.md5Hex(contraseña);
        if (tipoUsuario.equalsIgnoreCase("Usuario")){
            
            Cliente c = new Usuario(nombreUnico, contraseñaEncriptada, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            clienteLista.add(c);
            
        }
        else if(tipoUsuario.equalsIgnoreCase("Autor")) {
            Cliente c = new Autor(nombreUnico, contraseñaEncriptada, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            clienteLista.add(c);
            
        }
        else if(tipoUsuario.equalsIgnoreCase("Bibliotecario")) {
            
            Cliente c = new Bibliotecario(nombreUnico, contraseñaEncriptada, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            clienteLista.add(c);
            
        }      
    }
    
    public void modificarUsuario(String nombreUsuario, String nuevoUsuario, String nuevaContraseña) {
        String contraseñaEncriptada = DigestUtils.md5Hex(nuevaContraseña);
        if (existeUsuario(nombreUsuario)) {
            
            Cliente nombreViejo = getCliente(nombreUsuario);
            Cliente contraseñaVieja = getCliente(nombreUsuario);
            nombreViejo.setNombreUnico(nuevoUsuario);
            contraseñaVieja.setContraseña(contraseñaEncriptada);
            
        } 
    }
    
    public boolean existeUsuario (String nombreUsuario) {
        
        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            Cliente cl = (Cliente) clienteLista.get(i);
            String nombre = cl.getNombreUnico();
            if (nombre.equalsIgnoreCase(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }
    
    private Cliente getCliente(String nombreUsuario) {
        
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
     
        
    } //Fin borrarUsuario()
 
    public void agregarLibro(String titulo, String fechaIngreso, String autor, String isbn, String tema, String subtema) {
        
        Obra o = new Libro(isbn, tema, subtema, titulo, fechaIngreso, autor);
        libroLista.add(o);
        obraLista.add(o);
      
    }
    
    public void agregarRevista(String titulo, String fechaIngreso, String autor, String issn, String edicion) {
        
        Obra o = new Revista(issn, edicion, titulo, fechaIngreso, autor);
        revistaLista.add(o);
        obraLista.add(o);
        
    }
    
    public void agregarTesis(String titulo, String fechaIngreso, String autor, String resumen, String summary) {
        
        Obra o = new Tesis(resumen, summary, titulo, fechaIngreso, autor);
        tesisLista.add(o);
        obraLista.add(o);
     
    }
    
    public void agregarPeriodico(String titulo, String fechaIngreso, String autor, String issn, String edicion, String fechapublicacion) {
        
        Obra o = new Periodico(issn, edicion, fechapublicacion, titulo, fechaIngreso, autor);
        periodicosLista.add(o);
        obraLista.add(o);
       
    }
    
    public void agregarMemoria(String titulo, String fechaIngreso, String autor, String resumen, String summary, String conferencia) {
        
        Obra o = new Memoria(resumen, summary, conferencia, titulo, fechaIngreso, autor);
        memoriasLista.add(o);
        obraLista.add(o);
        
    }
    
    public boolean buscarObra (String nombreObra) {
        
        for (int i = 0; i <= obraLista.size() - 1; i++) {
            Obra o = (Obra) obraLista.get(i);
            String titulo = o.getTitulo();
            if (titulo.equalsIgnoreCase(nombreObra)) {
                return true;
            }
        }
        return false;
    }
    
    private Obra getObra(String titulo) {
        
        for (int i = 0; i <= obraLista.size() - 1; i++) {
            Obra o = (Obra) obraLista.get(i);
            if (o.getTitulo().equalsIgnoreCase(titulo)) {
                return o;
            }
        }
        return null;
    }
    
    public void modificarObra(String titulo, String nuevoTitulo, String nuevoAutor, String nuevaFecha) {
        
        if (buscarObra(titulo)) {
            
            Obra tituloViejo = getObra(titulo);
            Obra autorViejo = getObra(titulo);
            Obra fechaVieja = getObra(titulo);
            
            tituloViejo.setTitulo(nuevoTitulo);
            autorViejo.setAutor(nuevoAutor);
            fechaVieja.setFechaIngreso(nuevaFecha);
            
        }    
    }
    
    public boolean existeObra (String nombreObra) {
        
        for (int i = 0; i <= obraLista.size() - 1; i++) {
            Obra o = (Obra) obraLista.get(i);
            String nombre = o.getObra;
            if (nombre.equalsIgnoreCase(nombreObra)) {
                return true;
            }
        }
        return false;
    }
    
      public void borrarObra(String nombreObra){

        if (buscarObra(nombreObra)) {
            Obra o = (Obra)getObra(nombreObra);

            obraLista.remove(o);
        }  
    } //Fin borrarObra()
    
      public boolean verificaUsuario(String nombreUsuario, String contraseña, String tipoUsuario) {
          
          for (int i = 0; i <= clienteLista.size() - 1; i++) {
            Cliente c = (Cliente) clienteLista.get(i);
            if ((c.getNombreUnico().equalsIgnoreCase(nombreUsuario)) && (c.getContraseña().equals(contraseña)) && c.getTipoUsuario().equalsIgnoreCase(tipoUsuario)){              
                return true;
            }
        }
          return false;
      }
      
      public boolean borrarMoroso(String usuario) {
          boolean moroso = false;
          for (int i = 0; i <= usuariosMorosos.size()-1; i++) {
              if (usuariosMorosos.get(i).getUsuario().equals(usuario)) {
                  moroso = true;
              } 
          }
          return moroso;
      }
    
}
