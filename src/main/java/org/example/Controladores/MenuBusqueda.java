package org.example.Controladores;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.Clinica;
import org.example.Paciente;
import org.example.Psiquiatra;
import org.example.SistemaDeGestionClinica;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuBusqueda implements Initializable {
    @FXML
    //Se debe especificar el tipo de dato que serán las opciones para que no se pueda agregar cualquier cosa.
    public ComboBox<String> entidad;
    public ComboBox<String> atributo;
    public TextField valor;
    public TextArea resultados;
    public Label novedad;
    String selecEntidad;
    String valorBusq = "";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entidad.setItems(FXCollections.observableArrayList ("Clinica","Paciente","Psiquiatra"));
        //Entidad por defecto
        //entidad.setValue("Clinica");
    }

    public void Escoger(ActionEvent event){
        selecEntidad = String.valueOf(entidad.getValue());
        switch (selecEntidad) {
            case "Clinica":
                atributo.setItems(FXCollections.observableArrayList("Nit", "Nombre", "Teléfono"));
                break;
            case "Paciente":
            case "Psiquiatra":
                atributo.setItems(FXCollections.observableArrayList("Cédula", "Apellido", "Edad"));
                break;
        }
    }

    public void buscar(ActionEvent event) {
        resultados.setEditable(false);

        if (entidad.getValue() == null || atributo.getValue() == null || valor.getText().equals("")){
            novedad.setText("Campos vacíos, por favor diligencie la información.");
            return;
        }

        switch (selecEntidad) {
            case "Clinica":
                buscarClinica();
                break;
            case "Paciente":
                buscarPaciente();
                break;
            case "Psiquiatra":
               buscarPsiquitra();
                break;
        }

        /*if (valorBusq.equals("")) {
            novedad.setText("No se encuentra coincidencias con el valor de búsqueda.");
        }*/

    }

    public void buscarClinica(){
        switch (atributo.getValue()) {
            case "Nit":
                try {
                    resultados.setText(Clinica.ClinicaHash.get(Integer.parseInt(valor.getText().trim())).toString());
                    valorBusq = valor.getText();
                } catch (Exception excep) {
                    novedad.setText("El NIT es un número, por favor verifique el valor ingresado.");
                }
                break;
            case "Nombre":
                for (String clave : Clinica.clinicaNom.keySet()) {
                    if (clave.contains(valor.getText().trim().toLowerCase())) {
                        valorBusq = clave;
                        resultados.appendText(Clinica.clinicaNom.get(valorBusq).toString() + "\n");
                    }
                }
                break;
            case "Teléfono":
                try {
                    Integer.parseInt(valor.getText());
                    for (Integer clave : Clinica.clinicaTel.keySet()) {
                        if (String.valueOf(clave).contains(valor.getText().trim())) {
                            valorBusq = String.valueOf(clave);
                            resultados.appendText(Clinica.clinicaTel.get(Integer.parseInt(valorBusq)).toString() + "\n");
                        }
                    }
                } catch (Exception excep) {
                    novedad.setText("Número telefónico inválido, por favor verifique el valor ingresado.");
                }
                break;
        }
    }

    public void buscarPsiquitra(){
        switch (atributo.getValue()) {
            case "Cédula":
                try {
                    Integer.parseInt(valor.getText().trim());
                    resultados.setText(Psiquiatra.psiquiatraHash.get(valor.getText().trim()).toString());
                    valorBusq = valor.getText();
                } catch (Exception excep) {
                    novedad.setText("La cédula es un número, por favor verifique el valor ingresado.");
                }
                break;
            case "Apellido":
                for (String clave : Psiquiatra.psiApell.keySet()) {
                    if (clave.contains(valor.getText().trim().toLowerCase())) {
                        valorBusq = clave;
                        resultados.appendText(Psiquiatra.psiApell.get(valorBusq).toString() + "\n");
                    }
                }
                break;
            case "Edad":
                try {
                    Integer.parseInt(valor.getText());
                    for (Integer clave : Psiquiatra.psiEdad.keySet()) {
                        if (String.valueOf(clave).contains(valor.getText().trim())) {
                            valorBusq = String.valueOf(clave);
                            resultados.appendText(Psiquiatra.psiEdad.get(Integer.parseInt(valorBusq)).toString() + "\n");
                        }
                    }
                } catch (Exception excep) {
                    novedad.setText("Edad inválida, por favor verifique el valor ingresado.");
                }
                break;
        }
    }

    public void buscarPaciente(){
        switch (atributo.getValue()) {
            case "Cédula":
                try {
                    Integer.parseInt(valor.getText().trim());
                    resultados.setText(Paciente.pacienteHash.get(valor.getText().trim()).toString());
                    valorBusq = valor.getText();
                } catch (Exception excep) {
                    novedad.setText("La cédula es un número, por favor verifique el valor ingresado.");
                }
                break;
            case "Apellido":
                for (String clave : Paciente.pacienteApel.keySet()) {
                    if (clave.contains(valor.getText().trim().toLowerCase())) {
                        valorBusq = clave;
                        resultados.appendText(Paciente.pacienteApel.get(valorBusq).toString() + "\n");
                    }
                }
                break;
            case "Edad":
                try {
                    Integer.parseInt(valor.getText());
                    for (Integer clave : Paciente.pacienteEdad.keySet()) {
                        if (String.valueOf(clave).contains(valor.getText().trim())) {
                            valorBusq = String.valueOf(clave);
                            resultados.appendText(Paciente.pacienteEdad.get(Integer.parseInt(valorBusq)).toString() + "\n");
                        }
                    }
                } catch (Exception excep) {
                    novedad.setText("Edad inválida, por favor verifique el valor ingresado.");
                }
                break;
        }
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("MenuCoordinador");
    }


}
