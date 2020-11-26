package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Psiquiatra {
    public String idPsiquiatra;
    public String nombres;
    public String apellidos;
    public String emailPsiquiatra; //verificar que se pueda ingresar una @
    public String clavePsiquiatra;
    public String Sexo;
    public String direccion;
    public int edad;
    public LocalDate fechaNacimiento; //organizar para fecha
    public int tel;


    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static Hashtable<String,Psiquiatra> psiquiatraHash = new Hashtable<>();
    TreeSet<Psiquiatra> psiApellido = new TreeSet<>(Ordenamiento.apelPsiquiatra);
    TreeSet<Psiquiatra> psiEdad = new TreeSet<>(Ordenamiento.edadPsiquiatra);


    public Psiquiatra(String idPsiquiatra, String nombres, String apellidos, String emailPsiquiatra, String clavePsiquiatra, String sexo, String direccion, int edad, String fechaIng, int tel) {
        this.idPsiquiatra = idPsiquiatra;
        this.nombres = nombres;
        this.apellidos = apellidos.toLowerCase();
        this.emailPsiquiatra = emailPsiquiatra.toLowerCase();
        this.clavePsiquiatra = clavePsiquiatra;
        this.Sexo = sexo;
        this.direccion = direccion;
        this.edad = edad;
        LocalDate fechaNacimiento = LocalDate.parse(fechaIng,formateador);
        this.fechaNacimiento = fechaNacimiento;
        this.tel = tel;
        SistemaDeGestionClinica.BD.addVertex(this);
        psiquiatraHash.put(idPsiquiatra,this);
        psiApellido.add(this);
        psiEdad.add(this);
    }


    @Override
    public String toString() {
        return  "Cédula: " + idPsiquiatra + "\n" +
                "Nombre: " + nombres + "\n" +
                "Apellidos: " + apellidos + "\n" +
                "Sexo: " + Sexo + "\n" +
                "Email: " + emailPsiquiatra + "\n" +
                "Dirección: " + direccion + "\n" +
                "Edad: " + edad + "\n" +
                "Fecha de nacimiento: " + fechaNacimiento + "\n" +
                "Teléfono: " + tel ;
    }

}


