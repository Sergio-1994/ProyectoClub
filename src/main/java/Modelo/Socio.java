/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author ESTUDIANTE
 */
public class Socio extends Persona{
    
    private int idSocio;
    private ArrayList<PersonaAutorizada> personaAutorizada;
    private String fondoDisponible;
    private String tipoSuscripcion;

    public Socio(String fondoDisponible, String tipoSuscripcion, String cedula, String nombre) {
        super(cedula, nombre);
        this.fondoDisponible = fondoDisponible;
        this.tipoSuscripcion = tipoSuscripcion;
        this.personaAutorizada = new ArrayList();
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
    
    
    
    
    
    
    
}
