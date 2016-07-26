/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author martin
 */
public class Compuesto {
    private Elemento[] elementos;
    private int cantAtoms;
    private int[] cant;
    private String molecula;
    private String nom;
    private int tipo;
    private int[] estado;

    public Compuesto(Elemento[] elementos, int cantAtoms, int[] cant, String molecula, String nom, int tipo) {
        this.elementos = elementos;
        this.cantAtoms = cantAtoms;
        this.cant = cant;
        this.molecula = molecula;
        this.nom = nom;
        this.tipo = tipo;
    }

    public Elemento[] getElementos() {
        return elementos;
    }

    public int getCantAtoms() {
        return cantAtoms;
    }

    public int[] getCant() {
        return cant;
    }

    public String getMolecula() {
        return molecula;
    }

    public String getNom() {
        return nom;
    }

    public int getTipo() {
        return tipo;
    }
}
