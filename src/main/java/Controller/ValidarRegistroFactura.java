/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Club;
import Modelo.Factura;
import Modelo.Socio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tatiana
 */
public class ValidarRegistroFactura {

    private Club club;
    
    private Socio socio;

    public ValidarRegistroFactura(Club club) {
        this.club = club;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }



    public boolean registrarFactura(String concepto, String valor, String cedulaSocio) {
        boolean estado = false;
    
        
        if (concepto.equals("") || concepto.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo concepto no puede estar vacio");
            return estado;
        }
        if (valor.equals("") || valor.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo valor no puede estar vacio");
            return estado;
        }
        if (cedulaSocio.equals("") || cedulaSocio.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo cedula socio no puede estar vacio");
            return estado;
        }
        
        if (club.buscarSocioId(cedulaSocio) == null) {
            JOptionPane.showMessageDialog(null, "¡No existe un Socio con el número de cédula ingresado!");
            return estado;
        }

        
        return true;
    }

}
