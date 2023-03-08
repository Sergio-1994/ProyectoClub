/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsumoImpl;

/**
 *
 * @author Tatiana
 */
public class BebidasFriasNoAlcoholicas extends BebidasFrias{
    private double gramajeAzucar;

    public BebidasFriasNoAlcoholicas(double gramajeAzucar, String Marca, String tamaño, String nombre, double precio) {
        super(Marca, tamaño, nombre, precio);
        this.gramajeAzucar = gramajeAzucar;
    }

    public double getGramajeAzucar() {
        return gramajeAzucar;
    }

    public void setGramajeAzucar(double gramajeAzucar) {
        this.gramajeAzucar = gramajeAzucar;
    }
    
    
}
