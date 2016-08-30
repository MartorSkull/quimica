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
        } else if (tipo == Reaccion.OXIDO_BASICO) {
            this.compuesto = this.oxido_basico(elemento);
        } else if (tipo == Reaccion.OXIDO_ACIDO) {
            this.compuesto = this.oxido_acido(elemento);
        } else if (tipo == Reaccion.HIDROXIDO) {
            this.compuesto = this.hidroxido(elemento);
        } else if (tipo == Reaccion.ACIDO_OXACIDO) {
            this.compuesto = this.acido_oxacido(elemento);
        }else if (tipo == Reaccion.ACIDO_HIDRACIDO){
            this.compuesto = this.acido_hidracido(elemento);
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

        int mcm = mcm(h.getEstado_used(), ele.getEstado_used() * -1);
        cant.add(mcm / ele.getEstado_used() * -1);
        cant.add(mcm / h.getEstado_used());

        nom = nom(arr, cant);

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

        int mcm = mcm(ele.getEstado_used(), h.getEstado_used() * -1);
        cant.add(mcm / ele.getEstado_used());
        cant.add(mcm / h.getEstado_used() * -1);

        nom = nom(arr, cant);
        hm = new Compuesto(arr, cant, "sha cazi", nom, Reaccion.HIDRURO_METALICO);
        return hm;
    }

    private Compuesto oxido_basico(Elemento ele) {
        Compuesto om = null;
        Elemento o = Base.getNoMetal(5);
        o.setEstado_used(0);

        ArrayList<Elemento> arr = new ArrayList();
        ArrayList<Integer> cant = new ArrayList();
        arr.add(ele);
        arr.add(o);
        String nom = null;

        int mcm = mcm(ele.getEstado_used(), o.getEstado_used() * -1);
        cant.add(mcm / ele.getEstado_used());
        cant.add(mcm / o.getEstado_used() * -1);

        System.out.println(cant.get(0) + "Elemetno");
        System.out.println(cant.get(1) + "Oxigeno");

        nom = nom(arr, cant);

        om = new Compuesto(arr, cant, "sha cazi", nom, Reaccion.OXIDO_BASICO);
        return om;
    }

    private Compuesto oxido_acido(Elemento ele) {
        Compuesto onm = null;
        Elemento o = Base.getNoMetal(5);
        o.setEstado_used(0);

        ArrayList<Elemento> arr = new ArrayList();
        ArrayList<Integer> cant = new ArrayList();
        arr.add(ele);
        arr.add(o);
        String nom = null;

        int mcm = mcm(ele.getEstado_used(), o.getEstado_used() * -1);
        cant.add(mcm / ele.getEstado_used());
        cant.add(mcm / o.getEstado_used() * -1);

        nom = nom(arr, cant);

        onm = new Compuesto(arr, cant, "sha cazi", nom, Reaccion.OXIDO_ACIDO);
        return onm;
    }

    private Compuesto hidroxido(Elemento ele) {
        Compuesto hx = null;

        ArrayList<Elemento> arr = new ArrayList();
        ArrayList<Integer> cant = new ArrayList();
        Elemento o = Base.getNoMetal(5);
        Elemento h = Base.getNoMetal(1);
        o.setEstado_used(0);
        h.setEstado_used(0);

        ArrayList<Elemento> els = new ArrayList();
        els.add(o);
        els.add(h);
        ArrayList<Integer> rdc = new ArrayList();
        Radical rd = new Radical(els, rdc, "OH");

        arr.add(ele);
        arr.add(o);
        arr.add(h);

        int mcm = mcm(ele.getEstado_used(), rd.getEstado() * -1);
        cant.add(mcm / ele.getEstado_used());
        cant.add(mcm);
        cant.add(mcm);

        nom = ele.getNom() + "%a(" + rd.getFormula() + ")%b";
        if (cant.get(0) != 1) {
            nom = nom.replace("%a", cant.get(0) + "");
        } else {
            nom = nom.replace("%a", "");
        }
        if (cant.get(1) != 1) {
            nom = nom.replace("%b", cant.get(1) + "");
        } else {
            nom = nom.replace("%b", "");
        }
        hx = new Compuesto(arr, cant, "Almost there", nom, Reaccion.HIDROXIDO);
        return hx;
    }

    private Compuesto acido_oxacido(Elemento ele) {
        Compuesto ao = null;
        Elemento o = Base.getNoMetal(5);
        o.setEstado_used(0);
        Elemento h = Base.getNoMetal(1);
        h.setEstado_used(0);

        ArrayList<Elemento> arr = new ArrayList();
        ArrayList<Integer> cant = new ArrayList();
        arr.add(ele);
        arr.add(o);
        arr.add(h);
        String nom = null;

        int mcm = mcm(ele.getEstado_used(), o.getEstado_used() * -1, h.getEstado_used());
        cant.add(mcm / ele.getEstado_used());
        cant.add(mcm / o.getEstado_used() * -1);
        cant.add(mcm / h.getEstado_used());
        System.out.println(mcm);

        nom = nom(arr, cant);
        ao = new Compuesto(arr, cant, "almost here", nom, Reaccion.ACIDO_OXACIDO);
        return ao;
    }

    private Compuesto acido_hidracido(Elemento ele) {
        Compuesto  ah=this.hidruro_nometalico(ele);
        return new Compuesto(ah.getElementos(), ah.getCant(), "amos here",ah.getNom()+"(AC)",ah.getTipo());
    }
