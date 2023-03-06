/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Club;
import Modelo.Socio;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValidarRegistroPersonaAutodizada {

    private Club club;
    private Socio socio;

    public ValidarRegistroPersonaAutodizada(Club club) {
        this.club = club;

    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public void registrarPersonaAutorizada(String nombrePersonaAutorizada, String cedulaPersonaAutorizada, String cedulaSocio) {
        if (nombrePersonaAutorizada.equals("")) {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio");
            return;
        }
        if (cedulaPersonaAutorizada.equals("")) {
            JOptionPane.showMessageDialog(null, "El campo cédula persona autorizado no puede estar vacio");
            return;
        }
        if (cedulaSocio.equals("")) {
            JOptionPane.showMessageDialog(null, "El campo cédula socio no puede estar vacio");
            return;
        }
        if (!verificarNumeroEntero(cedulaPersonaAutorizada) || !verificarNumeroEntero(cedulaSocio)) {
            JOptionPane.showMessageDialog(null, "El campo cédula debe ser un número entero");
            return;
        }

        if (club.buscarSocioId(cedulaSocio) == null) {
            JOptionPane.showMessageDialog(null, "¡No existe un Socio con el número de cédula ingresado!");
            return;
        }

        if (cedulaPersonaAutorizada.equals(cedulaSocio)) {
            JOptionPane.showMessageDialog(null, "¡El número de cédula ingresado no puede ser igual al del socio!");
            return;
        }

        //Una vez validado el formulario procedemos a crear la persona autorizada
        try {

            socio = club.buscarSocioId(cedulaSocio);
            socio.registrarPersonaAutorizada(nombrePersonaAutorizada, cedulaPersonaAutorizada, cedulaSocio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR INESPERADO" + e);
        }

    }

    public boolean verificarNumeroEntero(String cedula) {
        try {
            Integer.parseInt(cedula);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
