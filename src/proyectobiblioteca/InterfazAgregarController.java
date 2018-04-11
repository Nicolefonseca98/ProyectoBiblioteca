
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InterfazAgregarController implements Initializable {

    @FXML private ChoiceBox choiceBoxTipoIdentificacion;
    @FXML private TextField textFieldUsuario;
    @FXML private TextField textFieldContraseña;
    @FXML private TextField textFieldNombre;
    @FXML private TextField textFieldIdentificacion;
    @FXML private ChoiceBox choiceBoxTipoUsuario;
    @FXML private Label labelMensaje;

    @FXML
    //Método que le da acción al botón "Agregar" para ingresar un usuario nuevo, llama a otro método y verifica si este existe
    private void buttonAgregarUsuario() {
        try {
            Logica l = new Logica();

            if (l.existeUsuario(textFieldUsuario.getText()) == true) {
                labelMensaje.setText("Usuario ya existe.");
            } else {
                l.agregarUsuario(textFieldUsuario.getText(), textFieldContraseña.getText(), textFieldNombre.getText(),
                        choiceBoxTipoIdentificacion.getValue().toString(), textFieldIdentificacion.getText(), choiceBoxTipoUsuario.getValue().toString());
                labelMensaje.setText("Usuario añadido");
            }
        } catch (NullPointerException NPE) {
            labelMensaje.setText("Ingrese todos los datos");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Agrega las opciones a escoger a los choiceBox
        choiceBoxTipoIdentificacion.getItems().add("Nacional");
        choiceBoxTipoIdentificacion.getItems().add("Extranjero");

        choiceBoxTipoUsuario.getItems().add("Usuario");
        choiceBoxTipoUsuario.getItems().add("Autor");
        choiceBoxTipoUsuario.getItems().add("Bibliotecario");

    }

    @FXML
    //Método que le da accion al botón "Menú" y regresa a la interfaz del bibliotecario.
    private void buttonVolverMenu(ActionEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("InterfazBibliotecario.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png"));
        window.setScene(scene);
        window.show();

    }

}
