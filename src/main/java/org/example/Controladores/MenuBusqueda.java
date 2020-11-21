package org.example.Controladores;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.example.SistemaDeGestionClinica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuBusqueda implements Initializable {
    @FXML
    //Se debe especificar el tipo de dato que serán las opciones para que no se pueda agregar cualquier cosa.
    public ChoiceBox<String> entidad;
    public ChoiceBox<String> atributo;
    public TextField valor;
    public ListView<Object> resultados;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entidad.setItems(FXCollections.observableArrayList ("Clinica","Paciente","Psiquiatra"));
        //Entidad por defecto
        entidad.setValue("Clinica");

        String selecEntidad = "";
        selecEntidad = String.valueOf(entidad.getValue());
        if (selecEntidad.equals("Clinica")){
            atributo.setItems(FXCollections.observableArrayList("Nit","Nombre","Teléfono"));
        }else if (selecEntidad.equals("Paciente")){
            atributo.setItems(FXCollections.observableArrayList("Cédula","Apellido","Edad"));
        }else if (selecEntidad.equals("Psiquiatra")){
            atributo.setItems(FXCollections.observableArrayList("Cédula","Apellido","Edad"));
        }


    }


    public void buscar(ActionEvent event){

    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("MenuCoordinador");
    }


}
