
package proyectobiblioteca;

import Dominio.Cliente;
import Dominio.Libro;
import Dominio.Obra;
import Dominio.PrestarLibro;
import Dominio.UsuarioMoroso;
import static Listas.Listas.clienteLista;
import static Listas.Listas.libroLista;
import static Listas.Listas.librosPrestados;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InterfazPrestarLibroController implements Initializable {

    @FXML private ComboBox comboBoxTitulo;
    @FXML private ComboBox comboBoxUsuario;
    @FXML private DatePicker datePickerPrestamo;
    @FXML private DatePicker datePickerRetorno;
    
    @FXML private TableView <PrestarLibro> tablaPrestamos;
    @FXML private TableView <UsuarioMoroso> tablaMorosidad;
    
    @FXML private TableColumn <PrestarLibro,String> columnaTitulo;
    @FXML private TableColumn <PrestarLibro,String> columnaUsuarioPrestamo;
    @FXML private TableColumn <PrestarLibro,String> columnaPrestamo;
    @FXML private TableColumn <PrestarLibro,String> columnaRetornoPrestamo;
    
    @FXML private TableColumn <UsuarioMoroso,String> columnaLibro;
    @FXML private TableColumn <UsuarioMoroso,String> columnaUsuarioMorosidad;
    @FXML private TableColumn <UsuarioMoroso,String> columnaRetornoMorosidad;
    
     @FXML
    private void menu(ActionEvent event) throws IOException {
     
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
        //Preparar las columnas en la tabla
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<PrestarLibro,String>("titulo"));
        columnaUsuarioPrestamo.setCellValueFactory(new PropertyValueFactory<PrestarLibro,String>("usuario"));
        columnaPrestamo.setCellValueFactory(new PropertyValueFactory<PrestarLibro,String>("fechaPrestamo"));
        columnaRetornoPrestamo.setCellValueFactory(new PropertyValueFactory<PrestarLibro,String>("fechaRetorno"));
        
        columnaUsuarioMorosidad.setCellValueFactory(new PropertyValueFactory<UsuarioMoroso,String>("usuario"));
        columnaLibro.setCellValueFactory(new PropertyValueFactory<UsuarioMoroso,String>("titulo"));
        columnaRetornoMorosidad.setCellValueFactory(new PropertyValueFactory<UsuarioMoroso,String>("nombreCompleto"));
                
        tablaPrestamos.setItems(librosPrestados);
//        tablaMorosidad.setItems();
        
        for (int i = 0; i <= libroLista.size() - 1; i++) {
            
            Obra o = (Libro) libroLista.get(i);
                comboBoxTitulo.getItems().addAll(o.getTitulo());
                
        } //Fin for
       
        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            
            Cliente c = (Cliente) clienteLista.get(i);
                comboBoxUsuario.getItems().addAll(c.getNombreCompleto());
                
        } //Fin for
        
        
    }
     @FXML private void botonPrestar() {
    PrestarLibro prestarLibro = new PrestarLibro(comboBoxTitulo.getValue().toString() , comboBoxUsuario.getValue().toString() , datePickerPrestamo.getValue().toString(), datePickerRetorno.getValue().toString());
    librosPrestados.add(prestarLibro);
    System.out.println(librosPrestados.toString());
    }
     
////     @FXML private void getMorosidad(DatePicker datePickerRetorno){
////         if(datePickerRetorno.(LocalDate.now())){
////             
////         }
//         
//     }
}
