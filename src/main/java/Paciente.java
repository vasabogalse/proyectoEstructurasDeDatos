import java.util.ArrayList;

public class Paciente implements handleJSON {

    public String idPaciente;
    public String nombres;
    public String apellidos;
    public String email;
    public String contrasena;
    public String direccion;
    public int edad;
    public String fechaNacimiento;
    public String telefono;
    public String nombreContactoEmergencia;
    public String telefonoContactoEmergencia;
    public int numLlamadas;
    public Psiquiatra psiquiatra;
    public ArrayList<Integer> estados;
    public ArrayList<Cita> listaCitas;
    public HistorialClinico historialClinico;

    // Recibe estados
    public Paciente(String idPaciente, String nombres, String apellidos, String email, String contrasena, String direccion, int edad, String fechaNacimiento, String telefono, String nombreContactoEmergencia, String telefonoContactoEmergencia) {
        this.idPaciente = idPaciente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.nombreContactoEmergencia = nombreContactoEmergencia;
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
        this.numLlamadas = 0;
        this.estados = null;
       /* this.listaCitas = null;
        this.historialClinico = null;*/
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                "Cédula=" + idPaciente + "," + "\n" +
                "nombres=" + nombres + "," + "\n" +
                "apellidos=" + apellidos + "," + "\n" +
                "email=" + email + "," + "\n" +
                "contrasena=" + contrasena + "," + "\n" +
                "direccion=" + direccion + "," + "\n" +
                "edad=" + edad + "," + "\n" +
                "fechaNacimiento=" + fechaNacimiento + "," + "\n" +
                "telefono=" + telefono + "," + "\n" +
                "nombreContactoEmergencia=" + nombreContactoEmergencia + "," + "\n" +
                "telefonoContactoEmergencia=" + telefonoContactoEmergencia + "," + "\n" +
                "numLlamadas=" + numLlamadas + "," + "\n" +
                "estados=" + estados + "," + "\n" +
                "Psiquiatra=" + psiquiatra + "\n" +
                '}'+ "\n";
    }

    Paciente(){
        idPaciente = null;
        nombres = null;
        apellidos= null ;
        email= null ;
        contrasena= null ;
        direccion= null ;
        edad= 0;
        fechaNacimiento= null;
        telefono = null;
        nombreContactoEmergencia = null;
        telefonoContactoEmergencia = null;

    }

    public void setPsiquiatra(Psiquiatra psiquiatra) {
        this.psiquiatra = psiquiatra;
    }

    public static void registrarPaciente(){
        ArrayList<Paciente> ListaPacientes;
        ListaPacientes = SistemaDeGestionClinica.pacientes;

        SistemaDeGestionClinica.input.nextLine();
        System.out.println("Bienvenido al sistema, por favor registre la siguiente información: ");
        System.out.println("Cédula: ");
        String idPaciente = SistemaDeGestionClinica.input.nextLine();

        System.out.println("Nombres: ");
        String nombres = SistemaDeGestionClinica.input.nextLine();

        System.out.println("Apellidos: ");
        String apellidos = SistemaDeGestionClinica.input.nextLine();

        System.out.println("Edad: ");
        int edad = SistemaDeGestionClinica.input.nextInt();

        SistemaDeGestionClinica.input.nextLine();

        System.out.println("fechaNacimiento: ");
        String fecha = SistemaDeGestionClinica.input.nextLine();

        System.out.println("Teléfono: ");
        String teléfono = SistemaDeGestionClinica.input.nextLine();

        System.out.println("Dirección: ");
        String direccion = SistemaDeGestionClinica.input.nextLine();

        System.out.println("Correo electrónico: ");
        String correo = SistemaDeGestionClinica.input.nextLine();

        System.out.println("Nombre del contacto de emergencia: ");
        String nombreContacto = SistemaDeGestionClinica.input.nextLine();

        System.out.println("Teléfono del contacto de emergencia: ");
        String TelContacto = SistemaDeGestionClinica.input.nextLine();

        System.out.println("Contraseña para el ingreso al sistema: ");
        String contrasena = SistemaDeGestionClinica.input.nextLine();

        Paciente nuevoPaciente = new Paciente(idPaciente,nombres,apellidos,correo,contrasena,direccion,edad,fecha,teléfono,nombreContacto,TelContacto);
        Psiquiatra.asignarPsiquiatra(nuevoPaciente);
        ListaPacientes.add(nuevoPaciente);

        Paciente paciGuar = new Paciente();
        paciGuar.writeJSON(ListaPacientes, "pacientes");

        ListaPacientes = paciGuar.readJSON(Paciente.class, "pacientes");

        SistemaDeGestionClinica.pacientes = ListaPacientes;
        System.out.println(SistemaDeGestionClinica.pacientes.toString());
    }

    public static void ingresarPaciente(){}

    public static void editarPaciente(){
        System.out.println("Ingrese su cédula para validar la acción");
        String cedula = SistemaDeGestionClinica.input.nextLine();

        for (Paciente paciente : SistemaDeGestionClinica.pacientes){
            if ((!cedula.equals(paciente.idPaciente))){
                System.out.println("Cédula no registrada en el sistema");
                return;
            }
        }

        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("Escoja la información que desea editar:");
            System.out.println("1. Nombres.");
            System.out.println("2. Apellidos.");
            System.out.println("3. Fecha de nacimiento.");
            System.out.println("4. Teléfono.");
            System.out.println("5. Dirección.");
            System.out.println("6. Correo electrónico.");
            System.out.println("7. Nombre del contacto de emergencia.");
            System.out.println("8. Teléfono del contacto de emergencia.");
            System.out.println("9. Contraseña para el ingreso al sistema.");
            option = SistemaDeGestionClinica.input.next();
            switch (option) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                case "5":

                case "6":

                case "7":

                case "8":

                    break;
                case "9":

                    break;
                case "0":
                    break label;
            }
        }

    }


    public static void eliminarPaciente(){
        System.out.println("Ingrese su cédula para validar la acción");
        String cedula = SistemaDeGestionClinica.input.nextLine();

        for (Paciente paciente : SistemaDeGestionClinica.pacientes){
            if ((!cedula.equals(paciente.idPaciente))){
                System.out.println("Cédula no registrada en el sistema");
                return;
            }
        }

        //SistemaDeGestionClinica.pacientes.removeElement();
    }

    public static void verPaciente(){
        System.out.println("Ingrese su cédula para validar la acción");
        String cedula = SistemaDeGestionClinica.input.nextLine();

        for (Paciente paciente : SistemaDeGestionClinica.pacientes){
            if ((!cedula.equals(paciente.idPaciente))){
                System.out.println("Cédula no registrada en el sistema");
                return;
            }
        }
        // Llamar al paciente para mostrar información.
        System.out.println();
    }


    public static void cambiarPsiquiatra(){}

    public static void registrarEmociones(){
        System.out.println("Ingrese su cédula para validar la acción");
        String cedula = SistemaDeGestionClinica.input.nextLine();

        for (Paciente paciente : SistemaDeGestionClinica.pacientes){
            if ((!cedula.equals(paciente.idPaciente))){
                System.out.println("Cédula no registrada en el sistema");
                return;
            }
        }
    }

    public static void asignarPsiquiatraDefecto(){}

    public static void programarCita(){}



}