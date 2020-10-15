import java.util.Scanner;

public class SistemaDeGestionClinica {
    public static Scanner input = new Scanner(System.in);
    public static handleDB db = new handleDB();
    public static Paciente paciente = new Paciente();
    public static Cita cita = new Cita();
    public static Psiquiatra psiquiatra = new Psiquiatra();
    public static HistorialClinico historialClinico = new HistorialClinico();
    public static CoordinadorDeClinica cdr = new CoordinadorDeClinica();

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
        //HistorialClinico.crearHistClinico();
    }

    //La opción de guardar deben estar en los métodos de las clases, que es donde se modifican todos los array
    //Primero deben preguntar si desea guardar los camibios hechos y que si no no se guargan al salir
    // este es como para que me ingresen los datos y mandar los datos a verificar

    public static void menuPrincipal(){
        String opt = "";
        while (true) {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println("                       **Bienvenido al Sistema de Gestión de Clinicas Psquiatricas**");
            System.out.println("Recuerde que para acceder a las funciones del sistema es necesario estar logueado con su usuario y contraseña.");
            System.out.println("Si usted es un paciente perteneciente a la clinica y no posee un usuario es necesario que haga el proceso de registro.");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Soy un paciente y quiero registrarme en el sistema.");
            System.out.println("2. Soy un usuario registrado y quiero ingresar al sistema.");
            System.out.println("0. Salir");
            opt = input.next();
            if(opt.equals("1")){
                paciente.registrarPaciente();
            } else if(opt.equals("2")){
               ingresoUsuario(opt);
            } else if(opt.equals("0")){
                System.out.println("¡Al salir perderás todos tus cambios!");
                System.out.println("Desea guardar los cambios hechos hasta el momento antes de salir: Y/N");
                String guardar = input.next();
                if(guardar.toLowerCase().equals("y")){
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
        String cedula = input.next();
        System.out.println("su cedula es: " + cedula);
        System.out.println("Ingrese su contraseña");
        String clave = input.next();
        System.out.println("su contra es: " + clave);
        System.out.println("La contraseña es :" + clave);
        if(opt.equals("2")){
            gestionarMenus(cedula, clave);
        }
    }

    public static Boolean verificarExistenciaUsuario(String cedula, String clave){
        Boolean usExiste =  false;
        for(CoordinadorDeClinica coordinador : db.getCoordinadores()){
            System.out.println(coordinador.getCedulaCoordinador());
            if(coordinador.getCedulaCoordinador().equals(cedula)){
                usExiste = true;
                break;
            }
        }
        for(Psiquiatra psiquiatra : db.getPsiquiatras()){
            if(psiquiatra.getIdPsiquiatra().equals(cedula)){
                usExiste = true;
                break;
            }
        }
        for(Paciente paciente : db.getPacientes()){
            if(paciente.getIdPaciente().equals(cedula)){
                usExiste = true;
                break;
            }
        }
        return usExiste;
    }

    public static String vertificarUsuarios(String cedula, String clave){
        String usuario = null;
        for(CoordinadorDeClinica coordinador : db.getCoordinadores()){
            if(coordinador.getCedulaCoordinador().equals(cedula) && coordinador.getContrasenaCoordinador().equals(clave)){
                usuario = "coordinador";
                break;
            }
        }
        for(Psiquiatra psiquiatra : db.getPsiquiatras()){
            if(psiquiatra.getIdPsiquiatra().equals(cedula) && psiquiatra.getClavePsiquiatra().equals(clave)){
                usuario = "psiquiatra";
                break;
            }
        }
        for(Paciente paciente : db.getPacientes()){
            if(paciente.getIdPaciente().equals(cedula) && paciente.getContrasena().equals(clave)){
                usuario = "paciente";
                break;
            }
        }
        return usuario;
    }

    public static void gestionarMenus(String cedula, String clave) {
        String usuario = vertificarUsuarios(cedula,clave);
        Boolean usExiste = verificarExistenciaUsuario(cedula, clave);
        System.out.println(usuario);

        if(usExiste){
            if(usuario != null){
                if(usuario.equals("coordinador")){
                    for(CoordinadorDeClinica co : db.getCoordinadores()){
                        if(cedula.equals(co.getCedulaCoordinador())){
                            cdr = co;
                            break;
                        }
                    }
                    menuCoordinador(cdr);
                } else if(usuario.equals("psiquiatra")){
                    for (Psiquiatra ps : db.getPsiquiatras()){
                        if (cedula.equals(ps.getIdPsiquiatra())){
                            psiquiatra = ps;
                        }
                    }
                    menuRolPquiatra(psiquiatra);
                    return;
                } else if (usuario.equals("paciente")){
                    for (Paciente pc : db.getPacientes()){
                        if (cedula.equals(pc.getIdPaciente())){
                            paciente = pc;
                        }
                    }
                    menuRolPaciente(paciente);
                    return;
                }
            } else{
                System.out.println("Cédula o contraseña inválida");
            }
        } else {
            System.out.println("El usuario no esta registrado en el sistema");
            System.out.println("A continuación ingrese sus datos nuevamente");
            ingresoUsuario("2");
        }

    }

    // Para el paciente
   public static void menuRolPaciente(Paciente paciente) {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("    Bienvenido " + paciente.getNombres() + " " + paciente.getApellidos());
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Ha ingresado al sistema en el rol de PACIENTE.");
            System.out.println("Se encuentra en el menú principal. ¿A cuál sub-menú quiere ingresar?");
            System.out.println();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Perfil.");
            System.out.println("2. Citas.");
            System.out.println("3. Registro emociones.");
            System.out.println("4. Buscar información en el sistema.");
            System.out.println("5. Diagnóstico de incosistencias.");
            System.out.println("0. Cancelar");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            option = input.next();
            switch (option) {
                case "1":
                    menuPerfilPaciente(paciente);
                    break;
                case "2":
                    menuCitaPaciente(paciente);
                    break;
                case "3":
                    break;
                case "4":
                    menuBucarPaciente(paciente);
                    break;
                case "5":
                    inconsistenciasPaciente(paciente);
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")||opccion.equals("y")) {
                            break label;
                        } else if (opccion.equals("N")||opccion.equals("n")) {
                            break;
                        }
                    }
            }
        }
    }

        public static void menuPerfilPaciente(Paciente paciente) {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("                             Menú perfil.");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Modificar mis datos personales.");
            System.out.println("2. Ver mis datos personales.");
            System.out.println("3. Cambiar de especialista.");
            System.out.println("4. Eliminar perfil.");
            System.out.println("0. Cancelar");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            option = input.next();
            switch (option) {
                case "1":
                    paciente.editarPaciente(paciente);
                    break;
                case "2":
                    paciente.verPaciente(paciente);
                    break;
                case "3":
                   paciente.cambiarPsiquiatra(paciente);
                    break;
                case "4":
                   paciente.eliminarPaciente(paciente);
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")||opccion.equals("y")) {
                            break label;
                        } else if (opccion.equals("N")||opccion.equals("n")) {
                            break;
                        }
                    }
            }
        }
    }

        public static void menuCitaPaciente(Paciente paciente) {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("                            Menú de citas.");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Programar una cita.");
            System.out.println("2. Ver citas agendadas.");
            System.out.println("3. Reagendar alguna cita.");
            System.out.println("4. Cancelar alguna cita agendada");
            System.out.println("0. Cancelar");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            option = input.next();
            switch (option) {
                case "1":
               //     paciente.programarCita(paciente);
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")||opccion.equals("y")) {
                            break label;
                        } else if (opccion.equals("N")||opccion.equals("n")) {
                            break;
                        }
                    }
            }
        }
    }

        public static void menuBucarPaciente(Paciente paciente){
        String option;
        label:
        while (true) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("                             Menú de búsqueda.");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Citas.");
            System.out.println("2. Registro diaro de emociones.");
            System.out.println("0. Cancelar");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            option = input.next();
            switch (option) {
                case "1":
                    break;
                case "2":
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")||opccion.equals("y")) {
                            break label;
                        } else if (opccion.equals("N")||opccion.equals("n")) {
                            break;
                        }
                    }
            }
        }
    }

    public static void inconsistenciasPaciente(Paciente paciente){
         System.out.println("HAY QUE HACER ESTO");
    }


    //Para psiquiatra
   public static void menuRolPquiatra(Psiquiatra psiquiatra) {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("    Bienvenido " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos());
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Ha ingresado al sistema en el rol de PSIQUIATRA.");
            System.out.println("Se encuentra en el menú principal. ¿A cuál sub-menú quiere ingresar?");
            System.out.println();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Gestión de citas");
            System.out.println("2. Gestión Historial Clínico.");
            System.out.println("3. Diagnóstico de inconsistencias.");
            System.out.println("0. Cancelar");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            option = input.next();
            switch (option) {
                case "1":
                    menuCitaPsiquiatra(psiquiatra);
                    break;
                case "2":
                    menuHistorialClinico(psiquiatra);
                    break;
                case "3":
                   // inconsistenciasPsiquiatra();
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")||opccion.equals("y")) {
                            break label;
                        } else if (opccion.equals("N")||opccion.equals("n")) {
                            break;
                        }
                    }
            }
        }
    }

    public static void menuCitaPsiquiatra(Psiquiatra psiquiatra) {
            String option;
            label:
            while (true) {
                System.out.println();
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("                            Menú de citas.");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Seleccione una opción:");
                System.out.println("1. Ver un listado de las citas agendadas.");
                System.out.println("2. Atender o cancelar alguna cita.");
                System.out.println("3. Atender o cancelar citas prioritarias");
                System.out.println("0. Cancelar");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println();
                option = input.next();
                switch (option) {
                    case "1":
                        break;
                    case "2":
                        cita.atenderCita();
                        break;
                    case "3":
                        break;
                    case "0":
                        while(true) {
                            System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                            String opccion = input.next();
                            if (opccion.equals("Y")||opccion.equals("y")) {
                                break label;
                            } else if (opccion.equals("N")||opccion.equals("n")) {
                                break;
                            }
                        }
                }
            }
        }

        public static void menuHistorialClinico(Psiquiatra psiquiatra) {
                String option;
                label:
                while (true) {
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("                       Menú de historial clinico");
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println();
                    System.out.println("Seleccione una opción:");
                    System.out.println("1. Crear un nuevo historial clínico a algún paciente.");
                    System.out.println("2. Ver el historial clínico de algún paciente.");
                    System.out.println("3. Modificar el historial clínico de algún paciente.");
                    System.out.println("0. Cancelar");
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println();
                    option = input.next();
                    switch (option) {
                        case "1":
                        historialClinico.crearHistClinico(psiquiatra);
                            break;
                        case "2":
                        historialClinico.verHistClinico(psiquiatra);
                            break;
                        case "3":
                        historialClinico.editarHistClinico(psiquiatra);
                            break;
                        case "0":
                            while(true) {
                                System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                                String opccion = input.next();
                                if (opccion.equals("Y")||opccion.equals("y")) {
                                    break label;
                                } else if (opccion.equals("N")||opccion.equals("n")) {
                                    break;
                                }
                            }
                    }
                }
            }

        public static void menuBucarPsiquiatra(Psiquiatra psiquiatra){
            String option;
            label:
            while (true) {
                System.out.println();
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("                             Menú de búsqueda.");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Seleccione una opción:");
                System.out.println("1. Citas.");
                System.out.println("2. Historial Clínico.");
                System.out.println("0. Cancelar");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println();
                option = input.next();
                switch (option) {
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "0":
                        while(true) {
                            System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                            String opccion = input.next();
                            if (opccion.equals("Y")||opccion.equals("y")) {
                                break label;
                            } else if (opccion.equals("N")||opccion.equals("n")) {
                                break;
                            }
                        }
                }
            }
        }

        public static void inconsistenciasPsiquiatra(){
            System.out.println("HAY QUE HACER ESTO");
        }

    //Para el coordinador
   public static void menuCoordinador(CoordinadorDeClinica coordinador) {
        String opcion = "";
        while (true) {
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("    Bienvenido " /* + coordinador.getNombres() + " " + coordinador.getApellidos()*/); //NO SE SI IRÁ NOMBRE
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Ha ingresado al sistema en el rol de COORDINADOR.");
            System.out.println("Se encuentra en el menú principal. ¿A cuál sub-menú quiere ingresar?");
            System.out.println();
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Gestionar clínica");
            System.out.println("2. Gestionar psiquiatras");
            System.out.println("3. Listar clínicas en el sistema");
            System.out.println("4. Regresar al ingreso al sistema");
            System.out.println("0. Cancelar");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            opcion = input.next();
            if (opcion.equals("1")) {
                menuGestionarClinica();
                return;
            } else if (opcion.equals("2")) {
                menuGestionarPsiquiatras(coordinador);
                return;
            } else if (opcion.equals("3")) {
                // cl.listarClinicas();
            } else if(opcion.equals("4")){
                return;
            } else if(opcion.equals("0")){
                while(true) {
                    System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                    String opccion = input.next();
                    if (opccion.equals("Y")||opccion.equals("y")) {
                        break;
                    } else if (opccion.equals("N")||opccion.equals("n")) {

                    }
                }
            } else {
                System.out.println("Opción incorrecta. Intenta seleccionando otra opción");
            }
        }
    }

        public static void menuGestionarClinica(){
            String opClinica = " ";
            while(true){
                System.out.println();
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("                         Menú de gestión de clínica");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Seleccione una opción:");
                System.out.println("1. Editar la clínica que administra");
                System.out.println("2. Borrar la clínica que administra");
                System.out.println("3. Ingresar medicamentos a la clínica");
                System.out.println("4. Borrar un medicamento que usa la clínica");
                System.out.println("0. Regresar al menú de utilidades de coordinador"); //cancelar
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println();
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
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")||opccion.equals("y")) {
                            break;
                        } else if (opccion.equals("N")||opccion.equals("n")) {

                        }
                    }
                } else {
                    System.out.println("Opción incorrecta. Intenta seleccionando otra opción");
                }
            }
    }

    public static void menuGestionarPsiquiatras(CoordinadorDeClinica coordinador){
        String opPsiquiatra = " ";
        while (true) {
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("                          Menú de gestión de psiquiatras");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar un psiquiatra a la clínica");
            System.out.println("2. Editar un psiquiatra de su clínica");
            System.out.println("3. Borrar un psiquiatra de la clínica");
            System.out.println("4. Listar psquiatras de la clínica que administra");
            System.out.println("0. Regresar al menú de utilidades de coordinador ");//cancelar
            System.out.println("-------------------------------------------------------------------------------");

            opPsiquiatra = input.next();
            if (opPsiquiatra.equals("1")) {
                psiquiatra.registrarPsiquiatra(coordinador);
                return;
            } else if (opPsiquiatra.equals("2")) {
                psiquiatra.editarPsiquiatra(coordinador);
                return;
            } else if (opPsiquiatra.equals("3")) {
                psiquiatra.borrarPsiquiatra(coordinador);
                return;
            } else if (opPsiquiatra.equals("4")) {
                psiquiatra.listarPsiquiatrasEnClinica(coordinador);
                return;
            } else if(opPsiquiatra.equals("0")){
                while(true) {
                    System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                    String opccion = input.next();
                    if (opccion.equals("Y")||opccion.equals("y")) {
                        break;
                    } else if (opccion.equals("N")||opccion.equals("n")) {

                    }
                }
            } else {
                System.out.println("Opción incorrecta. Intenta seleccionando otra opción");
            }
        }
    }

    public static void menuMedicamentos() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("                      Menú de control medicamentos.");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ver un listado con los medicamentos disponibles en mi clinica.");
            System.out.println("2. Actualizar el inventario de medicamentos disponibles en mi clinica.");
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            option = input.next();
            switch (option) {
                case "1":
                    break;
                case "2":
                  //  menuActualizarMedicamentos();
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")||opccion.equals("y")) {
                            break label;
                        } else if (opccion.equals("N")||opccion.equals("n")) {
                            break;
                        }
                    }
            }
        }
    }

    public static void menuActualizarMedicamentos() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Para actualizar el inventario de medicamentos elija una opción:");
            System.out.println();
            System.out.println("1. Ingresar un nuevo medicamento al inventario.");
            System.out.println("2. Actualizar las unidades disponibles de algún medicamento en el inventario.");
            System.out.println("3. Eliminar algún medicamento del inventario.");
            System.out.println("0. Cancelar");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            option = input.next();
            switch (option) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")||opccion.equals("y")) {
                            break label;
                        } else if (opccion.equals("N")||opccion.equals("n")) {
                            break;
                        }
                    }
            }
        }
    }

    public static void menuBucarCoordinador() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("                           Menú de búsqueda.");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Clínica.");
            System.out.println("2. Psiquiatra.");
            System.out.println("3. Medicamentos.");
            System.out.println("0. Cancelar");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            option = input.next();
            switch (option) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")||opccion.equals("y")) {
                            break label;
                        } else if (opccion.equals("N")||opccion.equals("n")) {
                            break;
                        }
                    }
            }
        }
    }

    public static void inconsistenciasCoordinador(){
    System.out.println("HAY QUE HACER ESTO");
    }
}
