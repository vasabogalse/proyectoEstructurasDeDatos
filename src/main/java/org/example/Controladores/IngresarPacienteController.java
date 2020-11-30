package org.example.Controladores;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.Paciente;
import org.example.SistemaDeGestionClinica;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class IngresarPacienteController implements Initializable {

    @FXML public TextField idTextField;
    @FXML public TextField nombresTextField;
    @FXML public TextField apellidosTextField;
    @FXML public TextField direccionTextField;
    @FXML public TextField emailTextField;
    @FXML public TextField telefonoTextField;
    @FXML public TextField nombreEmergenciaTextField;
    @FXML public TextField telefonoEmergenciaTextField;
    @FXML public TextField edadTextField;
    @FXML public TextField fechaNacimientoTextField;
    @FXML public Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void registrarPaciente(ActionEvent event) throws IOException {
        errorLabel.setText("");
        if (idTextField.getText().trim().equals("") || nombresTextField.getText().trim().equals("") ||
            apellidosTextField.getText().trim().equals("") || direccionTextField.getText().trim().equals("") ||
            emailTextField.getText().trim().equals("") || telefonoTextField.getText().trim().equals("") ||
            nombreEmergenciaTextField.getText().trim().equals("") || telefonoEmergenciaTextField.getText().trim().equals("") ||
            edadTextField.getText().trim().equals("") || fechaNacimientoTextField.getText().trim().equals("") ) {

            errorLabel.setText("Los campos no pueden estar vacios.");
            return;
        }
        String id = idTextField.getText().trim();
        if(Paciente.pacienteHash.containsKey(id)) {
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
        String telefono = telefonoTextField.getText().trim();
        String nombreEmergencia = nombreEmergenciaTextField.getText().trim();
        String telefonoEmergencia = telefonoEmergenciaTextField.getText().trim();
        String fechaNacimiento = fechaNacimientoTextField.getText().trim();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaDateTime;
        try{
            fechaDateTime = LocalDate.parse(fechaNacimiento,formateador);
            LocalDate dt1 = LocalDate.parse("01/01/1970", formateador);
            LocalDate dt2 = LocalDate.parse("31/12/2002",formateador);
            if(fechaDateTime.isBefore(dt1) || fechaDateTime.isAfter(dt2)){
                errorLabel.setText("La fecha de nacimiento de un paciente debe estar entre los 18 y 50 años");
                return;
            }
        }catch (DateTimeParseException e){
            System.out.println(e);
            errorLabel.setText("Formato de fecha inválido");
            return;
        }
        int edad;
        try{
            edad = Integer.parseInt(edadTextField.getText().trim());
            if(edad < 18 || edad > 50){
                errorLabel.setText("El psiquiatra debe tener entre 18 y 50 años de edad");
                return;
            }
        }catch (Exception e){
            errorLabel.setText("La edad tiene que ser un numero");
            return;
        }

        Paciente nuevoPaciente = new Paciente(id, nombres, apellidos, email, direccion, edad, fechaNacimiento,telefono, nombreEmergencia, telefonoEmergencia);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creacion satisfactoria");
        alert.setHeaderText("Creacion satisfactoria");
        alert.setContentText("Se ha ingresado el paciente satisfactoriamente:\n" + nuevoPaciente.toString());
        alert.showAndWait();
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarPaciente");
    }

}
