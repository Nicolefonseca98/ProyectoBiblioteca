
package proyectobiblioteca;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class InterfazAgregarController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML private ChoiceBox choiceBox1;
    @FXML private ChoiceBox choiceBox2;
    @FXML private ChoiceBox choiceBox3;
    @FXML private TextField txfUsuario;
    @FXML private TextField txfContraseña;
    @FXML private TextField txfNombre;
    @FXML private TextField txfIdentificacion;

    @FXML
    private void agregarUsuario() {
        
        Logica l = new Logica();
        l.agregarUsuario(txfUsuario.getText(), txfContraseña.getText(), txfNombre.getText(), choiceBox1.getValue().toString(), txfIdentificacion.getText());
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Agrega las opciones a escoger a los choiceBox
        choiceBox1.getItems().add("Nacional");
        choiceBox1.getItems().add("Extranjero");
        
        choiceBox2.getItems().add("Nacional");
        choiceBox2.getItems().add("Extranjero");
        
        choiceBox3.getItems().add("Nacional");
        choiceBox3.getItems().add("Extranjero");
        
    }    
    
}
