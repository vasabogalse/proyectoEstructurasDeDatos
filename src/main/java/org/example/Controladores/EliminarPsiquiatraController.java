package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.Psiquiatra;
import org.example.SistemaDeGestionClinica;
import java.io.IOException;
import java.util.Optional;

public class EliminarPsiquiatraController {
    @FXML
    public TextField idEliminarTextField;
    public Label errorLabel;

    public void eliminarPsiquiatra(ActionEvent event) throws IOException {
        errorLabel.setText("");
        String idEliminar = idEliminarTextField.getText().trim();
        int idEliminarInt;
        try{
            idEliminarInt = Integer.parseInt(idEliminarTextField.getText().trim());
        } catch (Exception e){
            errorLabel.setText("El ID del psiquiatra debe ser un número");
            return;
        }
        if (idEliminar.equals("")) {
            errorLabel.setText("El campo de ID del psquiatra a eliminar no puede estar vacío.");
            return;
        } else if (!Psiquiatra.psiquiatraHash.containsKey(idEliminar)){
            errorLabel.setText("No hay un paciente registrado con la id " + idEliminar);
            return;
        } else {
            Psiquiatra psiquiatraAEliminar = Psiquiatra.psiquiatraHash.get(idEliminar);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dialogo de confirmación");
            alert.setHeaderText("¿Está seguro que desea eliminar el siguiente psquiatra?" + "\n" + psiquiatraAEliminar);
            alert.setContentText("");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Eliminación satisfactoria");
                alert1.setHeaderText("Eliminación satisfactoria");
                alert1.setContentText("Se ha eliminado el psiquiatra satisfactoriamente:\n" + psiquiatraAEliminar.toString());
                alert1.showAndWait();
                Psiquiatra.eliminarPsquiatra(idEliminar);

                SistemaDeGestionClinica.BD.removeVertex(psiquiatraAEliminar);
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
        SistemaDeGestionClinica.setRoot("GestionarPsiquiatra");
    }
}
