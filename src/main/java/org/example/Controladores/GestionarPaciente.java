package org.example.Controladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.Paciente;
import org.example.SistemaDeGestionClinica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GestionarPaciente  {

//    public TableView<Paciente> pacientesTableView;
//    public TableColumn idTableColumn;
//    public TableColumn nombresTableColumn;
//    public TableColumn apellidosTableColumn;
//    public TableColumn edadTableColumn;
//    public TableColumn fechaNacimientoTableColumn;
//    public ObservableList<Paciente> pacientes;


//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        pacientes = FXCollections.observableArrayList();
//
//        //Asocia los atributos de la clase con las columnas
//        this.idTableColumn.setCellValueFactory(new PropertyValueFactory<>("idPaciente"));
//        this.nombresTableColumn.setCellValueFactory(new PropertyValueFactory<>("nombres"));
//        this.apellidosTableColumn.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
//        this.edadTableColumn.setCellValueFactory(new PropertyValueFactory<>("edad"));
//        this.nombresTableColumn.setCellValueFactory(new PropertyValueFactory<>("nombres"));
//
//    }

    @FXML
    public void routeIngresarPaciente(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("IngresarPaciente");
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("MenuCoordinador");
    }

    public void routeVerPacientes(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("VerPacientes");
    }

    @FXML
    public void routeEliminarPaciente(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("EliminarPaciente");
    }

    @FXML
    public void routeEditarPaciente(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("EditarPaciente");
    }

}
