package Controller;

import Modelo.Club;
import Modelo.PersonaAutorizada;
import Modelo.Socio;
import javax.swing.JOptionPane;
import Conexion.Conexion;

public class ValidarRegistroFactura  extends Conexion{

    private Club club;

    public ValidarRegistroFactura(Club club) {
        this.club = club;
         this.establecerConexion();
    }

    public boolean registrarFactura(String cedula,String consumo, String totalPagar) {

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

            club.crearFactura(cedula, consumo, totalPagar,this.getConexion());
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
}
