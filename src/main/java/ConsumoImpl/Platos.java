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
public class Platos extends Consumo {
    private int ingredientes;

    public Platos(int ingredientes, String nombre, String precio) {
        super(nombre, precio);
        this.ingredientes = ingredientes;
    }
    

    public int getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(int ingredientes) {
        this.ingredientes = ingredientes;
    }




  


}
