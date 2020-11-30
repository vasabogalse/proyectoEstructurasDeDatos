package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.SistemaDeGestionClinica;

import java.io.IOException;

public class GestionarPsiquiatra {

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
    public void routeIngresarPsiquiatra(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("IngresarPsiquiatra");
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("MenuCoordinador");
    }

    public void routeVerPsiquiatras(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("VerPsiquiatras");
    }

    @FXML
    public void routeEliminarPsiquiatra(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("EliminarPsiquiatra");
    }

    @FXML
    public void routeEditarPsiquiatra(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("EditarPsiquiatra");
    }


}
