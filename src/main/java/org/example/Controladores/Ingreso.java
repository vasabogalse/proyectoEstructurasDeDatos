package org.example.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.Paciente;
import org.example.Psiquiatra;
import org.example.SistemaDeGestionClinica;

import java.io.IOException;

public class Ingreso {
    @FXML
    public  TextField identificacion;
    public  TextField contrasena;
    public  Label novedad;
    public  Boolean existencia = true;

    public void Ingresar(ActionEvent event) throws IOException {
        //VALIDAR QUE EL TEXTO INGRESADO TENGA @
        int cedulaVa;
        Boolean cedula;

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
            cedula = true;
        } catch (Exception e){
            cedula = false;
        }

        if (((identificacion.getText().equals("12345678") || identificacion.getText().toLowerCase().equals("coordinador@gmail.com"))) && contrasena.getText().equals("coordinador")) {
            SistemaDeGestionClinica.setRoot("MenuCoordinador");
            return;
        }else{
            if (cedula.equals(true)){
                verificarCedula(identificacion.getText(),contrasena.getText());
            }else{
                verificarCorreo(identificacion.getText(),contrasena.getText());
            }
        }

        if (existencia.equals(true)){
            gestionarMenus();
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Ingreso al sistema.");
            alerta.setHeaderText("Error al ingresar.");
            alerta.setContentText("La información ingresada no está registrada en el sistema. Por favor, verifique los datos");
            alerta.showAndWait();
        }


    }

    public  void verificarCedula(String identificacion, String clave) throws IOException {
        if (Psiquiatra.psiquiatraHash.containsKey(identificacion)) {
            if (Psiquiatra.psiquiatraHash.get(identificacion).clavePsiquiatra.equals(clave)){
                SistemaDeGestionClinica.usuario = Psiquiatra.psiquiatraHash.get(identificacion);
            }else{
                novedad.setText("Contraseña incorrecta.");
            }
        } else if (Paciente.pacienteHash.containsKey(identificacion)) {
             if (Paciente.pacienteHash.get(identificacion).contrasena.equals(clave)){
                 SistemaDeGestionClinica.usuario = Paciente.pacienteHash.get(identificacion);
             }else{
                 novedad.setText("Contraseña incorrecta.");
             }
        }else{
            existencia = false;
        }
    }

    public  void verificarCorreo (String identificacion, String clave){

        for(Psiquiatra psiquiatra : Psiquiatra.psiquiatraHash.values()){
            if(psiquiatra.emailPsiquiatra.equals(identificacion)){
                if (psiquiatra.clavePsiquiatra.equals(clave)){
                    SistemaDeGestionClinica.usuario = psiquiatra;
                    break;
                }else{
                    novedad.setText("Contraseña incorrecta.");
                }
            }
        }

        for(Paciente paciente : Paciente.pacienteHash.values()){
            if(paciente.email.equals(identificacion)){
                if (paciente.contrasena.equals(clave)){
                    SistemaDeGestionClinica.usuario = paciente;
                    break;
                }else{
                    novedad.setText("Contraseña incorrecta.");
                }
            }
        }

        existencia = false;
    }

    public  void gestionarMenus() throws IOException {
       if (SistemaDeGestionClinica.identificador(SistemaDeGestionClinica.usuario,"paciente")){
           SistemaDeGestionClinica.setRoot("MenuPaciente");
       }else if (SistemaDeGestionClinica.identificador(SistemaDeGestionClinica.usuario,"psiquiatra")){
           SistemaDeGestionClinica.setRoot("MenuPsiquiatra");
       }

    }

    public void Cancelar(){

    }

 }