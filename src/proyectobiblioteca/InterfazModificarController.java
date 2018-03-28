
package proyectobiblioteca;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class InterfazModificarController implements Initializable {

    @FXML private TextField txfBuscar;
    @FXML private TextField txfNuevoUsuario;
    @FXML private TextField txfNuevaContraseña;
    @FXML private Button btnModificar;
    @FXML private Label lbMensaje;
    @FXML private Label lbMensaje2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        txfNuevoUsuario.setDisable(true);
        txfNuevaContraseña.setDisable(true);
        btnModificar.setDisable(true);
    }   
    
    @FXML 
    private void accionBuscar(){
        
        Logica l = new Logica();
        if(l.existeUsuario(txfBuscar.getText()) == true) {
            lbMensaje.setText("Usuario encontrado");
            txfNuevoUsuario.setDisable(false);
            txfNuevaContraseña.setDisable(false);
            btnModificar.setDisable(false);
        }
        else
            lbMensaje.setText("Usuario no encontrado");
        
    }
    
    @FXML
    private void accionModificar() {
        
        Logica l = new Logica();
        l.modificarUsuario(txfBuscar.getText(), txfNuevoUsuario.getText(), txfNuevaContraseña.getText());
        lbMensaje2.setText("Usuario modificado");
        
    }
    
}
