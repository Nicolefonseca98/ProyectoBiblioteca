/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;


public class Usuario extends Cliente{

    public Usuario() {
    }

    public Usuario(String nombreUnico, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion, String tipoUsuario) {
        super(nombreUnico, contraseña, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
    }

    
    
}
