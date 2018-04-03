/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

import Dominio.Libro;
import Dominio.Obra;
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
    
    public static ObservableList<Libro> librosPrestados = FXCollections.observableArrayList();
    
}
