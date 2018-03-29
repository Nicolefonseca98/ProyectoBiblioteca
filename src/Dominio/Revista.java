
package Dominio;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.DatePicker;

public class Revista extends Obra{
    
    private SimpleStringProperty issn;
    private SimpleStringProperty edición;

    public Revista(SimpleStringProperty issn, SimpleStringProperty edición) {
        this.issn = issn;
        this.edición = edición;
    }

    public Revista(SimpleStringProperty issn, SimpleStringProperty edición, SimpleStringProperty titulo, DatePicker fechaIngreso, SimpleStringProperty autor) {
        super(titulo, fechaIngreso, autor);
        this.issn = issn;
        this.edición = edición;
    }

    public SimpleStringProperty getIssn() {
        return issn;
    }

 
    public void setIssn(SimpleStringProperty issn) {
        this.issn = issn;
    }

    public SimpleStringProperty getEdición() {
        return edición;
    }

    public void setEdición(SimpleStringProperty edición) {
        this.edición = edición;
    }

    @Override
    public String toString() {
        return "Revista{" + "issn=" + issn + ", edici\u00f3n=" + edición + '}';
    }
    
}
