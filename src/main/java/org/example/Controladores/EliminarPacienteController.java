package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.Paciente;
import org.example.SistemaDeGestionClinica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class EliminarPacienteController {
    @FXML
    public TextField idEliminarTextField;
    public Label errorLabel;

    public void eliminarPaciente(ActionEvent event) throws IOException {
        errorLabel.setText("");
        String idEliminar = idEliminarTextField.getText().trim();
        if (idEliminar.equals("")) {
            errorLabel.setText("El campo de ID del paciente a eliminar no puede estar vacío.");
        }
        else if (!Paciente.pacienteHash.containsKey(idEliminar)){
            errorLabel.setText("No hay un paciente registrado con la id " + idEliminar);
        }
        else {
            Paciente pacienteAEliminar = Paciente.pacienteHash.get(idEliminar);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dialogo de confirmación");
            alert.setHeaderText("¿Está seguro que desea eliminar el siguiente paciente?" + "\n" + pacienteAEliminar);          alert.setContentText("");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Eliminación satisfactoria");
                alert1.setHeaderText("Eliminación satisfactoria");
                alert1.setContentText("Se ha eliminado el paciente satisfactoriamente:\n" + pacienteAEliminar.toString());
                alert1.showAndWait();
                Paciente.eliminarPaciente(idEliminar);

                SistemaDeGestionClinica.BD.removeVertex(pacienteAEliminar);
                for(Object obj : SistemaDeGestionClinica.BD.vertexSet()){
                    System.out.println(obj);
                }

                idEliminarTextField.setText("");
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarPaciente");
    }
}
