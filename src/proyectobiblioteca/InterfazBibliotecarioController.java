
package proyectobiblioteca;

import static Listas.Listas.usuarioLogin;
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
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class InterfazBibliotecarioController implements Initializable {

    @FXML private Button buttonAgregarUsuario;
    @FXML private Button buttonModificarUsuario;
    @FXML private Button buttonBorrarUsuario;
    @FXML private Button buttonAgregarObra;
    @FXML private Button buttonModificarObra;
    @FXML private Button buttonBorrarObra;
    @FXML private Button buttonPrestarLibro;
    @FXML private Button buttonListas;
    @FXML private Button buttonSalir;
    
    @FXML
    private void buttonAgregarUsuario(ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazAgregar.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.getIcons().add(new Image("/imagen/libros.png")); 
        window.show();
        
    }
    
    @FXML
    private void buttonModificarUsuario(ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazModificar.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png")); 
        window.setScene(scene);
        window.show();
        
    }
    
    @FXML
    private void buttonBorrarUsuario (ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazBorrar.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png")); 
        window.setScene(scene);
        window.show();
        
    }
    
    @FXML
    private void buttonAgregarObra (ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazAgregarObra.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png")); 
        window.setScene(scene);
        window.show();
        
    }
    
     @FXML
    private void buttonSalir(ActionEvent event) throws IOException {
        
        usuarioLogin.remove(0);
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazLoginUsuario.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png")); 
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void buttonModificarObra(ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazModificarObra.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png"));  
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void buttonPrestarLibro(ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazPrestarLibro.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png"));
        window.setTitle("Proyecto Biblioteca");
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }
    @FXML
    private void buttonBorrarObra(ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazBorrarObra.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png"));  
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void buttonListas(ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazListaObras.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png")); 
        window.setScene(scene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Imágenes de los botones
        buttonAgregarUsuario.setEffect(new ImageInput(new Image("/imagen/agregar-usuario.png")));
        buttonModificarUsuario.setEffect(new ImageInput(new Image("/imagen/usuario.png")));
        buttonBorrarUsuario.setEffect(new ImageInput(new Image("/imagen/borrarUsuario.png")));
        buttonAgregarObra.setEffect(new ImageInput(new Image("/imagen/agregarLibro.png")));
        buttonBorrarObra.setEffect(new ImageInput(new Image("/imagen/eliminarLibro.png")));
        buttonModificarObra.setEffect(new ImageInput(new Image("/imagen/modificarLibro.png")));
        buttonPrestarLibro.setEffect(new ImageInput(new Image("/imagen/estudiar.png")));
        buttonListas.setEffect(new ImageInput(new Image("/imagen/listaLibro.png")));
        buttonSalir.setEffect(new ImageInput(new Image("/imagen/salir.png")));
    }    
    
}
