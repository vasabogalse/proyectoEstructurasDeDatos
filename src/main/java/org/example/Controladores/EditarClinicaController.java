package org.example.Controladores;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.Clinica;
import org.example.Psiquiatra;
import org.example.SistemaDeGestionClinica;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class EditarClinicaController implements Initializable {
    @FXML public TextField idEditarTextField;
    @FXML public TextField CambioTextField;
    @FXML public ComboBox atributoEditarComboBox;
    @FXML public Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atributoEditarComboBox.setItems(FXCollections.observableArrayList ("Nombre","Teléfono","Dirección" ));
    }

    public void editarClinica(ActionEvent event) throws IOException {
        errorLabel.setText("");
        if (idEditarTextField.getText().trim().equals("")) {
            errorLabel.setText("Primero debe ingresar un Nit.");
            return;
        }
        if (CambioTextField.getText().trim().equals("")) {
            errorLabel.setText("Primero debe ingresar la información a cambiar.");
            return;
        }
        String id = idEditarTextField.getText().trim();
        if(!Clinica.ClinicaHash.containsKey(Integer.parseInt(id))) {
            errorLabel.setText("No hay una clínica con este nit registrado");
            idEditarTextField.setText("");
            return;
        }

        String select = String.valueOf(atributoEditarComboBox.getValue());
        String Cambio = CambioTextField.getText().trim();
        switch (select) {
            case "Nombre":
                String nombre = CambioTextField.getText().trim();
                String direccion = Clinica.ClinicaHash.get(Integer.parseInt(id)).direccion;
                int telefono = Clinica.ClinicaHash.get(Integer.parseInt(id)).telefono;

                Clinica.eliminarClinica(id);
                Clinica clinica = new Clinica(Integer.parseInt(id), nombre, direccion, telefono);
                editarGrafo(Integer.parseInt(id), nombre, direccion, telefono);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Edición satisfactoria");
                alert.setHeaderText("Edición satisfactoria");
                alert.setContentText("Se ha editado la clínica satisfactoriamente:\n" + clinica.toString());
                alert.showAndWait();
                idEditarTextField.setText("");
                CambioTextField.setText("");
                break;
            case "Teléfono":
                int telefono1;
                try{
                    telefono1 = Integer.parseInt(CambioTextField.getText().trim());
                }catch (Exception e){
                    errorLabel.setText("El teléfono tiene que ser una cadena de numeros");
                    CambioTextField.setText("");
                    return;
                }
                String nombre1 = Clinica.ClinicaHash.get(Integer.parseInt(id)).nombreClinica;
                String direccion1 = Clinica.ClinicaHash.get(Integer.parseInt(id)).direccion;

                Clinica.eliminarClinica(id);
                Clinica clinica1 = new Clinica(Integer.parseInt(id), nombre1, direccion1, telefono1);
                editarGrafo(Integer.parseInt(id), nombre1, direccion1, telefono1);

                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Edición satisfactoria");
                alert1.setHeaderText("Edición satisfactoria");
                alert1.setContentText("Se ha editado la clínica satisfactoriamente:\n" + clinica1.toString());
                alert1.showAndWait();
                idEditarTextField.setText("");
                CambioTextField.setText("");
                break;
            case "Dirección":
                String direccion2 = CambioTextField.getText().trim();
                String nombre2 = Clinica.ClinicaHash.get(Integer.parseInt(id)).nombreClinica;
                int telefono2 = Clinica.ClinicaHash.get(Integer.parseInt(id)).telefono;

                Clinica.eliminarClinica(id);
                Clinica clinica2 = new Clinica(Integer.parseInt(id), nombre2, direccion2, telefono2);
                editarGrafo(Integer.parseInt(id), nombre2, direccion2, telefono2);

                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Edición satisfactoria");
                alert2.setHeaderText("Edición satisfactoria");
                alert2.setContentText("Se ha editado la clínica satisfactoriamente:\n" + clinica2.toString());
                alert2.showAndWait();
                idEditarTextField.setText("");
                CambioTextField.setText("");
                break;
        }
    }
    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("GestionarClinica");
    }

    public void editarGrafo(int nit, String nombreClinica, String direccion, int telefono){
        ArrayList<Object> verticesClinica = new ArrayList<>(SistemaDeGestionClinica.BD.vertexSet());
        for(Object obj : verticesClinica) {
            if (SistemaDeGestionClinica.identificador(obj, "clinica")) {
                Clinica clinica = (Clinica) obj;
                if (clinica.nit == nit) {
                    clinica.nombreClinica = nombreClinica;
                    clinica.direccion = direccion;
                    clinica.telefono = telefono;
                }
            }
        }

        for(Object obj : verticesClinica) {
            System.out.println(obj);
        }
    }
}
