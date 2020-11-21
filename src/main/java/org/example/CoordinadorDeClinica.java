package org.example;

public class CoordinadorDeClinica{
    public String cedulaCoordinador;
    public String emailCoordinador; //verificar que se pueda ingresar al ingresar
    public String contrasenaCoordinador;


    public CoordinadorDeClinica(String cedulaCoordinador, String emailCoordinador, String contrasenaCoordinador) {
        this.cedulaCoordinador = cedulaCoordinador;
        this.emailCoordinador = emailCoordinador.toLowerCase();
        this.contrasenaCoordinador = contrasenaCoordinador.toLowerCase();

    }


    @Override
    public String toString() {
        return "{" + "\n" +
                " cedulaCoordinador : " + cedulaCoordinador + "," + "\n" +
                " emailCoordinador : " + emailCoordinador + "," + "\n" +
                " contrasenaCoordinador : " + contrasenaCoordinador + "," + "\n" +
                "}";
    }

    // metodos de la clase

}