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
    Socio socio = new Socio();

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
        socio = club.buscarSocioId(cedula);
        int respuesta;

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
        //*********************************       

        if ((socio != null
                && socio.getCedula().equals(cedula))
                && tipoSuscripcion.equals("VIP")
                && socio.getFondoDisponible().equals(fondosDisponibles)) {
            JOptionPane.showMessageDialog(null, "La cédula del socio VIP ingresado ya existe");
            return false;

        }

        //***********************************
        if ((socio != null
                && socio.getCedula().equals(cedula))
                && tipoSuscripcion.equals("Regular")
                && socio.getFondoDisponible().equals(fondosDisponibles)) {

            JOptionPane.showMessageDialog(null, "La cédula del socio Regular ingresado ya existe");
            return false;

        }

        if ((socio != null && socio.getCedula().equals(cedula))
                && !socio.getFondoDisponible().equals(fondosDisponibles)
                && tipoSuscripcion.equals("VIP")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Desea actualizar el monto del socio "
                    + tipoSuscripcion + "?",
                    "Confirmar salida", JOptionPane.OK_CANCEL_OPTION);

            return club.editarSocio(cedula, fondosDisponibles, tipoSuscripcion, respuesta);

        }

        if ((socio != null && socio.getCedula().equals(cedula))
                && !socio.getFondoDisponible().equals(fondosDisponibles)
                && tipoSuscripcion.equals("Regular")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Desea actualizar el monto del socio "
                    + tipoSuscripcion + "?",
                    "Confirmar salida", JOptionPane.OK_CANCEL_OPTION);

            return club.editarSocio(cedula, fondosDisponibles, tipoSuscripcion, respuesta);

        }

        //*********************************
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

    public Socio consultarSocio(String cedula) {
        //Socio socio = new Socio();

        if (cedula.equals("") || cedula.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo cédula no puede estar vacio");
            return null;
        } else {
            socio = club.buscarSocioId(cedula);
            return socio;
        }

    }

}
