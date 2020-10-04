import java.util.ArrayList;
import java.util.List;

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
    public ArrayList<Integer> estados;
    //public Cita cita;
    //public Psiquiatra psiquiatra;
    //public HistorialClinico historialClinico;

    public List<Clinica> pacienList;


    public Paciente(){
        this.pacienList = new ArrayList<>();
    }

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
                "estados=" + estados + "\n" +
                '}'+ "\n";
    }


}