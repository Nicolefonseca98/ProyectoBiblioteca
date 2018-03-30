
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
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class InterfazBibliotecarioController implements Initializable {

    @FXML
    private void accionBoton(ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazAgregar.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.getIcons().add(new Image("/imagen/libros.png")); 
        window.show();
        
    }
    
    @FXML
    private void botonModificar(ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazModificar.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png")); 
        window.setScene(scene);
        window.show();
        
    }
    
    @FXML
    private void botonBorrar (ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazBorrar.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png")); 
        window.setScene(scene);
        window.show();
        
    }
    
    @FXML
    private void agregarObra (ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazAgregarObra.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png")); 
        window.setScene(scene);
        window.show();
        
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
    
    @FXML
    private void botonModificarObra(ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazModificarObra.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png"));       
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void botonPrestarLibro(ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazPrestarLibro.fxml"));
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
