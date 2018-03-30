
package Dominio;

import javafx.beans.property.SimpleStringProperty;

public class Memoria extends Obra{
    
    private SimpleStringProperty resumen;
    private SimpleStringProperty summary;
    private SimpleStringProperty conferencia;

    public Memoria(String resumen, String summary, String conferencia, String titulo, String fechaIngreso, String autor) {
        super(titulo, fechaIngreso, autor);
        this.resumen = new SimpleStringProperty (resumen);
        this.summary = new SimpleStringProperty (summary);
        this.conferencia = new SimpleStringProperty (conferencia);
    }

    public String getResumen() {
        return resumen.get();
    }

    public void setResumen(String resumen) {
        this.resumen = new SimpleStringProperty (resumen);
    }

    public String getSummary() {
        return summary.get();
    }

    public void setSummary(String summary) {
        this.summary = new SimpleStringProperty (summary);
    }

    public String getConferencia() {
        return conferencia.get();
    }

    public void setConferencia(String conferencia) {
        this.conferencia = new SimpleStringProperty (conferencia);
    }

    @Override
    public String toString() {
        return "Memoria{" + "resumen=" + resumen + ", summary=" + summary + ", conferencia=" + conferencia +  " autor " + super.getAutor() + " titulo " + super.getTitulo() + " fecha ingreso " +super.getFechaIngreso() +'}';
    }
    
}
