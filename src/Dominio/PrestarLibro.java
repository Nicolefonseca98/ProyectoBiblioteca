package Dominio;

import javafx.beans.property.SimpleStringProperty;

public class PrestarLibro {
    
   private SimpleStringProperty titulo;
   private SimpleStringProperty usuario;
   private SimpleStringProperty fechaPrestamo;
   private SimpleStringProperty fechaRetorno;

    @Override
    public String toString() {
        return "PrestarLibro{" + "titulo=" + titulo + ", usuario=" + usuario + ", fechaPrestamo=" + fechaPrestamo + ", fechaRetorno=" + fechaRetorno + '}';
    }

    public PrestarLibro(String titulo, String usuario, String fechaPrestamo, String fechaRetorno) {
        this.titulo = new SimpleStringProperty(titulo);
        this.usuario = new SimpleStringProperty(usuario);
        this.fechaPrestamo = new SimpleStringProperty(fechaPrestamo);
        this.fechaRetorno = new SimpleStringProperty (fechaRetorno);
    }
    public PrestarLibro() {
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo.get();
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = new SimpleStringProperty (titulo);
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
     * @return the fechaPrestamo
     */
    public String getFechaPrestamo() {
        return fechaPrestamo.get();
    }

    /**
     * @param fechaPrestamo the fechaPrestamo to set
     */
    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = new SimpleStringProperty (fechaPrestamo);
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
        this.fechaRetorno = new SimpleStringProperty(fechaRetorno);
    }

    /**
     * @return the numeroPrestamo
     */
   
}
