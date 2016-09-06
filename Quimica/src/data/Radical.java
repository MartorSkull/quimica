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
public class Radical {
    private ArrayList<Elemento> elementos;
    private ArrayList<Integer> cant;
    private String formula;
    private int estado;
    
    public Radical(ArrayList<Elemento> elementos, ArrayList<Integer> cant, String formula) {
        this.elementos = elementos;
        this.cant = cant;
        this.formula = formula;
        for(Elemento i:elementos){
            this.estado+=i.getEstado_used();
            System.out.println(estado);
        }
    }

    public ArrayList<Elemento> getElemetnos() {
        return elementos;
    }

    public void setElemetnos(ArrayList<Elemento> elemetnos) {
        this.elementos = elemetnos;
    }

    public ArrayList<Integer> getCant() {
        return cant;
    }

    public void setCant(ArrayList<Integer> cant) {
        this.cant = cant;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
