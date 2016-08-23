/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.Base;
import data.Compuesto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author martin
 */
public class Reaccion {

    private Elemento[] elementos;
    private int cantAtoms;
    private int[] cant;
    private String nom;
    private String molecula;
    private Compuesto compuesto;
    private Elemento elemento;

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

    /**
     *
     * @param elementos Array de elementos
     * @param cantAtoms Cantidad de atomos
     * @param tipo usar alguno de los final
     *
     */
    public Reaccion(Elemento[] elementos, int tipo) {
        this.elementos = elementos;

    }

    public Reaccion(Compuesto compuesto, int tipo) {
        this.compuesto = compuesto;
    }

    public Reaccion(Elemento elemento, int tipo) {
        this.elemento = elemento;
        if (tipo == Reaccion.HIDRURO_NOMETALICO) {
            this.compuesto = this.hidruro_nometalico(elemento);
        } else if (tipo == Reaccion.HIDRURO_METALICO) {
            this.compuesto = this.hidruro_metalico(elemento);
        }
    }

    public Compuesto getCompuesto() {
        return compuesto;
    }

    private Compuesto hidruro_nometalico(Elemento ele) {
        Compuesto hnm = null;
        Elemento h = Base.getNoMetal(1);
        h.setEstado_used(0);
        ArrayList<Elemento> arr = new ArrayList();
        ArrayList<Integer> cant = new ArrayList();
        arr.add(ele);
        arr.add(h);
        String nom = null;
        
        int mcm = mcm(h.getEstado_used(), ele.getEstado_used()*-1);
        cant.add(mcm/ele.getEstado_used()*-1);
        cant.add(mcm/h.getEstado_used());
        
        if (cant.get(0) == 1 && cant.get(1) == 1) {
            nom = ele.getNom() + h.getNom();
        } else if (cant.get(0) == 1) {
            nom = ele.getNom() + h.getNom() + cant.get(1);
        } else if (cant.get(1) == 1) {
            nom = ele.getNom() + cant.get(0) + h.getNom();
        } else {
            nom = ele.getNom() + cant.get(0) + h.getNom() + cant.get(1);
        }

        hnm = new Compuesto(arr, cant, "sha cazi", nom, Reaccion.HIDRURO_NOMETALICO);
        return hnm;
    }

    private Compuesto hidruro_metalico(Elemento ele) {
        Compuesto hm = null;
        Elemento h = Base.getNoMetal(1);
        h.setEstado_used(1);
        ArrayList<Elemento> arr = new ArrayList();
        ArrayList<Integer> cant = new ArrayList();
        arr.add(ele);
        arr.add(h);
        String nom = null;
        
        int mcm=mcm(ele.getEstado_used(), h.getEstado_used()*-1);
        cant.add(mcm/h.getEstado_used()*-1);
        cant.add(mcm/ele.getEstado_used());
        
        if (cant.get(0) == 1 && cant.get(1) == 1) {
            nom = h.getNom() + ele.getNom();
        } else if (cant.get(0) == 1) {
            nom = h.getNom() + cant.get(1) + ele.getNom();
        } else if (cant.get(1) == 1) {
            nom = h.getNom() + ele.getNom() + cant.get(0);
        } else {
            nom = h.getNom() + cant.get(1) + ele.getNom() + cant.get(0);
        }
        hm = new Compuesto(arr, cant, "sha cazi", nom, Reaccion.HIDRURO_METALICO);
        return hm;
    }
    /*
    private Compuesto oxido_basico(Elemento ele) {

    }

    private Compuesto oxido_acido(Elemento ele) {

    }

    private Compuesto hidroxido(Elemento[] ele) {

    }

    private Compuesto acido_oxacido(Elemento[] ele) {

    }

    private Compuesto acido_hidracido(Elemento[] ele) {

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
     */
    
    private int mcm(int num1, int num2){
        int min = Math.min(num1, num2);
        int mcm = 0;
        for (int i=1; i<=min; i++) {
            if (num1%i==0 && num2%i==0) {
                int mcd = i;
                mcm = (num1*num2)/mcd;
            }
        }
        return mcm;
    }
}
