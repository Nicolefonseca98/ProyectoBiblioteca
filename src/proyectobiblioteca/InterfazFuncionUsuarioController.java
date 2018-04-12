
package proyectobiblioteca;
import Dominio.PrestarLibro;
import Listas.Listas;
import static Listas.Listas.librosPrestados;
import static Listas.Listas.usuarioLogin;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class InterfazFuncionUsuarioController extends Listas implements Initializable {

 @FXML private TableView<PrestarLibro> tablaPrestamoUsuario;
 @FXML private TableColumn columnaTitulo;
 @FXML private TableColumn columnaPrestamo;
 @FXML private TableColumn columnaRetorno;
 @FXML private Label labelNombreUsuario;
 @FXML private Button buttonBuscar;
 
    
    @Override
    public void initialize (URL url, ResourceBundle rb){
       
    }   
    
    @FXML
    private void buttonBuscar(ActionEvent event)  {

        labelNombreUsuario.setText(usuarioLogin.get(0).toString());
        
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<PrestarLibro,String>("titulo"));
        columnaPrestamo.setCellValueFactory(new PropertyValueFactory<PrestarLibro,String>("fechaPrestamo"));
        columnaRetorno.setCellValueFactory(new PropertyValueFactory<PrestarLibro,String>("fechaRetorno"));
        
        tablaPrestamoUsuario.setItems(librosPrestados);
        FilteredList<PrestarLibro> filteredData = new FilteredList<>(librosPrestados, p -> true);
        tablaPrestamoUsuario.setItems(filteredData);
        filteredData.setPredicate(PrestarLibro -> {  
        String usuarioPrestamo = PrestarLibro.getUsuario().toLowerCase();
        return usuarioPrestamo.contains(usuarioLogin.get(0).toString().toLowerCase());
        
        });
        
    }
    
    @FXML
    private void buttonSalir(ActionEvent event) throws IOException {
        usuarioLogin.remove(0);
        Parent parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png")); 
        window.setScene(scene);
        window.show();
        
    }
    
}
