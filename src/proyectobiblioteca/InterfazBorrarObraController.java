package proyectobiblioteca;

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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InterfazBorrarObraController implements Initializable {

     @FXML private TextField textFieldBuscarObra;
     @FXML private Label labelMensaje;
    
    @FXML
    private void buttonBuscarObra() {
        Logica logica = new Logica();
        try {
            if (logica.buscarObra(textFieldBuscarObra.getText())) {
                logica.borrarObra(textFieldBuscarObra.getText());
                labelMensaje.setText("Obra borrada");
            } else {
                labelMensaje.setText("La obra no existe");
            }
        } catch (NullPointerException NPE) {
            labelMensaje.setText("Ingrese los datos");
        }
    }
    
     @FXML
    private void buttonVolverMenu(ActionEvent event) throws IOException {
     
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
        // TODO
    }    
    
}
