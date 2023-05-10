/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE
 */
public class Socio extends Persona {

    private int idSocio;
    private ArrayList<PersonaAutorizada> personasAutorizadas;
    private String fondoDisponible;
    private String tipoSuscripcion;

    public Socio(String fondoDisponible, String tipoSuscripcion, String nombre, String cedula) {
        super(nombre, cedula);
        this.fondoDisponible = fondoDisponible;
        this.tipoSuscripcion = tipoSuscripcion;
        this.personasAutorizadas = new ArrayList();
    }

    public Socio() {
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getFondoDisponible() {
        return fondoDisponible;
    }

    public void setFondoDisponible(String fondoDisponible) {
        this.fondoDisponible = fondoDisponible;
    }

    public String getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(String tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public ArrayList<PersonaAutorizada> getPersonasAutorizadas() {
        return personasAutorizadas;
    }

    public void setPersonasAutorizadas(ArrayList<PersonaAutorizada> personasAutorizadas) {
        this.personasAutorizadas = personasAutorizadas;
    }
    
    

    public String listarPersonas() {
        String salida = "";
        for (PersonaAutorizada personaAutorizada : this.personasAutorizadas) {
            salida += personaAutorizada.getNombre() + "|"
                    + personaAutorizada.getCedula() + "|"
                    + personaAutorizada.getCedulaSocio() + "\n";
        }
        return salida;
    }

}
