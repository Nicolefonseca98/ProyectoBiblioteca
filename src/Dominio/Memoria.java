
package Dominio;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.DatePicker;

public class Memoria extends Obra{
    
    private SimpleStringProperty resumen;
    private SimpleStringProperty summary;
    private SimpleStringProperty conferencia;

    public Memoria(SimpleStringProperty resumen, SimpleStringProperty summary, SimpleStringProperty conferencia) {
        this.resumen = resumen;
        this.summary = summary;
        this.conferencia = conferencia;
    }

    public Memoria(SimpleStringProperty resumen, SimpleStringProperty summary, SimpleStringProperty conferencia, SimpleStringProperty titulo, DatePicker fechaIngreso, SimpleStringProperty autor) {
        super(titulo, fechaIngreso, autor);
        this.resumen = resumen;
        this.summary = summary;
        this.conferencia = conferencia;
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

    public SimpleStringProperty getConferencia() {
        return conferencia;
    }

    public void setConferencia(SimpleStringProperty conferencia) {
        this.conferencia = conferencia;
    }

    @Override
    public String toString() {
        return "Memoria{" + "resumen=" + resumen + ", summary=" + summary + ", conferencia=" + conferencia + '}';
    }
    
}
