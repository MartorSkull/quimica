/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author tobias
 */
public class Elemento implements Serializable{

    private int id;
    private String nombre;
    private String nom;
    private ArrayList<Integer> estados;
    private int colum;
    private int idColum;
    private float eleneg;
    private int estado_used;

    public Elemento(int id, 
                    String nombre, 
                    String nom, 
                    ArrayList<Integer> estados, 
                    int estado_used, 
                    float eleneg) {
        this.nombre = nombre;
        this.nom = nom;
        this.estados = estados;
        this.eleneg = eleneg;
        this.estado_used=estado_used;
    }

    public Elemento(int id, 
            String nombre, 
            String nom, 
            ArrayList<Integer> estados, 
            int estado_used, 
            int colum, 
            int idColum, 
            float eleneg) {
        this.id = id;
        this.nombre = nombre;
        this.nom = nom;
        this.estados = estados;
        this.colum = colum;
        this.idColum = idColum;
        this.eleneg = eleneg;
        this.estado_used = estado_used;
    }

    public Elemento(int id, 
                    String nombre, 
                    String nom, 
                    ArrayList<Integer> estados, 
                    int colum, 
                    int idColum, 
                    float eleneg) {
        this.id = id;
        this.nombre = nombre;
        this.nom = nom;
        this.estados = estados;
        this.colum = colum;
        this.idColum = idColum;
        this.eleneg = eleneg;
    }
    
    @Override
    public String toString(){
        return this.id+" - "+this.nombre+ " - "+this.nom+" - "+this.estados+" - "+this.colum+" - "+this.idColum+" - "+this.eleneg;
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

    public ArrayList<Integer> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Integer> estados) {
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

    public int getEstado_used() {
        return this.estados.get(estado_used);
    }

    public void setEstado_used(int id) {
        this.estado_used = id;
    }

}
