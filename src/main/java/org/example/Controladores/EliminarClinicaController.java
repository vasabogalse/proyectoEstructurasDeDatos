package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.Clinica;
import org.example.SistemaDeGestionClinica;

import java.io.IOException;
import java.util.Optional;

public class EliminarClinicaController {
    @FXML
    public TextField idEliminarTextField;
    public Label errorLabel;

    public void eliminarClinica(ActionEvent event) throws IOException {
        errorLabel.setText("");
        String idEliminar = idEliminarTextField.getText().trim();
        if (idEliminar.equals("")) {
            errorLabel.setText("El campo de nit de la clinica a eliminar no puede estar vacío.");
        }
        else if (!Clinica.ClinicaHash.containsKey(Integer.parseInt(idEliminar))){
            errorLabel.setText("No hay una clinica registrada con el nit " + idEliminar);
            idEliminarTextField.setText("");
        }
        else {
            Clinica clinicaAEliminar = Clinica.ClinicaHash.get(Integer.parseInt(idEliminar));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dialogo de confirmación");
            alert.setHeaderText("¿Está seguro que desea eliminar la siguiente clinica?" + "\n" + clinicaAEliminar);          alert.setContentText("");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Eliminación satisfactoria");
                alert1.setHeaderText("Eliminación satisfactoria");
                alert1.setContentText("Se ha eliminado la clínica satisfactoriamente:\n" + clinicaAEliminar.toString());
                alert1.showAndWait();
                Clinica.eliminarClinica(idEliminar);

                SistemaDeGestionClinica.BD.removeVertex(clinicaAEliminar);
                for(Object obj : SistemaDeGestionClinica.BD.vertexSet()){
                    System.out.println(obj);
                }
                idEliminarTextField.setText("");
            } else {
                SistemaDeGestionClinica.setRoot("GestionarClinica");
            }
        }
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarClinica");
    }
}
