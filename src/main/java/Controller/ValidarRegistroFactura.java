package Controller;

import Modelo.Club;
import Modelo.PersonaAutorizada;
import Modelo.Socio;
import javax.swing.JOptionPane;

public class ValidarRegistroFactura {

    private Club club;

    public ValidarRegistroFactura(Club club) {
        this.club = club;
    }

    public boolean registrarFactura(String cedula, int tipoServicio, int entrada, int postre,
            int platoFuerte, int porcion, int adicionPlatos, int salsa, int tipoBebida, int caliente,
            int alcoholica, int noAlcoholica, int gradoAcohol, int azucar, int adicionBebida, String totalPagar) {

        boolean estado = false;

        if (cedula.equals("") || cedula.equals(false)) {
            JOptionPane.showMessageDialog(null, "El campo cédula no puede estar vacio");
            return estado;
        }

        if (tipoServicio == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un tipo de servicio");
            return estado;
        }

        if (entrada == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una entrada");
            return estado;
        }

        if (postre == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un postre");
            return estado;
        }

        if (platoFuerte == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un plato fuerte");
            return estado;
        }

        if (porcion == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un porcion");
            return estado;
        }

        if (adicionPlatos == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una adicion de platos");
            return estado;
        }

        if (salsa == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una salsa");
            return estado;
        }

        if (tipoBebida == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un tipo de bebida");
            return estado;
        }

        if (caliente == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una bebida caliente");
            return estado;
        }

        if (alcoholica == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una bebida alcoholica");
            return estado;
        }
        if (noAlcoholica == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una bebida no alcoholica");
            return estado;
        }

        if (adicionBebida == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una adicion de bebida");
            return estado;
        }

        if (alcoholica == 4 && noAlcoholica == 4) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una bebida fria");
            return estado;
        }
        
        
        if (club.buscarSocioId(cedula) == null && club.buscarPersonaAutorizada(cedula) == null) {
            System.out.println(club.buscarPersonaAutorizada(cedula));
            JOptionPane.showMessageDialog(null, "Debes estar registrado para poder consumir");
            return estado;
        }
        
        return true;
    }
}
