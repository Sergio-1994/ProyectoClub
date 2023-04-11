/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsumoImpl;

/**
 *
 * @author Tatiana
 */
public class BebidasFriasAlcoholicas extends BebidasFrias {
    private double gradoAlcohol;

    public BebidasFriasAlcoholicas(double gradoAlcohol, String Marca, String tamaño, String nombre, String precio) {
        super(Marca, tamaño, nombre, precio);
        this.gradoAlcohol = gradoAlcohol;
    }

    public double getGradoAlcohol() {
        return gradoAlcohol;
    }

    public void setGradoAlcohol(double gradoAlcohol) {
        this.gradoAlcohol = gradoAlcohol;
    }
    
}
