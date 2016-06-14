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
public class Elemento {
    String nombre;
    String nom;
    int[] estados;

    public Elemento(String nombre, String nom, int[] estados) {
        this.nombre = nombre;
        this.nom = nom;
        this.estados = estados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int[] getEstados() {
        return estados;
    }

    public void setEstados(int[] estados) {
        this.estados = estados;
    }
    
    
}
