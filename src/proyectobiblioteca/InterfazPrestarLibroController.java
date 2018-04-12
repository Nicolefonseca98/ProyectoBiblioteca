
package proyectobiblioteca;

import Dominio.Cliente;
import Dominio.Libro;
import Dominio.Obra;
import Dominio.PrestarLibro;
import Dominio.Usuario;
import Dominio.UsuarioMoroso;
import static Listas.Listas.clienteLista;
import static Listas.Listas.libroLista;
import static Listas.Listas.librosPrestados;
import static Listas.Listas.usuariosMorosos;
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
import javafx.scene.control.Label;
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
    @FXML private Label labelMensaje;
    
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
    private void buttonMenu (ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazBibliotecario.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png"));
        window.setScene(scene);
        window.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Preparar las columnas en la tabla
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<PrestarLibro, String>("titulo"));
        columnaUsuarioPrestamo.setCellValueFactory(new PropertyValueFactory<PrestarLibro, String>("usuario"));
        columnaPrestamo.setCellValueFactory(new PropertyValueFactory<PrestarLibro, String>("fechaPrestamo"));
        columnaRetornoPrestamo.setCellValueFactory(new PropertyValueFactory<PrestarLibro, String>("fechaRetorno"));

        columnaUsuarioMorosidad.setCellValueFactory(new PropertyValueFactory<UsuarioMoroso, String>("usuario"));
        columnaLibro.setCellValueFactory(new PropertyValueFactory<UsuarioMoroso, String>("libro"));
        columnaRetornoMorosidad.setCellValueFactory(new PropertyValueFactory<UsuarioMoroso, String>("fechaRetorno"));

        tablaPrestamos.setItems(librosPrestados);
        tablaMorosidad.setItems(usuariosMorosos);

        for (int i = 0; i <= libroLista.size() - 1; i++) {
            Obra o = (Libro) libroLista.get(i);
            comboBoxTitulo.getItems().addAll(o.getTitulo());

        } 
         //clienteLista.isEmpty();
         
        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            Cliente c = (Cliente) clienteLista.get(i);
            comboBoxUsuario.getItems().addAll(c.getNombreUnico());
            
        }
        
    }

    @FXML
    private void buttonPrestar() {
        try {

            PrestarLibro prestarLibro = new PrestarLibro(comboBoxTitulo.getValue().toString(), comboBoxUsuario.getValue().toString(),
                    datePickerPrestamo.getValue(), datePickerRetorno.getValue());
            librosPrestados.add(prestarLibro);
            labelMensaje.setText("Libro prestado");

        } catch (NullPointerException NPE) {
            labelMensaje.setText("Ingrese todos los datos.");
        }
        
                LocalDate fechaRetorno;
        String usuario = "";
        String titulo = "";

        for (int i = 0; i <= librosPrestados.size() - 1; i++) {
            PrestarLibro prestarLibro = (PrestarLibro) librosPrestados.get(i);

            if (LocalDate.now().isAfter(prestarLibro.getFechaRetorno())) {
                usuario = prestarLibro.getUsuario();
                titulo = prestarLibro.getTitulo();
                fechaRetorno = prestarLibro.getFechaRetorno();
                UsuarioMoroso moroso = new UsuarioMoroso(usuario, titulo, fechaRetorno);
                usuariosMorosos.add(moroso);

            }
        }
    }
    
}
