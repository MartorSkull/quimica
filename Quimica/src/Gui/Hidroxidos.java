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
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author tobias
 */
public class Hidroxidos extends javax.swing.JFrame {

    /**
     * Creates new form Hidroxidos
     */
    public Hidroxidos() {
        initComponents();
        DefaultComboBoxModel model;
        model = new DefaultComboBoxModel();

        for (Elemento i : Base.getTodosMetales()) {
            model.addElement(i);
        }
        this.cbmetales.setModel(model);
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

        cbmetales = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        res = new javax.swing.JTextField();
        btn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infohidroxidos = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        states = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        cbmetales.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbmetalesItemStateChanged(evt);
            }
        });
        cbmetales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmetalesActionPerformed(evt);
            }
        });
        getContentPane().add(cbmetales);
        cbmetales.setBounds(22, 178, 120, 24);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("+");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(148, 182, 10, 18);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("=");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(367, 182, 9, 18);
        getContentPane().add(res);
        res.setBounds(380, 173, 80, 38);

        btn.setText("Combinar");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        getContentPane().add(btn);
        btn.setBounds(12, 229, 448, 55);

        jLabel6.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(253, 251, 251));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesq/image3398.png"))); // NOI18N
        jLabel6.setText("Hidroxidos");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(12, 12, 151, 49);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 73, 721, 10);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesq/flecharec.png"))); // NOI18N
        jButton2.setText("Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 30, 111, 40);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Metal");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(12, 144, 41, 18);

        infohidroxidos.setColumns(20);
        infohidroxidos.setRows(5);
        infohidroxidos.setText("Informacion:");
        jScrollPane1.setViewportView(infohidroxidos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 290, 450, 80);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("compuesto");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(380, 144, 79, 18);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("Oxigeno(O)");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(170, 183, 90, 18);

        jLabel12.setText("Oxigeno(O)");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 0, 0, 0);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText(")");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(0, 0, 0, 0);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("(");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(12, 180, 8, 22);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("+");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(259, 183, 20, 18);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Agua(H2O)");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(285, 183, 80, 18);

        getContentPane().add(states);
        states.setBounds(110, 140, 48, 27);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesq/fondo-con-ilustraciones-de-molculas_23-2147491176.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 490, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
        ComboBoxModel<Elemento> model = this.cbmetales.getModel();
        Elemento ele = model.getElementAt(this.cbmetales.getSelectedIndex());
        ele.setEstado_used(ele.getEstados().indexOf(this.states.getModel().getSelectedItem()));
        Reaccion r = new Reaccion(ele, Reaccion.HIDROXIDO);
        this.res.setText(r.getCompuesto().getNom());
         Compuesto com = r.getCompuesto();
        String info = "HIDROXIDOS\n";
        int a = 0;
        for (Elemento i : com.getElementos()) {
            info = info.concat(i.getNombre() + ":\n"
                    + "     Cantidad: " + com.getCant().get(a) + "\n"
                    + "     Electronegatividad: " + i.getEleneg() + "\n"
                    + "     Estado de Oxidacion: " + i.getEstado_used() + "" + "\n");
            a++;
        }
        infohidroxidos.setText(info);
    }//GEN-LAST:event_btnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VentanaPricipal aux = new VentanaPricipal();
        aux.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbmetalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmetalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbmetalesActionPerformed

    private void cbmetalesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbmetalesItemStateChanged
change();
    }//GEN-LAST:event_cbmetalesItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JComboBox<Elemento> cbmetales;
    private javax.swing.JTextArea infohidroxidos;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField res;
    private javax.swing.JComboBox<Integer> states;
    // End of variables declaration//GEN-END:variables
private void change() {
        // TODO add your handling code here:
        boolean flag = false;
        DefaultComboBoxModel estados = new DefaultComboBoxModel();
        ComboBoxModel<Elemento> modelo = this.cbmetales.getModel();
        Elemento ele = modelo.getElementAt(this.cbmetales.getSelectedIndex());
        for (int i : ele.getEstados()) {
            if (i > 0) {
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
    }
}
