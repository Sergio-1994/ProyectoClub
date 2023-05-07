/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Tatiana
 */
public class Conexion {
    
    private static String usuario = "UserClub";
    private static String contraseña = "12345678";
    private Connection conexion;
    public Conexion(){
        
    }
    
    public void establecerConexion(){
        try{
            String cadena= "jdbc:sqlserver://TATIANA:1433;datebaseName =CLUBSOCIAL; encrypt= true; trustServerCertificate=true";
            conexion = DriverManager.getConnection(cadena,usuario,contraseña);
            System.out.println("Funciono");
            
            
        }catch(Exception e){
            System.out.println("Tenemos problemas para conectar \n"+ e.getMessage());
        }
        
    }

    protected Connection getConexion() {
        return conexion;
    }

    protected void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
}