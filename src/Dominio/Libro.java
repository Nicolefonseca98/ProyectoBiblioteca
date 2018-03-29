
package Dominio;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.DatePicker;


public class Libro extends Obra{
    
    private SimpleStringProperty isbn;
    private SimpleStringProperty tema;
    private SimpleStringProperty subtema;

    public Libro(SimpleStringProperty isbn, SimpleStringProperty tema, SimpleStringProperty subtema) {
        this.isbn = isbn;
        this.tema = tema;
        this.subtema = subtema;
    }

    public Libro(SimpleStringProperty isbn, SimpleStringProperty tema, SimpleStringProperty subtema, SimpleStringProperty titulo, DatePicker fechaIngreso, SimpleStringProperty autor) {
        super(titulo, fechaIngreso, autor);
        this.isbn = isbn;
        this.tema = tema;
        this.subtema = subtema;
    }

    public SimpleStringProperty getIsbn() {
        return isbn;
    }

    public void setIsbn(SimpleStringProperty isbn) {
        this.isbn = isbn;
    }

    public SimpleStringProperty getTema() {
        return tema;
    }

    public void setTema(SimpleStringProperty tema) {
        this.tema = tema;
    }

    public SimpleStringProperty getSubtema() {
        return subtema;
    }

 
    public void setSubtema(SimpleStringProperty subtema) {
        this.subtema = subtema;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", tema=" + tema + ", subtema=" + subtema + '}';
    }
    
}
