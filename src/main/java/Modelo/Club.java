/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.Main;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE
 */
public class Club {

    private ArrayList<Socio> socios;
    private ArrayList<Persona> personas;

    public Club() {
        this.socios = new ArrayList();
        this.personas = new ArrayList();
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public boolean eliminarSocio(int cedulaCliente) {
        return true;
    }

    public double totalConsumos(int cedulaCliente) {
        return 0;
    }

    public boolean registrarSocio(String nombre, String cedula, String fondosDisponibles, String tipoSuscripcion) {
        Socio socio = buscarSocio(cedula);
        boolean suscripcion = sociosVIP(tipoSuscripcion);
        if (socio != null) {

            int resp = JOptionPane.showConfirmDialog(null, "El socio ya existe desea actualizarlo?", "Confirmar salida", JOptionPane.OK_CANCEL_OPTION);
            System.out.println(resp);
            if (resp == 0) {
                suscripcion = true;
                boolean respu = Validarfondo(fondosDisponibles, tipoSuscripcion, suscripcion);
                if (respu == true) {
                    socio.setNombre(nombre);
                    socio.setFondoDisponible(fondosDisponibles);
                    return true;
                }

                return false;
            }
            return false;
        }
        if (suscripcion == false) {
            JOptionPane.showMessageDialog(null, "No hay más cupos para socios VIP!!");
            return false;
        }

        boolean respu = Validarfondo(fondosDisponibles, tipoSuscripcion, suscripcion);
        if (respu == true) {
            //En caso de NO existir un socio con esa cédula ya puedo crearlo como nuevo socio
            socio = new Socio(fondosDisponibles, tipoSuscripcion, nombre, cedula);
            socios.add(socio);
            JOptionPane.showMessageDialog(null, socio.getNombre()
                    + " bienvenido, ya eres miembro del club social");

            return true;
        }
        return false;

    }

    public boolean Validarfondo(String fondosDisponibles, String tipoSuscripcion, boolean suscripcion) {
        if (suscripcion == true) {
            if (tipoSuscripcion.equals("VIP") && (Double.parseDouble(fondosDisponibles) < 100000 || Double.parseDouble(fondosDisponibles) > 5000000)) {
                JOptionPane.showMessageDialog(null, "El valor del fondo del afiliado VIP no puede ser menor a 100000 y mayor a 5000000$");
                return false;

            }
        }

        if (tipoSuscripcion.equals("Regular") && (Double.parseDouble(fondosDisponibles) < 50000 || Double.parseDouble(fondosDisponibles) > 1000000)) {
            JOptionPane.showMessageDialog(null, "El valor del fondo del afiliado regular no puede ser menor a 50000 y mayor a 1000000$");
            return false;

        }
        return true;

    }

    public Socio buscarSocio(String cedula) {
        for (Socio socio : this.socios) {
            if (socio.getCedula().equals(cedula)) {
                return socio;
            }
        }
        return null;
    }

    public Socio buscarSocioId(String cedula) {
        for (Socio socio : this.socios) {
            if (socio.getCedula().equals(cedula)) {
                return socio;

            }
        }
        return null;
    }

    /**
     * Método para validar el número de socios VIP
     */
    private boolean sociosVIP(String tipoSuscripcion) {
        int cont = 1;
        if (tipoSuscripcion.equals("VIP")) {
            for (Socio socio : this.socios) {
                if (socio.getTipoSuscripcion().equals(tipoSuscripcion)) {
                    cont++;
                }
            }
        }
        return cont <= 3;
    }

    public void listarPersonas() {
        String salida = "";
        for (Socio interador : socios) {
            salida += interador.listarPersonas() + '\n';
        }
        JOptionPane.showMessageDialog(null, salida);
    }

}
