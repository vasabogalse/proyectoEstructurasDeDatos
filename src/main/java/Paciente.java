import java.util.ArrayList;
import java.util.Collections;


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
    public int numLlamadas;
    public int psiquiatra;
    public ArrayList<Integer> estados;
    public ArrayList<Cita> listaCitas = new ArrayList<>();
    public int historialClinico;

    handleDB db = new handleDB();
    public Paciente(){};
    public static Paciente paciente = new Paciente();

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNombreContactoEmergencia(String nombreContactoEmergencia) {
        this.nombreContactoEmergencia = nombreContactoEmergencia;
    }

    public void setTelefonoContactoEmergencia(String telefonoContactoEmergencia) {
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
    }

    public void setPsiquiatra(int psiquiatra) {
        this.psiquiatra = psiquiatra;
    }

    public void setHistorialClinico(int historialClinico) {
        this.historialClinico = historialClinico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombreContactoEmergencia() {
        return nombreContactoEmergencia;
    }

    public String getTelefonoContactoEmergencia() {
        return telefonoContactoEmergencia;
    }

    public int getNumLlamadas() {
        return numLlamadas;
    }

    public int getPsiquiatra() {
        return psiquiatra;
    }

    public ArrayList<Integer> getEstados() {
        return estados;
    }

    public ArrayList<Cita> getListaCitas() {
        return listaCitas;
    }

    public int getHistorialClinico() {
        return historialClinico;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
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
                ", numLlamadas=" + numLlamadas +
                ", psiquiatra=" + psiquiatra +
                ", estados=" + estados +
                ", listaCitas=" + listaCitas +
                ", historialClinico=" + historialClinico +
                '}';
    }

    public  void registrarPaciente() {
        Paciente paciente = new Paciente();

        SistemaDeGestionClinica.input.nextLine();
        System.out.println("Bienvenido al sistema, por favor registre la siguiente información: ");
        System.out.println("Cédula: ");
        int idPaciente = SistemaDeGestionClinica.input.nextInt();
        SistemaDeGestionClinica.input.nextLine();

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
        String telefono = SistemaDeGestionClinica.input.nextLine();

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
        paciente.setContrasena(contrasena);
        asignarPsiquiatra(paciente);
        db.appendArrayToJSON("psiquiatras");
        db.updateJSON(paciente,"pacientes");
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
                    System.out.println("Nombre antiguo:" + paciente.getNombres() + ".Ingrese la información actualizada:");
                    String nomNuevo = SistemaDeGestionClinica.input.nextLine();
                    paciente.setNombres(nomNuevo);
                    System.out.println(paciente.getNombres());
                    break;
                case "2":
                    System.out.println("Apellido antiguo:" + paciente.getApellidos() + ".Ingrese la información actualizada:");
                    String apeNuevo = SistemaDeGestionClinica.input.nextLine();
                    paciente.setApellidos(apeNuevo);
                    System.out.println(paciente.getApellidos());
                    break;
                case "3":
                    System.out.println("Fecha de nacimiento antigua:" + paciente.getFechaNacimiento()+ ".Ingrese la información actualizada:");
                    String fechaNueva = SistemaDeGestionClinica.input.nextLine();
                    paciente.setFechaNacimiento(fechaNueva);
                    System.out.println(paciente.getFechaNacimiento());
                    break;
                case "4":
                    System.out.println("Teléfono antiguo:" + paciente.getTelefono() +".Ingrese la información actualizada:");
                    String telNuevo = SistemaDeGestionClinica.input.nextLine();
                    paciente.setTelefono(telNuevo);
                    System.out.println(paciente.getTelefono());
                    break;
                case "5":
                    System.out.println("Dirección antigua:" + paciente.getDireccion()+".Ingrese la información actualizada:");
                    String dirNueva = SistemaDeGestionClinica.input.nextLine();
                    paciente.setDireccion(dirNueva);
                    System.out.println(paciente.getDireccion());
                    break;
                case "6":
                    System.out.println("Correo electrónico antiguo:" + paciente.getEmail()+".Ingrese la información actualizada:");
                    String emailNuevo = SistemaDeGestionClinica.input.nextLine();
                    paciente.setEmail(emailNuevo);
                    System.out.println(paciente.getEmail());
                    break;
                case "7":
                    System.out.println("Nombre de contacto antiguo:" + paciente.getNombreContactoEmergencia()+".Ingrese la información actualizada:");
                    String nomContNuevo = SistemaDeGestionClinica.input.nextLine();
                    paciente.setNombreContactoEmergencia(nomContNuevo);
                    System.out.println(paciente.getNombreContactoEmergencia());
                    break;
                case "8":
                    System.out.println("Teléfono de contacto antiguo:" + paciente.getTelefonoContactoEmergencia()+".Ingrese la información actualizada:");
                    String telContNuevo = SistemaDeGestionClinica.input.nextLine();
                    paciente.setTelefonoContactoEmergencia(telContNuevo);
                    System.out.println(paciente.getTelefonoContactoEmergencia());
                    break;
                case "9":
                    System.out.println("Contraseña antigua:" + paciente.getContrasena()+".Ingrese la información actualizada:");
                    String Contraseña = SistemaDeGestionClinica.input.nextLine();
                    paciente.setContrasena(Contraseña);
                    System.out.println(paciente.getContrasena());
                    break;
                case "0":
                    break label;
            }
        }
        db.appendArrayToJSON("pacientes");
        System.out.println("Modificación exitoso.");
    }

    public  void eliminarPaciente(Paciente paciente){
        db.getPacientes().remove(paciente);
        for (Psiquiatra psiquiatra : db.getPsiquiatras()){
            if (psiquiatra.getIdPsiquiatra() == paciente.getPsiquiatra()){
                psiquiatra.getListaPacientes().remove(paciente);
            }
        }
        db.appendArrayToJSON("pacientes");
        db.appendArrayToJSON("psiquiatras");
        System.out.println("Se eliminó exitosamente el perfil.");
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

    public static void registrarEmociones(){

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
