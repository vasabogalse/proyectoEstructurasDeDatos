package org.example.Controladores;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import org.example.*;
import org.jgrapht.Graphs;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;


public class MenuBusqueda implements Initializable {
    @FXML
    //Se debe especificar el tipo de dato que serán las opciones para que no se pueda agregar cualquier cosa.
    public ComboBox<String> entidad;
    public ComboBox<String> atributo;
  //public ComboBox<String> relaciones;
    public TextField valor;
    public TextArea resultados;
    public Label novedad;
    public Label EtiquetaValor;
    //public Label EtiqRelaciones;
    String selecEntidad;
    String valorBusq;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entidad.setItems(FXCollections.observableArrayList ("Clinica","Paciente","Psiquiatra"));
        novedad.setText("Por favor tenga en cuenta las tildes y espacios para ingresar el valor de búsqueda.");
    }

    public void itemsAtributo(ActionEvent event){
        selecEntidad = String.valueOf(entidad.getValue());
        switch (selecEntidad) {
            case "Clinica":
                atributo.setItems(FXCollections.observableArrayList("Nit", "Nombre", "Teléfono","Psiquiatra","Paciente"));
                break;
            case "Paciente":
                atributo.setItems(FXCollections.observableArrayList("Cédula", "Apellido", "Edad","Clinica","Psiquiatra"));
                break;
            case "Psiquiatra":
                atributo.setItems(FXCollections.observableArrayList("Cédula", "Apellido", "Edad","Clinica","Paciente"));
                break;
        }
    }

    public void mensajeValor(ActionEvent event){
        switch (String.valueOf(atributo.getValue())) {
            case "Psiquiatra":
                EtiquetaValor.setText("Cédula psiquiatra: ");
                break;
            case "Paciente":
                EtiquetaValor.setText("Cédula paciente: ");
                break;
            case "Clinica":
                EtiquetaValor.setText("Nit clinica: ");
                break;
            default:
                EtiquetaValor.setText("Valor de búsqueda: ");
                break;
        }
    }

    public void buscar(ActionEvent event) {
        resultados.setEditable(false);
        valorBusq = "Dato no encontrado";
        novedad.setText("");
        resultados.clear();

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

        if (valorBusq.equals("Dato no encontrado")) {
            novedad.setText("No se encuentra coincidencias con el valor de búsqueda.");
        }

    }

    public void buscarClinica(){
        switch (atributo.getValue()) {
            case "Nit":
                try {
                    if (Integer.parseInt(valor.getText().trim()) < 0){
                        novedad.setText("El NIT es un número positivo. ");
                        valorBusq = "Dato inválido.";
                        return;
                    }
                } catch (Exception excep) {
                    novedad.setText("Dato inválido,por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido.";
                    return;
                }
                if (Clinica.ClinicaHash.containsKey(Integer.parseInt(valor.getText().trim()))){
                    valorBusq = valor.getText().trim();
                    resultados.setText(Clinica.ClinicaHash.get(Integer.parseInt(valorBusq)).toString());
                }
                break;
            case "Nombre":
                try{
                    Integer.parseInt(valor.getText().trim());
                    novedad.setText("Dato númerico, por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido.";
                    return;
                }catch(Exception ignored){

                }
                for (String clave : Clinica.clinicaNom.keySet()) {
                    if (clave.contains(valor.getText().trim().toLowerCase())) {
                        valorBusq = clave;
                        resultados.appendText(imprimirLista(Clinica.clinicaNom.get(valorBusq).toString()));
                    }
                }
                break;
            case "Teléfono":
                try {
                    if (Integer.parseInt(valor.getText()) < 0){
                        novedad.setText("El número de teléfono no puede ser negativo.");
                        valorBusq = "Dato inválido.";
                        return;
                    }
                } catch (Exception excep) {
                    novedad.setText("Número telefónico inválido, por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido";
                    return;
                }
                for (Integer clave : Clinica.clinicaTel.keySet()) {
                    if (String.valueOf(clave).contains(valor.getText().trim())) {
                        valorBusq = String.valueOf(clave);
                        resultados.appendText(imprimirLista(Clinica.clinicaTel.get(Integer.parseInt(valorBusq)).toString()));
                    }
                }
                break;
            case "Paciente":
            case "Psiquiatra":
                try {
                    if (Integer.parseInt(valor.getText().trim()) < 0){
                        novedad.setText("Cédula inválida.");
                        valorBusq = "Dato inválido";
                        return;
                    }
                } catch (Exception excep) {
                    novedad.setText("Dato inválido, por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido";
                    return;
                }
                Psiquiatra buscado = null;
                if (Psiquiatra.psiquiatraHash.containsKey(valor.getText().trim()) && atributo.getValue().equals("Psiquiatra")){
                    valorBusq = valor.getText().trim();
                    buscado = Psiquiatra.psiquiatraHash.get(valorBusq);
                }else if (Paciente.pacienteHash.containsKey(valor.getText().trim()) && atributo.getValue().equals("Paciente")){
                    valorBusq = valor.getText().trim();
                    for (Object nodo : Graphs.neighborListOf(SistemaDeGestionClinica.BD, Paciente.pacienteHash.get(valorBusq))){
                        if(SistemaDeGestionClinica.identificador(nodo,"psiquiatra")){
                            buscado = (Psiquiatra) nodo;
                        }
                    }
                    if (buscado == null){
                        novedad.setText("El paciente no es atendido por un psiquiatra,por ende, no tiene asociado una clinica.");
                        return;
                    }

                }else{
                    return;
                }
                for (Object nodo : Graphs.neighborListOf(SistemaDeGestionClinica.BD, buscado)){
                    if(SistemaDeGestionClinica.identificador(nodo,"clinica")){
                        Clinica clinica = (Clinica) nodo;
                        resultados.appendText(clinica.toString());
                        return;
                    }
                }
                novedad.setText("No se encuentra registrado en una clinica.");
        }
    }

    public void buscarPsiquitra(){
        switch (atributo.getValue()) {
            case "Cédula":
                try {
                    if (Integer.parseInt(valor.getText().trim()) < 0){
                        novedad.setText("Cédula inválida.");
                        valorBusq = "Dato inválido";
                        return;
                    }
                } catch (Exception excep) {
                    novedad.setText("Dato inválido, por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido";
                    return;
                }
                if (Psiquiatra.psiquiatraHash.containsKey(valor.getText().trim())){
                    valorBusq = valor.getText().trim();
                    resultados.setText(Psiquiatra.psiquiatraHash.get(valorBusq).toString());
                }
                break;
            case "Apellido":
                try{
                    Integer.parseInt(valor.getText().trim());
                    novedad.setText("Dato númerico, por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido.";
                    return;
                }catch(Exception ignored){

                }
                for (String clave : Psiquiatra.psiApell.keySet()) {
                    if (clave.contains(valor.getText().trim().toLowerCase())) {
                        valorBusq = clave;
                        resultados.appendText(imprimirLista(Psiquiatra.psiApell.get(valorBusq).toString()));
                    }
                }
                break;
            case "Edad":
                try {
                    if (Integer.parseInt(valor.getText()) < 0){
                     novedad.setText("La edad no puede ser negativa.");
                     valorBusq = "Dato inválido.";
                     return;
                    }
                } catch (Exception excep) {
                    novedad.setText("Edad inválida,por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido.";
                    return;
                }
                for (Integer clave : Psiquiatra.psiEdad.keySet()) {
                    if (String.valueOf(clave).contains(valor.getText().trim())) {
                        valorBusq = String.valueOf(clave);
                        resultados.appendText(imprimirLista(Psiquiatra.psiEdad.get(Integer.parseInt(valorBusq)).toString()));
                    }
                }
                break;
            case "Clinica":
                try {
                    if (Integer.parseInt(valor.getText().trim()) < 0){
                        novedad.setText("El NIT es un número positivo. ");
                        valorBusq = "Dato inválido.";
                        return;
                    }
                } catch (Exception excep) {
                    novedad.setText("Dato inválido,por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido.";
                    return;
                }
                if (Clinica.ClinicaHash.containsKey(Integer.parseInt(valor.getText()))){
                    valorBusq = valor.getText().trim();
                    for (Object nodo : Graphs.neighborListOf(SistemaDeGestionClinica.BD, Clinica.ClinicaHash.get(Integer.parseInt(valorBusq)))){
                        if(SistemaDeGestionClinica.identificador(nodo,"Psiquiatra")){
                            Psiquiatra psiquiatra = (Psiquiatra) nodo;
                            resultados.appendText(psiquiatra.toString() + "\n");
                        }
                    }
                }
                if (resultados.getText().equals("")){
                    novedad.setText("No hay psiquiatras registrados en esta clinica.");
                }
            case "Paciente":
                try {
                    if (Integer.parseInt(valor.getText().trim()) < 0){
                        novedad.setText("Cédula inválida.");
                        valorBusq = "Dato inválido";
                        return;
                    }
                } catch (Exception excep) {
                    novedad.setText("Dato inválido,por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido";
                    return;
                }
                if (Paciente.pacienteHash.containsKey(valor.getText().trim())){
                    valorBusq = valor.getText().trim();
                    for (Object nodo : Graphs.neighborListOf(SistemaDeGestionClinica.BD, Paciente.pacienteHash.get(valorBusq))){
                        if(SistemaDeGestionClinica.identificador(nodo,"Psiquiatra")){
                            Psiquiatra psiquiatra = (Psiquiatra) nodo;
                            resultados.appendText(psiquiatra.toString());
                            break;
                        }
                    }
                    if (resultados.getText().equals("")){
                        novedad.setText("Este paciente no tiene médico asignado.");
                    }
                }
        }
    }

    public void buscarPaciente(){
        switch (atributo.getValue()) {
            case "Cédula":
                try {
                    if (Integer.parseInt(valor.getText().trim()) < 0){
                        novedad.setText("Cédula inválida.");
                        valorBusq = "Dato inválido";
                        return;
                    }
                } catch (Exception excep) {
                    novedad.setText("Dato inválido, por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido";
                    return;
                }
                if (Paciente.pacienteHash.containsKey(valor.getText().trim())){
                    resultados.setText(Paciente.pacienteHash.get(valor.getText().trim()).toString());
                }
                break;
            case "Apellido":
                try{
                    Integer.parseInt(valor.getText().trim());
                    novedad.setText("Dato númerico, por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido.";
                    return;
                }catch(Exception ignored){

                }
                for (String clave : Paciente.pacienteApel.keySet()) {
                    if (clave.contains(valor.getText().trim().toLowerCase())) {
                        valorBusq = clave;
                        resultados.appendText(imprimirLista(Paciente.pacienteApel.get(valorBusq).toString()));
                    }
                }
                break;
            case "Edad":
                try {
                    if (Integer.parseInt(valor.getText()) < 0){
                        novedad.setText("La edad no puede ser negativa.");
                        valorBusq = "Dato inválido.";
                        return;
                    }
                } catch (Exception excep) {
                    novedad.setText("Edad inválida, por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido.";
                    return;
                }
               for (Integer clave : Paciente.pacienteEdad.keySet()) {
                    if (String.valueOf(clave).contains(valor.getText().trim())) {
                        valorBusq = String.valueOf(clave);
                        resultados.appendText(imprimirLista(Paciente.pacienteEdad.get(Integer.parseInt(valorBusq)).toString()));
                    }
               }
                break;
            case "Clinica":
                try {
                    if (Integer.parseInt(valor.getText().trim()) < 0){
                        novedad.setText("El NIT es un número positivo. ");
                        valorBusq = "Dato inválido.";
                        return;
                    }
                } catch (Exception excep) {
                    novedad.setText("Dato inválido, por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido.";
                    return;
                }
                if (Clinica.ClinicaHash.containsKey(Integer.parseInt(valor.getText()))){
                    valorBusq = valor.getText().trim();
                    for (Object nodo : Graphs.neighborListOf(SistemaDeGestionClinica.BD, Clinica.ClinicaHash.get(Integer.parseInt(valorBusq)))){
                        if(SistemaDeGestionClinica.identificador(nodo,"Psiquiatra")){
                            Psiquiatra psiquiatra = (Psiquiatra) nodo;
                            for (Object nodo2: Graphs.neighborListOf(SistemaDeGestionClinica.BD, psiquiatra)){
                                if (SistemaDeGestionClinica.identificador(nodo2,"Paciente")){
                                    Paciente paciente = (Paciente) nodo2;
                                    resultados.appendText(paciente.toString() + "\n" );
                                }
                            }
                        }
                    }
                }
                if (resultados.getText().equals("")){
                    novedad.setText("No hay pacientes registrados en esta clinica.");
                }
            case "Psiquiatra":
                try {
                    if (Integer.parseInt(valor.getText().trim()) < 0){
                        novedad.setText("Cédula inválida.");
                        valorBusq = "Dato inválido";
                        return;
                    }
                } catch (Exception excep) {
                    novedad.setText("Dato inválido, por favor verifique el valor ingresado.");
                    valorBusq = "Dato inválido";
                    return;
                }
                if (Psiquiatra.psiquiatraHash.containsKey(valor.getText().trim())){
                    valorBusq = valor.getText().trim();
                    for (Object nodo : Graphs.neighborListOf(SistemaDeGestionClinica.BD,Psiquiatra.psiquiatraHash.get(valorBusq))){
                        if (SistemaDeGestionClinica.identificador(nodo,"Paciente")){
                            Paciente paciente = (Paciente) nodo;
                            resultados.appendText(paciente.toString() + "\n" );
                        }
                    }
                }
                if (resultados.getText().equals("")){
                    novedad.setText("El psiquiatra no tiene pacientes asignados.");
                }
        }
    }

    public String imprimirLista(String list){
         return list.replace(",", "\n").replace("[", "").replace("]", "\n");
    }

    public void volver(ActionEvent event) throws IOException {
        SistemaDeGestionClinica.setRoot("MenuCoordinador");
    }


}
