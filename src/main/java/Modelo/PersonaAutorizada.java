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
    
    private int cedulaSocio;

    public PersonaAutorizada(int cedulaSocio, String cedula, String nombre) {
        super(cedula, nombre);
        this.cedulaSocio = cedulaSocio;
    }

    public int getCedulaSocio() {
        return cedulaSocio;
    }

    public void setCedulaSocio(int cedulaSocio) {
        this.cedulaSocio = cedulaSocio;
    }    
    
    
    
}
