package org.example.Controladores;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.SistemaDeGestionClinica;
import java.io.IOException;

public class GestionarClinica  {

    @FXML
    public void routeIngresarClinica(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("IngresarClinica");
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("MenuCoordinador");
    }

    public void routeVerClinica(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("VerClinica");
    }

    @FXML
    public void routeEliminarClinica(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("EliminarClinica");
    }

    @FXML
    public void routeEditarClinica(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("EditarClinica");
    }
}