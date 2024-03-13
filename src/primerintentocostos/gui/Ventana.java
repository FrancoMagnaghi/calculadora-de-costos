/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primerintentocostos.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import primerintentocostos.logica.Material;

/**
 *
 * @author franc
 */
public class Ventana extends javax.swing.JFrame implements ClipboardOwner{
    private final ArrayList<Material> materiales;
    private final ArrayList<JTextField> campos;
    private int alto = 0;
    private int ancho = 0;
    private int cantidad = 0;
    /**
     * Creates new form Ventana
     * @param materiales
     */
    public Ventana(ArrayList<Material> materiales) {
        initComponents();
        
        this.materiales = materiales;
        
        campos = new ArrayList<>();
        campos.add(txtAlto);
        campos.add(txtAncho);
        campos.add(txtCantidad);
        
    }
    
    public void setClipboard(String texto){
        StringSelection txt = new StringSelection(texto);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(txt, this);
    }
    
    private int calcularCosto(int ancho, int alto, int cantidad, int precioMaterial){
        int cmsCuadradosMaterial = 6000; 
        int cmsCuadradosCalco = ancho * alto;
        
        return ((cmsCuadradosCalco * precioMaterial) / cmsCuadradosMaterial) * cantidad;
    }
    
    private int calcularPresupuesto(int costo){
        return costo * 3;
    }
    
    private Material materialSeleccionado(String nombreDelMaterial){
        Material materialSeleccionado = null;
        for(Material material : materiales){
            if(material.getNombre().equals(nombreDelMaterial)){ //si el material se encuenta en la lista
                materialSeleccionado = material;
                break;
            } 
        } return materialSeleccionado;
    }
    
    private boolean cargaDeDatosIncompleta(ArrayList<JTextField> campos){
        boolean camposIncompletos = false;
        
        for(JTextField texto : campos){
            if("".equals(texto.getText())){
                camposIncompletos = true;
                break;
            }   
        }
        return camposIncompletos;
    }
    
