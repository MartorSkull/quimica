/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

/**
 *
 * @author tobias
 */
public class Peroxidos extends javax.swing.JFrame {

    /**
     * Creates new form Peroxidos
     */
    public Peroxidos() {
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

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesq/image3398.png"))); // NOI18N
        jLabel1.setText("Peroxidos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 18, 146, 49);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 73, 446, 10);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesq/flecharec.png"))); // NOI18N
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(348, 25, 86, 42);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(29, 149, 106, 27);

        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Metal");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(29, 126, 40, 17);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("+");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(147, 153, 10, 18);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("(O)");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(225, 151, 26, 21);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("oxigeno");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(163, 154, 70, 18);

        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("-1");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(257, 138, 14, 17);

        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("2");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(263, 167, 8, 17);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("=");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(283, 150, 9, 18);

        jButton2.setText("crear");
        getContentPane().add(jButton2);
        jButton2.setBounds(30, 190, 370, 50);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(304, 146, 90, 27);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 250, 371, 87);

        jLabel9.setIcon(new javax.swing.ImageIcon("/home/serna/Documentos/quimica-master/Quimica/src/imagenesq/fondo-con-ilustraciones-de-molculas_23-2147491176.jpg")); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 450, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
VentanaPricipal aux = new VentanaPricipal();
    aux.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
