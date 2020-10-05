import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeGestionClinica {
    public static Scanner input = new Scanner(System.in);

    // En esta clase van ocho arraylist uno por cada clase
    public static ArrayList<Clinica> clinicas = new ArrayList<>();
    public static ArrayList<Paciente> pacientes = new ArrayList<>();
    public static ArrayList<HistorialClinico> histClinicos = new ArrayList<>();
    public static ArrayList<Psiquiatra> psiquiatras = new ArrayList<>();



    public static Clinica clGuar = new Clinica(); // create an object from the class require - constructor vacío para guardar
    public static Paciente paGuar = new Paciente();
    public static HistorialClinico histGuar = new HistorialClinico();

    public static ArrayList<Clinica> clinicasJava = null;
    public static ArrayList<Paciente> pacientesJava = null;
    public static ArrayList<HistorialClinico> HistClinicosJava = null;


    public static void main(String[] args) {
        // create objects
        Clinica clinica1 = new Clinica(1, "eps", "dir", 123456);
        Clinica clinica2 = new Clinica(2, "eps2", "dir2", 879034);
        Clinica clinica3 = new Clinica(3, "eps3", "dir3", 1011121);
        Clinica clinica4 = new Clinica(4, "eps4", "dir4", 7865744);

        Paciente paciente1= new Paciente("1","nom1","apell1","email1","123","dir1",14,"28-5-2019","123","cont1","tel1");
        Paciente paciente2= new Paciente("2","nom2","apell2","email2","456","dir2",15,"8-5-2019","123","cont2","tel2");
        Paciente paciente3= new Paciente("3","nom3","apell3","email3","789","dir3",16,"12-5-2019","123","cont3","tel3");

        HistorialClinico historial1 = new HistorialClinico(1,"cancer","quimioterapia","dieta");
        HistorialClinico historial2 = new HistorialClinico(2, "cancer","quimioterapia","dieta");
        HistorialClinico historial3 = new HistorialClinico(3, "cancer","quimioterapia","dieta");

        Psiquiatra psiquiatra1 = new Psiquiatra("1","psi1","osorio");
        Psiquiatra psiquiatra2 = new Psiquiatra("2","psi2","cano");

        //Add objects to an array
        clinicas.add(clinica1);
        clinicas.add(clinica2);
        clinicas.add(clinica3);
        clinicas.add(clinica4);

        pacientes.add(paciente1);
        pacientes.add(paciente2);
        pacientes.add(paciente3);

        histClinicos.add(historial1);
        histClinicos.add(historial2);
        histClinicos.add(historial3);

        psiquiatras.add(psiquiatra1);
        psiquiatras.add(psiquiatra2);

        Psiquiatra.asignarPsiquiatra(paciente1);

        clGuar.writeJSON(clinicas, "clinicas"); // serialization of objects
        // single Obj Ex: String obj2 = clinica2.writeJSON(clinica1,"user2");
        paGuar.writeJSON(pacientes, "pacientes");
        histGuar.writeJSON(histClinicos, "historialesClinicos");


        ArrayList<Clinica> clinicasJava = clGuar.readJSON(Clinica.class,"clinicas"); // deserialization of JSON file (read file)
        ArrayList<Paciente> pacientesJava = paGuar.readJSON(Paciente.class, "pacientes" );
        ArrayList<HistorialClinico> HistClinicosJava = histGuar.readJSON(HistorialClinico.class, "historialesClinicos");


        //MENÚ HISTORIAL CLINICO.
        String option;
        label:
        while(true) {
            System.out.println();
            System.out.println("Menú historial clinico, escoja una opción:");
            System.out.println("1. Crear historial clinico del paciente.");
            System.out.println("2. Editar historial clinico del paciente.");
            System.out.println("3. Borrar historial clinico del paciente.");
            System.out.println("4. Ver historial clinico del paciente.");
            System.out.println("0. Salir.");
            option = input.next();
            switch (option) {
                case "1":
                    HistorialClinico.crearHistClinico();
                    break;
                case "2":
                    HistorialClinico.editarHistClinico();
                    break;
                case "3":
                    HistorialClinico.borrarHistClinico();
                    break;
                case "4":
                    HistorialClinico.verHistClinico();
                    break;
                case "0":
                    break label;
            }
        }

        // MENÚ PACIENTE.
        label:
        while (true) {
            System.out.println();
            System.out.println("Menú paciente, escoja una opción:");
            System.out.println("1. registrar paciente.");
            System.out.println("2. ingresar paciente.");
            System.out.println("3. editar paciente.");
            System.out.println("4. eliminar paciente.");
            System.out.println("5. ver paciente.");
            System.out.println("6. cambiar psiquiatra.");
            System.out.println("7. registrar emociones.");
            System.out.println("8. asignar Psiquiatra Defecto.");
            System.out.println("9. programar Cita.");
            System.out.println("10. asignar psiquiatra.");
            System.out.println("0. Salir.");
            option = input.next();
            switch (option) {
                case "1":
                    Paciente.registrarPaciente();
                    break;
                case "2":
                    Paciente.ingresarPaciente();
                    break;
                case "3":
                    Paciente.editarPaciente();
                    break;
                case "4":
                    Paciente.eliminarPaciente();
                case "5":
                    Paciente.verPaciente();
                case "6":
                    Paciente.cambiarPsiquiatra();
                case "7":
                    Paciente.registrarEmociones();
                case "8":
                    Paciente.asignarPsiquiatraDefecto();
                    break;
                case "9":
                    Paciente.programarCita();
                case "10":
                    //SistemaDeGestionClinica.asignarPsiquiatra();
                    break;
                case "0":
                    break label;
            }
        }









    }
}