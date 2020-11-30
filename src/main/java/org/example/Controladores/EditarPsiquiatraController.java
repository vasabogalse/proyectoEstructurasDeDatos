package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.Clinica;
import org.example.Paciente;
import org.example.Psiquiatra;
import org.example.SistemaDeGestionClinica;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditarPsiquiatraController<Psquiatra> implements Initializable {
    @FXML public TextField idEditarTextField;
    @FXML public TextField nombresEditarTextField;
    @FXML public TextField apellidosEditarTextField;
    @FXML public TextField edadEditarTextField;
    @FXML public TextField direccionEditarTextField;
    @FXML public TextField emailEditarTextField;
    @FXML public TextField telefonoEditarTextField;
    @FXML public TextField fechaEditarTextField;
    @FXML public Label errorLabel;
    @FXML public ComboBox<String> seleccionClinicaComboBox;
    public ArrayList<Clinica> clinicasComboBox = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    public void buscarPsiquiatra(ActionEvent event) throws IOException {
        String idEditar = idEditarTextField.getText().trim();
        if(idEditar.equals("")){
            errorLabel.setText("El campo de ID no debe estar vacío");
            return;
        }else if(Psiquiatra.psiquiatraHash.containsKey(idEditar)){
            Psiquiatra psiquiatraEditar = Psiquiatra.psiquiatraHash.get(idEditar);
            System.out.println(psiquiatraEditar.fechaNacimiento);
            nombresEditarTextField.setText(psiquiatraEditar.nombres);
            apellidosEditarTextField.setText(psiquiatraEditar.apellidos);
            edadEditarTextField.setText(String.valueOf(psiquiatraEditar.edad));
            direccionEditarTextField.setText(psiquiatraEditar.direccion);
            emailEditarTextField.setText(psiquiatraEditar.emailPsiquiatra);
            telefonoEditarTextField.setText(String.valueOf(psiquiatraEditar.tel));
            fechaEditarTextField.setText(psiquiatraEditar.fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            int c = 0;
            for (Clinica clinica : Clinica.ClinicaHash.values()) {
                seleccionClinicaComboBox.getItems().add(clinica.nombreClinica);
                clinicasComboBox.add(clinica);
                if (SistemaDeGestionClinica.BD.containsEdge(clinica, psiquiatraEditar)) {
                    seleccionClinicaComboBox.getSelectionModel().select(c);
                }
                c++;
            }
        }
    }

    public void editarPsiquiatra(ActionEvent event) throws IOException {
        if (idEditarTextField.getText().trim().equals("") || nombresEditarTextField.getText().trim().equals("") ||
                apellidosEditarTextField.getText().trim().equals("") || direccionEditarTextField.getText().trim().equals("") ||
                emailEditarTextField.getText().trim().equals("") || telefonoEditarTextField.getText().trim().equals("") ||
                edadEditarTextField.getText().trim().equals("") || fechaEditarTextField.getText().trim().equals("") ) {

            errorLabel.setText("Los campos no pueden estar vacios.");
            return;
        }
        String idEditar = idEditarTextField.getText().trim();
        Psiquiatra psiquiatraEditar = Psiquiatra.psiquiatraHash.get(idEditar);
        String nombres = nombresEditarTextField.getText().trim();
        String apellidos = apellidosEditarTextField.getText().trim();
        String direccion = direccionEditarTextField.getText().trim();
        String email = emailEditarTextField.getText().trim();
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(!email.matches(regex)){
            errorLabel.setText("E-mail inválido");
            return;
        }
        String fechaNacimiento = fechaEditarTextField.getText();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaDateTime;
        try{
            fechaDateTime = LocalDate.parse(fechaNacimiento,formateador);
            LocalDate dt1 = LocalDate.parse("01/01/1970", formateador);
            LocalDate dt2 = LocalDate.parse("31/12/2002",formateador);
            if(fechaDateTime.isBefore(dt1) || fechaDateTime.isAfter(dt2)){
                errorLabel.setText("La fecha de nacimiento debe coindicir con un psiquiatra entre los 18 y 50 años");
                return;
            }
        }catch (DateTimeParseException e){
            System.out.println(e);
            errorLabel.setText("Formato de fecha inválido");
            return;
        }
        int edadPsiquiatra;
        try{
            edadPsiquiatra = Integer.parseInt(edadEditarTextField.getText().trim());
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
            telefono = Integer.parseInt(telefonoEditarTextField.getText().trim());
            if(telefono < 0){
                errorLabel.setText("El número de teléfono debe ser mayor que cero");
                return;
            }
        }catch (Exception e){
            errorLabel.setText("El teléfono tiene que ser un número");
            return;
        }

        //Guardar pacientes con los que tenía relación antes de borrar el vertice psiquiatra a relacionar los pacientes:
        ArrayList<Paciente> pacientesRelacion = new ArrayList<>();
        for (Paciente paciente : Paciente.pacienteHash.values()) {
            if (SistemaDeGestionClinica.BD.containsEdge(paciente, Psiquiatra.psiquiatraHash.get(idEditar))) {
                pacientesRelacion.add(paciente);
            }
        }

        int indexClinica = seleccionClinicaComboBox.getSelectionModel().getSelectedIndex();
        Clinica clinicaRelacion = clinicasComboBox.get(indexClinica);

        Psiquiatra.eliminarPsquiatra(idEditar);
        Psiquiatra nuevoPsiquiatra = new Psiquiatra(idEditar, nombres, apellidos, email, "M", direccion, edadPsiquiatra, fechaNacimiento, telefono);
        SistemaDeGestionClinica.BD.addEdge(nuevoPsiquiatra, clinicaRelacion);

        //Hacer aristas paciente-psiquiatra de nuevo
        for (Paciente paciente : pacientesRelacion) {
            SistemaDeGestionClinica.BD.addEdge(nuevoPsiquiatra, paciente);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Edición satisfactoria");
        alert.setHeaderText("Edición satisfactoria");
        alert.setContentText("Se ha editado el psiquiatra satisfactoriamente:\n" + nuevoPsiquiatra.toString());
        alert.showAndWait();

        ArrayList<Object> verticesPsiquiatra = new ArrayList<>(SistemaDeGestionClinica.BD.vertexSet());
        for(Object obj : verticesPsiquiatra){
            if(SistemaDeGestionClinica.identificador(obj, "psiquiatra")){
                Psiquiatra psiquiatra = (Psiquiatra) obj;
                if(psiquiatra.idPsiquiatra.equals(idEditar)){
                    psiquiatra.nombres = nombres;
                    psiquiatra.apellidos = apellidos;
                    psiquiatra.direccion = direccion;
                    psiquiatra.emailPsiquiatra = email;
                    psiquiatra.edad = edadPsiquiatra;
                    psiquiatra.fechaNacimiento = fechaDateTime;
                    psiquiatra.tel = telefono;
                }
            }
        }

        for(Object obj : verticesPsiquiatra){
            System.out.println(obj);
        }

        limpiarCampos();
    }
    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarPsiquiatra");
    }

    public void limpiarCampos(){
        idEditarTextField.clear();
        nombresEditarTextField.clear();
        apellidosEditarTextField.clear();
        direccionEditarTextField.clear();
        emailEditarTextField.clear();
        telefonoEditarTextField.clear();
        edadEditarTextField.clear();
        fechaEditarTextField.clear();
        errorLabel.setText("");
    }
}
