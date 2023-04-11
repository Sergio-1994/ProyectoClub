/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsumoImpl;

/**
 *
 * @author Tatiana
 */
public  class Entradas extends Platos{
    private String porcion;
    private String salsa;

    public Entradas(String porcion, String salsa, int ingredientes, String nombre, String precio) {
        super(ingredientes, nombre, precio);
        this.porcion = porcion;
        this.salsa = salsa;
    }

    public String getPorcion() {
        return porcion;
    }

    public void setPorcion(String porcion) {
        this.porcion = porcion;
    }

    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }
    
}
