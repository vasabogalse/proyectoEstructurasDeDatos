package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.example.Psiquiatra;
import org.example.SistemaDeGestionClinica;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VerPsiquiatrasController implements Initializable {

    public ListView listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Psiquiatra psiquiatra : Psiquiatra.psiquiatraHash.values()) {
            listView.getItems().add(psiquiatra);
        }
    }

    @FXML
    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarPsiquiatra");
    }
}
