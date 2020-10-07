import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SistemaDeGestionClinica {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // carga automáticamente el contenido de los JSON
        handleDB db = new handleDB();
        db.readAllJSON();

        // datos de prueba de la clase Clinica
        Clinica clinica2 = new Clinica(5, "eps2", "dir2", 879034);
        Clinica clinica3 = new Clinica(6, "eps2", "dir2", 879034);

        // el método updateJSON agrega el objeto al arreglo y actualiza el JSON
        db.updateJSON(clinica2, "clinicas");
        db.updateJSON(clinica3, "clinicas");
        System.out.println(db.getClinicas());

        // elimina un objeto del array y actualiza el JSON para que no tenga dicho objeto
        db.deleteObjectInArray(2, "clinicas");

        /**------------------------------------------------------------------**/


        /**------------------------------------------------------------------**/

        //cl.listarClinicas();


        //System.out.println(ClinicSort.nitOrder.getClass());

        //Clinica cl = new Clinica(); // create an object from the class require
        //clinicas = cl.readJSON(Clinica.class,"clinicas"); // deserialization of JSON file (read file)

        // create objects
        /*Clinica clinica1 = new Clinica(1, "eps", "dir", 123456);
        Clinica clinica2 = new Clinica(2, "eps2", "dir2", 879034);
        Clinica clinica3 = new Clinica(3, "eps3", "dir3", 1011121);
        Clinica clinica4 = new Clinica(4, "eps4", "dir4", 7865744);

        //Add objects to an array
        clinicas.add(clinica1);
        clinicas.add(clinica2);
        clinicas.add(clinica3);
        clinicas.add(clinica4);*/

        //cl.writeJSON(clinicas, "clinicas"); // serialization of objects
        // single Obj Ex: String obj2 = clinica2.writeJSON(clinica1,"user2");

        /** Ordenamiento según atributos primarios de clase Clínica**/
        //Collections.sort(clinicas, ClinicSort.nitOrder);
        //System.out.println(clinicas);

        //Collections.sort(clinicas, ClinicSort.clinicNameOrder);
        //System.out.println(clinicas);

        //Collections.sort(clinicas, ClinicSort.directionOrder);
        //System.out.println(clinicas);

        //Collections.sort(clinicas, ClinicSort.telOrder);
        //System.out.println(clinicas);
    }

    // este es como para que me ingresen los datos y mandar los datos a verificar
    public static void menuPrincipal(){
        /*while(true){
            // menu registrar paciente
            // mirar menu de Innis
        }*/

        String opt = "";
        while (true) {
            System.out.println("Bienvenido al Sistema de Gestión de Clinicas Psquiatricas");
            System.out.println("Recuerde que para acceder a las funciones del sistema es necesario estar logueado con su usuario y contraseña.");
            System.out.println("Si usted es un paciente perteneciente a la clinica y no posee un usuario es necesario que haga el proceso de registro.");
            System.out.println("Elija una opción:");
            System.out.println("1. Soy un paciente y quiero registrarme en el sistema.");
            System.out.println("2. Soy un paciente registrado y quiero ingresar al sistema.");
            System.out.println("3. Soy parte del personal de la clinica y quiero ingresar al sistema.");
            System.out.println("0. Salir");
            opt = sc.next();
            switch (opt) {
                case "1":
                    //registroUsuario();
                    break;
                case "2":
                    //ingresarPaciente();
                    break;
                case "3":
                    //verificacion();
                    break;
                case "0":
                    break;
                    // este metodo llama a ingreso usuario, ingreso usuario toma datos y los envía a verificacion
                // finalmente verificarUsuario manda a los menus correspondientes
            }
        }
    }

    public void ingresoUsuario(String opt){
        boolean coordinador = false;
        if(opt.equals("2")){
            System.out.println("Ingrese su cédula");
            int cedula = sc.nextInt();
            verificarUsuarios(cedula,"paciente");
        } else if(opt.equals("3")){

        }
    }

    // verificar a que clase de usuario pertenece y mandarle su menu
    public static void verificarUsuarios(int clavePrimaria,String tipoUsuario) {
        // me tienen que enviar la opcion para saber de una vez porque arreglo tirarme
        // y un identificador único para hacer la validacion

        // menuPaciente(cedula)
        // buscarnomre
    }

    public static void menuCoordinador() {
        String opcion = "";
        while (true) {
            System.out.println("Bienvenido Coordinador ?");
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Gestionar clínica");
            System.out.println("2. Gestionar psiquiatras");
            System.out.println("3. Listar clínicas en el sistema");
            opcion = sc.next();
            if (opcion.equals("1")) {
                // menuGestionarClinicia();
            } else if (opcion.equals("2")) {
                // menuGestionarPsiquiatras()
            } else if (opcion.equals("3")) {
                // cl.listarClinicas();
            } else {
                System.out.println("Opción incorrecta. Intenta seleccionando otra opción");
            }
        }
    }

    public static void menuGestionarClinica(){
        String opClinica = " ";
        while(true){
            System.out.println("1. Editar la clínica que administra");
            System.out.println("2. Borrar la clínica que administra");
            System.out.println("3. Ingresar medicamentos a la clínica");
            System.out.println("4. Borrar un medicamento que usa la clínica");
            opClinica = sc.next();
            if(opClinica.equals("1")){
                // cl.editarClinica(param1, param2 ..)
                return;
            } else if(opClinica.equals("2")){
                // cl.borraClinica(params..)
                return;
            } else if(opClinica.equals("3")){
                // cl.ingresarMedicamentos(params)..
                return;
            } else if(opClinica.equals("4")){
                // cl.borrarMedicamento(params ..)
                return;
            } else {
                System.out.println("Opción incorrecta. Intenta seleccionando otra opción");
            }
        }
    }

    public static void menuGestionasPsiquiatras(){
        String opPsiquiatra = " ";
        while (true) {
            System.out.println("1. Registrar un psiquiatra a la clínica");
            System.out.println("2. Borrar un psiquiatra de la clínica");
            System.out.println("3. Listar psquiatras de la clínica que administra");
            opPsiquiatra = sc.next();
            if (opPsiquiatra.equals("1")) {
                // ps.registrarPsiquiatra(params ...)
                return;
            } else if (opPsiquiatra.equals("2")) {
                // ps.borrarPsiquiatra(params ...)
                return;
            } else if (opPsiquiatra.equals("3")) {
                // ps.listarPsiquiatras(params);
                return;
            } else {
                System.out.println("Opción incorrecta. Intenta seleccionando otra opción");
            }
        }
    }
}


