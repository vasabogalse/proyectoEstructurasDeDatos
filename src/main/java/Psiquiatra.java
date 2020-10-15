import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Psiquiatra implements handleJSON {
    public int idPsiquiatra;
    public String nombres;
    public String apellidos;
    public String emailPsiquiatra;
    public String clavePsiquiatra;
    public String Sexo;
    public String direccion;
    public int edad;
    public String fechaNacimiento;
    public int tel;
    public ArrayList<HistorialClinico> historiales;
    public ArrayList<Paciente> pacientes;
    public ArrayList<Cita> citas;
    public Clinica clinicaPsiquiatra;

    handleDB db = new handleDB();
    Psiquiatra ps = new Psiquiatra();
    Scanner input = new Scanner(System.in);

    public Psiquiatra(){ }

    public Psiquiatra(int idPsiquiatra, String emailPsiquiatra, String clavePsiquiatra) {
        this.idPsiquiatra = idPsiquiatra;
        this.emailPsiquiatra = emailPsiquiatra;
        this.clavePsiquiatra = clavePsiquiatra;
    }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getSexo() { return Sexo;}
    public void setSexo(String sexo) { Sexo = sexo; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public int getTel() { return tel; }
    public void setTel(int tel) { this.tel = tel; }
    public ArrayList<HistorialClinico> getHistoriales() { return historiales; }
    public void setHistoriales(ArrayList<HistorialClinico> historiales) { this.historiales = historiales; }
    public ArrayList<Paciente> getPacientes() { return pacientes; }
    public void setPacientes(ArrayList<Paciente> pacientes) { this.pacientes = pacientes; }
    public Clinica getClinicaPsiquiatra() { return clinicaPsiquiatra; }
    public void setClinicaPsiquiatra(Clinica clinicaPsiquiatra) { this.clinicaPsiquiatra = clinicaPsiquiatra; }
    public int getIdPsiquiatra() { return idPsiquiatra; }
    public void setIdPsiquiatra(int idPsiquiatra) { this.idPsiquiatra = idPsiquiatra; }
    public String getEmailPsiquiatra() { return emailPsiquiatra; }
    public void setEmailPsiquiatra(String emailPsiquiatra) { this.emailPsiquiatra = emailPsiquiatra; }
    public String getClavePsiquiatra() { return clavePsiquiatra; }
    public void setClavePsiquiatra(String clavePsiquiatra) { this.clavePsiquiatra = clavePsiquiatra; }
    public ArrayList<Cita> getCitas() { return citas; }
    public void setCitas(ArrayList<Cita> citas) { this.citas = citas; }

    @Override
    public String toString() {
        return "{"  + "\n" +
                "idPsiquiatra : " + idPsiquiatra + "," + "\n" +
                "emailPsiquiatra : " + emailPsiquiatra + "," + "\n" +
                "clavePsiquiatra : " + clavePsiquiatra + "," + "\n" +
                '}';
    }

    public void registrarPsiquiatra() {
        System.out.println("Ingrese el primer nombre (y segundo nombre si tiene) del psiquiatra a registrar:");
        input.nextLine();
        String nombres = input.nextLine();

        System.out.println("Ingrese los apellidos del psiquiatra a registrar:");
        input.nextLine();
        String apellidos = input.nextLine();

        System.out.println("Ingrese el email del psiquiatra a registrar:");
        input.nextLine();
        String email = input.nextLine();

        System.out.println("Ingrese la contraseña del psiquiatra a registrar:");
        input.nextLine();
        String contrasena = input.nextLine();

        System.out.println("Por favor confirme la contraseña");
        String contrasenaConfir = input.nextLine();

        while(true){
            if (contrasena.equals(contrasenaConfir)){
                ps.setClavePsiquiatra(contrasena);
                break;
            } else {
                System.out.println("La contraseña no coincide, vuelva a ingresar la contraseña que desea.");
                contrasena = input.nextLine();
                System.out.println("Por favor confirme la contraseña");
                contrasenaConfir = input.nextLine();
            }
        }

        String sexo = "";
        while(true) {
            System.out.println("Ingrese el sexo del(de la) psiquiatra: ");
            System.out.println("1. Masculino");
            System.out.println("2. Femenino");
            System.out.println("3. Otro");
            sexo = input.next();
            if (sexo.equals("1")) {
                sexo = "masculino";
                break;
            } else if (sexo.equals("2")) {
                sexo = "femenino";
                break;
            } else if (sexo.equals("3")) {
                sexo = "otro";
                break;
            } else {
                System.out.println("Ingresó una respuesta inválida. Por favor elija una opción");
            }
        }

        int edad = 0;
        while(true) {
            System.out.println("Ingrese la edad del psiquiatra a registrar:");
            edad = input.nextInt();
            if (edad < 18) {
                System.out.println("La edad ingresada es inválida, debe ser mayor a 18");
            } else if(edad < 0 || edad > 100){
                System.out.println("La edad deber estar entre 0 y 100 años");
            } else {
                break;
            }
        }

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
            }
        }
        String fecha = String.valueOf(aaaa) + "-" + String.valueOf(mm) + "-" + String.valueOf(dd);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date fechaNacimiento = null;
        try {
            //Parsing the String
            fechaNacimiento = dateFormat.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Ingrese la dirección del psiquiatra a registrar:");
        input.nextLine();
        String direccion = input.nextLine().toLowerCase();

        int telefono  = 0;
        while(true){
            System.out.println("Ingrese el teléfono del psiquiatra a registrar:");
            telefono = input.nextInt();
            if (telefono < 0) {
                System.out.println("El teléfono ingresado es inválido, no puede ser negativo");
            } else {
                break;
            }
        }
    }

    public void editarPsiquiatra(int idPsiquiatra) {
        Collections.sort(db.getPsiquiatras(), ClinicSort.idOrderPsiquiatra);
        Psiquiatra ps = new Psiquiatra();
        ps.setIdPsiquiatra(idPsiquiatra);
        int indexPsiquiatra = Collections.binarySearch(db.getPsiquiatras(), ps, ClinicSort.idOrderPsiquiatra);
        ps = db.getPsiquiatras().get(indexPsiquiatra);
        String opt = "";
        String guardarCambio = "";
        String correoNuevo = "", claveNueva = "", direccionNueva = "";
        int nuevoTelefono = 0;
        System.out.println("__________________________________________________");
        System.out.println("            Editar perfil de psicólogo");
        System.out.println("--------------------------------------------------");
        while(true){
            System.out.println("Selecciones el campo a editar/actualizar");
            System.out.println("1. Correo");
            System.out.println("2. Contraseña");
            System.out.println("3. Dirección");
            System.out.println("4. Teléfono");
            System.out.println("0. Regresar al menú principal");
            System.out.println("----------------------------------------------");
            opt = input.next();
            if(opt.equals("1")){
                System.out.println("Ingrese el nuevo correo electrónico:");
                correoNuevo = input.next().toLowerCase();
                break;
            } else if(opt.equals("2")) {
                System.out.println("Ingrese la nueva contraseña");
                claveNueva = input.next();
            } else if(opt.equals("3")){
                System.out.println("Ingrese la nueva dirección");
                direccionNueva = input.next().toLowerCase();
                break;
            } else if(opt.equals("4")) {
                System.out.println("Ingrese el nuevo teléfono");
                nuevoTelefono = input.nextInt();
                break;
            } else if(opt.equals("0")){
                return;
            }else {
                System.out.println("Ingresaste una opción incorrecta");
            }
            System.out.println("¿Desea cambiar guardar el cambio? Y/N: ");
            guardarCambio = input.next().toLowerCase();
            if(guardarCambio.equals("y")){
                switch (opt) {
                    case "1":
                        for(int i = 0; i <= db.getPsiquiatras().size(); i++){
                            if(db.getPsiquiatras().get(i).idPsiquiatra == idPsiquiatra) {
                                db.getPsiquiatras().get(i).setEmailPsiquiatra(correoNuevo);
                                break;
                            }
                        }
                        break;
                    case "2":
                        for(int i = 0; i <= db.getPsiquiatras().size(); i++){
                            if(db.getPsiquiatras().get(i).idPsiquiatra == idPsiquiatra) {
                                db.getPsiquiatras().get(i).setClavePsiquiatra(claveNueva);
                                break;
                            }
                        }
                        break;
                    case "3":
                        for(int i = 0; i <= db.getPsiquiatras().size(); i++){
                            if(db.getPsiquiatras().get(i).idPsiquiatra == idPsiquiatra) {
                                db.getPsiquiatras().get(i).setDireccion(direccionNueva);
                                break;
                            }
                        }
                        break;
                    case "4":
                        for(int i = 0; i <= db.getPsiquiatras().size(); i++) {
                            if (db.getPsiquiatras().get(i).idPsiquiatra == idPsiquiatra) {
                                db.getPsiquiatras().get(i).setTel(nuevoTelefono);
                                break;
                            }
                        }
                        break;
                }
                db.appendArrayToJSON("psiquiatras");
            } else if(guardarCambio.equals("n")){
                System.out.println("Si no cierra el sistema puede guardar sus cambios en la opción 6 del menú principal");
                break;
            }
        }
    }
}
