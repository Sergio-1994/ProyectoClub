package Controller;

import Modelo.Club;
import Modelo.PersonaAutorizada;
import Modelo.Socio;
import javax.swing.JOptionPane;
import Conexion.Conexion;
import Modelo.Factura;
import java.util.List;

public class ValidarRegistroFactura extends Conexion {

    private Club club;

    public ValidarRegistroFactura(Club club) {
        this.club = club;
        this.establecerConexion();
    }

    public boolean registrarFactura(String cedula, String consumo, String totalPagar) {

        boolean estado = false;

        if (cedula.equals("") || cedula.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo cédula no puede estar vacio");
            return estado;
        }

        if (totalPagar.equals("") || totalPagar.equals(false)) {
            JOptionPane.showMessageDialog(null, "Es necesario que haga un pedido");
            return estado;
        }

        try {

            club.crearFactura(cedula, consumo, totalPagar, this.getConexion());
            return true;
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

    public List consultarFacturas(String cedula) {
        if (cedula.equals("") || cedula.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo cédula no puede estar vacio");
            return null;
        }
        try {
            
            return club.consultarFacturas(cedula, this.getConexion());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR INESPERADO" + e.getMessage() + "/n" + e.getCause());
            for (StackTraceElement stack : e.getStackTrace()) {
                System.out.println(stack.toString());
            };
             return null;
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

    public void pagarFactura(String IdFactura) {
      if (IdFactura.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo IdFactura no puede estar vacio");
            return ;
        }
        try {
             int valorEntero = Integer.parseInt(IdFactura);
             club.pagarFactura(valorEntero, this.getConexion());
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
