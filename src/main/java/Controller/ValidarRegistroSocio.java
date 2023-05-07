/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Conexion.Conexion;
import Modelo.Club;
import Modelo.Socio;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ValidarRegistroSocio extends Conexion {

    private Club club;
    Socio socio = new Socio();

    public ValidarRegistroSocio(Club club) {
        super();
        this.club = club;
        this.establecerConexion();
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

            estado = club.registrarSocio(nombre, cedula, fondosDisponibles, tipoSuscripcion, this.getConexion());
            return estado;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR INESPERADO" + e.getMessage() + "/n" + e.getCause());
            for (StackTraceElement stack : e.getStackTrace()) {
                System.out.println(stack.toString());
            };
            return estado;
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

    public void actualizarMonto() {
        String cedula;
        double monto;
        cedula = JOptionPane.showInputDialog("Ingrese la cédula del socio correspondiente");
        monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto"));

        if (cedula.equals("") || cedula.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo cédula no puede estar vacio");
            return;
        }

        if (Double.parseDouble(cedula) < 0) {
            JOptionPane.showMessageDialog(null, "El campo cédula no puede ser un número negativo");
            return;
        }
        if (monto < 0) {
            JOptionPane.showMessageDialog(null, "El campo monto no puede ser un número negativo");
            return;
        }
        //consultarSocio(cedula);
        try {

            club.actualizarMonto(cedula, monto, this.getConexion());

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
    public Socio consultarSocio(String cedula) {

        if (cedula.equals("") || cedula.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo cédula no puede estar vacio");
            return null;
        }

        try {

            if (club.buscarSocioId(cedula, this.getConexion()) == null) {
                JOptionPane.showMessageDialog(null, "No existe un socio con ese número de cédula");
                return null;
            } else {
                socio = club.buscarSocioId(cedula, this.getConexion());
                return socio;
            }

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

        return null;
    }

}
