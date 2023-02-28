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

    public void registrarPersonaAutorizada(String nombrePersonaAutorizada, String cedulaPersonaAutorizada, String cedulaSocio) {

        PersonaAutorizada personaAutorizada = buscarPersonaAutorizada(cedulaPersonaAutorizada);

        if (personaAutorizada != null) {
            JOptionPane.showMessageDialog(null, "Vaya ya exite una persona con se número de cédula!!");
            return;
        }

        personaAutorizada = new PersonaAutorizada(nombrePersonaAutorizada, cedulaPersonaAutorizada, cedulaSocio);
        personasAutorizadas.add(personaAutorizada);
        JOptionPane.showMessageDialog(null, personaAutorizada.getNombre()
                + " bienvenido, ya eres una persona autorizada");
        listarPersonas();

    }

    public PersonaAutorizada buscarPersonaAutorizada(String cedula) {
        for (PersonaAutorizada personaAutorizada : this.personasAutorizadas) {
            if (personaAutorizada.getCedula().equals(cedula)) {
                return personaAutorizada;
            }
        }
        return null;
    }

    public void listarPersonas() {
        for (PersonaAutorizada personaAutorizada : this.personasAutorizadas) {
            System.out.println("Hola: " + personaAutorizada.getNombre());
        }
    }

}
