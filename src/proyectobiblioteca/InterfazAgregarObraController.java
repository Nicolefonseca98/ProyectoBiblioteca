
package proyectobiblioteca;

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
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InterfazAgregarObraController implements Initializable {

    @FXML private ComboBox comboBoxTipoObra;
    @FXML private TextField textFieldTitulo;
    @FXML private DatePicker datePickerFechaIngreso;
    @FXML private ComboBox comboBoxAutor;
    @FXML private TextField textFieldTema;
    @FXML private TextField textFieldSubtema;
    @FXML private DatePicker datePickerFechaPublicacion;
    @FXML private TextField textFieldEdicion;
    @FXML private TextArea textAreaResumen;
    @FXML private TextField textFieldConferencia;
    @FXML private TextField textFieldIsbn;
    @FXML private TextField textFieldIssn;
    @FXML private TextArea textAreaSummary;
    @FXML private Label labelMensaje;
    @FXML private Button buttonAgregar;
    @FXML private Button buttonOk;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Tipos de obras a elegir por el usuario
        comboBoxTipoObra.getItems().addAll("Libro", "Revista", "Tesis", "Periódico", "Memoria");
        
        /*
       * Busca en la lista los usuarios que son autores
       * para mostrarlos en el comboBox a la hora de ingresar una nueva obra
       * y así asignarle a la obra un autor ya registrado en el sistema
       */
        for (int i = 0; i <= clienteLista.size() - 1; i++) {
            Cliente c = (Cliente) clienteLista.get(i);
            if (c.getTipoUsuario().equalsIgnoreCase("Autor")) {
                
                comboBoxAutor.getItems().addAll(c.getNombreUnico());
                
            }
        } //Fin for
        
        
        /*Campos deshabilitados hasta que se escoja el tipo de obra
        * que se va agregar al sistema
        */ 
        textFieldTema.setDisable(true);
        textFieldSubtema.setDisable(true);
        datePickerFechaPublicacion.setDisable(true);
        textAreaResumen.setDisable(true);
        textFieldEdicion.setDisable(true);
        textFieldConferencia.setDisable(true);
        textFieldIsbn.setDisable(true);
        textFieldIssn.setDisable(true);
        textAreaSummary.setDisable(true);
        
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
    
    @FXML
    private void buttonAgregar() {
        try {
            Logica l = new Logica();

            LocalDate fechaIngreso = datePickerFechaIngreso.getValue();
            LocalDate fechaPublicacion = datePickerFechaPublicacion.getValue();

            if (comboBoxTipoObra.getValue().toString().equalsIgnoreCase("Libro")) {
                if (textFieldTitulo.getText().equals("") || fechaIngreso.equals("") || comboBoxAutor.getValue().toString().equals("") || textFieldIsbn.getText().equals("")
                        || textFieldTema.getText().equals("") || textFieldSubtema.getText().equals("")) {
                    labelMensaje.setText("Ingrese todos los datos");
                } else {
                    l.agregarLibro(textFieldTitulo.getText(), fechaIngreso.toString(), comboBoxAutor.getValue().toString(), textFieldIsbn.getText(), textFieldTema.getText(), textFieldSubtema.getText());
                    labelMensaje.setText("Obra agregada");
                    buttonAgregar.setDisable(true);
                }
            } else if (comboBoxTipoObra.getValue().toString().equalsIgnoreCase("Revista")) {
                if (textFieldTitulo.getText().equals("") || fechaIngreso.equals("") || comboBoxAutor.getValue().toString().equals("") || textFieldIssn.getText().equals("")
                        || textFieldEdicion.getText().equals("")) {
                    labelMensaje.setText("Ingrese todos los datos");
                } else {
                    l.agregarRevista(textFieldTitulo.getText(), fechaIngreso.toString(), comboBoxAutor.getValue().toString(), textFieldIssn.getText(), textFieldEdicion.getText());
                    labelMensaje.setText("Obra agregada");
                    buttonAgregar.setDisable(true);
                }
            } else if (comboBoxTipoObra.getValue().toString().equalsIgnoreCase("Tesis")) {
                if (textFieldTitulo.getText().equals("") || fechaIngreso.equals("") || comboBoxAutor.getValue().toString().equals("") || textAreaResumen.getText().equals("")
                        || textAreaSummary.getText().equals("")) {
                    labelMensaje.setText("Ingrese todos los datos");
                } else {
                    l.agregarTesis(textFieldTitulo.getText(), fechaIngreso.toString(), comboBoxAutor.getValue().toString(), textAreaResumen.getText(), textAreaSummary.getText());
                    labelMensaje.setText("Obra agregada");
                    buttonAgregar.setDisable(true);
                }
            } else if (comboBoxTipoObra.getValue().toString().equalsIgnoreCase("Periódico")) {
                if (textFieldTitulo.getText().equals("") || fechaIngreso.equals("") || comboBoxAutor.getValue().toString().equals("") || textFieldIssn.getText().equals("")
                        || fechaPublicacion.equals("")) {
                    labelMensaje.setText("Ingrese todos los datos");
                } else {
                    l.agregarPeriodico(textFieldTitulo.getText(), fechaIngreso.toString(), comboBoxAutor.getValue().toString(), textFieldIssn.getText(), textFieldEdicion.getText(), fechaPublicacion.toString());
                    labelMensaje.setText("Obra agregada");
                    buttonAgregar.setDisable(true);
                }
            } else if (comboBoxTipoObra.getValue().toString().equals("Memoria")) {
                if (textFieldTitulo.getText().equals("") || fechaIngreso.equals("") || comboBoxAutor.getValue().toString().equals("") || textAreaResumen.getText().equals("")
                        || textAreaSummary.getText().equals("") || textFieldConferencia.getText().equals("")) {
                    labelMensaje.setText("Ingrese todos los datos");
                } else {
                    l.agregarMemoria(textFieldTitulo.getText(), fechaIngreso.toString(), comboBoxAutor.getValue().toString(), textAreaResumen.getText(), textAreaSummary.getText(), textFieldConferencia.getText());
                    labelMensaje.setText("Obra agregada");
                    buttonAgregar.setDisable(true);
                }
            }
        } catch (NullPointerException NPE) {
            labelMensaje.setText("Ingrese todos los datos.");
        }
    }
    
    @FXML
    private void buttonOk() {
        try {
        if(comboBoxTipoObra.getValue().equals("Libro")){
            textFieldIsbn.setDisable(false);
            textFieldTema.setDisable(false);
            textFieldSubtema.setDisable(false);
            buttonOk.setDisable(true);
        }
        else if(comboBoxTipoObra.getValue().toString().equals("Revista")) {
            textFieldIssn.setDisable(false);
            textFieldEdicion.setDisable(false);
            buttonOk.setDisable(true);
        }
        else if(comboBoxTipoObra.getValue().toString().equals("Tesis")) {
            textAreaResumen.setDisable(false);
            textAreaSummary.setDisable(false);
            buttonOk.setDisable(true);
        }
        else if(comboBoxTipoObra.getValue().toString().equals("Periódico")) {
            textFieldIssn.setDisable(false);
            textFieldEdicion.setDisable(false);
            datePickerFechaPublicacion.setDisable(false);
            buttonOk.setDisable(true);
        }
        else if(comboBoxTipoObra.getValue().toString().equals("Memoria")) {
            textAreaResumen.setDisable(false);
            textAreaSummary.setDisable(false);
            textFieldConferencia.setDisable(false);
            buttonOk.setDisable(true);
        }
        } catch (NullPointerException NPE) {
            labelMensaje.setText("Ingrese el tipo de obra");
        }
    }
    
}
