
package Dominio;

import javafx.beans.property.SimpleStringProperty;

public class UsuarioLogin {

    private SimpleStringProperty nombreUsuario;

    public UsuarioLogin(String nombreUsuario) {
        this.nombreUsuario = new SimpleStringProperty (nombreUsuario);
    }

    public UsuarioLogin() {
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario.get();
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = new SimpleStringProperty (nombreUsuario);
    }

    @Override
    public String toString() {
        return "UsuarioLogin{" + "nombreUsuario=" + nombreUsuario + '}';
    }
    
}
