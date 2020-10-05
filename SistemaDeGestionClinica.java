import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeGestionClinica {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Clinica> clinicas = new ArrayList<>();
    public static ArrayList<Psiquiatra> psiquiatras = new ArrayList<>();
    public static ArrayList<String> pacientes = new ArrayList<>();
    public static ArrayList<String> historialesClinicos = new ArrayList<>();
    public static ArrayList<String> formulasMedicas = new ArrayList<>();
    public static ArrayList<String> citas = new ArrayList<>();
    public static ArrayList<String> medicamentos = new ArrayList<>();

    //Menú inicial
    public static void main(String[] args) {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Bienvenido al Sistema de Gestión de la Clinica Psquiatrica");
            System.out.println();
            System.out.println("Recuerde que para acceder a las funciones del sistema es necesario estar logueado con su usuario y contraseña.");
            System.out.println();
            System.out.println("Si usted es un paciente perteneciente a la clinica y no posee un usuario es necesario que haga el proceso de registro.");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Soy un paciente y quiero registrarme en el sistema.");
            System.out.println();
            System.out.println("2. Soy un paciente registrado y quiero ingresar al sistema.");
            System.out.println();
            System.out.println("3. Soy parte del staff de la clinica y quiero ingresar al sistema.");
            System.out.println();
            System.out.println("0. Salir");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            option = input.next();
            switch (option) {
                case "1":
                    registroUsuario(); //Hay que cambiar los nombres de los metodos, esto es de prueba
                    break;
                case "2":
                    ingresoUsuario();
                    break;
                case "3":
                    ingresoUsuario();
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea salir del sistema? Perderá todos lo cambios que no hayan sido guardados Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }

    //Dentro del metodo de registro e ingreso se llama al menú correspondiente al rol del usuario.
    // Es necesario cambiar los metodos del menú segun sea el caso.
    //estos menus (El de Registro e ingreso) No son definitivos, son solo para poder practicar sin problemas
    private static void registroUsuario() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("1. Coordinador");
            System.out.println("2. Pquiatra");
            System.out.println("3. Paciente");
            System.out.println("0. Salir");

            option = input.next();
            switch (option) {
                case "1":
                    menuRolCoordinadorClinica();
                    break;
                case "2":
                    menuRolPquitara();
                    break;
                case "3":
                    menuRolPaciente();
                    break;
                case "0":
                    break label;
            }
        }
    }

    private static void ingresoUsuario() {

        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("1. Coordinador");
            System.out.println("2. Pquiatra");
            System.out.println("3. Paciente");
            System.out.println("0. Salir");

            option = input.next();
            switch (option) {
                case "1":
                    menuRolCoordinadorClinica();
                    break;
                case "2":
                    menuRolPquitara();
                    break;
                case "3":
                    menuRolPaciente();
                    break;
                case "0":
                    break label;
            }
        }
    }

    // Para el coordinador
    private static void menuRolCoordinadorClinica() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Bienvenido <Aqui ponemos el nombre>."); //No olvidemos modificar
            System.out.println();
            System.out.println("Ha ingresado al sistema en el rol de COORDINADOR DE CLINICA.");
            System.out.println();
            System.out.println("Se encuentra en el menú principal. ¿A cuál sub-menú quiere ingresar?");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Clínica.");
            System.out.println();
            System.out.println("2. Psiquiatra.");
            System.out.println();
            System.out.println("3. Medicamentos.");
            System.out.println();
            System.out.println("4. Buscar información en el sistema.");
            System.out.println();
            System.out.println("5. Diagnóstico de incosistencias.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            option = input.next();
            switch (option) {
                case "1":
                    menuClinicaCoordinador();
                    break;
                case "2":
                    menuPsquiatra();
                    break;
                case "3":
                    menuMedicamentos();
                    break;
                case "4":
                    menuBucarCoordinador();
                    break;
                case "5":
                    inconsistenciasCoordinador();
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void menuClinicaCoordinador() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Ha ingresado al menú CLINICA ¿Que desea hacer?.");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Crear una nueva clinica.");
            System.out.println();
            System.out.println("2. Ver información general de alguna clinica.");
            System.out.println();
            System.out.println("3. Actualizar información de alguna clinica.");
            System.out.println();
            System.out.println("4. Dar de baja alguna clinica.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            option = input.next();
            switch (option) {
                case "1":
                    Clinica.NuevaClinica(); // Estaba provando, se que este metodo no se va a usar
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
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void menuPsquiatra() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Ha ingresado al menú PSQUIATRA ¿Que desea hacer?.");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Ingresar un nuevo psiquiatra al sistema.");
            System.out.println();
            System.out.println("2. Eliminar el perfil de algún psiquiatra registrado en el sistema.");
            System.out.println();
            System.out.println("3. Ver un listado con todo el personal médico de mi clinica.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
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
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void menuMedicamentos() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Ha ingresado al menú MEDICAMENTOS ¿Que desea hacer?.");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Ver un listado con los medicamentos disponibles en mi clinica.");
            System.out.println();
            System.out.println("2. Actualizar el inventario de medicamentos disponibles en mi clinica.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            option = input.next();
            switch (option) {
                case "1":
                    break;
                case "2":
                    menuActualizarMedicamentos();
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void menuActualizarMedicamentos() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Para actualizar el inventario de medicamentos elija una opción:");
            System.out.println();
            System.out.println("1. Ingresar un nuevo medicamento al inventario.");
            System.out.println();
            System.out.println("2. Actualizar las unidades disponibles de algún medicamento en el inventario.");
            System.out.println();
            System.out.println("3. Eliminar algún medicamento del inventario.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
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
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void menuBucarCoordinador() {String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Se encuentra en el menú de busqueda. ¿En cuál sub-menú quiere buscar información?");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Clínica.");
            System.out.println();
            System.out.println("2. Psiquiatra.");
            System.out.println();
            System.out.println("3. Medicamentos.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
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
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void inconsistenciasCoordinador(){
        System.out.println("HAY QUE HACER ESTO");
    }

    // Para el psiquitra
    private static void menuRolPquitara() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Bienvenido <Aqui ponemos el nombre>."); //No olvidemos modificar
            System.out.println();
            System.out.println("Ha ingresado al sistema en el rol de PSIQUIATRA.");
            System.out.println();
            System.out.println("Se encuentra en el menú principal. ¿A cuál sub-menú quiere ingresar?");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Perfil.");
            System.out.println();
            System.out.println("2. Citas.");
            System.out.println();
            System.out.println("3. Historial Clínico.");
            System.out.println();
            System.out.println("4. Buscar información en el sistema.");
            System.out.println();
            System.out.println("5. Diagnóstico de incosistencias.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            option = input.next();
            switch (option) {
                case "1":
                    menuPerfilPsiquiatra();
                    break;
                case "2":
                    menuCitaPsiquiatra();
                    break;
                case "3":
                    menuHistorialClinico();
                    break;
                case "4":
                    menuBucarPsiquiatra();
                    break;
                case "5":
                    inconsistenciasPsiquiatra();
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void menuPerfilPsiquiatra() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Ha ingresado al menú de PERFIL ¿Que desea hacer?.");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Modificar mis datos personales.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            option = input.next();
            switch (option) {
                case "1":
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void menuCitaPsiquiatra() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Ha ingresado al menú CITAS ¿Que desea hacer?.");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Ver un listado de las citas agendadas.");
            System.out.println();
            System.out.println("2. Atender o cancelar alguna cita.");
            System.out.println();
            System.out.println("3. Atender o cancelar citas prioritarias");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
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
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void menuHistorialClinico() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Ha ingresado al menú HISTORIAL CLÍNICO ¿Que desea hacer?.");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Crear un nuevo historial clínico a algún paciente.");
            System.out.println();
            System.out.println("2. Ver el historial clínico de algún paciente.");
            System.out.println();
            System.out.println("3. Modificar el historial clínico de algún paciente.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            option = input.next();
            switch (option) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "0":
                    break label;
            }
        }
    }
    private static void menuBucarPsiquiatra(){
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Se encuentra en el menú de busqueda. ¿En cuál sub-menú quiere buscar información?");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println();
            System.out.println("1. Citas.");
            System.out.println();
            System.out.println("2. Historial Clínico.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();

            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
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
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void inconsistenciasPsiquiatra(){
        System.out.println("HAY QUE HACER ESTO");
    }

    // Para el paciente
    private static void menuRolPaciente() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Bienvenido <Aqui ponemos el nombre>."); //No olvidemos modificar
            System.out.println();
            System.out.println("Ha ingresado al sistema en el rol de PACIENTE.");
            System.out.println();
            System.out.println("Se encuentra en el menú principal. ¿A cuál sub-menú quiere ingresar?");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Perfil.");
            System.out.println();
            System.out.println("2. Citas.");
            System.out.println();
            System.out.println("3. Registro diaro de emociones.");
            System.out.println();
            System.out.println("4. Buscar información en el sistema.");
            System.out.println();
            System.out.println("5. Diagnóstico de incosistencias.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            option = input.next();
            switch (option) {
                case "1":
                    menuPerfilPaciente();
                    break;
                case "2":
                    menuCitaPaciente();
                    break;
                case "3":
                    break;
                case "4":
                    menuBucarPaciente();
                    break;
                case "5":
                    inconsistenciasPaciente();
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void menuPerfilPaciente() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Ha ingresado al menú de PERFIL ¿Que desea hacer?.");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Modificar mis datos personales.");
            System.out.println();
            System.out.println("2. Cambiar de especialista.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            option = input.next();
            switch (option) {
                case "1":
                    break;
                case "0":
                    while(true) {
                        System.out.println("¿Está seguro de que desea cancelar está acción?  Y/N");
                        String opccion = input.next();
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void menuCitaPaciente() {
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Ha ingresado al menú CITAS ¿Que desea hacer?.");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Programar una cita.");
            System.out.println();
            System.out.println("2. Ver citas agendadas.");
            System.out.println();
            System.out.println("3. Reagendar alguna cita.");
            System.out.println();
            System.out.println("4. Cancelar alguna cita agendada");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            option = input.next();
            switch (option) {
                case "1":
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
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void menuBucarPaciente(){
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Se encuentra en el menú de busqueda. ¿En cuál sub-menú quiere buscar información?");
            System.out.println();
            System.out.println("Elija una opción:");
            System.out.println();
            System.out.println("1. Citas.");
            System.out.println();
            System.out.println("2. Registro diaro de emociones.");
            System.out.println();
            System.out.println("0. Cancelar");
            System.out.println();

            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
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
                        if (opccion.equals("Y")) {
                            break label;
                        } else if (opccion.equals("N")) {
                            break;
                        }
                    }
            }
        }
    }
    private static void inconsistenciasPaciente(){
        System.out.println("HAY QUE HACER ESTO");
    }


    //Hay que agregar un menú de guardar cada vez que se haga una edición
    private static void guardar() {
        System.out.println("¿Está seguro de que desea guardar estos cambios?  Y/N");
        String opccion = input.next();
        if (opccion.equals("Y")) {
            //HAY QUE ACOMODAR ESTO
        } else if (opccion.equals("N")) {
        }
    }
}


