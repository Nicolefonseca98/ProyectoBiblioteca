
package proyectobiblioteca;

import Dominio.PrestarLibro;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class InterfazFuncionUsuarioController implements Initializable {

 @FXML private TableView<PrestarLibro> tablaPrestamoUsuario;
 @FXML private TableColumn columnaTitulo;
 @FXML private TableColumn columnaPrestamo;
 @FXML private TableColumn columnaRetorno;
 @FXML private Label nombreCompleto;
 @FXML private Label identificacion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    
    
    @FXML
    private void salir(ActionEvent event) throws IOException {
     
        Parent parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png"));       
        window.setScene(scene);
        window.show();

    }
    
}
