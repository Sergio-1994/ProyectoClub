/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ESTUDIANTE
 */
public class PersonaAutorizada extends Persona{
    
    private String cedulaSocio;

    public PersonaAutorizada(String nombre, String cedula, String cedulaSocio) {
        super(nombre, cedula);
        this.cedulaSocio = cedulaSocio;
    }

    public String getCedulaSocio() {
        return cedulaSocio;
    }

    public void setCedulaSocio(String cedulaSocio) {
        this.cedulaSocio = cedulaSocio;
    }    
    
    
    
}
