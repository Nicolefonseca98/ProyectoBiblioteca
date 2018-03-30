
package Dominio;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.DatePicker;


public class Libro extends Obra{
    
    private SimpleStringProperty isbn;
    private SimpleStringProperty tema;
    private SimpleStringProperty subtema;


    public Libro(String isbn, String tema, String subtema, String titulo, String fechaIngreso, String autor) {
        super(titulo, fechaIngreso, autor);
        this.isbn = new SimpleStringProperty (isbn);
        this.tema = new SimpleStringProperty (tema);
        this.subtema = new SimpleStringProperty (subtema);
    }

    public String getIsbn() {
        return isbn.get();
    }

    public void setIsbn(String isbn) {
        this.isbn = new SimpleStringProperty (isbn);
    }

    public String getTema() {
        return tema.get();
    }

    public void setTema(String tema) {
        this.tema = new SimpleStringProperty (tema);
    }

    public String getSubtema() {
        return subtema.get();
    }

 
    public void setSubtema(String subtema) {
        this.subtema = new SimpleStringProperty (subtema);
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", tema=" + tema + ", subtema=" + subtema + '}';
    }
    
}
