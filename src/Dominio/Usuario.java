package Dominio;


public class Usuario extends Cliente{

    public Usuario() {
    }

    public Usuario(String nombreUnico, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion, String tipoUsuario) {
        super(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
    }

    
    
}
