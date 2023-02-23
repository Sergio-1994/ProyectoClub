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
public class Persona {
    
    private String cedula;
    private String nombre;
    private ArrayList<Factura> factura;

    public Persona(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.factura = new ArrayList();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Factura> getFactura() {
        return factura;
    }

    public void setFactura(ArrayList<Factura> factura) {
        this.factura = factura;
    }
    
    
    
    
    
    
}
