
package Dominio;

import javafx.beans.property.SimpleStringProperty;

public class Cliente {
    
    private SimpleStringProperty nombreUnico;
    private SimpleStringProperty contraseña;
    private SimpleStringProperty nombreCompleto;
    private SimpleStringProperty tipoIdentificacion;
    private SimpleStringProperty identificacion;
    private SimpleStringProperty tipoUsuario;

    public Cliente() {
    }

    public Cliente(String nombreUnico, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion, String tipoUsuario) {
        this.nombreUnico =  new SimpleStringProperty(nombreUnico);
        this.contraseña =  new SimpleStringProperty(contraseña);
        this.nombreCompleto = new SimpleStringProperty (nombreCompleto);
        this.tipoIdentificacion =  new SimpleStringProperty(tipoIdentificacion);
        this.identificacion =  new SimpleStringProperty(identificacion);
        this.tipoUsuario =  new SimpleStringProperty(tipoUsuario);
    }

    public String getNombreUnico() {
        return nombreUnico.get();
    }

    public void setNombreUnico(String nombreUnico) {
        this.nombreUnico = new SimpleStringProperty(nombreUnico);
    }

    public String getContraseña() {
        return contraseña.get();
    }

    public void setContraseña(String contraseña) {
        this.contraseña = new SimpleStringProperty(contraseña);
    }

    public String getNombreCompleto() {
        return nombreCompleto.get();
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = new SimpleStringProperty(nombreCompleto);
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion.get();
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = new SimpleStringProperty(tipoIdentificacion);
    }

    public String getIdentificacion() {
        return identificacion.get();
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = new SimpleStringProperty(identificacion);
    }

    /**
     * @return the tipoUsuario
     */
    public String getTipoUsuario() {
        return tipoUsuario.get();
    }

    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = new SimpleStringProperty(tipoUsuario);
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombreUnico=" + nombreUnico + ", contrase\u00f1a=" + contraseña + ", nombreCompleto=" + nombreCompleto + ", tipoIdentificacion=" + tipoIdentificacion + ", identificacion=" + identificacion + ", tipoUsuario=" + tipoUsuario + '}';
    }
    
}
