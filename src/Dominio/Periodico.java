
package Dominio;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.DatePicker;

public class Periodico extends Obra{
    
    private SimpleStringProperty issn;
    private SimpleStringProperty edicion;
    private DatePicker fechaPublicacion;

    public Periodico(SimpleStringProperty issn, SimpleStringProperty edicion, DatePicker fechaPublicacion) {
        this.issn = issn;
        this.edicion = edicion;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Periodico(SimpleStringProperty issn, SimpleStringProperty edicion, DatePicker fechaPublicacion, SimpleStringProperty titulo, DatePicker fechaIngreso, SimpleStringProperty autor) {
        super(titulo, fechaIngreso, autor);
        this.issn = issn;
        this.edicion = edicion;
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * @return the issn
     */
    public SimpleStringProperty getIssn() {
        return issn;
    }

    /**
     * @param issn the issn to set
     */
    public void setIssn(SimpleStringProperty issn) {
        this.issn = issn;
    }

    /**
     * @return the edicion
     */
    public SimpleStringProperty getEdicion() {
        return edicion;
    }

    /**
     * @param edicion the edicion to set
     */
    public void setEdicion(SimpleStringProperty edicion) {
        this.edicion = edicion;
    }

    /**
     * @return the fechaPublicacion
     */
    public DatePicker getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion the fechaPublicacion to set
     */
    public void setFechaPublicacion(DatePicker fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Periodico{" + "issn=" + issn + ", edicion=" + edicion + ", fechaPublicacion=" + fechaPublicacion + '}';
    }

    
    
}
