/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controller.ValidarRegistroSocio;
import Modelo.Club;
import Modelo.Persona;
import Modelo.Socio;

/**
 *
 * @author RENTCOM SAS
 */
public class RegistrarSocio extends javax.swing.JFrame {
    
    private Club club;
    private Socio socio;
    
    public RegistrarSocio(Club club) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.club = club;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputFondos = new javax.swing.JTextField();
        labelCedula = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        registrarSocio = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelFondos = new javax.swing.JLabel();
        inputCedula = new javax.swing.JTextField();
        labelSuscripcion = new javax.swing.JLabel();
        inputSuscripcion = new javax.swing.JComboBox<>();
        registrarPersonaAutorizada = new javax.swing.JButton();
        consultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        inputFondos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFondosActionPerformed(evt);
            }
        });

        labelCedula.setText("Ingresar Cedula:");

        labelNombre.setText("Ingresar Nombre:");

        inputNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreActionPerformed(evt);
            }
        });

        registrarSocio.setBackground(new java.awt.Color(1, 68, 68));
        registrarSocio.setText("Guardar");
        registrarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarSocioActionPerformed(evt);
            }
        });

        regresar.setBackground(new java.awt.Color(1, 68, 68));
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jLabel1.setText("REGISTRAR UN NUEVO SOCIO");

        labelFondos.setText("Fondos Disponibles:");

        inputCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCedulaActionPerformed(evt);
            }
        });

        labelSuscripcion.setText("Tipo Suscripción:");

        inputSuscripcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VIP", "Regular" }));

        registrarPersonaAutorizada.setBackground(new java.awt.Color(1, 68, 68));
        registrarPersonaAutorizada.setText("Persona Autorizada");
        registrarPersonaAutorizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarPersonaAutorizadaActionPerformed(evt);
            }
        });

        consultar.setBackground(new java.awt.Color(1, 68, 68));
        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(143, 143, 143))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCedula)
                    .addComponent(labelFondos)
                    .addComponent(labelSuscripcion)
                    .addComponent(labelNombre))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inputCedula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputFondos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputSuscripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(registrarPersonaAutorizada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registrarSocio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(regresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(consultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addGap(34, 34, 34)
                        .addComponent(labelCedula)
                        .addGap(34, 34, 34)
                        .addComponent(labelFondos)
                        .addGap(35, 35, 35)
                        .addComponent(labelSuscripcion))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regresar))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consultar))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputFondos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registrarSocio))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputSuscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registrarPersonaAutorizada))))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        labelCedula.getAccessibleContext().setAccessibleName("nombre");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputFondosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFondosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFondosActionPerformed

    private void inputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        Main inicio = new Main(club);
        inicio.show();
        this.show(false);
    }//GEN-LAST:event_regresarActionPerformed

    private void registrarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarSocioActionPerformed
        // TODO add your handling code here:
        ValidarRegistroSocio controller = new ValidarRegistroSocio(club);
        controller.registrarSocio(inputNombre.getText(), inputCedula.getText(), inputFondos.getText(), inputSuscripcion.getSelectedItem().toString());
        
    }//GEN-LAST:event_registrarSocioActionPerformed

    private void inputCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCedulaActionPerformed

    private void registrarPersonaAutorizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarPersonaAutorizadaActionPerformed
        RegistrarPersonaAutorizada inicio = new RegistrarPersonaAutorizada(club);
        inicio.show();
        this.show(false);
    }//GEN-LAST:event_registrarPersonaAutorizadaActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        ValidarRegistroSocio controller = new ValidarRegistroSocio(club);
        controller.consultarSocio(inputCedula.getText());
    }//GEN-LAST:event_consultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultar;
    private javax.swing.JTextField inputCedula;
    private javax.swing.JTextField inputFondos;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JComboBox<String> inputSuscripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelFondos;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSuscripcion;
    private javax.swing.JButton registrarPersonaAutorizada;
    private javax.swing.JButton registrarSocio;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
