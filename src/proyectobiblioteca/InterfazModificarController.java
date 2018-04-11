
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class InterfazModificarController implements Initializable {

    @FXML private TextField textFieldBuscar;
    @FXML private TextField textFieldNuevoUsuario;
    @FXML private PasswordField recibeContraseña;
    @FXML private Button buttonModificar;
    @FXML private Label labelMensaje;
    @FXML private Label labelMensaje2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        textFieldNuevoUsuario.setDisable(true);
        recibeContraseña.setDisable(true);
        buttonModificar.setDisable(true);
    }   
    
    @FXML 
    private void accionBuscar(){
        
        Logica l = new Logica();
        if(l.existeUsuario(textFieldBuscar.getText()) == true) {
            labelMensaje.setText("Usuario encontrado");
            textFieldNuevoUsuario.setDisable(false);
            recibeContraseña.setDisable(false);
            buttonModificar.setDisable(false);
        }
        else
            labelMensaje.setText("Usuario no encontrado");
        
    }
    
    @FXML
    private void accionModificar() {
        
        Logica l = new Logica();
        if (textFieldNuevoUsuario.getText().equals("") || recibeContraseña.getText().equals("")) {
            labelMensaje2.setText("Ingrese todos los datos.");
        } else {
        l.modificarUsuario(textFieldBuscar.getText(), textFieldNuevoUsuario.getText(), recibeContraseña.getText());
        labelMensaje2.setText("Usuario modificado");
        }
    }
    
    @FXML
    private void buttonVolverMenu(ActionEvent event) throws IOException {
     
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazBibliotecario.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png"));       
        window.setScene(scene);
        window.show();

    }
    
}