/*
    private Compuesto sal_hidracida(Compuesto hidracido, Compuesto hidroxido) {

    }
/*
    private Compuesto sal_neutra(Compuesto oxoacido, Compuesto hidroxido) {

    }
/*
    private Compuesto sal_acida(Compuesto oxoacido, Compuesto hidroxido) {

    }
/*
    private Compuesto sal_basica(Compuesto oxoacido, Compuesto hidroxido) {

    }
/*
    private Compuesto sal_mixta(Compuesto oxoacido, Compuesto hidroxido1, Compuesto hidroxido2) {
        
    }
     */
    private String nom(ArrayList<Elemento> eles, ArrayList<Integer> cant) {
        String nom = null;

        if (eles.size() == 2) {
            if (eles.get(1).getId() == 1) {
                if (eles.get(0).getColum() == 16 || eles.get(0).getColum() == 17) {
                    nom = eles.get(1).getNom() + "%a" + eles.get(0).getNom() + "%b";
                    if (cant.get(1) != 1) {
                        nom = nom.replace("%a", cant.get(1) + "");
                    } else {
                        nom = nom.replace("%a", "");
                    }
                    if (cant.get(0) != 1) {
                        nom = nom.replace("%b", cant.get(0) + "");
                    } else {
                        nom = nom.replace("%b", "");
                    }
                } else {
                    nom = eles.get(0).getNom() + "%a" + eles.get(1).getNom() + "%b";
                    if (cant.get(0) != 1) {
                        nom = nom.replace("%a", cant.get(0) + "");
                    } else {
                        nom = nom.replace("%a", "");
                    }
                    if (cant.get(1) != 1) {
                        nom = nom.replace("%b", cant.get(1) + "");
                    } else {
                        nom = nom.replace("%b", "");
                    }
                }
            } else if (eles.get(1).getId() == 5) {
                nom = eles.get(0).getNom() + "%a" + eles.get(1).getNom() + "%b";
                if (cant.get(0) != 1) {
                    nom = nom.replace("%a", cant.get(0) + "");
                } else {
                    nom = nom.replace("%a", "");
                }
                if (cant.get(1) != 1) {
                    nom = nom.replace("%b", cant.get(1) + "");
                } else {
                    nom = nom.replace("%b", "");
                }
            }
        } else if (eles.size() == 3) {
            boolean flag = false;
            for (Elemento i : Base.getTodosNoMetales()) {
                if (i.equals(eles.get(0))) {
                    flag = true;
                    nom = eles.get(2).getNom() + "%a" + eles.get(0).getNom() + "%b" + eles.get(1).getNom() + "%c";
                    if (cant.get(0) != 1) {
                        nom = nom.replace("%b", cant.get(0) + "");
                    } else {
                        nom = nom.replace("%b", "");
                    }
                    if (cant.get(1) != 1) {
                        nom = nom.replace("%c", cant.get(1) + "");
                    } else {
                        nom = nom.replace("%c", "");
                    }
                    if (cant.get(2) != 1) {
                        nom = nom.replace("%a", cant.get(2) + "");
                    } else {
                        nom = nom.replace("%a", "");
                    }

                }
            }
        }
        return nom;
    }

    private int mcm(int num1, int num2) {
        int min = Math.min(num1, num2);
        int mcm = 0;
        for (int i = 1; i <= min; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                int mcd = i;
                mcm = (num1 * num2) / mcd;
            }
        }
        return mcm;
    }

    private int mcm(int num1, int num2, int num3) {
        int max = 0;
        int mcm = 0;
        
        max = num1;
        if(num2>max)
            max = num2;
        if(num3 > max)
            max=num3;
        
        mcm=max;
        while((mcm%num1 != 0) || (mcm%num2 != 0) || (mcm % num3!=0))
            mcm++;
        return mcm;
    }

}
