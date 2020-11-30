package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.example.Psiquiatra;
import org.example.SistemaDeGestionClinica;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class IngresarPsiquiatraController implements Initializable {
    @FXML public TextField idTextField;
    @FXML public TextField nombresTextField;
    @FXML public TextField apellidosTextField;
    @FXML public TextField direccionTextField;
    @FXML public TextField emailTextField;
    @FXML public TextField telefonoTextField;
    @FXML public TextField edadTextField;
    @FXML public RadioButton femeninoRadioButton;
    @FXML public RadioButton masculinoRadioButton;
    @FXML public TextField fechaNacimientoTextField;
    @FXML public Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    public void registrarPsiquiatra(ActionEvent event) throws IOException {
        errorLabel.setText("");
        if (idTextField.getText().trim().equals("") || nombresTextField.getText().trim().equals("") ||
            apellidosTextField.getText().trim().equals("") || direccionTextField.getText().trim().equals("") ||
            emailTextField.getText().trim().equals("") || telefonoTextField.getText().trim().equals("") ||
            edadTextField.getText().trim().equals("") || fechaNacimientoTextField.getText().trim().equals("") ) {

            errorLabel.setText("Los campos no pueden estar vacios.");
            return;
        }
        String id = idTextField.getText().trim();
        if(Psiquiatra.psiquiatraHash.containsKey(id)) {
            errorLabel.setText("Ya hay un paciente con esta ID registrado");
            return;
        }
        String nombres = nombresTextField.getText().trim();
        String apellidos = apellidosTextField.getText().trim();
        String direccion = direccionTextField.getText().trim();
        String email = emailTextField.getText().trim();
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(!email.matches(regex)){
            errorLabel.setText("E-mail inválido");
            return;
        }
        String fechaNacimiento = fechaNacimientoTextField.getText();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaDateTime;
        try{
            fechaDateTime = LocalDate.parse(fechaNacimiento,formateador);
            LocalDate dt1 = LocalDate.parse("01/01/1970", formateador);
            LocalDate dt2 = LocalDate.parse("31/12/2002",formateador);
            if(fechaDateTime.isBefore(dt1) || fechaDateTime.isAfter(dt2)){
                errorLabel.setText("La fecha de nacimiento de un psiquiatra debe estar entre los 18 y 50 años");
                return;
            }
        }catch (DateTimeParseException e){
            System.out.println(e);
            errorLabel.setText("Formato de fecha inválido");
            return;
        }
        int edadPsiquiatra;
        try{
           edadPsiquiatra = Integer.parseInt(edadTextField.getText().trim());
           if(edadPsiquiatra < 18 || edadPsiquiatra > 50){
               errorLabel.setText("El psiquiatra debe tener entre 18 y 50 años de edad");
               return;
           }
        }catch (Exception e){
            errorLabel.setText("La edad tiene que ser un número");
            return;
        }
        int telefono;
        try{
            telefono = Integer.parseInt(telefonoTextField.getText().trim());
            if(telefono < 0){
                errorLabel.setText("El número de teléfono debe ser mayor que cero");
                return;
            }
        }catch (Exception e){
            errorLabel.setText("El teléfono tiene que ser un número");
            return;
        }
        String sexo = null;
        if(!(femeninoRadioButton.isSelected() || masculinoRadioButton.isSelected())){
            errorLabel.setText("Por favor selecciona el género del psiquiatra");
            return;
        } else if(femeninoRadioButton.isSelected()){
            masculinoRadioButton.setSelected(false);
            sexo = femeninoRadioButton.getText();
        } else if(masculinoRadioButton.isSelected()){
            femeninoRadioButton.setSelected(false);
            sexo = masculinoRadioButton.getText();
        }

        Psiquiatra nuevoPsiquiatra = new Psiquiatra(id, nombres, apellidos, email, sexo, direccion, edadPsiquiatra, fechaNacimiento, telefono);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creacion satisfactoria");
        alert.setHeaderText("Creacion satisfactoria");
        alert.setContentText("Se ha ingresado el psiquiatra satisfactoriamente:\n" + nuevoPsiquiatra.toString());
        alert.showAndWait();

        limpiarCampos();
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarPsiquiatra");
        limpiarCampos();
    }

    public void limpiarCampos(){
        idTextField.clear();
        nombresTextField.clear();
        apellidosTextField.clear();
        direccionTextField.clear();
        emailTextField.clear();
        telefonoTextField.clear();
        edadTextField.clear();
        femeninoRadioButton.setSelected(false);
        masculinoRadioButton.setSelected(false);
        fechaNacimientoTextField.clear();
        errorLabel.setText("");
    }
}
