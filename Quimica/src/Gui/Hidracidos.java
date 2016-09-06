/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import data.Base;
import data.Compuesto;
import data.Elemento;
import data.Reaccion;
import java.sql.SQLException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author tobias
 */
public class Hidracidos extends javax.swing.JFrame {

    /**
     * Creates new form Hidracidos
     */
    public Hidracidos() {
        initComponents();
        DefaultComboBoxModel modelant = new DefaultComboBoxModel();
        for (Elemento i : Base.getTodosNoMetales()) {
            if (!i.getNombre().equals("Oxigeno") && !i.getNombre().equals("Hidrogeno")) {
                modelant.addElement(i);
            }

        }
        this.cbnometales.setModel(modelant);
        change();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbnometales = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        infohidracidos = new javax.swing.JTextPane();
        btn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        res = new javax.swing.JTextField();
        states = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 350));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesq/image3398.png"))); // NOI18N
        jLabel1.setText("Hidracidos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 12, 149, 49);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Hidrogeno(H)");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 109, 100, 18);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("+");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(113, 109, 10, 18);

        cbnometales.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbnometalesItemStateChanged(evt);
            }
        });
        cbnometales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnometalesActionPerformed(evt);
            }
        });
        getContentPane().add(cbnometales);
        cbnometales.setBounds(133, 104, 102, 24);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("=");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(263, 109, 22, 18);

        infohidracidos.setEditable(false);
        jScrollPane2.setViewportView(infohidracidos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 210, 481, 70);

        btn.setText("combinar");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        getContentPane().add(btn);
        btn.setBounds(10, 139, 480, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesq/flecharec.png"))); // NOI18N
        jButton2.setText("Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(364, 16, 129, 40);

        res.setEditable(false);
        getContentPane().add(res);
        res.setBounds(300, 104, 82, 19);

        states.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statesActionPerformed(evt);
            }
        });
        getContentPane().add(states);
        states.setBounds(210, 70, 47, 24);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesq/fondo-con-ilustraciones-de-molculas_23-2147491176.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 580, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbnometalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnometalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbnometalesActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        ComboBoxModel<Elemento> modelo = this.cbnometales.getModel();
        Elemento ele = modelo.getElementAt(this.cbnometales.getSelectedIndex());
        ele.setEstado_used(ele.getEstados().indexOf(this.states.getModel().getSelectedItem()));
        Reaccion r = new Reaccion(ele, Reaccion.ACIDO_HIDRACIDO);
        this.res.setText(r.getCompuesto().getNom());
        Compuesto com = r.getCompuesto();
        String info = "HIDRACIDO\n";
        int a = 0;
        for (Elemento i : com.getElementos()) {
            info = info.concat(i.getNombre() + ":\n"
                    + "     Cantidad: " + com.getCant().get(a) + "\n"
                    + "     Electronegatividad: " + i.getEleneg() + "\n"
                    + "     Estado de Oxidacion: " + i.getEstado_used() + "" + "\n");
            a++;
        }
        infohidracidos.setText(info);
    }//GEN-LAST:event_btnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VentanaPricipal aux = new VentanaPricipal();
        aux.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void statesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statesActionPerformed

    private void cbnometalesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbnometalesItemStateChanged
        // TODO add your handling code here:
        change();
    }//GEN-LAST:event_cbnometalesItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JComboBox<Elemento> cbnometales;
    private javax.swing.ButtonGroup grupo1;
    private javax.swing.JTextPane infohidracidos;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField res;
    private javax.swing.JComboBox<Integer> states;
    // End of variables declaration//GEN-END:variables
private void change() {
        boolean flag = false;
        DefaultComboBoxModel estados = new DefaultComboBoxModel();
        ComboBoxModel<Elemento> modelo = this.cbnometales.getModel();
        Elemento ele = modelo.getElementAt(this.cbnometales.getSelectedIndex());
        for (int i : ele.getEstados()) {
            if (i < 0) {
                flag = true;
                estados.addElement(i);
            }
        }
        if (flag) {
            btn.setEnabled(true);
        } else {
            btn.setEnabled(false);
        }
        this.states.setModel(estados);
        this.res.setText("");
        this.infohidracidos.setText("");
    }
}
