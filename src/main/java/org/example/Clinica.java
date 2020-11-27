package org.example;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeMap;

public class Clinica{
    public int nit;
    public String nombreClinica;
    public String direccion;
    public int telefono;

    public static Hashtable<Integer,Clinica> ClinicaHash = new Hashtable<>();
    public static TreeMap<String, LinkedList<Clinica>> clinicaNom = new TreeMap<>();
    public static TreeMap<Integer, LinkedList<Clinica>> clinicaTel = new TreeMap<>();


    public Clinica(int nit, String nombClinica, String direccion, int telefono) {
        this.nit = nit;
        this.nombreClinica = nombClinica.toLowerCase();
        this.direccion = direccion.toLowerCase();
        this.telefono = telefono;
        SistemaDeGestionClinica.BD.addVertex(this);
        ClinicaHash.put(nit,this);

        if (!clinicaNom.containsKey(nombreClinica)) {
            clinicaNom.put(this.nombreClinica, new LinkedList<>());
        }
        if (!clinicaTel.containsKey(telefono)){
            clinicaTel.put(this.telefono,new LinkedList<>());
        }
        clinicaNom.get(nombreClinica).add(this);
        clinicaTel.get(telefono).add(this);
    }



    public int getNit() {
        return nit;
    }

    @Override
    public String toString() {
        return  "Nit: " + nit+"\n" +
                "Nombre: " + nombreClinica + "\n" +
                "Dirección: " + direccion + "\n" +
                "Teléfono: " + telefono + "\n"
              ;
    }
}
