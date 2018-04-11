
package proyectobiblioteca;

import Dominio.Libro;
import Dominio.Obra;
import Dominio.PrestarLibro;
import static Listas.Listas.librosPrestados;
import static Listas.Listas.obraLista;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class InterfazListaObrasController implements Initializable {

    @FXML private TableView <Obra> tablaObras;
    @FXML private TableColumn <Libro,String> columnaTitulo;
    @FXML private TableColumn <Libro,String> columnaAutor;
    @FXML private TableColumn <Libro,String> columnaIngreso;
    @FXML private TextField buscarTitulo;
    @FXML private TextField buscarAutor;
    @FXML private Label nombreUsuario;
    @FXML private Label fechaPrestamo;
    @FXML private Label fechaRetorno;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<Libro,String>("titulo"));
        columnaAutor.setCellValueFactory(new PropertyValueFactory<Libro,String>("autor"));
        columnaIngreso.setCellValueFactory(new PropertyValueFactory<Libro,String>("fechaIngreso"));
        
        tablaObras.setItems(obraLista);
        FilteredList<Obra> filteredData = new FilteredList<>(obraLista, p -> true);
        tablaObras.setItems(filteredData);
        buscarAutor.setPromptText("Buscar por autor...");
        buscarTitulo.setPromptText("Buscar por título...");
        
        //Filtro para buscar en la tabla por nombre de autor
        buscarAutor.textProperty().addListener((prop, old, text) -> {
        filteredData.setPredicate(obra -> {
        if(text == null || text.isEmpty()) return true;
        String autor = obra.getAutor().toLowerCase();
        return autor.contains(text.toLowerCase());
        });
        });
        
        //Filtro para buscar en la tabla por título
        buscarTitulo.textProperty().addListener((prop, old, text) -> {
        filteredData.setPredicate(obra -> {
        if(text == null || text.isEmpty()) return true;
        String titulo = obra.getTitulo().toLowerCase();
        return titulo.contains(text.toLowerCase());
        });
        });
        
        tablaObras.setRowFactory(tv -> {
            TableRow<Obra> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    Obra clickTituloTabla = row.getItem();
                } 
                
                for (int i = 0; i <= librosPrestados.size() - 1; i++) {
                    
                    PrestarLibro prestarLibro = librosPrestados.get(i);
                    String tituloTabla = row.getItem().getTitulo();
                    String tituloPrestamo = prestarLibro.getTitulo();
                    
                    if (tituloTabla.equals(tituloPrestamo)) {
                        nombreUsuario.setText(prestarLibro.getUsuario());
                        fechaPrestamo.setText(prestarLibro.getFechaPrestamo().toString());
                        fechaRetorno.setText(prestarLibro.getFechaRetorno().toString());
                    } 
                }
            });
            return row;
        });
            
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
