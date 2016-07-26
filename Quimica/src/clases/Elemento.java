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

    private int id;
    private String nombre;
    private String nom;
    private int[] estados;
    private int estado_used;
    private int colum;
    private int idColum;
    private float eleneg;

    public Elemento(String nombre, String nom, int[] estados, int estado_used, float eleneg) {
        this.nombre = nombre;
        this.nom = nom;
        this.estados = estados;
        this.eleneg = eleneg;
        this.estado_used = estado_used;
    }

    public Elemento(int id, String nombre, String nom, int[] estados, int estado_used,float eleneg) {
        this.nombre = nombre;
        this.nom = nom;
        this.estados = estados;
        this.eleneg = eleneg;
        this.estado_used = estado_used;
    }

    public Elemento(String nombre, String nom, int[] estados, int estado_used, float eleneg, int colum, int idColum) {
        this.id = id;
        this.nombre = nombre;
        this.nom = nom;
        this.estados = estados;
        this.eleneg = eleneg;
        this.colum = colum;
        this.idColum = idColum;
        this.estado_used = estado_used;
    }

    public Elemento(int id, String nombre, String nom, int[] estados, int estado_used, int colum,int idColum, float eleneg) {
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
    
    public int getEstado_used(){
        return estado_used;
    }
    
    public void setEstado_used(int estado){
        this.estado_used = estado;
    }
}
