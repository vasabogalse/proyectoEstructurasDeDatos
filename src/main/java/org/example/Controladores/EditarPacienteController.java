package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.Paciente;
import org.example.Psiquiatra;
import org.example.SistemaDeGestionClinica;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class EditarPacienteController implements Initializable {
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
    @FXML public ComboBox<String> seleccionPsiquiatraComboBox;
    public ArrayList<Psiquiatra> psiquiatrasComboBox = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void buscarPaciente(ActionEvent event) throws IOException {
        String idEditar = idTextField.getText().trim();
        if(idEditar.equals("")){
            errorLabel.setText("El campo de ID no debe estar vacío");
            return;
        }else if(Paciente.pacienteHash.containsKey(idEditar)){
            Paciente pacienteEditar = Paciente.pacienteHash.get(idEditar);
            nombresTextField.setText(pacienteEditar.nombres);
            apellidosTextField.setText(pacienteEditar.apellidos);
            edadTextField.setText(String.valueOf(pacienteEditar.edad));
            direccionTextField.setText(pacienteEditar.direccion);
            emailTextField.setText(pacienteEditar.email);
            telefonoTextField.setText(String.valueOf( pacienteEditar.telefono));
            fechaNacimientoTextField.setText(pacienteEditar.fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            nombreEmergenciaTextField.setText(pacienteEditar.nombreContactoEmergencia);
            telefonoEmergenciaTextField.setText(pacienteEditar.telefonoContactoEmergencia);

            int c = 0;
            for (Psiquiatra psiquiatra : Psiquiatra.psiquiatraHash.values()) {
                seleccionPsiquiatraComboBox.getItems().add(psiquiatra.nombres + " " + psiquiatra.apellidos);
                psiquiatrasComboBox.add(psiquiatra);
                if (SistemaDeGestionClinica.BD.containsEdge(pacienteEditar, psiquiatra)) {
                    seleccionPsiquiatraComboBox.getSelectionModel().select(c);
                }
                c++;
            }
        }
    }

    public void editarPaciente(ActionEvent event) throws IOException {
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
        String nombres = nombresTextField.getText().trim();
        String apellidos = apellidosTextField.getText().trim();
        String direccion = direccionTextField.getText().trim();
        String email = emailTextField.getText().trim();
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

        int indexPsiquiatra = seleccionPsiquiatraComboBox.getSelectionModel().getSelectedIndex();
        Psiquiatra psiquiatraRelacion = psiquiatrasComboBox.get(indexPsiquiatra);

        Paciente.eliminarPaciente(id);
        Paciente nuevoPaciente = new Paciente(id, nombres, apellidos, email, direccion, edad, fechaNacimiento,telefono, nombreEmergencia, telefonoEmergencia);

        ListIterator<Paciente> iteratorApellido = Paciente.pacienteApel.get(nuevoPaciente.apellidos).listIterator();
        while (iteratorApellido.hasNext()) {
            Paciente pApellidoIterator = iteratorApellido.next();
            System.out.println(pApellidoIterator);
            if (pApellidoIterator.idPaciente.equals(nuevoPaciente.idPaciente)) {
                iteratorApellido.set(nuevoPaciente);
                break;
            }
        }
        ListIterator<Paciente> iteratorEdad = Paciente.pacienteEdad.get(nuevoPaciente.edad).listIterator();
        while (iteratorEdad.hasNext()) {
            Paciente pEdadIterator = iteratorEdad.next();
            System.out.println(pEdadIterator);
            if (pEdadIterator.idPaciente.equals(nuevoPaciente.idPaciente)) {
                iteratorApellido.set(nuevoPaciente);
                break;
            }
        }

        SistemaDeGestionClinica.BD.addEdge(nuevoPaciente, psiquiatraRelacion);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Edición satisfactoria");
        alert.setHeaderText("Edición satisfactoria");
        alert.setContentText("Se ha ingresado el paciente satisfactoriamente:\n" + nuevoPaciente.toString());
        alert.showAndWait();

        ArrayList<Object> verticesPaciente = new ArrayList<>(SistemaDeGestionClinica.BD.vertexSet());
        for(Object obj : verticesPaciente){
            if(SistemaDeGestionClinica.identificador(obj, "paciente")){
                Paciente paciente = (Paciente) obj;
                if(paciente.idPaciente.equals(id)){
                    paciente.nombres = nombres;
                    paciente.apellidos = apellidos;
                    paciente.direccion = direccion;
                    paciente.email= email;
                    paciente.edad = edad;
                    paciente.fechaNacimiento = fechaDateTime;
                    paciente.nombreContactoEmergencia = nombreEmergencia;
                    paciente.telefonoContactoEmergencia = telefonoEmergencia;
                }
            }
        }

        for(Object obj : verticesPaciente){
            System.out.println(obj);
        }
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarPaciente");
    }
}
