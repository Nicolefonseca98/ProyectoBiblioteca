
package proyectobiblioteca;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    
    @FXML
    private void volverMenu(ActionEvent event) throws IOException {
     
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazBibliotecario.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png"));       
        window.setScene(scene);
        window.show();

    }
    
}
