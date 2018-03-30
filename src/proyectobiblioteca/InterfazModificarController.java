
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;


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
