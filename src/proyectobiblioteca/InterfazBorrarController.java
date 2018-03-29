
package proyectobiblioteca;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InterfazBorrarController implements Initializable {

    @FXML private TextField txfBuscar;
    @FXML private Label lbMensaje;
    
    @FXML
    private void botonB() {
       
        Logica l = new Logica();
        l.borrarUsuario(txfBuscar.getText());
        lbMensaje.setText("Usuario borrado");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
