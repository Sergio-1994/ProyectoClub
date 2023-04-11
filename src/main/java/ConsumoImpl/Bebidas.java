/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsumoImpl;

import Modelo.Consumo;

/**
 *
 * @author Tatiana
 */
public abstract class Bebidas extends Consumo {
    private String tamaño; 

    public Bebidas(String tamaño, String nombre, String precio) {
        super(nombre, precio);
        this.tamaño = tamaño;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
    
}
