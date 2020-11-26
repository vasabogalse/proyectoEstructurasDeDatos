package org.example.Controladores;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.Clinica;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entidad.setItems(FXCollections.observableArrayList ("Clinica","Paciente","Psiquiatra"));
        //Entidad por defecto
        //entidad.setValue("Clinica");
    }

    public void Escoger(ActionEvent event){
        //Aquí deberías coger el item seleccionado.
        selecEntidad = String.valueOf(entidad.getValue());
        if (selecEntidad.equals("Clinica")){
            atributo.setItems(FXCollections.observableArrayList("Nit","Nombre","Teléfono"));
        }else if (selecEntidad.equals("Paciente")){
            atributo.setItems(FXCollections.observableArrayList("Cédula","Apellido","Edad"));
        }else if (selecEntidad.equals("Psiquiatra")){
            atributo.setItems(FXCollections.observableArrayList("Cédula","Apellido","Edad"));
        }
    }

    public void buscar(ActionEvent event) {
        resultados.setEditable(false);
        String valorBusq = "";

        if (entidad.getValue() == null || atributo.getValue() == null || valor.getText().equals("")){
            novedad.setText("Campos vacíos, por favor diligencie la información.");
            return;
        }

        if (selecEntidad.equals("Clinica")) {
            if (atributo.getValue().equals("Nit")) {
                try {
                    resultados.setText(Clinica.ClinicaHash.get(Integer.parseInt(valor.getText().trim())).toString());
                } catch (Exception excep) {
                    novedad.setText("El NIT es un número, por favor verifique el valor ingresado.");
                }
            } else if (atributo.getValue().equals("Nombre")) {
                for (String clave : Clinica.clinicaNom.keySet()) {
                    if (clave.contains(valor.getText().trim().toLowerCase())) {
                        valorBusq = clave;
                        resultados.appendText(Clinica.clinicaNom.get(valorBusq).toString() + "\n");
                    }
                }
            } else if (atributo.getValue().equals("Teléfono")) {
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
            }
        }//else if (selecEntidad.equals("Paciente")){

        //}else if (selecEntidad.equals("Psiquiatra")){

        //}
       if (valorBusq.equals("")) {
            novedad.setText("No se encuentra coincidencias con el valor de búsqueda.");
       }
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("MenuCoordinador");
    }


}
