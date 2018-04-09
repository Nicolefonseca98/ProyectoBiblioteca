
package proyectobiblioteca;

import Dominio.Cliente;
import static Listas.Listas.clienteLista;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class InterfazModificarObraController implements Initializable {

    @FXML private TextField txfBuscar;
    @FXML private TextField txfTitulo;
    @FXML private ComboBox comboBoxAutor;
    @FXML private DatePicker dtFecha;
    @FXML private Label lbMensaje;
    @FXML private Button btnModificar;
    @FXML private Label mensajeModificar;
    
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
    
    @FXML
    private void btnBuscar() {
       
        Logica l = new Logica();
        if(l.buscarObra(txfBuscar.getText())) {
            lbMensaje.setText("Obra encontrado");
            txfTitulo.setDisable(false);
            comboBoxAutor.setDisable(false);
            dtFecha.setDisable(false);
            btnModificar.setDisable(false);
            
        }
        else
            lbMensaje.setText("La obra no existe");
        
    }
    
    
    @FXML
    private void btnModificar(){
        
        try {
            Logica l = new Logica();
            l.modificarObra(txfBuscar.getText(), txfTitulo.getText(), comboBoxAutor.getValue().toString(), dtFecha.getValue().toString());
            mensajeModificar.setText("Obra modificada");
        } catch (NullPointerException NPE) {
            mensajeModificar.setText("Ingrese todos los datos");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        /*
       * Busca en la lista los usuarios que son autores
       * para mostrarlos en el comboBox a la hora de ingresar una nueva obra
       * y así asignarle a la obra un autor ya registrado en el sistema
       */
        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            Cliente c = (Cliente) clienteLista.get(i);
            if (c.getTipoUsuario().equalsIgnoreCase("Autor")) {
                
                comboBoxAutor.getItems().addAll(c.getNombreCompleto());
                
            }
        } //Fin for
        
        txfTitulo.setDisable(true);
        comboBoxAutor.setDisable(true);
        dtFecha.setDisable(true);
        btnModificar.setDisable(true);
        
    }    
    
}
