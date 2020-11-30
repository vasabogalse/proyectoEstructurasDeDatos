package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Psiquiatra {
    public String idPsiquiatra;
    public String nombres;
    public String apellidos;
    public String emailPsiquiatra;
    public String Sexo;
    public String direccion;
    public int edad;
    public LocalDate fechaNacimiento; //organizar para fecha
    public int tel;


    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static Hashtable<String,Psiquiatra> psiquiatraHash = new Hashtable<>();
    public static TreeMap<String,LinkedList<Psiquiatra>> psiApell = new TreeMap<>();
    public static TreeMap<Integer,LinkedList<Psiquiatra>> psiEdad = new TreeMap<>();


    public Psiquiatra(){}

    public Psiquiatra(String idPsiquiatra, String nombres, String apellidos, String emailPsiquiatra, String sexo, String direccion, int edad, String fechaIng, int tel) {
        this.idPsiquiatra = idPsiquiatra;
        this.nombres = nombres.toLowerCase();
        this.apellidos = apellidos.toLowerCase();
        this.emailPsiquiatra = emailPsiquiatra.toLowerCase();
        this.Sexo = sexo;
        this.direccion = direccion;
        this.edad = edad;
        this.fechaNacimiento = LocalDate.parse(fechaIng,formateador);
        this.tel = tel;
        SistemaDeGestionClinica.BD.addVertex(this);

        psiquiatraHash.put(idPsiquiatra,this);

        if (!psiApell.containsKey(this.apellidos)) {
            psiApell.put(this.apellidos, new LinkedList<>());
        }
        if (!psiEdad.containsKey(edad)){
            psiEdad.put(this.edad,new LinkedList<>());
        }
        psiApell.get(this.apellidos).add(this);
        psiEdad.get(edad).add(this);
    }
    public static void eliminarPsquiatra(String idEliminar) {
        Psiquiatra psquiatraEliminar = psiquiatraHash.get(idEliminar);

        ListIterator<Psiquiatra> iteratorApellido = psiApell.get(psquiatraEliminar.apellidos).listIterator();
        while (iteratorApellido.hasNext()) {
            Psiquiatra pApellidoIterator = iteratorApellido.next();
            if (pApellidoIterator.idPsiquiatra.equals(idEliminar)) {
                iteratorApellido.remove();
                break;
            }
        }

        ListIterator<Psiquiatra> iteratorEdad = psiEdad.get(psquiatraEliminar.edad).listIterator();
        while (iteratorEdad.hasNext()) {
            Psiquiatra pEdadIterator = iteratorEdad.next();
            if (pEdadIterator.idPsiquiatra.equals(idEliminar)) {
                iteratorEdad.remove();
                break;
            }
        }

        psiquiatraHash.remove(idEliminar);
        SistemaDeGestionClinica.BD.removeVertex(psquiatraEliminar);
    }


    @Override
    public String toString() {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return  "Cédula: " + idPsiquiatra + "\n" +
                "Nombre: " + nombres + "\n" +
                "Apellidos: " + apellidos + "\n" +
                "Sexo: " + Sexo + "\n" +
                "Email: " + emailPsiquiatra + "\n" +
                "Dirección: " + direccion + "\n" +
                "Edad: " + edad + "\n" +
                "Fecha de nacimiento: " + formateador.format(fechaNacimiento) + "\n" +
                "Teléfono: " + tel + "\n";
    }

}


