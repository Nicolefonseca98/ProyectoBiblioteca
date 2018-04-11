
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

    @FXML private TextField txfBuscar;
    @FXML private Label lbMensaje;
    
    @FXML
    private void botonB() {
       
        Logica l = new Logica();
        
        if (txfBuscar.getText().equals("")) {
            lbMensaje.setText("Ingrese un usuario.");
        }else if (txfBuscar.getText().equals(usuarioLogin.get(0))) { 
            lbMensaje.setText("No se puede borrar este usuario");
        } else if(l.borrarMoroso(txfBuscar.getText())){
            lbMensaje.setText("El usuario está moroso");
        } else {  
            l.borrarUsuario(txfBuscar.getText());
            lbMensaje.setText("Usuario borrado.");
            
        } 
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
