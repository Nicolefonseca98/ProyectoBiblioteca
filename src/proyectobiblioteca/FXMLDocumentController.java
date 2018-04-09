package proyectobiblioteca;

import Dominio.Autor;
import Dominio.Bibliotecario;
import Dominio.Cliente;
import Dominio.Libro;
import Dominio.Usuario;
import Dominio.UsuarioLogin;
import Listas.Listas;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.commons.codec.digest.DigestUtils;

public class FXMLDocumentController extends Listas implements Initializable {

    @FXML
    private TextField txfUsuario;
    @FXML
    private PasswordField txfContraseña;
    @FXML
    private Label mensaje;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        Logica logica = new Logica();

        //Ventana función bibliotecario
        Parent parent = FXMLLoader.load(getClass().getResource("InterfazBibliotecario.fxml"));
        Scene scene = new Scene(parent);
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.getIcons().add(new Image("/imagen/libros.png"));

        //Ventana función usuario
        Parent parentUsuario = FXMLLoader.load(getClass().getResource("InterfazFuncionUsuario.fxml"));
        Scene sceneUsuario = new Scene(parentUsuario);
        Stage ventanaUsuario = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ventanaUsuario.getIcons().add(new Image("/imagen/libros.png"));

        String contraseñaEncriptada = DigestUtils.md5Hex(txfContraseña.getText());

        //Verifica datos del usuario
        if (logica.verificaUsuario(txfUsuario.getText(), contraseñaEncriptada, "Bibliotecario")) {

            window.setScene(scene);
            window.show();
            System.out.println(clienteLista.toString());
        } else if (logica.verificaUsuario(txfUsuario.getText(), contraseñaEncriptada, "Usuario")) {  
            UsuarioLogin usuario = new UsuarioLogin(txfUsuario.getText());
            usuarioLogin.add(usuario);
            System.out.println(usuarioLogin.toString());
            ventanaUsuario.setScene(sceneUsuario);
            ventanaUsuario.show();
            
        } else if (logica.verificaUsuario(txfUsuario.getText(), contraseñaEncriptada, "Autor")) {

        } else {
            mensaje.setText("Datos inválidos");
            txfContraseña.setText("");
            txfUsuario.setText("");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String contraseñaEncriptada = DigestUtils.md5Hex("1234");
        //Autor predeterminado
        Autor a = new Autor("autor1", contraseñaEncriptada, "Ana Rodríguez", "Nacional", "123456789", "Autor");
        clienteLista.addAll(a);

        //Bibliotecario predeterminado
        Bibliotecario bl = new Bibliotecario("bibliotecario01", contraseñaEncriptada, "Juan Solano", "Nacional", "123456789", "Bibliotecario");
        clienteLista.add(bl);

        //Usuario predeterminado
        Usuario us = new Usuario("Karla2", contraseñaEncriptada, "Karla Fallas", "Residencia", "109630582", "Usuario");
        clienteLista.add(us);
        
        Libro l = new Libro("123", "a", "a", "a", "2018-04-07", "Ana Rodríguez");
        obraLista.add(l);
        libroLista.add(l);

    }

}
