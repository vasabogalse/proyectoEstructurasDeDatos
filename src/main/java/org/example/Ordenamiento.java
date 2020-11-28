package org.example;

import java.util.Comparator;

public class Ordenamiento {

    //Clinica
    static final Comparator<Clinica> nitClinicOrder = new Comparator<Clinica>() {
        public int compare(Clinica c1, Clinica c2) {
            if(c1.nit < c2.nit){
                return -1;
            } else if(c1.getNit() == c2.getNit()){
                return 0;
            } else {
                return 1;
            }
        }
    };
    static final Comparator<Clinica> clinicNameOrder = new Comparator<Clinica>() {
        @Override
        public int compare(Clinica c1, Clinica c2) {
            return c1.nombreClinica.compareTo(c2.nombreClinica);
        }
    };
    static final Comparator<Clinica> directionClinicOrder = new Comparator<Clinica>() {
        @Override
        public int compare(Clinica c1, Clinica c2) {
            return c1.direccion.compareTo(c2.direccion);
        }
    Comparator<Clinica> dirOrder = (Clinica o1, Clinica o2) -> {return o1.direccion.compareTo(o2.direccion);};
    };
    static final Comparator<Clinica> telClinicOrder = new Comparator<Clinica>() {
        @Override
        public int compare(Clinica c1, Clinica c2) {
            if(c1.telefono < c2.telefono){
                return -1;
            } else if(c1.telefono == c2.telefono){
                return 0;
            } else {
                return 1;
            }
        }
    };

    //Psiquiatra
    static final Comparator<Psiquiatra> apelPsiquiatra = new Comparator<Psiquiatra>() {
        @Override
        public int compare(Psiquiatra p1, Psiquiatra p2) {
            return p1.apellidos.compareTo(p2.apellidos);
        }
    };
    static final Comparator<Psiquiatra> edadPsiquiatra = new Comparator<Psiquiatra>() {
        public int compare(Psiquiatra ps1, Psiquiatra ps2) {
            if(ps1.edad < ps2.edad){
                return -1;
            } else if(ps1.edad == ps1.edad){
                return 0;
            } else {
                return 1;
            }
        }
    };


    //Paciente
    public static final Comparator<Paciente> ApePaciente = new Comparator<Paciente>() {
          public int compare(Paciente p1, Paciente p2) {
            return p1.apellidos.compareTo(p2.apellidos);
        }
    };
    static final Comparator<Paciente> edadPaciente = new Comparator<Paciente>() {
        public int compare(Paciente pa1, Paciente pa2) {
            if(pa1.edad < pa2.edad){
                return -1;
            } else if(pa1.telefono == pa2.telefono){
                return 0;
            } else {
                return 1;
            }
        }
    };


}
