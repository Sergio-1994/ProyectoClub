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

    public void registrarSocio(String nombre, String cedula, String fondosDisponibles, String tipoSuscripcion) {
        if (nombre.equals("") || nombre.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio");
            return;
        }
        if (cedula.equals("") || cedula.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo cédula no puede estar vacio");
            return;
        }
        if (fondosDisponibles.equals("") || fondosDisponibles.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo fondos no puede estar vacio");
            return;
        }

        try {
            Double.parseDouble(fondosDisponibles);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El valor debe ser un dato numérico");
        }

        //A continuación llamamos el método registrarSocio de la clase Club
        try {
            club.registrarSocio(nombre, cedula, fondosDisponibles, tipoSuscripcion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR INESPERADO");
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
            return socio;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR INESPERADO");
        }
    }

}
