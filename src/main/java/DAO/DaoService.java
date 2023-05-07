/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Socio;
import java.sql.SQLException;

/**
 *
 * @author Tatiana
 */
public interface DaoService {
     public Socio buscarSocioId(String cedula) throws SQLException;
     public void registrarSocio(Socio socio)throws SQLException;
     public boolean buscarSociosVIP(String tpoSuscripcion)throws SQLException;
     public void actualizarMonto(String cedula, double nuevoMonto)throws SQLException;
    
}
