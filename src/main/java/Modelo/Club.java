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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public double totalConsumos(int cedulaCliente) {
        return 0;
    }

    public boolean registrarSocio(String nombre, String cedula, String fondosDisponibles, String tipoSuscripcion, Connection conexion) throws SQLException {
        Socio socio = buscarSocioId(cedula, conexion);
        boolean suscripcion = true;
        if (socio == null) {
            if (tipoSuscripcion == "VIP") {
                suscripcion = sociosVIP(tipoSuscripcion, conexion);
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
        } else {
            JOptionPane.showMessageDialog(null, socio.getNombre() + " Ya existe un registro con esa identificación ");

        }
        return false;

    }

    public boolean actualizarMonto(String cedula, double nuevoMonto, Connection conexion) throws SQLException {
        double sumMonto;
        Socio socio = buscarSocioId(cedula, conexion);

        if (socio != null) {
            DaoService dao = new DAOImplementation(conexion);
            dao.actualizarMonto(cedula, nuevoMonto);
            JOptionPane.showMessageDialog(null, "Se actualizo registro correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "La identificacion ingresada no esta creada");
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
    public void listarPersonas(String cedula, Connection conexion) throws SQLException {
        DaoService dao = new DAOImplementation(conexion);
        List<Persona> personas = dao.listarPersonas(cedula);

        StringBuilder mensaje = new StringBuilder();
        for (Persona persona : personas) {
            mensaje.append("Cédula: ").append(persona.getCedula()).append("\n");
            mensaje.append("Nombre: ").append(persona.getNombre()).append("\n\n");
        }

// Mostrar la cadena de texto en un JOptionPane
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Listado de Personas", JOptionPane.INFORMATION_MESSAGE);
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

    public void eliminarSocio(String cedula, Connection conexion) throws SQLException {

        DaoService dao = new DAOImplementation(conexion);
        String rs = dao.eliminarSocio(cedula);

        if (rs.equals("1")) {
            JOptionPane.showMessageDialog(null, "Se elimino correctamente el socio");
        } else if (rs.equals("2")) {
            JOptionPane.showMessageDialog(null, "El Socio a eliminar es un VIP");
        } else if (rs.equals("3")) {
            JOptionPane.showMessageDialog(null, "El Socio a eliminar tiene facturas asociadas");
        } else {
            JOptionPane.showMessageDialog(null, "El Socio a eliminar tiene personas autorizadas asociadas");
        }

    }

    /**
     * Método para validar el número de socios VIP
     */
    private boolean sociosVIP(String tipoSuscripcion, Connection conexion) throws SQLException {
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
        String cedulaS = cedula;
        Socio socio = buscarSocioId(cedula, conexion);
        if (socio == null) {
            PersonaAutorizada pesonaAutorizada = buscarPersonaAutorizada(cedula, conexion);
            if (pesonaAutorizada == null) {
                JOptionPane.showMessageDialog(null, "No existe persona para poder realizar este consumo");
                return;
            } else {
                cedulaS = pesonaAutorizada.getCedulaSocio();
            }
        }

        if (consultarFondoActual(cedulaS, conexion) <= Double.parseDouble(totalPagar)) {
            JOptionPane.showMessageDialog(null, "¡Vaya no tienes saldo disponible ");
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Si tiene saldo para pagar");
            //pagarFactura(totalPagar);
            DaoService dao = new DAOImplementation(conexion);
            Factura factura = new Factura(consumos, totalPagar, cedula, "");

            dao.registrarFactura(factura);

        }

        /*
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
        /*
        if (pesonaAutorizada != null) {

            FabricaDeConsumos fabrica = new FabricaDeConsumos();
            Consumo consumo = fabrica.fabricaConsumo(cedula, consumos, totalPagar);

            //Factura factura = new Factura(consumo.getNombre(), consumo.getPrecio(), cedula);
            Factura factura = new Factura(consumos, totalPagar, cedula);
          //  pesonaAutorizada.getFactura().add(factura);
            factura.setEstado(false);

            JOptionPane.showMessageDialog(null, "Se generó el pedido a nombre de " + pesonaAutorizada.getNombre());
        }
         */
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
        //PersonaAutorizada persona = buscarPersonaAutorizada(cedula);
        if (socio != null) {

            return Double.parseDouble(socio.getFondoDisponible());
        } else {
            JOptionPane.showMessageDialog(null, "El socio consultado no existe");
            return Double.parseDouble("0");
        }

    }

    public void pagarFactura(String valorFactura) {
        double saldoActual;
        for (Socio socio : socios) {
            saldoActual = (Double.parseDouble(socio.getFondoDisponible()) - Double.parseDouble(valorFactura));
            socio.setFondoDisponible(String.valueOf(saldoActual));
            return;
        }
    }

    public PersonaAutorizada buscarPersonaAutorizada(String cedula, Connection conexion) throws SQLException {

        DaoService dao = new DAOImplementation(conexion);
        PersonaAutorizada personaAutorizada = dao.buscarPersonaAutorizadaId(cedula);

        return personaAutorizada;

    }

    public void listarTodasLasPersonas() {
        for (Socio persona : socios) {
            for (PersonaAutorizada p : persona.getPersonasAutorizadas()) {
                System.out.println(p.getNombre());
                System.out.println(persona.getNombre());
            }
        }
    }

    public boolean registrarPersonaAutorizada(String nombrePersonaAutorizada, String cedulaPersonaAutorizada, String cedulaSocio, Connection conexion) throws SQLException {

        PersonaAutorizada personaAutorizada = buscarPersonaAutorizada(cedulaPersonaAutorizada, conexion);

        if (personaAutorizada != null) {
            JOptionPane.showMessageDialog(null, "Vaya ya exite una persona con se número de cédula!!");
            return false;

        } else {

            personaAutorizada = new PersonaAutorizada(nombrePersonaAutorizada, cedulaPersonaAutorizada, cedulaSocio);
            // personasAutorizadas.add(personaAutorizada);
            DaoService dao = new DAOImplementation(conexion);
            dao.registrarAutorizado(personaAutorizada);
            JOptionPane.showMessageDialog(null, personaAutorizada.getNombre()
                    + " bienvenid@, ya eres una persona autorizada");
            listarPersonas(cedulaSocio, conexion);
            return true;
        }

    }

}
