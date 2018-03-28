
package proyectobiblioteca;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class InterfazAgregarController implements Initializable {

    @FXML private AnchorPane anchor;
    @FXML private ChoiceBox choiceBox1;
    @FXML private TextField txfUsuario;
    @FXML private TextField txfContraseña;
    @FXML private TextField txfNombre;
    @FXML private TextField txfIdentificacion;
    @FXML private ChoiceBox choiceBox2;
    @FXML private Label lbMensaje;

    @FXML
    private void agregarUsuario() {
        
        Logica l = new Logica();
        l.agregarUsuario(txfUsuario.getText(), txfContraseña.getText(), txfNombre.getText(),
                        choiceBox1.getValue().toString(), txfIdentificacion.getText(), choiceBox2.getValue().toString());
        lbMensaje.setText("Usuario añadido");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Agrega las opciones a escoger a los choiceBox
        choiceBox1.getItems().add("Nacional");
        choiceBox1.getItems().add("Extranjero");
        
        choiceBox2.getItems().add("Usuario");
        choiceBox2.getItems().add("Autor");
        choiceBox2.getItems().add("Bibliotecario");

        
    }    
    
}
