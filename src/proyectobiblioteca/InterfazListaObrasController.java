
package proyectobiblioteca;

import Dominio.Cliente;
import Dominio.Libro;
import Dominio.Obra;
import static Listas.Listas.obraLista;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class InterfazListaObrasController implements Initializable {

    @FXML private TableView <Obra> tablaObras;
    @FXML private TableColumn <Libro,String> columnaTitulo;
    @FXML private TableColumn <Libro,String> columnaAutor;
    @FXML private TableColumn <Libro,String> columnaIngreso;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<Libro,String>("titulo"));
        columnaAutor.setCellValueFactory(new PropertyValueFactory<Libro,String>("autor"));
        columnaIngreso.setCellValueFactory(new PropertyValueFactory<Libro,String>("fechaIngreso"));
        
        tablaObras.setItems(obraLista);
        
    }  

    
}
