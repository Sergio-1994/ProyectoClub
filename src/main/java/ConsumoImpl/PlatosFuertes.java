/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsumoImpl;

/**
 *
 * @author Tatiana
 */
public class PlatosFuertes extends Platos {
    private String BebidaNoAlcoholica;
    private String TipoPlato;

    public PlatosFuertes(String BebidaNoAlcoholica, String TipoPlato, int ingredientes, String nombre, String precio) {
        super(ingredientes, nombre, precio);
        this.BebidaNoAlcoholica = BebidaNoAlcoholica;
        this.TipoPlato = TipoPlato;
    }

    public String getBebidaNoAlcoholica() {
        return BebidaNoAlcoholica;
    }

    public void setBebidaNoAlcoholica(String BebidaNoAlcoholica) {
        this.BebidaNoAlcoholica = BebidaNoAlcoholica;
    }

    public String getTipoPlato() {
        return TipoPlato;
    }

    public void setTipoPlato(String TipoPlato) {
        this.TipoPlato = TipoPlato;
    }

    
}
