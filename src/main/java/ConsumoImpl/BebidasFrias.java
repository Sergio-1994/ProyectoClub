/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsumoImpl;

/**
 *
 * @author Tatiana
 */
public class BebidasFrias extends Bebidas{
    private String Marca;

    public BebidasFrias(String Marca, String tamaño, String nombre, double precio) {
        super(tamaño, nombre, precio);
        this.Marca = Marca;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    
    
}
