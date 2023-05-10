/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Conexion.Conexion;
import Modelo.Club;
import Modelo.Socio;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValidarRegistroPersonaAutodizada extends Conexion {

    private Club club;
    private Socio socio;

    public ValidarRegistroPersonaAutodizada(Club club) {
        this.club = club;
        this.establecerConexion();
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public boolean registrarPersonaAutorizada(String nombrePersonaAutorizada, String cedulaPersonaAutorizada, String cedulaSocio) {
        if (nombrePersonaAutorizada.equals("")) {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio");
            return false;
        }
        if (cedulaPersonaAutorizada.equals("")) {
            JOptionPane.showMessageDialog(null, "El campo cédula persona autorizado no puede estar vacio");
            return false;
        }
        if (cedulaSocio.equals("")) {
            JOptionPane.showMessageDialog(null, "El campo cédula socio no puede estar vacio");
            return false;
        }
        if (!verificarNumeroEntero(cedulaPersonaAutorizada) || !verificarNumeroEntero(cedulaSocio)) {
            JOptionPane.showMessageDialog(null, "El campo cédula debe ser un número entero");
            return false;

        }

        try {

            boolean estado = club.registrarPersonaAutorizada(nombrePersonaAutorizada, cedulaPersonaAutorizada, cedulaSocio, this.getConexion());
            return estado;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR INESPERADO" + e);
            return false;
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

    public void listarPersonas(String cedula) {
        if (cedula.equals("")) {
            JOptionPane.showMessageDialog(null, "El campo cédula socio no puede estar vacio");
            return;
        }
         try {

            club.listarPersonas(cedula, this.getConexion());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR INESPERADO" + e.getMessage() + "/n" + e.getCause());
            for (StackTraceElement stack : e.getStackTrace()) {
                System.out.println(stack.toString());
            };
            
        } finally {
            try {
                this.getConexion().close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Fallo cerrando conexión " + ex);
                for (StackTraceElement stack : ex.getStackTrace()) {
                    System.out.println(stack.toString());
                };
            }

        }

    }

}
