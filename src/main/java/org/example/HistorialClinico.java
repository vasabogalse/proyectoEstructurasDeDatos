package org.example;

import org.jgrapht.Graphs;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HistorialClinico {
    public int idHistClinico;
    public ArrayList<String> antecedentes = new ArrayList<>();
    public ArrayList<String> procedimientos = new ArrayList<>();
    public ArrayList<String> recomendaciones = new ArrayList<>();
    public String fecha;

    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy, HH:mm:ss a");

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Cita )){
            return false;
        }
        HistorialClinico historialClinico = (HistorialClinico)o; //Objeto que comparo conmigo mismo.
        //Criterio de igualdad, el que quiera.
        if (historialClinico.idHistClinico == this.idHistClinico){
            return true;
        }else{
            return false;
        }
    }
    public HistorialClinico(int idHistClinico, String antece, String procedi, String recomen) {
        this.idHistClinico = idHistClinico;
        this.antecedentes.add(antece);
        this.procedimientos.add(procedi);
        this.recomendaciones.add(recomen);
        String fecha = formateador.format(LocalDateTime.now());
        this.fecha = fecha;
        SistemaDeGestionClinica.BD.addVertex(this);
    }


    @Override
   public String toString() {
        return "HistorialClinico{" +
                "idHistClinico=" + idHistClinico +
                ", antecedentes=" + antecedentes +
                ", procedimientos=" + procedimientos +
                ", recomendaciones=" + recomendaciones +
                ", fechaModificacion='" + fecha + '\'' +
                '}';
   }
}

