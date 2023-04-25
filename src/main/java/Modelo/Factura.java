/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import FabricaDeConsumos.FabricaDeConsumos;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE
 */
public class Factura {

    private String concepto;
    private String valor;
    private Date fechaFactura;
    private String cedulaSocio;
    private boolean estado;
    
    public Factura(){
        
    }


    public Factura(String concepto, String valor, String cedulaSocio) {
        this.concepto = concepto;
        this.valor = valor;
        this.cedulaSocio = cedulaSocio;
        this.fechaFactura = new Date();
        this.estado = true;

    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
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

    public String getCedulaSocio() {
        return cedulaSocio;
    }

    public void setCedulaSocio(String cedulaSocio) {
        this.cedulaSocio = cedulaSocio;
    }


}
