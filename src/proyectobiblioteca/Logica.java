
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
import org.apache.commons.codec.digest.DigestUtils;

public class Logica extends Listas {
       /*
        * Verifica el tipo de usuario ingresado, dependiendo si es "Usuario", "Autor" o " "Bibliotecario"
        * agrega un nuevo usuario a la lista respectiva.
        */

    public void agregarUsuario(String nombreUnico, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion, String tipoUsuario) {

        String contraseñaEncriptada = DigestUtils.md5Hex(contraseña);
        if (tipoUsuario.equalsIgnoreCase("Usuario")) {

            Cliente c = new Usuario(nombreUnico, contraseñaEncriptada, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            clienteLista.add(c);

        } else if (tipoUsuario.equalsIgnoreCase("Autor")) {
            Cliente c = new Autor(nombreUnico, contraseñaEncriptada, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            clienteLista.add(c);

        } else if (tipoUsuario.equalsIgnoreCase("Bibliotecario")) {

            Cliente c = new Bibliotecario(nombreUnico, contraseñaEncriptada, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
            clienteLista.add(c);

        }
    }
    
    /*
    * Recibe como parámetro los datos a modificar, 
    * mediante un nuevo String codifica con la biblioteca de MD5
    * la contraseña nueva para actualizarla.
    */
    
    public void modificarUsuario(String nombreUsuario, String nuevoUsuario, String nuevaContraseña) {
        String contraseñaEncriptada = DigestUtils.md5Hex(nuevaContraseña);
        if (existeUsuario(nombreUsuario)) {

            Cliente nombreViejo = getCliente(nombreUsuario);
            Cliente contraseñaVieja = getCliente(nombreUsuario);
            nombreViejo.setNombreUnico(nuevoUsuario);
            contraseñaVieja.setContraseña(contraseñaEncriptada);

        }
    }
    /*
    *Método de tipo boolean que recibe como parámetro un nombre de usuario, 
    * recorre la lista cliente para verificar si este existe y retorna
    *un true, de caso contrario retorna un false.
    */
    public boolean existeUsuario(String nombreUsuario) {

        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            Cliente cl = (Cliente) clienteLista.get(i);
            String nombre = cl.getNombreUnico();
            if (nombre.equalsIgnoreCase(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }
    /*
    *Método de tipo Cliente, que retorna un cliente para los métodos de Borrar y modificar 
    */
    private Cliente getCliente(String nombreUsuario) {

        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            Cliente c = (Cliente) clienteLista.get(i);
            if (c.getNombreUnico().equalsIgnoreCase(nombreUsuario)) {
                return c;
            }
        }

        return null;
    }
    /*
    *Metodo que recibe como parámetro un nombre de usuario y
    * se encarga de removerlo de la lista Cliente
    */
    public void borrarUsuario(String nombreUsuario) {

        if (existeUsuario(nombreUsuario)) {
            Cliente c = (Cliente) getCliente(nombreUsuario);

            clienteLista.remove(c);
        }

    } 
    
    /*
    * Método que recibe como parámetros los atributos de obras y libro
    *para agregarlo a la lista Libro y Obra
    */
    public void agregarLibro(String titulo, String fechaIngreso, String autor, String isbn, String tema, String subtema) {

        Obra o = new Libro(isbn, tema, subtema, titulo, fechaIngreso, autor);
        libroLista.add(o);
        obraLista.add(o);

    }
    
    /*
    * Método que recibe como parámetros los atributos de obras y revista
    *para agregarlo a la lista Revista y Obra
    */
    public void agregarRevista(String titulo, String fechaIngreso, String autor, String issn, String edicion) {

        Obra o = new Revista(issn, edicion, titulo, fechaIngreso, autor);
        revistaLista.add(o);
        obraLista.add(o);

    }
    
    /*
    * Método que recibe como parámetros los atributos de obras y tesis
    *para agregarlo a la lista Tesis y Obra
    */
    public void agregarTesis(String titulo, String fechaIngreso, String autor, String resumen, String summary) {

        Obra o = new Tesis(resumen, summary, titulo, fechaIngreso, autor);
        tesisLista.add(o);
        obraLista.add(o);

    }
    
    /*
    * Método que recibe como parámetros los atributos de obras y periodico
    *para agregarlo a la lista Periodico y Obra
    */
    
    public void agregarPeriodico(String titulo, String fechaIngreso, String autor, String issn, String edicion, String fechapublicacion) {

        Obra o = new Periodico(issn, edicion, fechapublicacion, titulo, fechaIngreso, autor);
        periodicosLista.add(o);
        obraLista.add(o);

    }
    
    /*
    * Método que recibe como parámetros los atributos de obras y Memoria
    *para agregarlo a la lista Memoria y Obra
    */
    
    public void agregarMemoria(String titulo, String fechaIngreso, String autor, String resumen, String summary, String conferencia) {

        Obra o = new Memoria(resumen, summary, conferencia, titulo, fechaIngreso, autor);
        memoriasLista.add(o);
        obraLista.add(o);

    }
    
    /*
    * Método Boolean que recibe como parámetro el nombre de una obra,
    * recorre la lista de Obras y si esta existe retorna un true, de caso
    * contrario retorna un false.
    */
    
    public boolean buscarObra(String nombreObra) {

        for (int i = 0; i <= obraLista.size() - 1; i++) {
            Obra o = (Obra) obraLista.get(i);
            String titulo = o.getTitulo();
            if (titulo.equalsIgnoreCase(nombreObra)) {
                return true;
            }
        }
        return false;
    }
    
    /*
    * Método que recibe como parámetro el título de una obra
    * y la retorna para modificarObra o borrarObra
  */
    private Obra getObra(String titulo) {

        for (int i = 0; i <= obraLista.size() - 1; i++) {
            Obra obra = (Obra) obraLista.get(i);
            if (obra.getTitulo().equalsIgnoreCase(titulo)) {
                return obra;
            }
        }
        return null;
    }

    /*
    * Método que recibe como parámetros los nuevos atributos que se le van a asignar a una obra en específico,
    * busca una obra por su título y la modifica.
  */
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
    
    /*
    *Método que recibe como parámetro el nombre de una obra,
    * recorre la lista Obra y retorna true si este existe o en caso contrario false.
    */
    public boolean existeObra(String nombreObra) {

        for (int i = 0; i <= obraLista.size() - 1; i++) {
            Obra obra = (Obra) obraLista.get(i);
            String nombre = obra.getObra;
            if (nombre.equalsIgnoreCase(nombreObra)) {
                return true;
            }
        }
        return false;
    }
    
    /*
    *Método que recibe como parámetro el nombre de una obra,
    * y si se encuentra en la lista obra, la borra.
    */
    
    public void borrarObra(String nombreObra) {

        if (buscarObra(nombreObra)) {
            Obra obra = (Obra) getObra(nombreObra);

            obraLista.remove(obra);
            libroLista.remove(obra);
        }
    }
    
      /*  
      * Método que recibe como parámetro el nombre de usuario, contraseña y el tipo de usuario,
      * verifica que estos datos coincidan con los de la lista Cliente para permitir el ingreso al 
      * sistema, de lo contrario el acceso es denegado.
      */
    public boolean verificaUsuario(String nombreUsuario, String contraseña, String tipoUsuario) {

        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            Cliente c = (Cliente) clienteLista.get(i);
            if ((c.getNombreUnico().equalsIgnoreCase(nombreUsuario)) && (c.getContraseña().equals(contraseña)) && c.getTipoUsuario().equalsIgnoreCase(tipoUsuario)) {
                return true;
            }
        }
        return false;
    }
      
      /* 
      * Método que recibe como parámetro el usuario, verifica si este se encuentra en la lista de usuarios
      * mororos y si es así retorna un true, de caso contrario un false.
      */
    public boolean borrarMoroso(String usuario) {
        boolean moroso = false;
        for (int i = 0; i <= usuariosMorosos.size() - 1; i++) {
            if (usuariosMorosos.get(i).getUsuario().equals(usuario)) {
                moroso = true;
            }
        }
        return moroso;
    }

}
