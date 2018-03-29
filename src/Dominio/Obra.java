
package Dominio;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.DatePicker;

public class Obra {
    
    private SimpleStringProperty titulo;
    private DatePicker fechaIngreso;
    private SimpleStringProperty autor;

    public Obra() {
    }

    public Obra(SimpleStringProperty titulo, DatePicker fechaIngreso, SimpleStringProperty autor) {
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
        this.autor = autor;
    }

    public SimpleStringProperty getTitulo() {
        return titulo;
    }

    public void setTitulo(SimpleStringProperty titulo) {
        this.titulo = titulo;
    }

    public DatePicker getFechaIngreso() {
        return fechaIngreso;
    }

    
    public void setFechaIngreso(DatePicker fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
 
    public SimpleStringProperty getAutor() {
        return autor;
    }

    public void setAutor(SimpleStringProperty autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Obra{" + "titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + ", autor=" + autor + '}';
    }

    
}
