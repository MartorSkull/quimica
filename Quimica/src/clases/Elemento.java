/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author tobias
 */
public class Elemento {
    int id;
    String nombre;
    String nom;
    int[] estados;
    int colum;
    int idColum;
    float eleneg;

    public Elemento(String nombre, String nom, int[] estados, float eleneg) {
        this.nombre = nombre;
        this.nom = nom;
        this.estados = estados;
        this.eleneg = eleneg;
    }

    public Elemento(int id, String nombre, String nom, int[] estados, float eleneg) {
        this.nombre = nombre;
        this.nom = nom;
        this.estados = estados;
        this.eleneg=eleneg;
    }

    public Elemento(String nombre, String nom, int[] estados, float eleneg, int colum, int idColum) {
        this.id = id;
        this.nombre = nombre;
        this.nom = nom;
        this.estados = estados;
        this.eleneg = eleneg;
        this.colum = colum;
        this.idColum = idColum;
    }

    public Elemento(int id, String nombre, String nom, int[] estados, int colum, int idColum, float eleneg) {
        this.id = id;
        this.nombre = nombre;
        this.nom = nom;
        this.estados = estados;
        this.colum = colum;
        this.idColum = idColum;
        this.eleneg = eleneg;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColum() {
        return colum;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }

    public int getIdColum() {
        return idColum;
    }

    public void setIdColum(int idColum) {
        this.idColum = idColum;
    }

    public float getEleneg() {
        return eleneg;
    }

    public void setEleneg(float eleneg) {
        this.eleneg = eleneg;
    }
    
}
