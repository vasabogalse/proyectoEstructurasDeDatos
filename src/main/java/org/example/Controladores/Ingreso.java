package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.SistemaDeGestionClinica;

import java.io.IOException;

public class Ingreso {
    @FXML
    public  TextField identificacion;
    public  PasswordField contrasena;
    public  Label novedad;
    public Button cerrar;

    public void Ingresar(ActionEvent event) throws IOException {
        //VALIDAR QUE EL TEXTO INGRESADO TENGA @

        //Limpiar los mensajes de error para mostrar unos nuevos.
        novedad.setText("");

        int cedulaVa;

        if (identificacion.getText().trim().equals("") || contrasena.getText().trim().equals("")){
            novedad.setText("Campos vacios, por favor complete el formulario.");
            return;
        }

        try {
            cedulaVa = Integer.parseInt(identificacion.getText().trim());
            if (cedulaVa <0 ){
                novedad.setText("Cédula inválida.");
                return;
            }
        } catch (Exception e){
            novedad.setText("Por favor digite el número de su cédula.");
            return;
        }

        if (((identificacion.getText().equals("12345678") || identificacion.getText().toLowerCase().equals("coordinador@gmail.com"))) && contrasena.getText().equals("coordinador")) {
            SistemaDeGestionClinica.setRoot("MenuCoordinador");
            return;
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Ingreso al sistema.");
            alerta.setHeaderText("Error al ingresar.");
            alerta.setContentText("La información ingresada no está registrada en el sistema. Por favor, verifique los datos.");
            alerta.showAndWait();
        }

        //Limpiar campos para que no queden los datos si hubo un error
        identificacion.setText("");
        contrasena.setText("");
    }


    public void Salir(ActionEvent event){
        //Stage: Contenedor de la escena; ventana,barra de titulo, botones de max-min-cerrar
        Stage stage = (Stage) cerrar.getScene().getWindow();
        stage.close();
    }

 }