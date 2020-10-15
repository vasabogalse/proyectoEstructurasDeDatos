import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;


public class Paciente implements handleJSON {
    public String idPaciente;
    public String nombres;
    public String apellidos;
    public String email;
    public String contrasena;
    public String direccion;
    public int edad;
    public String fechaNacimiento;
    public int telefono;
    public String nombreContactoEmergencia;
    public String telefonoContactoEmergencia;
    public String psiquiatra;
    public ArrayList<Cita> listaCitas = new ArrayList<>();
    public int historialClinico;

    handleDB db = new handleDB();
    Scanner input = new Scanner(System.in);
    public static Paciente paciente = new Paciente();

    public Paciente(){};

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombreContactoEmergencia() {
        return nombreContactoEmergencia;
    }

    public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
        this.nombreContactoEmergencia = nombreContactoEmergencia;
    }

    public String getTelefonoContactoEmergencia() {
        return telefonoContactoEmergencia;
    }

    public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) {
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
    }

    public String getPsiquiatra() {
        return psiquiatra;
    }

    public void setPsiquiatra(String psiquiatra) {
        this.psiquiatra = psiquiatra;
    }

    public ArrayList<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(ArrayList<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }

    public int getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(int historialClinico) {
        this.historialClinico = historialClinico;
    }

    public void registrarPaciente() {
        Paciente paciente = new Paciente();

        System.out.println("Ingrese la cédula del paciente:");
        String cedula =  input.next();

        char [] arr = cedula.toCharArray();
        String cadena = "";
        for (char digito : arr) {
            if (Character.isDigit(digito)) { //Verifica que haya un número
                cadena += digito;
            } else if (cadena.equals("")) {
                System.out.println("Dato inválido.");
                return;
            }
        }
        String idPsiquiatra = cadena;

        input.nextLine();
        System.out.println("Nombres: ");
        String nombres = input.nextLine();

        System.out.println("Apellidos: ");
        String apellidos = input.nextLine();

        int edad = 0;
        while(true) {
            System.out.println("Edad:");
            edad = input.nextInt();
            if (edad < 18) {
                System.out.println("La edad ingresada es inválida, debe ser mayor a 18");
            } else if(edad < 0 || edad > 100){
                System.out.println("La edad deber estar entre 0 y 100 años");
            } else {
                break;
            }
        }

        input.nextLine();

        int aaaa = 0;
        while(true) {
            System.out.println("Ingrese el año de nacimiento");
            aaaa = input.nextInt();
            if (aaaa > 2020 || aaaa < 1920 || aaaa < 0) {
                System.out.println("Año de nacimiento inválido. Por favor vuelva a ingresar el año de nacimiento");
                return;
            } else {
                break;
            }
        }
        int mm = 0;
        while(true) {
            System.out.println("Ingrese el mes de nacimiento en número");
            mm = input.nextInt();
            if (mm > 12 || mm < 1) {
                System.out.println("Mes de nacimiento inválido. Por favor vuelva a ingresar el mes de nacimiento");
            } else {
                break;
            }
        }
        int dd = 0;
        while(true){
            System.out.println("Ingrese el día de nacimiento");
            dd = input.nextInt();
            if (dd > 31 || dd < 1) {
                System.out.println("Día de nacimiento inválido. Por favor vuelva a ingresar el día de nacimiento");
            } else {
                break;
            }
        }

        String fecha =  String.valueOf(dd) + "-" + String.valueOf(mm) + "-" + String.valueOf(aaaa) ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        Date fechaNacimiento = null;
        try {
            //Parsing the String
            fechaNacimiento = dateFormat.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Dirección:");
        String direccion = input.next().toLowerCase();
        input.nextLine();

        int telefono  = 0;
        while(true){
            System.out.println("Teléfono:");
            telefono = input.nextInt();
            if (telefono < 0) {
                System.out.println("El teléfono ingresado es inválido, no puede ser negativo");
            } else {
                break;
            }
        }

        input.nextLine();
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
            contrasena = input.nextLine();
            System.out.println("Por favor confirme la contraseña");
            contrasenaConfir = input.nextLine();
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
            option = input.next();
            switch (option) {
                case "1":
                    input.nextLine();
                    System.out.println("Nombre antiguo: " + paciente.getNombres() +". Ingrese la información actualizada:");
                    String nomNuevo = input.nextLine();
                    paciente.setNombres(nomNuevo);

                    break;
                case "2":
                    System.out.println("Apellido antiguo: " + paciente.getApellidos() + ". Ingrese la información actualizada:");
                    String apeNuevo = input.nextLine();
                    paciente.setApellidos(apeNuevo);
                    break;
                case "3":
                    System.out.println("Fecha de nacimiento antigua: " + paciente.getFechaNacimiento()+ " .Ingrese la información actualizada:");
                    String fechaNueva = input.nextLine();
                    paciente.setFechaNacimiento(fechaNueva);
                    break;
                case "4":
                    System.out.println("Teléfono antiguo: " + paciente.getTelefono() +". Ingrese la información actualizada:");
                    telefono = input.nextInt();
                    if (telefono < 0) {
                        System.out.println("El teléfono ingresado es inválido, no puede ser negativo");
                    }
                    paciente.setTelefono(telefono);
                    break;
                case "5":
                    System.out.println("Dirección antigua: " + paciente.getDireccion() +". Ingrese la información actualizada:");
                    String dirNueva = input.nextLine();
                    paciente.setDireccion(dirNueva);
                    break;
                case "6":
                    System.out.println("Correo electrónico antiguo: " + paciente.getEmail()+". Ingrese la información actualizada:");
                    String emailNuevo = input.nextLine();
                    paciente.setEmail(emailNuevo);
                    break;
                case "7":
                    System.out.println("Nombre de contacto antiguo: " + paciente.getNombreContactoEmergencia()+". Ingrese la información actualizada:");
                    String nomContNuevo = input.nextLine();
                    paciente.setNombreContactoEmergencia(nomContNuevo);
                    break;
                case "8":
                    System.out.println("Teléfono de contacto antiguo: " + paciente.getTelefonoContactoEmergencia()+". Ingrese la información actualizada:");
                    String telContNuevo = input.nextLine();
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
                        contrasena = input.nextLine();

                        System.out.println("Por favor confirme la contraseña.");
                        String contrasenaConfir;
                        contrasenaConfir = input.nextLine();
                        while(true){
                            if (contrasena.equals(contrasenaConfir)){
                                paciente.setContrasena(contrasena);
                                break;
                            }
                            System.out.println("La contraseña no coincide, vuelva a ingresar la contraseña que desea.");
                            contrasena = input.nextLine();
                            System.out.println("Por favor confirme la contraseña");
                            contrasenaConfir = input.nextLine();
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
            String opcion = input.next();
            if (opcion.equals("Y")||opcion.equals("y")) {
                int indice = 0;
                for (Paciente paci: db.getPacientes()){
                    if (paciente.getIdPaciente() == paci.getIdPaciente()){
                        indice= db.getPacientes().indexOf(paci);
                    }
                }

                //Elimina relación con psiquiatra
                for (Psiquiatra psiquiatra : db.getPsiquiatras()){
                    if (psiquiatra.getIdPsiquiatra().equals(paciente.getPsiquiatra())){
                        psiquiatra.getListaPacientes().removeIf(pc -> (pc == paciente.idPaciente));
                    }
                }

                // Elimina relación con historial clinico
                HistorialClinico hist = new HistorialClinico();
                hist.borrarHistClinico(paciente);

                //Eliminar relación cita
                int posicion=0;
                for (Cita ct : db.getCitas()){
                    if (ct.paciente.equals(paciente.getIdPaciente())){
                        posicion= db.getCitas().indexOf(ct);
                    }
                    db.deleteObjectInArray(posicion,"cita");
                }

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
            String opcion = input.next();
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
            String opcion = input.next();
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
            String opcion = input.next();
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
            String opcion = input.next();
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
            String opcion = input.next();
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
            String opcion = input.next();
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

    public  void programarCita(Paciente paciente){
        Cita ct = new Cita();
        ct.crearCita(paciente);
    }

    public  void asignarPsiquiatra(Paciente paciente){
        Collections.sort(db.getPsiquiatras(), PsiquiatraOrdenar.Apellidos);
        Collections.sort(db.getPsiquiatras(), PsiquiatraOrdenar.NumPacientes);
        Psiquiatra psiqui;

        psiqui = db.getPsiquiatras().get(0);
        psiqui.listaPacientes.add(paciente.getIdPaciente());
        paciente.setPsiquiatra(psiqui.getIdPsiquiatra());
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente='" + idPaciente + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", direccion='" + direccion + '\'' +
                ", edad=" + edad +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nombreContactoEmergencia='" + nombreContactoEmergencia + '\'' +
                ", telefonoContactoEmergencia='" + telefonoContactoEmergencia + '\'' +
                ", psiquiatra='" + psiquiatra + '\'' +
                ", listaCitas=" + listaCitas +
                ", historialClinico=" + historialClinico +
                '}';
    }
}

