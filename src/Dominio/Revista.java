
package Dominio;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.DatePicker;

public class Revista extends Obra{
    
    private SimpleStringProperty issn;
    private SimpleStringProperty edición;


    public Revista(String issn, String edición, String titulo, String fechaIngreso, String autor) {
        super(titulo, fechaIngreso, autor);
        this.issn = new SimpleStringProperty (issn);
        this.edición = new SimpleStringProperty (edición);
    }

    public String getIssn() {
        return issn.get();
    }

 
    public void setIssn(String issn) {
        this.issn = new SimpleStringProperty (issn);
    }

    public String getEdición() {
        return edición.get();
    }

    public void setEdición(String edición) {
        this.edición = new SimpleStringProperty (edición);
    }

    @Override
    public String toString() {
        return "Revista{" + "issn=" + issn + ", edici\u00f3n=" + edición + " autor " + super.getAutor() + " titulo " + super.getTitulo() + " fecha ingreso " +super.getFechaIngreso() +'}';
    }
    
}
