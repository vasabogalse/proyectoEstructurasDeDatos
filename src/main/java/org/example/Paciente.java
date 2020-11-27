package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Paciente {
    public String idPaciente;
    public String nombres;
    public String apellidos;
    public String email; //verificar que se pueda ingresar una
    public String contrasena;
    public String direccion;
    public int edad;
    public LocalDate fechaNacimiento;// Arreglar
    public String telefono; //Hacer que reciba celular y telefono
    public String nombreContactoEmergencia;
    public String telefonoContactoEmergencia;

    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static Hashtable<String,Paciente> pacienteHash = new Hashtable<>();
     public static TreeMap<String, LinkedList<Paciente>> pacienteNom = new TreeMap<>();
    public static TreeMap<Integer, LinkedList<Paciente>> pacienteEdad = new TreeMap<>();

    public Paciente(String idPaciente, String nombres, String apellidos, String email, String contrasena, String direccion, int edad, String fechaIng, String telefono, String nombreContactoEmergencia, String telefonoContactoEmergencia) {
        this.idPaciente = idPaciente;
        this.nombres = nombres.toLowerCase();
        this.apellidos = apellidos.toLowerCase();
        this.email = email.toLowerCase();
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.edad = edad;
        LocalDate fechaNacimiento = LocalDate.parse(fechaIng,formateador);
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.nombreContactoEmergencia = nombreContactoEmergencia;
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
        String nomCompleto = nombres + " " + apellidos;
        SistemaDeGestionClinica.BD.addVertex(this);
        pacienteHash.put(idPaciente,this);

        if (!pacienteNom.containsKey(nomCompleto)) {
            pacienteNom.put(nomCompleto, new LinkedList<>());
        }
        if (!pacienteEdad.containsKey(edad)){
            pacienteEdad.put(this.edad,new LinkedList<>());
        }
        pacienteNom.get(nomCompleto).add(this);
        pacienteEdad.get(edad).add(this);
    }


    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Paciente )){
            return false;
        }
        Paciente paciente = (Paciente) o; //Objeto que comparo conmigo mismo.
        //Criterio de igualdad, el que quiera.
        if (paciente.idPaciente == this.idPaciente){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return  "Cédula: " + idPaciente + "\n" +
                "Nombre: " + nombres + "\n" +
                "Apellidos: " + apellidos + "\n" +
                "Email: " + email + "\n" +
                "Dirección: " + direccion + "\n" +
                "Edad: " + edad + "\n" +
                "Fecha de nacimiento: " + fechaNacimiento + "\n" +
                "Teléfono: " + telefono + "\n" +
                "Nombre contacto emergencia: " + nombreContactoEmergencia + "\n" +
                "Teléfono contacto emergencia: " + telefonoContactoEmergencia;
    }
}

