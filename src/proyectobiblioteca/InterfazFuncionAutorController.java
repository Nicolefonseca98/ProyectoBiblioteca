package proyectobiblioteca;

import Dominio.Obra;
import static Listas.Listas.clienteLista;
import static Listas.Listas.obraLista;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InterfazFuncionAutorController implements Initializable {
@FXML private TableView<Obra>tablaObrasAutor;
@FXML private TableColumn columnaTitulo;
@FXML private TableColumn columnaFechaIngreso;
@FXML private Label nombreCompleto;
@FXML private Label identificacion;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<Obra,String>("titulo"));
        columnaFechaIngreso.setCellValueFactory(new PropertyValueFactory<Obra,String>("fechaIngreso"));
         for (int i = 0 ; i <= usuarioLogin.size() -1; i++) {
            String us = usuarioLogin.get(i);
        
        nombreCompleto.setText(us);
        tablaObrasAutor.setItems(obraLista);
        FilteredList<Obra> filteredData = new FilteredList<>(obraLista, p -> true);
        tablaObrasAutor.setItems(filteredData);
        filteredData.setPredicate(Obra -> {  
        String usuario = (Obra.getAutor().toLowerCase());
        return usuario.contains(us.toLowerCase());
        
        });
        
        }
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
