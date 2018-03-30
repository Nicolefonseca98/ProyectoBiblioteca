
package Dominio;

import javafx.beans.property.SimpleStringProperty;

public class Tesis extends Obra{
    
    private SimpleStringProperty resumen;
    private SimpleStringProperty summary;

    public Tesis() {
    }


    public Tesis(String resumen, String summary, String titulo, String fechaIngreso, String autor) {
        super(titulo, fechaIngreso, autor);
        this.resumen = new SimpleStringProperty (resumen);
        this.summary = new SimpleStringProperty (summary);
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

    @Override
    public String toString() {
        return "Tesis{" + "resumen=" + resumen + ", summary=" + summary + " autor " + super.getAutor() + " titulo " + super.getTitulo() + " fecha ingreso " +super.getFechaIngreso() + '}';
    }

  
}
