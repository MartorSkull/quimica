package Gui;

import data.Base;
import data.Elemento;
import data.Reaccion;
import data.Compuesto;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class Hidruros extends javax.swing.JFrame {

    /**
     * Creates new form Hidruros
     */
    public Hidruros() {
        initComponents();
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (Elemento i : Base.getMetalesEnColumna(1)) {

            model.addElement(i);

        }
        for (Elemento e : Base.getMetalesEnColumna(2)) {
            model.addElement(e);
        }
        this.cbmetales.setModel(model);

        DefaultComboBoxModel nometal = new DefaultComboBoxModel();
        for (Elemento i : Base.getTodosNoMetales()) {
            if (!i.getNombre().equals("Hidrogeno") && !i.getNombre().equals("Oxigeno")) {
                nometal.addElement(i);
            }
        }
        this.cbnometales.setModel(nometal);
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

        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbmetales = new javax.swing.JComboBox<>();
        cbnometales = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resM = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        resNM = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtinfo1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtinfo2 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        btnNM = new javax.swing.JButton();
        statesNM = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(12, 67, 721, 10);

        jLabel3.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesq/image3398.png"))); // NOI18N
        jLabel3.setText("Hidruros");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 12, 134, 49);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesq/flecharec.png"))); // NOI18N
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(320, 10, 128, 40);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Metalicos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 87, 141, 21);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("No Metalicos");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 300, 114, 21);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Hidrogeno(H)");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(12, 148, 121, 18);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Hidrogeno(H)");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 340, 100, 18);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(-30, 270, 733, 20);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("+");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(139, 148, 20, 18);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("+");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(140, 340, 20, 18);

        cbmetales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmetalesActionPerformed(evt);
            }
        });
        getContentPane().add(cbmetales);
        cbmetales.setBounds(178, 143, 120, 24);

        cbnometales.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbnometalesItemStateChanged(evt);
            }
        });
        getContentPane().add(cbnometales);
        cbnometales.setBounds(180, 340, 113, 24);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("=");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(310, 148, 20, 18);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("=");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(310, 340, 20, 18);

        resM.setEditable(false);
        jScrollPane1.setViewportView(resM);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(336, 130, 105, 40);

        resNM.setEditable(false);
        jScrollPane2.setViewportView(resNM);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(340, 330, 101, 39);

        txtinfo1.setEditable(false);
        txtinfo1.setColumns(20);
        txtinfo1.setRows(5);
        txtinfo1.setText("informacion:");
        jScrollPane3.setViewportView(txtinfo1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 180, 430, 70);

        txtinfo2.setEditable(false);
        txtinfo2.setColumns(20);
        txtinfo2.setRows(5);
        txtinfo2.setText("informacion:");
        jScrollPane4.setViewportView(txtinfo2);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(20, 380, 420, 70);

        jLabel10.setForeground(new java.awt.Color(1, 1, 1));
        jLabel10.setText("Nota: el estado de oxidacion del (H) en M es -1. En los NM es +1");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 470, 442, 15);

        btn1.setText("combinar");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1);
        btn1.setBounds(336, 95, 105, 25);

        btnNM.setText("combinar");
        btnNM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNMActionPerformed(evt);
            }
        });
        getContentPane().add(btnNM);
        btnNM.setBounds(340, 290, 101, 25);

        statesNM.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statesNMItemStateChanged(evt);
            }
        });
        getContentPane().add(statesNM);
        statesNM.setBounds(260, 310, 50, 24);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesq/fondo-con-ilustraciones-de-molculas_23-2147491176.jpg"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(-10, -10, 520, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        ComboBoxModel<Elemento> modelo = this.cbmetales.getModel();
        Elemento ele = modelo.getElementAt(this.cbmetales.getSelectedIndex());
        Reaccion r = new Reaccion(ele, Reaccion.HIDRURO_METALICO);
        this.resM.setText(r.getCompuesto().getNom());
        Compuesto com = r.getCompuesto();
        String info = "HIDRUROS\n";
        int a = 0;
        for (Elemento i : com.getElementos()) {
            info = info.concat(i.getNombre() + ":\n"
                    + "     Cantidad: " + com.getCant().get(a) + "\n"
                    + "     Electronegatividad: " + i.getEleneg() + "\n"
                    + "     Estado de Oxidacion: " + i.getEstado_used() + "" + "\n");
            a++;
        }
        txtinfo1.setText(info);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btnNMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNMActionPerformed
        ComboBoxModel<Elemento> modelo = this.cbnometales.getModel();
        Elemento ele = modelo.getElementAt(this.cbnometales.getSelectedIndex());
        ele.setEstado_used(ele.getEstados().indexOf(this.statesNM.getModel().getSelectedItem()));
        Reaccion r = new Reaccion(ele, Reaccion.HIDRURO_NOMETALICO);
        this.resNM.setText(r.getCompuesto().getNom());
        Compuesto com = r.getCompuesto();
        String info = "HIDRUROS\n";
        int a = 0;
        for (Elemento i : com.getElementos()) {
            info = info.concat(i.getNombre() + ":\n"
                    + "     Cantidad: " + com.getCant().get(a) + "\n"
                    + "     Electronegatividad: " + i.getEleneg() + "\n"
                    + "     Estado de Oxidacion: " + i.getEstado_used() + "" + "\n");
            a++;
        }
        txtinfo2.setText(info);

    }//GEN-LAST:event_btnNMActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaPricipal aux = new VentanaPricipal();
        aux.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbmetalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmetalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbmetalesActionPerformed

    private void statesNMItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statesNMItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_statesNMItemStateChanged

    private void cbnometalesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbnometalesItemStateChanged
        // TODO add your handling code here:
change();
    }//GEN-LAST:event_cbnometalesItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btnNM;
    private javax.swing.JComboBox<Elemento> cbmetales;
    private javax.swing.JComboBox<Elemento> cbnometales;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextPane resM;
    private javax.swing.JTextPane resNM;
    private javax.swing.JComboBox<Integer> statesNM;
    private javax.swing.JTextArea txtinfo1;
    private javax.swing.JTextArea txtinfo2;
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
            btnNM.setEnabled(true);
        } else {
            btnNM.setEnabled(false);
        }
        this.statesNM.setModel(estados);
    }
}
