
package proyectobiblioteca;

import static Listas.Listas.usuarioLogin;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InterfazBorrarController implements Initializable {

    @FXML private TextField textFieldBuscar;
    @FXML private Label labelMensaje;
    
    @FXML
    private void buttonBorrar() {
       
        Logica l = new Logica();
        
        if (textFieldBuscar.getText().equals("")) {
            labelMensaje.setText("Ingrese un usuario.");
        }else if (textFieldBuscar.getText().equals(usuarioLogin.get(0))) { 
            labelMensaje.setText("No se puede borrar este usuario");
        } else if(l.borrarMoroso(textFieldBuscar.getText())){
            labelMensaje.setText("El usuario está moroso");
        } else {  
            l.borrarUsuario(textFieldBuscar.getText());
            labelMensaje.setText("Usuario borrado.");
            
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
