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

    private String nombre;
    private String cedula;

    private ArrayList<Factura> factura;

    public Persona() {

    }

    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.factura = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ArrayList<Factura> getFactura() {
        return factura;
    }

    public void setFactura(ArrayList<Factura> factura) {
        this.factura = factura;
    }

    public String listarFacturas() {
        String salida = "";
        for (Factura iterador : this.factura) {
            salida += iterador.getCedula() + "|"
                    + iterador.getConcepto() + "|"
                    + iterador.getValor() + "|"
                    + iterador.getEstado() + "\n";
        }

        return salida;
    }


    

}
