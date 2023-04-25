/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FabricaDeConsumos;

import ConsumoImpl.Entradas;
import Modelo.Consumo;
import javax.swing.JOptionPane;

/**
 *
 * @author RENTCOM SAS
 */
public class FabricaDeConsumos {

    public FabricaDeConsumos() {

    }

    public Consumo fabricaConsumo( String cedula, int tipoServicio, String entrada, int porcion, String totalPagar) {

        switch (tipoServicio) {

            case 1: {
                return new Entradas("Unica", "Tomate", 5, entrada, totalPagar);
            }

            default: {
                return null;
            }
        }

    }

}
