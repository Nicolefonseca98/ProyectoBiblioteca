
package proyectobiblioteca;

public class Bibliotecario extends Cliente{

    public Bibliotecario() {
    }

    public Bibliotecario(String nombreUnico, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion) {
        super(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion);
    }
    
}
