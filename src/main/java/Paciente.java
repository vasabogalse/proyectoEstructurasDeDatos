import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Paciente implements handleJSON {
    public int idPaciente;
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
    public int psiquiatra;
    public ArrayList<Cita> listaCitas = new ArrayList<>();
    public int historialClinico;

    handleDB db = new handleDB();
    Scanner input = new Scanner(System.in);
    public static Paciente paciente = new Paciente();

    public Paciente(){};

    public void setIdPaciente(int idPaciente) { this.idPaciente = idPaciente; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setEmail(String email) { this.email = email; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setNombreContactoEmergencia(String nombreContactoEmergencia) { this.nombreContactoEmergencia = nombreContactoEmergencia; }
    public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) { this.telefonoContactoEmergencia = telefonoContactoEmergencia; }
    public void setPsiquiatra(int psiquiatra) { this.psiquiatra = psiquiatra; }
    public void setHistorialClinico(int historialClinico) { this.historialClinico = historialClinico; }
    public int getIdPaciente() { return idPaciente; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getEmail() { return email; }
    public String getContrasena() { return contrasena; }
    public String getDireccion() { return direccion; }
    public int getEdad() { return edad; }
    public String getFechaNacimiento() { return fechaNacimiento;}
    public String getTelefono() { return telefono; }
    public String getNombreContactoEmergencia() { return nombreContactoEmergencia; }
    public String getTelefonoContactoEmergencia() { return telefonoContactoEmergencia; }
    public int getPsiquiatra() { return psiquiatra; }
    public ArrayList<Cita> getListaCitas() { return listaCitas; }
    public int getHistorialClinico() { return historialClinico; }
    public void setListaCitas(ArrayList<Cita> listaCitas) { this.listaCitas = listaCitas; }

    @Override
    public String toString() {
        return "{" +
                "idPaciente : " + idPaciente +
                ", nombres : " + nombres + '\'' +
                ", apellidos : " + apellidos + '\'' +
                ", email : " + email + '\'' +
                ", contrasena : " + contrasena + '\'' +
                ", direccion : " + direccion + '\'' +
                ", edad : " + edad +
                ", fechaNacimiento : " + fechaNacimiento + '\'' +
                ", telefono : " + telefono + '\'' +
                ", nombreContactoEmergencia : " + nombreContactoEmergencia + '\'' +
                ", telefonoContactoEmergencia : " + telefonoContactoEmergencia + '\'' +
                ", psiquiatra : " + psiquiatra +
                ", listaCitas : " + listaCitas +
                ", historialClinico : " + historialClinico +
                '}';
    }

    public void registrarPaciente() {
        Paciente paciente = new Paciente();

        input.nextLine();
        System.out.println("Bienvenido al sistema, por favor registre la siguiente información: ");
        System.out.println("Cédula:");
        int idPaciente = input.nextInt();
        input.nextLine();

        System.out.println("Nombres: ");
        String nombres = input.nextLine();

        System.out.println("Apellidos: ");
        String apellidos = input.nextLine();

        System.out.println("Edad: ");
        int edad = input.nextInt();

        input.nextLine();

        System.out.println("fecha de nacimiento: ");
        String fecha = input.nextLine();

        System.out.println("Teléfono: ");
        String telefono = input.nextLine();

        System.out.println("Dirección: ");
        String direccion = input.nextLine();

        System.out.println("Correo electrónico: ");
        String correo = input.nextLine();

        System.out.println("Nombre del contacto de emergencia: ");
        String nombreContacto = input.nextLine();

        System.out.println("Teléfono del contacto de emergencia: ");
        String TelContacto = input.nextLine();

        System.out.println("Contraseña para el ingreso al sistema: ");
        String contrasena = input.nextLine();

        System.out.println("Por favor confirme la contraseña");
        String contrasenaConfir = input.nextLine();

        paciente.setIdPaciente(idPaciente);
        paciente.setNombres(nombres);
        paciente.setApellidos(apellidos);
        paciente.setEdad(edad);
        paciente.setFechaNacimiento(fecha);
        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);
        paciente.setEmail(correo);
        paciente.setNombreContactoEmergencia(nombreContacto);
        paciente.setTelefonoContactoEmergencia(TelContacto);

        while(true){
            if (contrasena.equals(contrasenaConfir)){
                paciente.setContrasena(contrasena);
                break;
            }
            System.out.println("La contraseña no coincide, vuelva a ingresar la contraseña que desea.");
            contrasena = SistemaDeGestionClinica.input.nextLine();
            System.out.println("Por favor confirme la contraseña");
            contrasenaConfir = SistemaDeGestionClinica.input.nextLine();
        }

        asignarPsiquiatra(paciente);
        db.appendArrayToJSON("psiquiatras");
        db.updateJSON(paciente,"pacientes");

        System.out.println("Por favor diligencie el registro de emociones para completar la creación del perfil.");
        registrarEmociones(paciente);
        System.out.println("Registro exitoso ¡Bienvenido!");
    }

    public  void editarPaciente(Paciente paciente){
        String option;
        label:
        while (true) {
            System.out.println();
            System.out.println("Escoja la información que desea modificar:");
            System.out.println("1. Nombres.");
            System.out.println("2. Apellidos.");
            System.out.println("3. Fecha de nacimiento.");
            System.out.println("4. Teléfono.");
            System.out.println("5. Dirección.");
            System.out.println("6. Correo electrónico.");
            System.out.println("7. Nombre del contacto de emergencia.");
            System.out.println("8. Teléfono del contacto de emergencia.");
            System.out.println("9. Contraseña para el ingreso al sistema.");
            System.out.println("0. Regresar.");
            option = SistemaDeGestionClinica.input.next();
            switch (option) {
                case "1":
                    System.out.println("Nombre antiguo: " + paciente.getNombres() +". Ingrese la información actualizada:");
                    String nomNuevo = SistemaDeGestionClinica.input.nextLine();
                    paciente.setNombres(nomNuevo);
                    break;
                case "2":
                    System.out.println("Apellido antiguo: " + paciente.getApellidos() + ". Ingrese la información actualizada:");
                    String apeNuevo = SistemaDeGestionClinica.input.nextLine();
                    paciente.setApellidos(apeNuevo);
                    break;
                case "3":
                    System.out.println("Fecha de nacimiento antigua: " + paciente.getFechaNacimiento()+ " .Ingrese la información actualizada:");
                    String fechaNueva = SistemaDeGestionClinica.input.nextLine();
                    paciente.setFechaNacimiento(fechaNueva);
                    break;
                case "4":
                    System.out.println("Teléfono antiguo: " + paciente.getTelefono() +". Ingrese la información actualizada:");
                    String telNuevo = SistemaDeGestionClinica.input.nextLine();
                    paciente.setTelefono(telNuevo);
                    break;
                case "5":
                    System.out.println("Dirección antigua: " + paciente.getDireccion()+". Ingrese la información actualizada:");
                    String dirNueva = SistemaDeGestionClinica.input.nextLine();
                    paciente.setDireccion(dirNueva);
                    break;
                case "6":
                    System.out.println("Correo electrónico antiguo: " + paciente.getEmail()+". Ingrese la información actualizada:");
                    String emailNuevo = SistemaDeGestionClinica.input.nextLine();
                    paciente.setEmail(emailNuevo);
                    break;
                case "7":
                    System.out.println("Nombre de contacto antiguo: " + paciente.getNombreContactoEmergencia()+". Ingrese la información actualizada:");
                    String nomContNuevo = SistemaDeGestionClinica.input.nextLine();
                    paciente.setNombreContactoEmergencia(nomContNuevo);
                    break;
                case "8":
                    System.out.println("Teléfono de contacto antiguo: " + paciente.getTelefonoContactoEmergencia()+". Ingrese la información actualizada:");
                    String telContNuevo = SistemaDeGestionClinica.input.nextLine();
                    paciente.setTelefonoContactoEmergencia(telContNuevo);
                    break;
                case "9":
                    input.nextLine();
                    System.out.println("Ingrese su contraseña actual.");
                    String contraConfirm;
                    contraConfirm = input.nextLine();

                    if (paciente.getContrasena().equals(contraConfirm)){
                        System.out.println("Ingrese nueva contraseña. ");
                        String contrasena;
                        contrasena = SistemaDeGestionClinica.input.nextLine();

                        System.out.println("Por favor confirme la contraseña.");
                        String contrasenaConfir;
                        contrasenaConfir = SistemaDeGestionClinica.input.nextLine();
                        while(true){
                            if (contrasena.equals(contrasenaConfir)){
                                paciente.setContrasena(contrasena);
                                break;
                            }
                            System.out.println("La contraseña no coincide, vuelva a ingresar la contraseña que desea.");
                            contrasena = SistemaDeGestionClinica.input.nextLine();
                            System.out.println("Por favor confirme la contraseña");
                            contrasenaConfir = SistemaDeGestionClinica.input.nextLine();
                        }
                    }else{
                        System.out.println("Contraseña incorrecta.");
                        break;
                    }
                case "0":
                    break label;
            }
        }
        db.appendArrayToJSON("pacientes");
        System.out.println("Modificación exitosa.");
    }

    public  void eliminarPaciente(Paciente paciente){
        System.out.println("¿Está seguro que desea eliminar su usuario? Y/N");
        while (true){
            String opcion = SistemaDeGestionClinica.input.next();
            if (opcion.equals("Y")||opcion.equals("y")) {
                int indice = 0;
                for (Paciente paci: db.getPacientes()){
                    if (paciente.getIdPaciente() == paci.getIdPaciente()){
                        indice= db.getPacientes().indexOf(paci);
                    }
                }

                //Elimina relación con psiquiatra
                for (Psiquiatra psiquiatra : db.getPsiquiatras()){
                    if (psiquiatra.getIdPsiquiatra() == paciente.getPsiquiatra()){
                        psiquiatra.getListaPacientes().removeIf(pc -> (pc.idPaciente == paciente.idPaciente));
                    }
                }

                // Elimina relación con historial clinico
                HistorialClinico hist = new HistorialClinico();
                hist.borrarHistClinico(paciente);

                //FALTA ELIMINAR RELACIÓN CON CITA

                db.deleteObjectInArray(indice,"pacientes");
                db.appendArrayToJSON("psiquiatras");
                System.out.println("Se eliminó exitosamente el perfil.");
            }else if (opcion.equals("N")||opcion.equals("n")){
                break;
            }
            return;
        }
    }

    public  void verPaciente(Paciente paciente){
        System.out.println(paciente.toString());
    }

    public  void cambiarPsiquiatra(Paciente paciente) {
        Psiquiatra psiAntiguo = new Psiquiatra();

        for (Psiquiatra psiquiatra : db.getPsiquiatras()){
            if (psiquiatra.getIdPsiquiatra() == paciente.getPsiquiatra()){
                System.out.println("El nombre de su médico actual es:" + psiquiatra.getNombres());
                psiAntiguo = psiquiatra;
                psiquiatra.listaPacientes.removeIf(pc -> (pc.idPaciente == paciente.idPaciente));
            }
        }
        paciente.setPsiquiatra(0);
        asignarPsiquiatra(paciente);


        if (psiAntiguo.getIdPsiquiatra() == paciente.getPsiquiatra()){
            for (Psiquiatra psiquiatra : db.getPsiquiatras()){
                if (psiquiatra.getIdPsiquiatra() == paciente.getPsiquiatra()){
                    System.out.println("El nombre de su médico actual es:" + psiquiatra.getNombres() + psiquiatra.getIdPsiquiatra());
                    psiquiatra.listaPacientes.removeIf(pc -> (pc.idPaciente == paciente.idPaciente));
                }
            }
            asignarPsiquiatra(paciente);
        }

        db.appendArrayToJSON("pacientes");
        db.appendArrayToJSON("psiquiatras");

    }

    public  void registrarEmociones(Paciente paciente) {
        int count = 0;
        System.out.println();
        System.out.println("Nos preocupamos por tu bienestar. Tus emociones son muy importantes para nosostros.");
        System.out.println();
        System.out.println("Para que puedas compartirnos cómo te sientes te invitamos a contestar el siguiente cuestionario.");
        System.out.println("Lee detenidamente las preguntas y respóndelas todas.");
        while (true) {
            System.out.println();
            System.out.println("Mi estado de ánimo  durante los últimos días ha sido: ");
            System.out.println();
            System.out.println("Elije una opción");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("1. Positivo. Me he sentido bien.");
            System.out.println("2. Neutral. He tenido días mejores.");
            System.out.println("3. Negativo. Me siento triste la mayor parte del día");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println();
            String opcion = SistemaDeGestionClinica.input.next();
            switch (opcion) {
                case "1":
                    count += 1;
                    break;
                case "2":
                    count += 2;
                    break;
                case "3":
                    count += 3;
                    break;
            }
            break;
        }
        while (true) {
            System.out.println();
            System.out.println("Cuando pienso en el futuro: ");
            System.out.println();
            System.out.println("Elije una opción");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("1. Pensar en el futuro me aterra.");
            System.out.println("2. Soy optimista, tengo muchos planes que cumplir.");
            System.out.println("3. No me preocupo por el futuro");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println();
            String opcion = SistemaDeGestionClinica.input.next();
            switch (opcion) {
                case "1":
                    count += 3;
                    break;
                case "2":
                    count += 1;
                    break;
                case "3":
                    count += 2;
                    break;
            }
            break;
        }

        while (true) {
            System.out.println();
            System.out.println("Cuando me comparo con otras personas: ");
            System.out.println();
            System.out.println("Elije una opción");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("1. A veces gano yo. Otras ganan ellos.");
            System.out.println("2. Me siento inferior.");
            System.out.println("3. Me siento satisfecho conmigo mismo");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println();
            String opcion = SistemaDeGestionClinica.input.next();
            switch (opcion) {
                case "1":
                    count += 2;
                    break;
                case "2":
                    count += 3;
                    break;
                case "3":
                    count += 1;
                    break;
            }
            break;
        }

        while (true) {
            System.out.println();
            System.out.println("En lo que respecta a mis hábitos de sueño: ");
            System.out.println();
            System.out.println("Elije una opción");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("1. Puedo dormir todo el día o no conciliar el sueño en toda la noche.");
            System.out.println("2. Duermo como siempre.");
            System.out.println("3. Me despierto a vces a la mitad de la noche y no puedo dormir nuevamente");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println();
            String opcion = SistemaDeGestionClinica.input.next();
            switch (opcion) {
                case "1":
                    count += 3;
                    break;
                case "2":
                    count += 1;
                    break;
                case "3":
                    count += 2;
                    break;
            }
            break;
        }

        while (true) {
            System.out.println();
            System.out.println("En lo que respecta a mi apetito: ");
            System.out.println();
            System.out.println("Elije una opción");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("1. Es igual que siempre.");
            System.out.println("2. Ha sido algo irregular, pero me estoy alimentando.");
            System.out.println("3. No siento deseo de comer o no puedo parar de comer");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println();
            String opcion = SistemaDeGestionClinica.input.next();
            switch (opcion) {
                case "1":
                    count += 1;
                    break;
                case "2":
                    count += 2;
                    break;
                case "3":
                    count += 3;
                    break;
            }
            break;
        }
        while (true) {
            System.out.println();
            System.out.println("En lo que respecta a mi capacidad de trabajo y energía: ");
            System.out.println();
            System.out.println("Elije una opción");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("1. Siento que mi rendimiento ha disminuido algo sin motivo aparente.");
            System.out.println("2. No noto diferencia");
            System.out.println("3. Estoy tan cansado que soy incapaz de hacer nada.");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println();
            String opcion = SistemaDeGestionClinica.input.next();
            switch (opcion) {
                case "1":
                    count += 2;
                    break;
                case "2":
                    count += 1;
                    break;
                case "3":
                    count += 3;
                    break;
            }
            break;
        }
        if(count==18){
            Cita citas = new Cita();
            citas.mensajeEmergencia();
            citas.crearEmergencia(paciente);
        }else{
            System.out.println();
            System.out.println("Muchas gracias por llenar el cuestionario, nos alegra saber cómo te sientes");
            System.out.println("¡No olvides volver la próxima semana!");
            System.out.println();
        }
    }

    public static void programarCita(Paciente paciente){
        Cita ct = new Cita();
        ct.crearCita(paciente);
    }

    public  void asignarPsiquiatra(Paciente paciente){
        Collections.sort(db.getPsiquiatras(), PsiquiatraOrdenar.Apellidos);
        Collections.sort(db.getPsiquiatras(), PsiquiatraOrdenar.NumPacientes);
        Psiquiatra psiqui;

        if (paciente.getPsiquiatra() == 0){
            psiqui = db.getPsiquiatras().get(0);
        }else{
            psiqui =db.getPsiquiatras().get(1);
        }
        psiqui.listaPacientes.add(paciente);
        paciente.setPsiquiatra(psiqui.getIdPsiquiatra());
    }




}
