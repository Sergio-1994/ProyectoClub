/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ESTUDIANTE
 */
public class Factura {
    private String concepto;
    private double valor;
    private Date fechaFactura;
    private ArrayList<Socio> socios;

    public Factura(String concepto, double valor, ArrayList<Socio> socios) {
        this.concepto = concepto;
        this.valor = valor;
        this.socios = socios;
        this.fechaFactura = new Date();
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }
}
