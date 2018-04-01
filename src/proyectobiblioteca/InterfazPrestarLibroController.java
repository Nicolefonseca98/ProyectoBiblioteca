
package proyectobiblioteca;


import Dominio.Cliente;
import Dominio.Libro;
import Dominio.Obra;
import static Listas.Listas.clienteLista;
import static Listas.Listas.libroLista;
import static Listas.Listas.librosPrestados;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;



public class InterfazPrestarLibroController implements Initializable {

    @FXML private ComboBox comboBoxTitulo;
    @FXML private ComboBox comboBoxUsuario;
    @FXML private DatePicker datePickerPrestamo;
    @FXML private DatePicker datePickerRetorno;
    @FXML private Button btnPrestar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        for (int i = 0; i <= libroLista.size() - 1; i++) {
            
            Obra o = (Libro) libroLista.get(i);
                comboBoxTitulo.getItems().addAll(o.getTitulo());
                
        } //Fin for
       
        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            
            Cliente c = (Cliente) clienteLista.get(i);
                comboBoxUsuario.getItems().addAll(c.getNombreCompleto());
                
        } //Fin for
        
    }

    @FXML private void botonPrestar() {
        
        librosPrestados.add(comboBoxTitulo.getValue().toString() + comboBoxUsuario.getValue().toString() + datePickerPrestamo.getValue().toString()
                               + datePickerRetorno.getValue().toString());
        System.out.println(librosPrestados.toString());
    }
    
}
