package Dominio;

import javafx.beans.property.SimpleStringProperty;

public class UsuarioMoroso {
    
    private SimpleStringProperty usuario;
    private SimpleStringProperty libro;
    private SimpleStringProperty fechaRetorno;

    public UsuarioMoroso(String usuario, String libro, String fechaRetorno) {
        this.usuario = new SimpleStringProperty(usuario);
        this.libro = new SimpleStringProperty(libro);
        this.fechaRetorno = new SimpleStringProperty(fechaRetorno);
    }

    public UsuarioMoroso() {
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario.get();
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = new SimpleStringProperty (usuario);
    }

    /**
     * @return the libro
     */
    public String getLibro() {
        return libro.get();
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(String libro) {
        this.libro = new SimpleStringProperty (libro);
    }

    /**
     * @return the fechaRetorno
     */
    public String getFechaRetorno() {
        return fechaRetorno.get();
    }

    /**
     * @param fechaRetorno the fechaRetorno to set
     */
    public void setFechaRetorno(String fechaRetorno) {
        this.fechaRetorno = new SimpleStringProperty (fechaRetorno);
    }
      @Override
    public String toString() {
        return "UsuarioMoroso{" + "usuario=" + usuario + ", libro=" + libro + ", fechaRetorno=" + fechaRetorno + '}';
    }
    
}
