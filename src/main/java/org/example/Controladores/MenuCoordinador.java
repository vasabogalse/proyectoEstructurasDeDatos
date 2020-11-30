package org.example.Controladores;


import javafx.event.ActionEvent;
import org.example.SistemaDeGestionClinica;

import java.io.IOException;

public class MenuCoordinador {

    public void gestionarClinica(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarClinica");
    }

    public void buscar(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("MenuBusqueda");
    }

    public void gestionarPaciente(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarPaciente");
    }

    public void cerrarSesion(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("Ingreso");
    }

    public void gestionarPsiquiatra(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarPsiquiatra");
    }
}
