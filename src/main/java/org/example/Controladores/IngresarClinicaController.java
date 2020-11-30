package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.Clinica;
import org.example.SistemaDeGestionClinica;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IngresarClinicaController implements Initializable {

    @FXML public TextField nitTextField;
    @FXML public TextField nombreTextField;
    @FXML public TextField direccionTextField;
    @FXML public TextField telefonoTextField;
    @FXML public Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void registrarClinica(ActionEvent event) throws IOException {
        errorLabel.setText("");
        if (nitTextField.getText().trim().equals("") || nombreTextField.getText().trim().equals("") || direccionTextField.getText().trim().equals("") || telefonoTextField.getText().trim().equals("")) {
            errorLabel.setText("Debe llenar todos los campos.");
            return;
        }

        String id = nitTextField.getText().trim();
        if(Clinica.ClinicaHash.containsKey(Integer.parseInt(id))) {
            errorLabel.setText("Ya hay una clínica con este nit registrado");
            nitTextField.setText("");
            return;
        }

        String nombre = nombreTextField.getText().trim();
        String direccion = direccionTextField.getText().trim();

        int telefono;
        try{
            telefono = Integer.parseInt(telefonoTextField.getText().trim());
        }catch (Exception e){
            errorLabel.setText("El teléfono tiene que ser una cadena de numeros");
            telefonoTextField.setText("");
            return;
        }

        Clinica nuevaClinica = new Clinica(Integer.parseInt(id), nombre, direccion, telefono);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creación satisfactoria");
        alert.setHeaderText("Creación satisfactoria");
        alert.setContentText("Se ha ingresado la clínica satisfactoriamente:\n" + nuevaClinica.toString());
        alert.showAndWait();
        nitTextField.setText("");
        nombreTextField.setText("");
        direccionTextField.setText("");
        telefonoTextField.setText("");
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarClinica");
    }
}
