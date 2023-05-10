/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Factura;
import Modelo.Persona;
import Modelo.PersonaAutorizada;
import Modelo.Socio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tatiana
 */
public interface DaoService {
     public Socio buscarSocioId(String cedula) throws SQLException;
     public void registrarSocio(Socio socio)throws SQLException;
     public boolean buscarSociosVIP(String tpoSuscripcion)throws SQLException;
     public void actualizarMonto(String cedula, double nuevoMonto)throws SQLException;
     public String eliminarSocio(String cedula) throws SQLException;
     public void registrarAutorizado(PersonaAutorizada personaAutorizada) throws SQLException;
     public PersonaAutorizada buscarPersonaAutorizadaId(String cedula) throws SQLException;
     public List<Persona> listarPersonas(String cedula) throws SQLException;
     public void registrarFactura(Factura factura) throws SQLException;
    
}
