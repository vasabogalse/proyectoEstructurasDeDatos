package org.example;

import java.util.*;

public class Cita{
    public int idCita;
    public String estadoCita;
    public Boolean prioridad;
    public Calendar fechaCita = new GregorianCalendar();//Mirar si se va a cambiar localTime

    Hashtable<Integer,Cita> CitaHash = new Hashtable<>();
    TreeSet<Cita> citaFecha = new TreeSet<>(Ordenamiento.CitaFecha);


    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Cita )){//Entrará si el objeto no es cita
            return false;
        }
        Cita cita = (Cita)o; //Objeto que comparo conmigo mismo.
        //Criterio de igualdad, el que quiera.
        if (cita.idCita == this.idCita){
            return true;
        }else{
            return false;
        }
    }



}