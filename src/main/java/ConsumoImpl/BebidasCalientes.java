/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsumoImpl;

/**
 *
 * @author Tatiana
 */
public class BebidasCalientes extends Bebidas {
    private String Adiccion;
    private double valorAdd;

    public BebidasCalientes(String Adiccion, double valorAdd, String tamaño, String nombre, String precio) {
        super(tamaño, nombre, precio);
        this.Adiccion = Adiccion;
        this.valorAdd = valorAdd;
    }

    public String getAdiccion() {
        return Adiccion;
    }

    public void setAdiccion(String Adiccion) {
        this.Adiccion = Adiccion;
    }

    public double getValorAdd() {
        return valorAdd;
    }

    public void setValorAdd(double valorAdd) {
        this.valorAdd = valorAdd;
    }
    
    
}