    private int calculoDeCostoConTransfer(int indice, int cms){ // 4 es Unical. 5 es Adere
        int precioX40mts = materiales.get(indice).getPrecio();
        
        return (cms * precioX40mts) / 4000;
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbMaterial = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtAlto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAncho = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        txtCosto = new javax.swing.JLabel();
        btnActualizarPrec = new javax.swing.JButton();
        txtPrecioMaterial = new javax.swing.JLabel();
        chBoxTransferUnical = new javax.swing.JCheckBox();
        chBoxTransferAdere = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPresupuesto = new javax.swing.JTextArea();
        btnCopiar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("CALCULADORA DE COSTOS");

        jLabel2.setText("Material");

        cmbMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Negro/Blanco Oracal 100", "Dorado Metalizado McCal", "Tornasolado", "Otro" }));
        cmbMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMaterialActionPerformed(evt);
            }
        });

        jLabel3.setText("Alto");

        txtAlto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAltoActionPerformed(evt);
            }
        });

        jLabel4.setText("Ancho");

        txtAncho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnchoActionPerformed(evt);
            }
        });

        jLabel5.setText("cm");

        jLabel6.setText("cm");

        jLabel7.setText("Cantidad");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        txtCosto.setBackground(new java.awt.Color(153, 153, 153));
        txtCosto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCosto.setText("$0");

        btnActualizarPrec.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnActualizarPrec.setText("Actualizar Precios");
        btnActualizarPrec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPrecActionPerformed(evt);
            }
        });

        chBoxTransferUnical.setText("Con Transfer Unical");
        chBoxTransferUnical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxTransferUnicalActionPerformed(evt);
            }
        });

        chBoxTransferAdere.setText("Con Transfer ADERE");
        chBoxTransferAdere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxTransferAdereActionPerformed(evt);
            }
        });

        txtPresupuesto.setColumns(20);
        txtPresupuesto.setRows(5);
        jScrollPane1.setViewportView(txtPresupuesto);

        btnCopiar.setText("Copiar");
        btnCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("PRESUPUESTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnCopiar)))
                .addGap(23, 23, 23))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCopiar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtAlto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(btnCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(chBoxTransferAdere)
                                            .addComponent(chBoxTransferUnical))
                                        .addGap(79, 79, 79)))
                                .addGap(71, 71, 71)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(btnActualizarPrec, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarPrec, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPrecioMaterial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAlto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chBoxTransferUnical)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(chBoxTransferAdere)
                        .addGap(31, 31, 31)
                        .addComponent(btnCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCosto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMaterialActionPerformed
        String nombreDelMaterial = cmbMaterial.getSelectedItem().toString();
        Material materialSeleccionado = materialSeleccionado(nombreDelMaterial);
        
        if(materialSeleccionado != null){
            txtPrecioMaterial.setText("$" + Integer.toString(materialSeleccionado.getPrecio()));
        } else{txtPrecioMaterial.setText("");
        }
    }//GEN-LAST:event_cmbMaterialActionPerformed

    private void txtAltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAltoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAltoActionPerformed

    private void txtAnchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnchoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnchoActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnActualizarPrecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPrecActionPerformed
        ActualizacionPrecios ventanaActu = new ActualizacionPrecios(materiales);
        
        ventanaActu.setVisible(true);
        ventanaActu.setLocationRelativeTo(null);
        ventanaActu.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnActualizarPrecActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        String nombreDelMaterial = cmbMaterial.getSelectedItem().toString(); // NOMBRE del material seleccionado
        Material materialSeleccionado = materialSeleccionado(nombreDelMaterial);
        
        if(materialSeleccionado==null){
          JOptionPane optionPane = new JOptionPane("Selecciona algun material");
          optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
          JDialog dialog = optionPane.createDialog("Carga Incompleta");
          dialog.setAlwaysOnTop(true);
          dialog.setVisible(true);
        }else if(cargaDeDatosIncompleta(campos)){
          JOptionPane optionPane = new JOptionPane("Carga todos los datos");
          optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
          JDialog dialog = optionPane.createDialog("Carga Incompleta");
          dialog.setAlwaysOnTop(true);
          dialog.setVisible(true);
        }else{
            try {
                alto = Integer.parseInt(txtAlto.getText());
                ancho = Integer.parseInt(txtAncho.getText());
                cantidad = Integer.parseInt(txtCantidad.getText());
                int costo = calcularCosto(ancho, alto, cantidad, materialSeleccionado.getPrecio());
                if(chBoxTransferUnical.isSelected()){
                  costo = costo + calculoDeCostoConTransfer(4, Math.max(alto, ancho));
                }else if(chBoxTransferAdere.isSelected()){
                  costo = costo + calculoDeCostoConTransfer(5, Math.max(alto, ancho));
                }
                txtCosto.setText("$" + Integer.toString(costo));
                txtPresupuesto.setText(txtCantidad.getText() + " unidad en " + txtAncho.getText() + "cm x " + txtAlto.getText() + "cm: \n" + nombreDelMaterial + "___ $" + calcularPresupuesto(costo));
            } catch (NumberFormatException ex){
                JOptionPane optionPane = new JOptionPane("Los datos tienen que ser numeros");
                optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Datos erroneos");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }    
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void chBoxTransferAdereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxTransferAdereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chBoxTransferAdereActionPerformed

    private void chBoxTransferUnicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxTransferUnicalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chBoxTransferUnicalActionPerformed

    private void btnCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarActionPerformed
       setClipboard(txtPresupuesto.getText());
    }//GEN-LAST:event_btnCopiarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarPrec;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCopiar;
    private javax.swing.JCheckBox chBoxTransferAdere;
    private javax.swing.JCheckBox chBoxTransferUnical;
    private javax.swing.JComboBox<String> cmbMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAlto;
    private javax.swing.JTextField txtAncho;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JLabel txtCosto;
    private javax.swing.JLabel txtPrecioMaterial;
    private javax.swing.JTextArea txtPresupuesto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
    }
}
