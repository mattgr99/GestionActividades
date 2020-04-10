/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import proyingresos.aportacionespanel;
import proyingresos.cuotaspanel;
import proyingresos.pnlMultas;

/**
 *
 * @author Kevin
 */
public class Ingresos extends javax.swing.JPanel {

    /**
     * Creates new form Ingresos
     */
    public Ingresos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        panelIngresos = new javax.swing.JPanel();
        btnMultas = new javax.swing.JButton();
        btnCuotas = new javax.swing.JButton();
        btnAportaciones = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelIngresos.setBackground(new java.awt.Color(255, 255, 255));
        panelIngresos.setLayout(new java.awt.GridBagLayout());
        add(panelIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 920, -1));

        btnMultas.setBackground(new java.awt.Color(255, 255, 255));
        btnMultas.setText("Multas");
        btnMultas.setBorder(null);
        btnMultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMultasMousePressed(evt);
            }
        });
        btnMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultasActionPerformed(evt);
            }
        });
        add(btnMultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 180, 40));

        btnCuotas.setBackground(new java.awt.Color(255, 255, 255));
        btnCuotas.setText("Cuotas");
        btnCuotas.setBorder(null);
        btnCuotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCuotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCuotasMousePressed(evt);
            }
        });
        btnCuotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuotasActionPerformed(evt);
            }
        });
        add(btnCuotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 40));

        btnAportaciones.setBackground(new java.awt.Color(255, 255, 255));
        btnAportaciones.setText("Aportaciones");
        btnAportaciones.setBorder(null);
        btnAportaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAportaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAportacionesMousePressed(evt);
            }
        });
        btnAportaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAportacionesActionPerformed(evt);
            }
        });
        add(btnAportaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 180, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultasActionPerformed
        if(this.btnMultas.isSelected()){
        new paneles.CambiaPanel(panelIngresos, new pnlMultas());
        }
    }//GEN-LAST:event_btnMultasActionPerformed

    private void btnAportacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAportacionesActionPerformed
         if(this.btnAportaciones.isSelected()){
        new paneles.CambiaPanel(panelIngresos, new aportacionespanel()); 
         }
    }//GEN-LAST:event_btnAportacionesActionPerformed

    private void btnMultasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMultasMousePressed
         this.btnMultas.setSelected(true);
         this.btnCuotas.setSelected(false);
         this.btnAportaciones.setSelected(false);
    }//GEN-LAST:event_btnMultasMousePressed

    private void btnAportacionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAportacionesMousePressed
        this.btnMultas.setSelected(false);
        this.btnCuotas.setSelected(false);
        this.btnAportaciones.setSelected(true);
        
    }//GEN-LAST:event_btnAportacionesMousePressed

    private void btnCuotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuotasActionPerformed
         if(this.btnCuotas.isSelected()){
        new paneles.CambiaPanel(panelIngresos, new cuotaspanel());
         }
    }//GEN-LAST:event_btnCuotasActionPerformed

    private void btnCuotasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuotasMousePressed
        this.btnMultas.setSelected(false);
        this.btnCuotas.setSelected(true);
        this.btnAportaciones.setSelected(false);

    }//GEN-LAST:event_btnCuotasMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAportaciones;
    private javax.swing.JButton btnCuotas;
    private javax.swing.JButton btnMultas;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel panelIngresos;
    // End of variables declaration//GEN-END:variables
}
