package Dominio;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

public class PrestarLibro {
    
   private SimpleStringProperty titulo;
   private SimpleStringProperty usuario;
   private LocalDate fechaPrestamo;
   private LocalDate fechaRetorno;

    @Override
    public String toString() {
        return "PrestarLibro{" + "titulo=" + titulo + ", usuario=" + usuario + ", fechaPrestamo=" + fechaPrestamo + ", fechaRetorno=" + fechaRetorno + '}';
    }

    public PrestarLibro(String titulo, String usuario, LocalDate fechaPrestamo, LocalDate fechaRetorno) {
        this.titulo = new SimpleStringProperty(titulo);
        this.usuario = new SimpleStringProperty(usuario);
        this.fechaPrestamo = fechaPrestamo;
        this.fechaRetorno = fechaRetorno;
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
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * @param fechaPrestamo the fechaPrestamo to set
     */
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * @return the fechaRetorno
     */
    public LocalDate getFechaRetorno() {
        return fechaRetorno;
    }

    /**
     * @param fechaRetorno the fechaRetorno to set
     */
    public void setFechaRetorno(LocalDate fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    /**
     * @return the numeroPrestamo
     */
   
}
