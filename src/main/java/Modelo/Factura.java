/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author ESTUDIANTE
 */
public class Factura {
    
    
    private int idFactura;
    private String concepto;
    private String valor;
    private Date fechaFactura;
    private String cedula;
    private String nombre;
    private String estado;
    
    public Factura(){
        
    }


    public Factura(String concepto, String valor, String cedulaSocio, String estado, String nombre,int idFactura) {
        this.concepto = concepto;
        this.valor = valor;
        this.cedula = cedulaSocio;
        this.fechaFactura = new Date();
        this.estado = estado;
        this.nombre = nombre;
        this.idFactura = idFactura;

    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


}
