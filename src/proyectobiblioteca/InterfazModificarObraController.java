
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

    @FXML private TextField textFieldBuscar;
    @FXML private TextField textFieldTitulo;
    @FXML private ComboBox comboBoxAutor;
    @FXML private DatePicker datePickerFechaPublicacion;
    @FXML private Label labelMensaje;
    @FXML private Button buttonModificar;
    @FXML private Label labelMensajeModificar;
    @FXML private Button buttonBuscar;
    
     @FXML
    private void buttonVolverMenu(ActionEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("InterfazBibliotecario.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png"));
        window.setScene(scene);
        window.show();

    }

    @FXML
    private void buttonBuscar() {

        Logica l = new Logica();
        if (l.buscarObra(textFieldBuscar.getText())) {
            labelMensaje.setText("Obra encontrado");
            textFieldTitulo.setDisable(false);
            comboBoxAutor.setDisable(false);
            datePickerFechaPublicacion.setDisable(false);
            buttonModificar.setDisable(false);
            buttonBuscar.setDisable(true);

        } else {
            labelMensaje.setText("La obra no existe");
        }

    }

    @FXML
    private void buttonModificar() {

        try {
            Logica l = new Logica();
            l.modificarObra(textFieldBuscar.getText(), textFieldTitulo.getText(), comboBoxAutor.getValue().toString(), datePickerFechaPublicacion.getValue().toString());
            labelMensajeModificar.setText("Obra modificada");
        } catch (NullPointerException NPE) {
            labelMensajeModificar.setText("Ingrese todos los datos");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            Cliente c = (Cliente) clienteLista.get(i);
            if (c.getTipoUsuario().equalsIgnoreCase("Autor")) {

                comboBoxAutor.getItems().addAll(c.getNombreCompleto());

            }
        }

        textFieldTitulo.setDisable(true);
        comboBoxAutor.setDisable(true);
        datePickerFechaPublicacion.setDisable(true);
        buttonModificar.setDisable(true);

    }
    
}
