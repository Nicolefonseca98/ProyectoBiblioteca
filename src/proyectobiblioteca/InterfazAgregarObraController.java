
package proyectobiblioteca;

import Dominio.Autor;
import Dominio.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static Listas.Listas.clienteLista;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InterfazAgregarObraController implements Initializable {

    @FXML private ComboBox comboBoxObra;
    @FXML private TextField txfTitulo;
    @FXML private DatePicker dtFechaIngreso;
    @FXML private ComboBox comboBoxAutor;
    @FXML private TextField txfTema;
    @FXML private TextField txfSubtema;
    @FXML private DatePicker dtFechaPublicacion;
    @FXML private TextField txfEdicion;
    @FXML private TextArea txaResumen;
    @FXML private TextField txfConferencia;
    @FXML private TextField txfISBN;
    @FXML private TextField txfISSN;
    @FXML private Button btnAgregar;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Tipos de obras a elegir por el usuario
        comboBoxObra.getItems().addAll("Libro", "Revista", "Tesis", "Periódico", "Memoria");
        
       //Autores predeterminados
       Autor a = new Autor("autor1", "1234", "Ana", "Nacional", "123456789", "Autor");  
       clienteLista.addAll(a);
        
        /*
       * Busca en la lista los usuarios que son autores
       * para mostrarlos en el comboBox a la hora de ingresar una nueva obra
       * y así asignarle a la obra un autor ya registrado en el sistema
       */
        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            Cliente c = (Cliente) clienteLista.get(i);
            if (c.getTipoUsuario().equalsIgnoreCase("Autor")) {
                
                comboBoxAutor.getItems().addAll(c.getNombreCompleto());
                break;
            }
        } //Fin for
        
        
        /*Campos deshabilitados hasta que se escoja el tipo de obra
        * que se va agregar al sistema
        */ 
        txfTema.setDisable(true);
        txfSubtema.setDisable(true);
        dtFechaPublicacion.setDisable(true);
        txaResumen.setDisable(true);
        txfEdicion.setDisable(true);
        txfConferencia.setDisable(true);
        txfISBN.setDisable(true);
        txfISSN.setDisable(true);
        
    }  
    
    @FXML
    private void volverMenu(ActionEvent event) throws IOException {
     //
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazBibliotecario.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png"));       
        window.setScene(scene);
        window.show();

    }
    

    
}
