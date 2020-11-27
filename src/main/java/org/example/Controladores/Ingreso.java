package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.SistemaDeGestionClinica;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ingreso {
    @FXML
    public  TextField identificacion;
    public  PasswordField contrasena;
    public  Label novedad;
    public  Button cerrar;

    public void Ingresar(ActionEvent event) throws IOException {
        //Limpiar los mensajes de error para mostrar unos nuevos.
        novedad.setText("");
        int cedulaVa;

        if (identificacion.getText().trim().equals("") || contrasena.getText().trim().equals("")){
            novedad.setText("Campos vacíos, por favor complete el formulario.");
            return;
        }

        //Esta clase compila la expresión regular (Creación del patrón)
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.([a-zA-Z]{2,4})+$");
        //Objeto que permite hacer operaciones sobre la secuencia de caracteres que queremos validar. Se crea a partir del patrón.
        Matcher mather = pattern.matcher(identificacion.getText());

        try {
            cedulaVa = Integer.parseInt(identificacion.getText());
            if (cedulaVa < 0 || identificacion.getText().length() < 7){
                novedad.setText("Cédula inválida.");
                return;
            }
        } catch (Exception e){
            if (!mather.matches()){
                novedad.setText("Dato inválido,por favor ingrese la información correspondiente.");
                return;
            }
       }

        if (((identificacion.getText().equals("12345678") || identificacion.getText().toLowerCase().equals("coordinador@gmail.com"))) && contrasena.getText().equals("coordinador")) {
            SistemaDeGestionClinica.setRoot("MenuCoordinador");
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