package org.example;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.Hashtable;
import java.util.TreeSet;

public class Clinica{
    public int nit;
    public String nombreClinica;
    public String direccion;
    public int telefono;

    Hashtable<Integer,Clinica> ClinicaHash = new Hashtable<>();
    TreeSet<Clinica> clinicaNom = new TreeSet<>(Ordenamiento.clinicNameOrder);
    TreeSet<Clinica> clinicaTel = new TreeSet<>(Ordenamiento.telClinicOrder);

    public Clinica(int nit, String nombreClinica, String direccion, int telefono) {
        this.nit = nit;
        this.nombreClinica = nombreClinica.toLowerCase();
        this.direccion = direccion.toLowerCase();
        this.telefono = telefono;
        SistemaDeGestionClinica.BD.addVertex(this);
        ClinicaHash.put(nit,this);
        clinicaNom.add(this);
        clinicaTel.add(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Cita )){
            return false;
        }
        Clinica clinica = (Clinica) o; //Objeto que comparo conmigo mismo.
        //Criterio de igualdad, el que quiera.
        if (clinica.nit == this.nit){
            return true;
        }else{
            return false;
        }
    }

    public int getNit() {
        return nit;
    }
    public void setNit(int nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                " nit : " + nit + "," + "\n" +
                " nombreClinica : " + nombreClinica + "," + "\n" +
                " direccion : " + direccion + "," + "\n" +
                " telefono : " + telefono + "\n" +
                '}';
    }
}
