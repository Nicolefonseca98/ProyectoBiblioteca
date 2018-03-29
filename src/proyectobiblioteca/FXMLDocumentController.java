
package proyectobiblioteca;

import Dominio.Bibliotecario;
import Listas.Listas;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class FXMLDocumentController extends Listas implements Initializable {
    
    @FXML
    private TextField txfUsuario;
    @FXML
    private PasswordField txfContraseña;
    @FXML private Button btnAgregar;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
     
        //Bibliotecario permanente
        Bibliotecario bl = new Bibliotecario("bibliotecario01", "1234", "Juan Solano", "Nacional", "123456789", "Biblitecario");
        clienteLista.add(bl);
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazBibliotecario.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png")); 
        
         //Verifica datos del usuario
        if (txfUsuario.getText().equals(bl.getNombreUnico()) && (txfContraseña.getText().equals(bl.getContraseña()))) {

            window.setScene(scene);
            window.show();

        } else {
            System.out.println("Usuario invalido");
        }
       
        System.out.println(clienteLista.toString());
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
