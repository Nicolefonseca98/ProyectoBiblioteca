
package proyectobiblioteca;

import Dominio.Autor;
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
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InterfazAgregarObraController implements Initializable {

    @FXML private ComboBox comboBoxObra;
    @FXML private TextField txfTitulo;
    @FXML private DatePicker dtFechaIngreso;
    @FXML private ComboBox comboBoxAutor;
    @FXML private TextField txfTema;
    @FXML private TextField txfSubtema;
    @FXML private DatePicker dtFechaPublicacion;
    @FXML private TextField txfEdicion;
    @FXML private TextArea txaResumen;
    @FXML private TextField txfConferencia;
    @FXML private TextField txfISBN;
    @FXML private TextField txfISSN;
    @FXML private TextArea txaSummary;
    @FXML private Label lbMensaje;
    @FXML private Button btnAgregar;
    @FXML private Button btnOk;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Tipos de obras a elegir por el usuario
        comboBoxObra.getItems().addAll("Libro", "Revista", "Tesis", "Periódico", "Memoria");
        
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
        
        
        /*Campos deshabilitados hasta que se escoja el tipo de obra
        * que se va agregar al sistema
        */ 
        txfTema.setDisable(true);
        txfSubtema.setDisable(true);
        dtFechaPublicacion.setDisable(true);
        txaResumen.setDisable(true);
        txfEdicion.setDisable(true);
        txfConferencia.setDisable(true);
        txfISBN.setDisable(true);
        txfISSN.setDisable(true);
        txaSummary.setDisable(true);
        
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
    
@FXML
    private void agregar() {
        try {
        Logica l = new Logica();
        
         LocalDate fechaIngreso = dtFechaIngreso.getValue();
         LocalDate fechaPublicacion = dtFechaPublicacion.getValue();
        
        if(comboBoxObra.getValue().toString().equalsIgnoreCase("Libro")) {
            if (txfTitulo.getText().equals("") || fechaIngreso.equals("") || comboBoxAutor.getValue().toString().equals("") || txfISBN.getText().equals("")
                || txfTema.getText().equals("") || txfSubtema.getText().equals("")) {
                lbMensaje.setText("Ingrese todos los datos");
            } else {
            l.agregarLibro(txfTitulo.getText(), fechaIngreso.toString(), comboBoxAutor.getValue().toString(), txfISBN.getText(), txfTema.getText(), txfSubtema.getText());
            lbMensaje.setText("Obra agregada");
            btnAgregar.setDisable(true);
            }
        } else if (comboBoxObra.getValue().toString().equalsIgnoreCase("Revista")){
            if (txfTitulo.getText().equals("") || fechaIngreso.equals("") || comboBoxAutor.getValue().toString().equals("") || txfISSN.getText().equals("")
                || txfEdicion.getText().equals("")) {
            } else {
                l.agregarRevista(txfTitulo.getText(), fechaIngreso.toString(), comboBoxAutor.getValue().toString(), txfISSN.getText(), txfEdicion.getText());
                lbMensaje.setText("Obra agregada");
            btnAgregar.setDisable(true);
            }           
        }
        else if (comboBoxObra.getValue().toString().equalsIgnoreCase("Tesis")) {
            if (txfTitulo.getText().equals("") || fechaIngreso.equals("") || comboBoxAutor.getValue().toString().equals("") || txaResumen.getText().equals("")
                || txaSummary.getText().equals("")) {
            } else {
            l.agregarTesis(txfTitulo.getText(), fechaIngreso.toString(), comboBoxAutor.getValue().toString(), txaResumen.getText(), txaSummary.getText());
            lbMensaje.setText("Obra agregada");
            btnAgregar.setDisable(true);
            }
        }
        else if (comboBoxObra.getValue().toString().equalsIgnoreCase("Periódico")) {
            if (txfTitulo.getText().equals("") || fechaIngreso.equals("") || comboBoxAutor.getValue().toString().equals("") || txfISSN.getText().equals("") 
                || fechaPublicacion.equals("")) {    
            } else {
            l.agregarPeriodico(txfTitulo.getText(), fechaIngreso.toString(), comboBoxAutor.getValue().toString(), txfISSN.getText(), txfEdicion.getText(), fechaPublicacion.toString());
            lbMensaje.setText("Obra agregada");
            btnAgregar.setDisable(true);
            }
        }
        else if (comboBoxObra.getValue().toString().equals("Memoria")) {
            if (txfTitulo.getText().equals("") || fechaIngreso.equals("") || comboBoxAutor.getValue().toString().equals("") || txaResumen.getText().equals("")
                || txaSummary.getText().equals("") || txfConferencia.getText().equals("")) {
            }else {
            l.agregarMemoria(txfTitulo.getText(), fechaIngreso.toString(), comboBoxAutor.getValue().toString(), txaResumen.getText(), txaSummary.getText(), txfConferencia.getText());
            lbMensaje.setText("Obra agregada");
            btnAgregar.setDisable(true);
            }
        }   
        }catch (NullPointerException NPE) {
        lbMensaje.setText("Ingrese todos los datos.");
    } 
}
    
    @FXML
    private void btnOk() {
        try {
        if(comboBoxObra.getValue().equals("Libro")){
            txfISBN.setDisable(false);
            txfTema.setDisable(false);
            txfSubtema.setDisable(false);
            btnOk.setDisable(true);
        }
        else if(comboBoxObra.getValue().toString().equals("Revista")) {
            txfISSN.setDisable(false);
            txfEdicion.setDisable(false);
            btnOk.setDisable(true);
        }
        else if(comboBoxObra.getValue().toString().equals("Tesis")) {
            txaResumen.setDisable(false);
            txaSummary.setDisable(false);
            btnOk.setDisable(true);
        }
        else if(comboBoxObra.getValue().toString().equals("Periódico")) {
            txfISSN.setDisable(false);
            txfEdicion.setDisable(false);
            dtFechaPublicacion.setDisable(false);
            btnOk.setDisable(true);
        }
        else if(comboBoxObra.getValue().toString().equals("Memoria")) {
            txaResumen.setDisable(false);
            txaSummary.setDisable(false);
            txfConferencia.setDisable(false);
            btnOk.setDisable(true);
        }
        } catch (NullPointerException NPE) {
            lbMensaje.setText("Ingrese el tipo de obra");
        }
    }
    
}
