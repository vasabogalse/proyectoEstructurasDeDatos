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
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        // resultados.clear();

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

        if (valorBusq.equals("")) {
            novedad.setText("No se encuentra coincidencias con el valor de búsqueda.");
        }

    }



    public void buscarClinica(){
        switch (atributo.getValue()) {
            case "Nit":
                try {
                    Integer.parseInt(valor.getText().trim());
                } catch (Exception excep) {
                    novedad.setText("El NIT es un número, por favor verifique el valor ingresado.");
                }
                if (Clinica.ClinicaHash.containsKey(Integer.parseInt(valor.getText().trim()))){
                    resultados.setText(Clinica.ClinicaHash.get(Integer.parseInt(valor.getText().trim())).toString());
                }else{
                    novedad.setText("No se encuentra coincidencias con el valor de búsqueda.");
                }
                break;
            case "Nombre":
                for (String clave : Clinica.clinicaNom.keySet()) {
                    if (clave.contains(valor.getText().trim().toLowerCase())) {
                        valorBusq = clave;
                        resultados.appendText(imprimirList(Clinica.clinicaNom.get(valorBusq).toString()));
                    }
                }
                break;
            case "Teléfono":
                try {
                    Integer.parseInt(valor.getText());
                    for (Integer clave : Clinica.clinicaTel.keySet()) {
                        if (String.valueOf(clave).contains(valor.getText().trim())) {
                            valorBusq = String.valueOf(clave);
                            resultados.appendText(imprimirList(Clinica.clinicaTel.get(Integer.parseInt(valorBusq)).toString()));
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
                } catch (Exception excep) {
                    novedad.setText("La cédula es un número, por favor verifique el valor ingresado.");
                }
                if (Psiquiatra.psiquiatraHash.containsKey(valor.getText().trim())){
                    resultados.setText(Psiquiatra.psiquiatraHash.get(valor.getText().trim()).toString());

                }else{
                    novedad.setText("No se encuentra coincidencias con el valor de búsqueda.");
                }
                break;
            case "Apellido":
                for (String clave : Psiquiatra.psiApell.keySet()) {
                    if (clave.contains(valor.getText().trim().toLowerCase())) {
                        valorBusq = clave;
                        resultados.appendText(imprimirList(Psiquiatra.psiApell.get(valorBusq).toString()));
                    }
                }
                break;
            case "Edad":
                try {
                    Integer.parseInt(valor.getText());
                    for (Integer clave : Psiquiatra.psiEdad.keySet()) {
                        if (String.valueOf(clave).contains(valor.getText().trim())) {
                            valorBusq = String.valueOf(clave);
                            resultados.appendText(imprimirList(Psiquiatra.psiEdad.get(Integer.parseInt(valorBusq)).toString()));
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
                } catch (Exception excep) {
                    novedad.setText("La cédula es un número, por favor verifique el valor ingresado.");
                }
                if (Paciente.pacienteHash.containsKey(valor.getText().trim())){
                    resultados.setText(Paciente.pacienteHash.get(valor.getText().trim()).toString());
                }else{
                    novedad.setText("No se encuentra coincidencias con el valor de búsqueda.");
                }
                break;
            case "Apellido":
                for (String clave : Paciente.pacienteApel.keySet()) {
                    if (clave.contains(valor.getText().trim().toLowerCase())) {
                        valorBusq = clave;
                        resultados.appendText(imprimirList(Paciente.pacienteApel.get(valorBusq).toString()));
                    }
                }
                break;
            case "Edad":
                try {
                    Integer.parseInt(valor.getText());
                    for (Integer clave : Paciente.pacienteEdad.keySet()) {
                        if (String.valueOf(clave).contains(valor.getText().trim())) {
                            valorBusq = String.valueOf(clave);
                            resultados.appendText(imprimirList(Paciente.pacienteEdad.get(Integer.parseInt(valorBusq)).toString()));
                        }
                    }
                } catch (Exception excep) {
                    novedad.setText("Edad inválida, por favor verifique el valor ingresado.");
                }
                break;
        }
    }

    public String imprimirList(String list){
         return list.replace(",", "\n").replace("[", "").replace("]", "\n");
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("MenuCoordinador");
    }


}
