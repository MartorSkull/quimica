/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.SQLException;

/**
 *
 * @author martin
 */
public class Reaccion {

    private Base db;
    private Elemento[] elementos;
    private int cantAtoms;
    private int[] cant;
    private String nom;
    private String molecula;
    private Compuesto compuesto;

    public static final int HIDRURO_NOMETALICO = 0;
    public static final int HIDRURO_METALICO = 1;
    public static final int OXIDO_BASICO = 2;
    public static final int OXIDO_ACIDO = 3;
    public static final int HIDROXIDO = 4;
    public static final int ACIDO_OXACIDO = 5;
    public static final int ACIDO_HIDRACIDO = 6;
    public static final int SAL_HIDRACIDO = 7;
    public static final int SAL_NEUTRA = 8;
    public static final int SAL_ACIDA = 9;
    public static final int SAL_BASICA = 10;
    public static final int SAL_MIXTA = 11;
    public static final int PEROXIDOS = 12;

    public Reaccion(Base db, Elemento[] elementos, int cantAtoms, int tipo) {
        this.db = db;
        this.elementos = elementos;
        this.cantAtoms = cantAtoms;
    }

    public Compuesto getCompuesto() {
        return compuesto;
    }

    private Compuesto hidruro_nometalico(Elemento ele) {
        String nom=null;
        try {
            Elemento H = new Elemento(1, this.db.getElementNameNM(0), this.db.getElementNomNM(0), this.db.getElementStatesArrayM(0), this.db.getElementElenegM(0));
            if (ele.getEleneg()<H.getEleneg()){
                
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    private Compuesto hidruro_metalico(Elemento ele) {

    }

    private Compuesto oxido_basico(Elemento ele) {

    }

    private Compuesto oxido_acido(Elemento ele) {

    }

    private Compuesto hidroxido(Elemento ele) {

    }

    private Compuesto acido_oxacido(Elemento ele) {

    }

    private Compuesto acido_hidracido(Elemento ele) {

    }

    private Compuesto sal_hidracida(Compuesto hidracido, Compuesto hidroxido) {

    }

    private Compuesto sal_neutra(Compuesto oxoacido, Compuesto hidroxido) {

    }

    private Compuesto sal_acida(Compuesto oxoacido, Compuesto hidroxido) {

    }

    private Compuesto sal_basica(Compuesto oxoacido, Compuesto hidroxido) {

    }

    private Compuesto sal_mixta(Compuesto oxoacido, Compuesto hidroxido1, Compuesto hidroxido2) {

    }
}
