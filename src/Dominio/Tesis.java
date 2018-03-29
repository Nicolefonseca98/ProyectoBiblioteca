
package Dominio;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.DatePicker;

public class Tesis extends Obra{
    
    private SimpleStringProperty resumen;
    private SimpleStringProperty summary;

    public Tesis() {
    }

    public Tesis(SimpleStringProperty resumen, SimpleStringProperty summary) {
        this.resumen = resumen;
        this.summary = summary;
    }

    public Tesis(SimpleStringProperty resumen, SimpleStringProperty summary, SimpleStringProperty titulo, DatePicker fechaIngreso, SimpleStringProperty autor) {
        super(titulo, fechaIngreso, autor);
        this.resumen = resumen;
        this.summary = summary;
    }

    public SimpleStringProperty getResumen() {
        return resumen;
    }

    public void setResumen(SimpleStringProperty resumen) {
        this.resumen = resumen;
    }

    public SimpleStringProperty getSummary() {
        return summary;
    }

    public void setSummary(SimpleStringProperty summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Tesis{" + "resumen=" + resumen + ", summary=" + summary + '}';
    }

  
}
