
package Dominio;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.DatePicker;

public class Periodico extends Obra{
    
    private SimpleStringProperty issn;
    private SimpleStringProperty edicion;
    private SimpleStringProperty fechaPublicacion;


    public Periodico(String issn, String edicion, String fechaPublicacion, String titulo, String fechaIngreso, String autor) {
        super(titulo, fechaIngreso, autor);
        this.issn = new SimpleStringProperty (issn);
        this.edicion = new SimpleStringProperty (edicion);
        this.fechaPublicacion = new SimpleStringProperty (fechaPublicacion);
    }

    public String getIssn() {
        return issn.get();
    }

    public void setIssn(String issn) {
        this.issn = new SimpleStringProperty (issn);
    }

    public String getEdicion() {
        return edicion.get();
    }

    public void setEdicion(String edicion) {
        this.edicion = new SimpleStringProperty (edicion);
    }

    public String getFechaPublicacion() {
        return fechaPublicacion.get();
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = new SimpleStringProperty (fechaPublicacion);
    }

    @Override
    public String toString() {
        return "Periodico{" + "issn=" + issn + ", edicion=" + edicion + ", fechaPublicacion=" + fechaPublicacion +  " autor " + super.getAutor() + " titulo " + super.getTitulo() + " fecha ingreso " +super.getFechaIngreso() +'}';
    }

    
    
}
