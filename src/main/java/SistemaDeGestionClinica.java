import java.util.Arrays;
import java.util.Scanner;

public class SistemaDeGestionClinica {
    public static Scanner input = new Scanner(System.in);
    public static handleDB db = new handleDB();

    public static void main(String[] args) {
        // carga automáticamente el contenido de los JSON
        db.readAllJSON();
/*
        //datos de prueba de la clase Clinica
        Clinica clinica2 = new Clinica(5, "eps2", "dir2", 879034);
        Clinica clinica3 = new Clinica(6, "eps2", "dir2", 879034);

        // el método updateJSON agrega el objeto al arreglo y actualiza el JSON
        db.updateJSON(clinica2, "clinicas");
        db.updateJSON(clinica3, "clinicas");
        System.out.println(db.getClinicas());

        // elimina un objeto del array y actualiza el JSON para que no tenga dicho objeto
        db.deleteObjectInArray(2, "clinicas");

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

        menuPrincipal();
    }

    //La opción de guardar deben estar en los métodos de las clases, que es donde se modifican todos los array
    //Primero deben preguntar si desea guardar los camibios hechos y que si no no se guargan al salir
    // este es como para que me ingresen los datos y mandar los datos a verificar
    public static void menuPrincipal(){
        String opt = "";
        while (true) {
            System.out.println("__________________________________________________________________________________________________________________________");
            System.out.println("                       **Bienvenido al Sistema de Gestión de Clinicas Psquiatricas**");
            System.out.println("Recuerde que para acceder a las funciones del sistema es necesario estar logueado con su usuario y contraseña.");
            System.out.println("Si usted es un paciente perteneciente a la clinica y no posee un usuario es necesario que haga el proceso de registro.");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Selccione una opción:");
            System.out.println("1. Soy un paciente y quiero registrarme en el sistema.");
            System.out.println("2. Soy un usuario registrado y quiero ingresar al sistema.");
            System.out.println("0. Salir");
            opt = input.next();
            if(opt.equals("1")){
                //registroUsuario();
            } else if(opt.equals("2")){
                ingresoUsuario(opt);
            } else if(opt.equals("0")){
                System.out.println("¡Al salir perderás todos tus cambios!");
                System.out.println("Desea guardar los cambios hechos hasta el momento antes de salir: S/N");
                String guardar = input.next();
                if(guardar.toLowerCase().equals("s")){
                    // guardarTodo()
                    break;
                } else if(guardar.toLowerCase().equals("n")){
                    System.exit(0);
                } else {
                    System.out.println("Respuesta incorrecta. Escribe 'S' si quieres guardar los cambios y 'N' si los quieres descartar");
                }

            }
        }
    }

    public static void ingresoUsuario(String opt){
        System.out.println("Ingrese su cédula:");
        int cedula= input.nextInt();
        System.out.println("Ingrese su contraseña");
        String clave = input.next();
        if(opt.equals("2")){
            gestionarMenus(cedula, clave);
        }
    }

    public static String vertificarUsuarios(int cedula, String clave){
        String usuario = null;
        int indexCoordinador = 0;
        for(CoordinadorDeClinica coordinador : db.getCoordinadores()){
            if(coordinador.getCedulaCoordinador() == cedula && coordinador.getContrasenaCoordinador().equals(clave)){
                usuario = "coordinador";
                break;
            }
        }
        for(Psiquiatra psiquiatra : db.getPsiquiatras()){
            if(psiquiatra.getIdPsiquiatra() == cedula && psiquiatra.getClavePsiquiatra().equals(clave)){
                usuario = "psiquiatra";
                break;
            }
        }
        for(Paciente paciente : db.getPacientes()){
            if(paciente.getIdPaciente() == cedula && paciente.getContrasena().equals(clave)){
                usuario = "paciente";
                break;
            }
        }
        return usuario;
    }

    public static void gestionarMenus(int cedula, String clave) {
        String usuario = vertificarUsuarios(cedula,clave);
        System.out.println(usuario);

        if(usuario != null){
            if(usuario.equals("coordinador")){
                menuCoordinador();
            } else if(usuario.equals("psiquiatra")){
                // menuPsiquiatra(cedula u objecto que buscamos)
                return;
            } else if (usuario.equals("paciente")){
                // menuPaciente(cedula u objeto encontrado)
                return;
            }
        } else{
            System.out.println("Cédula o contraseña inválida");
        }
    }

    public static void menuCoordinador() {
        String opcion = "";
        while (true) {
            System.out.println("__________________________________________");
            System.out.println("    Bienvenido Coordinador ?");
            System.out.println("------------------------------------------");
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Gestionar clínica");
            System.out.println("2. Gestionar psiquiatras");
            System.out.println("3. Listar clínicas en el sistema");
            System.out.println("4. Regresar al ingreso al sistema");
            System.out.println("5. Salir y terminar todo");
            System.out.println("------------------------------------------");
            opcion = input.next();
            if (opcion.equals("1")) {
                menuGestionarClinica();
                return;
            } else if (opcion.equals("2")) {
                menuGestionarPsiquiatras();
                return;
            } else if (opcion.equals("3")) {
                // cl.listarClinicas();
            } else if(opcion.equals("4")){
                return;
            } else if(opcion.equals("5")){
                System.exit(0);
            } else {
                System.out.println("Opción incorrecta. Intenta seleccionando otra opción");
            }
        }
    }

    public static void menuGestionarClinica(){
        String opClinica = " ";
        while(true){
            System.out.println("____________________________________________________");
            System.out.println("            Menú de gestión de clínica");
            System.out.println("----------------------------------------------------");
            System.out.println("Seleccione una opción");
            System.out.println("1. Editar la clínica que administra");
            System.out.println("2. Borrar la clínica que administra");
            System.out.println("3. Ingresar medicamentos a la clínica");
            System.out.println("4. Borrar un medicamento que usa la clínica");
            System.out.println("0. Regresar al menú de utilidades de coordinador");
            System.out.println("----------------------------------------------------");
            opClinica = input.next();
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
            } else if(opClinica.equals("0")){
                menuCoordinador();
            } else {
                System.out.println("Opción incorrecta. Intenta seleccionando otra opción");
            }
        }
    }

    public static void menuGestionarPsiquiatras(){
        String opPsiquiatra = " ";
        while (true) {
            System.out.println("___________________________________________________");
            System.out.println("          Menú de gestión de psiquiatras");
            System.out.println("---------------------------------------------------");
            System.out.println("1. Registrar un psiquiatra a la clínica");
            System.out.println("2. Borrar un psiquiatra de la clínica");
            System.out.println("3. Listar psquiatras de la clínica que administra");
            System.out.println("0. Regresar al menú de utilidades de coordinador ");
            System.out.println("----------------------------------------------------");

            opPsiquiatra = input.next();
            if (opPsiquiatra.equals("1")) {
                // ps.registrarPsiquiatra(params ...)
                return;
            } else if (opPsiquiatra.equals("2")) {
                // ps.borrarPsiquiatra(params ...)
                return;
            } else if (opPsiquiatra.equals("3")) {
                // ps.listarPsiquiatras(params);
                return;
            } else if(opPsiquiatra.equals("0")){
                menuCoordinador();
            } else {
                System.out.println("Opción incorrecta. Intenta seleccionando otra opción");
            }
        }
    }
}


