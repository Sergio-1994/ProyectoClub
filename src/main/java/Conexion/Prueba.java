/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Conexion;

import Modelo.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tatiana
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conexion = new Conexion(); 
        conexion.establecerConexion();
        try {
          String Query = "USE  CLUBSOCIAL   SELECT cedulaP FROM  Persona INNER JOIN Socio ON Persona.cedulaP = Socio.cedula ";
        //String Query = "SELECT dbo.Persona.cedula, nombre, tipoDeSuscripcion, fondos FROM dbo.Persona INNER JOIN dbo.Socio ON dbo.Persona.cedula = dbo.Socio.cedula WHERE dbo.Persona.cedula = ? ";
        PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(Query);
       // preparedStatement.setString(1,"1");
        System.out.println(preparedStatement.toString());
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("cedulaP"));
        }
        } catch (Exception e) {
            System.out.println("hola" + e.getMessage());
        }
        
        
    }
    
}
