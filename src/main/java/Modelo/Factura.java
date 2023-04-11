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
    
    public Factura(){
        
    }


    public Factura(String concepto, String valor, String cedulaSocio) {
        this.concepto = concepto;
        this.valor = valor;
        this.cedulaSocio = cedulaSocio;
        this.fechaFactura = new Date();

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

    public Consumo registrarConsumo(String cedula, String totalPagar, String tipoBebida, int tipoServicio) {

        FabricaDeConsumos fabrica = new FabricaDeConsumos();

        try {

            Consumo consumo = fabrica.fabricaConsumo(cedula, totalPagar, tipoBebida, tipoServicio);
            JOptionPane.showMessageDialog(null, "Su pedido ha sido generado, por favor espere"); 
            return consumo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR INESPERADO");   
            return null;
        }

    }

}
