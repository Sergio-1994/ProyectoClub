/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Club;
import Modelo.Socio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ValidarRegistroSocio {

    private Club club;

    public ValidarRegistroSocio(Club club) {
        this.club = club;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public boolean registrarSocio(String nombre, String cedula, String fondosDisponibles, String tipoSuscripcion) {
        boolean estado = false;
        if (nombre.equals("") || nombre.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio");
            return estado;
        }
        if (cedula.equals("") || cedula.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo cédula no puede estar vacio");
            return estado;
        }
        if (fondosDisponibles.equals("") || fondosDisponibles.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo fondos no puede estar vacio");
            return estado;
        }

        try {
            Double.parseDouble(fondosDisponibles);
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El valor debe ser un dato numérico");
            
            
        }

        //A continuación llamamos el método registrarSocio de la clase Club
        try {
            
            estado = club.registrarSocio(nombre, cedula, fondosDisponibles, tipoSuscripcion);
            return estado;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR INESPERADO");
            return estado;
        }

    }

    public void consultarSocio(String cedula, Socio socio) {
        if (cedula.equals("") || cedula.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo cédula no puede estar vacio");
            return;
        }

        try {
            socio = club.buscarSocioId(cedula);
            System.out.println(socio.getNombre());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR INESPERADO");
        }
    }

}
