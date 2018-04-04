
package Listas;

import Dominio.Obra;
import Dominio.PrestarLibro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Listas {
    
    public static ObservableList<Object> clienteLista = FXCollections.observableArrayList();
     
    public static ObservableList<Object> libroLista = FXCollections.observableArrayList();
    
    public static ObservableList<Object> revistaLista = FXCollections.observableArrayList();
    
    public static ObservableList<Object> tesisLista = FXCollections.observableArrayList();
    
    public static ObservableList<Object> periodicosLista = FXCollections.observableArrayList();
    
    public static ObservableList<Object> memoriasLista = FXCollections.observableArrayList();
    
    public static ObservableList<Obra> obraLista = FXCollections.observableArrayList();
    
    public static ObservableList<PrestarLibro> librosPrestados = FXCollections.observableArrayList();
    
}
