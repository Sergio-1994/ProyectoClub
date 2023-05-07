/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import DAO.DAOImplementation;
import DAO.DaoService;
import FabricaDeConsumos.FabricaDeConsumos;
import Vista.Main;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE
 */
public class Club {

    private ArrayList<Socio> socios;
    private ArrayList<Persona> personas;

    public Club() {
        this.socios = new ArrayList();
        this.personas = new ArrayList();
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public boolean eliminarSocio(int cedulaCliente) {
        return true;
    }

    public double totalConsumos(int cedulaCliente) {
        return 0;
    }

    public boolean registrarSocio(String nombre, String cedula, String fondosDisponibles, String tipoSuscripcion, Connection conexion) throws SQLException {
        Socio socio = buscarSocioId(cedula, conexion);
       boolean suscripcion  = true;
        if (socio == null) {
            if (tipoSuscripcion == "VIP"){
                suscripcion= sociosVIP(tipoSuscripcion, conexion);
            }
            
            if (suscripcion == false) {
                JOptionPane.showMessageDialog(null, "No hay más cupos para socios VIP!!");
                return false;
            }

            boolean respuesta = validarFondo(fondosDisponibles, tipoSuscripcion, suscripcion);
            if (respuesta == true) {
                //En caso de NO existir un socio con esa cédula ya puedo crearlo como nuevo socio
                socio = new Socio(fondosDisponibles, tipoSuscripcion, nombre, cedula);
                DaoService dao = new DAOImplementation(conexion);
                dao.registrarSocio(socio);
                //socios.add(socio);
                JOptionPane.showMessageDialog(null, socio.getNombre()
                        + " bienvenid@, ya eres miembro del club social");
                return true;
            }
        }else{
                JOptionPane.showMessageDialog(null, socio.getNombre()+" Ya existe un registro con esa identificación ");
        
        }
         return false;

    }

    public boolean actualizarMonto(String cedula, double nuevoMonto,Connection conexion) throws SQLException {
        double sumMonto;
        Socio socio = buscarSocioId(cedula, conexion);
         
         if (socio != null) {
             DaoService dao = new DAOImplementation(conexion);
             dao.actualizarMonto(cedula, nuevoMonto);
             JOptionPane.showMessageDialog(null,"Se actualizo registro correctamente");
         }else{
             JOptionPane.showMessageDialog(null,"La identificacion ingresada no esta creada");
         }
        /*for (Socio socio : this.socios) {
            if (socio.getCedula().equals(cedula)) {
                sumMonto = Double.parseDouble(socio.getFondoDisponible()) + nuevoMonto;
                socio.setFondoDisponible(String.valueOf(sumMonto));
                return true;
            }
        }*/
        return false;

    }

    /**
     * Método para listar las personas autorizadas
     */
    public void listarPersonas() {
        String salida = "";
        for (Socio interador : socios) {
            salida += interador.listarPersonas() + '\n';
        }
        JOptionPane.showMessageDialog(null, salida);
    }

    /**
     * Método para validar el fondo de los socios registrados
     *
     * @param fondosDisponibles
     * @param tipoSuscripcion
     * @param suscripcion
     * @return
     */
    public boolean validarFondo(String fondosDisponibles, String tipoSuscripcion, boolean suscripcion) {
        if (suscripcion == true) {
            if (tipoSuscripcion.equals("VIP") && (Double.parseDouble(fondosDisponibles) < 100000 || Double.parseDouble(fondosDisponibles) > 5000000)) {
                JOptionPane.showMessageDialog(null, "El valor del fondo del afiliado VIP no puede ser menor a 100000 y mayor a 5000000$");
                return false;

            }
        }

        if (tipoSuscripcion.equals("Regular") && (Double.parseDouble(fondosDisponibles) < 50000 || Double.parseDouble(fondosDisponibles) > 1000000)) {
            JOptionPane.showMessageDialog(null, "El valor del fondo del afiliado regular no puede ser menor a 50000 y mayor a 1000000$");
            return false;

        }
        return true;

    }

    /**
     * Método para filtrar los socios por cédula
     *
     * @param cedula
     * @return
     */
    public Socio buscarSocioId(String cedula, Connection conexion) throws SQLException {
        /*for (Socio socio : this.socios) {
            if (socio.getCedula().equals(cedula)) {
                return socio;
            }
        }*/
        DaoService dao = new DAOImplementation(conexion);
        Socio socion = dao.buscarSocioId(cedula);
        return socion;
    }

    /**
     * Método para validar el número de socios VIP
     */
    private boolean sociosVIP(String tipoSuscripcion, Connection conexion)throws SQLException {
       /* int cont = 1;
        if (tipoSuscripcion.equals("VIP")) {
            for (Socio socio : this.socios) {
                if (socio.getTipoSuscripcion().equals(tipoSuscripcion)) {
                    cont++;
                }
            }
        }*/
       
        DaoService dao = new DAOImplementation(conexion);
        return dao.buscarSociosVIP(tipoSuscripcion);
    }

    public void crearFactura(String cedula, String consumos, String totalPagar, Connection conexion) throws SQLException {
        Persona socio = buscarSocioId(cedula, conexion);
        Persona pesonaAutorizada = buscarPersonaAutorizada(cedula);

        if (consultarFondoActual(cedula, conexion) <= Double.parseDouble(totalPagar)) {
            JOptionPane.showMessageDialog(null, "¡Vaya no tienes saldo disponible ");
            return;
        } else {
            pagarFactura(totalPagar);

        }

        if (socio != null) {

            FabricaDeConsumos fabrica = new FabricaDeConsumos();
            Consumo consumo = fabrica.fabricaConsumo(cedula, consumos, totalPagar);

            // System.out.println(consumo.getNombre()+ consumo.getPrecio()+ cedula);
            // Factura factura = new Factura(consumo.getNombre(), consumo.getPrecio(), cedula);
            Factura factura = new Factura(consumos, totalPagar, cedula);
            socio.getFactura().add(factura);
            factura.setEstado(false);

            JOptionPane.showMessageDialog(null, "Se generó el pedido a nombre de " + socio.getNombre());
        }
        if (pesonaAutorizada != null) {

            FabricaDeConsumos fabrica = new FabricaDeConsumos();
            Consumo consumo = fabrica.fabricaConsumo(cedula, consumos, totalPagar);

            //Factura factura = new Factura(consumo.getNombre(), consumo.getPrecio(), cedula);
            Factura factura = new Factura(consumos, totalPagar, cedula);
            pesonaAutorizada.getFactura().add(factura);
            factura.setEstado(false);

            JOptionPane.showMessageDialog(null, "Se generó el pedido a nombre de " + pesonaAutorizada.getNombre());
        }

    }

    public void listarFacturas() {
        String salida = "";
        for (Persona iterador : socios) {
            salida += iterador.listarFacturas() + "\n";

        }
        JOptionPane.showMessageDialog(null, salida);
    }

    public Double consultarFondoActual(String cedula, Connection conexion) throws SQLException {

        Socio socio = buscarSocioId(cedula, conexion);
        PersonaAutorizada persona = buscarPersonaAutorizada(cedula);
        if (socio != null) {

            return Double.parseDouble(socio.getFondoDisponible());
        } else {
            cedula = persona.getCedulaSocio();

            socio = buscarSocioId(cedula, conexion);
            return Double.parseDouble(socio.getFondoDisponible());
        }
        /*for (Socio socio : this.socios) {
            System.out.println(socio);
            for (PersonaAutorizada persona : socio.getPersonasAutorizadas()) {
                if (socio.getCedula().equals(cedula) ) {
                    System.out.println("Entra");
                    return Double.parseDouble(socio.getFondoDisponible());
                }
            }
 return null;
        }*/

    }

    public void pagarFactura(String valorFactura) {
        double saldoActual;
        for (Socio socio : socios) {
            saldoActual = (Double.parseDouble(socio.getFondoDisponible()) - Double.parseDouble(valorFactura));
            socio.setFondoDisponible(String.valueOf(saldoActual));
            return;
        }
    }

    public PersonaAutorizada buscarPersonaAutorizada(String cedula) {
        for (Socio socio : this.socios) {
            PersonaAutorizada pesonaAutorizada = socio.buscarPersonaAutorizada(cedula);
            return pesonaAutorizada;
        }
        return null;
    }

    public void listarTodasLasPersonas() {
        for (Socio persona : socios) {
            for (PersonaAutorizada p : persona.getPersonasAutorizadas()) {
                System.out.println(p.getNombre());
                System.out.println(persona.getNombre());
            }
        }
    }

}
