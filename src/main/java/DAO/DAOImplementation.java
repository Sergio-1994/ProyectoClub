/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tatiana
 */
public class DAOImplementation implements DaoService {

    private Connection conexion;

    public DAOImplementation(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public Socio buscarSocioId(String cedula) throws SQLException {
        Socio socio = null;
        String Query = "USE  CLUBSOCIAL   SELECT cedulaP, nombre, tipoDeSuscripcion, fondos FROM                     Persona \n"
                + "                    INNER JOIN Socio ON Persona.cedulaP = Socio.cedula WHERE cedulaP = ? ";
        //String Query = "SELECT dbo.Persona.cedula, nombre, tipoDeSuscripcion, fondos FROM dbo.Persona INNER JOIN dbo.Socio ON dbo.Persona.cedula = dbo.Socio.cedula WHERE dbo.Persona.cedula = ? ";
        PreparedStatement preparedStatement = conexion.prepareStatement(Query);
        preparedStatement.setString(1, cedula);
        System.out.println(preparedStatement.toString());
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            String nombre = rs.getString("nombre");
            String tipoDeSuscripcion = rs.getString("tipoDeSuscripcion");
            String cedulaR = rs.getString("cedulaP");
            String fondos = rs.getString("fondos");
            socio = new Socio(fondos, tipoDeSuscripcion, nombre, cedula);
        }

        System.out.println("Lo que se encontro " + rs);
        rs.close();
        preparedStatement.close();

        return socio;
    }

    @Override
    public void registrarSocio(Socio socio) throws SQLException {
        String Query = "USE [CLUBSOCIAL] INSERT INTO [dbo].[Persona] ([cedulaP],[nombre]) VALUES (?,?)";
        PreparedStatement preparedStatement = conexion.prepareStatement(Query);
        preparedStatement.setString(1, socio.getCedula());
        preparedStatement.setString(2, socio.getNombre());
        preparedStatement.execute();
        preparedStatement.close();

        String Query2 = "USE [CLUBSOCIAL] INSERT INTO [dbo].[socio] ([cedula],[tipoDeSuscripcion],fondos) VALUES (?,?,?)";
        PreparedStatement preparedStatement2 = conexion.prepareStatement(Query2);
        preparedStatement2.setString(1, socio.getCedula());
        preparedStatement2.setString(2, socio.getTipoSuscripcion());
        preparedStatement2.setString(3, socio.getFondoDisponible());
        preparedStatement2.execute();
        preparedStatement2.close();

    }

    @Override
    public boolean buscarSociosVIP(String tpoSuscripcion) throws SQLException {
        int cant = 0;
        String Query = "USE [CLUBSOCIAL] SELECT COUNT(ID) AS CANT FROM SOCIO WHERE tipoDeSuscripcion = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(Query);
        preparedStatement.setString(1, tpoSuscripcion);
        ResultSet rs = preparedStatement.executeQuery();
        preparedStatement.close();
        if (rs.next()) {
            cant = rs.getInt("CANT");

        }
        if (cant < 4) {
            return true;
        } else {
            return false;
        }

    }
     @Override
     public void actualizarMonto(String cedula, double nuevoMonto) throws SQLException {
        
        String Query = "USE [CLUBSOCIAL] UPDATE SOCIO SET fondos = ? WHERE cedula = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(Query);
        preparedStatement.setDouble(1, nuevoMonto);
        preparedStatement.setString(2, cedula);
        preparedStatement.execute();
        preparedStatement.close();
        
     }
     
}
