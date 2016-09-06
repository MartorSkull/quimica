/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author martin
 */
public class Compuesto {

    private ArrayList<Elemento> elementos;
    private ArrayList<Integer> cant;
    private String molecula;
    private String nom;
    private int tipo;

    public Compuesto(ArrayList<Elemento> elementos, ArrayList<Integer> cant, String molecula, String nom, int tipo) {
        this.elementos = elementos;
        this.cant = cant;
        this.molecula = molecula;
        this.nom = nom;
        this.tipo = tipo;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public ArrayList<Integer> getCant() {
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
