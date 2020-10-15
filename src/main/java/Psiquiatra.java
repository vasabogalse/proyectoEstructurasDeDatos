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
            } else if(opt.equals("2")) {
                System.out.println("Ingrese la nueva contraseña");
                claveNueva = input.next();
            } else if(opt.equals("3")){
                System.out.println("Ingrese la nueva dirección");
                direccionNueva = input.next().toLowerCase();
            } else if(opt.equals("4")) {
                System.out.println("Ingrese el nuevo teléfono");
                nuevoTelefono = input.nextInt();
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
