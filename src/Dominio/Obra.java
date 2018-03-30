
package Dominio;

import javafx.beans.property.SimpleStringProperty;

public class Obra {
    
    private SimpleStringProperty titulo;
    private SimpleStringProperty fechaIngreso;
    private SimpleStringProperty autor;

    public Obra() {
    }

    public Obra(String titulo, String fechaIngreso, String autor) {
        this.titulo = new SimpleStringProperty (titulo);
        this.fechaIngreso = new SimpleStringProperty (fechaIngreso);
        this.autor = new SimpleStringProperty (autor);
    }

    public String getTitulo() {
        return titulo.get();
    }

    public void setTitulo(String titulo) {
        this.titulo = new SimpleStringProperty (titulo);
    }

    public String getFechaIngreso() {
        return fechaIngreso.get();
    }

    
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = new SimpleStringProperty (fechaIngreso);
    }
 
    public String getAutor() {
        return autor.get();
    }

    public void setAutor(String autor) {
        this.autor = new SimpleStringProperty (autor);
    }

    @Override
    public String toString() {
        return "Obra{" + "titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + ", autor=" + autor + '}';
    }

    
}
