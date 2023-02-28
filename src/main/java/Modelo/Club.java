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

    public void registrarSocio(String nombre, String cedula, String fondosDisponibles, String tipoSuscripcion) {
        Socio socio = buscarSocio(cedula);
        boolean suscripcion = sociosVIP(tipoSuscripcion);
        if (socio != null) {
            JOptionPane.showMessageDialog(null, "Vaya ya esxite un socio con ese número de cédula!!");
            return;
        }
        if (suscripcion == false) {
            JOptionPane.showMessageDialog(null, "No hay más cupos para socios VIP!!");
            return;
        }
        if (suscripcion == true) {
            if (tipoSuscripcion.equals("VIP") && Double.parseDouble(fondosDisponibles) < 100000) {
                JOptionPane.showMessageDialog(null, "Socios VIP deben tener un fondo inicial de 100000$");
                return;
            }

        }
        if (!tipoSuscripcion.equals("VIP") && Double.parseDouble(fondosDisponibles) < 50000) {
            JOptionPane.showMessageDialog(null, "Socios Regulares deben tener un fondo inicial de 50000$");
            return;
        }
        
        //En caso de NO existir un socio con esa cédula ya puedo crearlo como nuevo socio
        socio = new Socio(fondosDisponibles, tipoSuscripcion, nombre, cedula);
        socios.add(socio);
        JOptionPane.showMessageDialog(null, socio.getNombre()
                + " bienvenido, ya eres miembro del club social");    
            

    }

    public Socio buscarSocio(String cedula) {
        for (Socio socio : this.socios) {
            if (socio.getCedula().equals(cedula)) {
                return socio;
            }
        }
        return null;
    }
    
    public void  buscarSocioId(String cedula) {
        for (Socio socio : this.socios) {
            if (socio.getCedula().equals(cedula)) {
                System.out.println(""+socio.getNombre());
                
            }
        }
        
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
    
    

}
