package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.example.Clinica;
import org.example.Paciente;
import org.example.SistemaDeGestionClinica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VerClinicaController implements Initializable {

    public ListView listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Clinica clinica : Clinica.ClinicaHash.values()) {
            listView.getItems().add(clinica);
        }
    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarClinica");
    }
}
