
package Listas;

import Dominio.Cliente;
import Dominio.Obra;
import Dominio.PrestarLibro;
import Dominio.UsuarioMoroso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// Clase para guardar cada dato en su lista respectiva.
public class Listas {
    
    public static ObservableList<Cliente> clienteLista = FXCollections.observableArrayList();
     
    public static ObservableList<Object> libroLista = FXCollections.observableArrayList();
    
    public static ObservableList<Object> revistaLista = FXCollections.observableArrayList();
    
    public static ObservableList<Object> tesisLista = FXCollections.observableArrayList();
    
    public static ObservableList<Object> periodicosLista = FXCollections.observableArrayList();
    
    public static ObservableList<Object> memoriasLista = FXCollections.observableArrayList();
    
    public static ObservableList<Obra> obraLista = FXCollections.observableArrayList();
    
    public static ObservableList<PrestarLibro> librosPrestados = FXCollections.observableArrayList();

    public static ObservableList<UsuarioMoroso> usuariosMorosos = FXCollections.observableArrayList();
    
    public static ObservableList<Object> usuarioLogin = FXCollections.observableArrayList();
}
