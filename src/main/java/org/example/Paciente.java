package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;
import java.util.Scanner;
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
    TreeSet<Paciente> pacienteApel = new TreeSet<>(Ordenamiento.ApePaciente);
    TreeSet<Paciente> pacienteTel = new TreeSet<>(Ordenamiento.edadPaciente);

    public Paciente(String idPaciente, String nombres, String apellidos, String email, String contrasena, String direccion, int edad, String fechaIng, String telefono, String nombreContactoEmergencia, String telefonoContactoEmergencia) {
        this.idPaciente = idPaciente;
        this.nombres = nombres;
        this.apellidos = apellidos.toLowerCase();
        this.email = email;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.edad = edad;
        LocalDate fechaNacimiento = LocalDate.parse(fechaIng,formateador);
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.nombreContactoEmergencia = nombreContactoEmergencia;
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
        SistemaDeGestionClinica.BD.addVertex(this);
        pacienteHash.put(idPaciente,this);
        pacienteApel.add(this);
        pacienteTel.add(this);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Cita )){
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
        return "Paciente{" +
                "idPaciente='" + idPaciente + '\'' +
                ", nombres='" + nombres + '\'' +
                '}';
    }
}

