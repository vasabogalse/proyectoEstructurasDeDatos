import java.util.ArrayList;
import java.util.Date;

public class Paciente implements handleJSON {
    public int idPaciente;
    public String nombres;
    public String apellidos;
    public String email;
    public String contrasena;
    public String direccion;
    public int edad;
    //public String fechaNacimiento;
    public int telefono;
    public String nombreContactoEmergencia;
    public int telefonoContactoEmergencia;
    public int numLlamadas;
    public Psiquiatra psiquiatra;
    //public ArrayList<Integer> estados;
    //public ArrayList<Cita> listaCitas;
    //public HistorialClinico historialClinico;

    public Paciente() { }

    // Recibe estados
    public Paciente(int idPaciente, String nombres, String apellidos, String email, String contrasena, String direccion, int edad/*, String fechaNacimiento*/, int telefono, String nombreContactoEmergencia, int telefonoContactoEmergencia) {
        this.idPaciente = idPaciente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.edad = edad;
        //this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.nombreContactoEmergencia = nombreContactoEmergencia;
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
        this.numLlamadas = 0;
        //this.estados = null;
        //this.listaCitas = null;
        //this.historialClinico = null;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
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

    public int getTelefonoContactoEmergencia() {
        return telefonoContactoEmergencia;
    }

    public void setTelefonoContactoEmergencia(int telefonoContactoEmergencia) {
        this.telefonoContactoEmergencia = telefonoContactoEmergencia;
    }

    public int getNumLlamadas() {
        return numLlamadas;
    }

    public void setNumLlamadas(int numLlamadas) {
        this.numLlamadas = numLlamadas;
    }

    public Psiquiatra getPsiquiatra() {
        return psiquiatra;
    }

    public void setPsiquiatra(Psiquiatra psiquiatra) {
        this.psiquiatra = psiquiatra;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                "Cédula : " + idPaciente + "," + "\n" +
                "nombres : " + nombres + "," + "\n" +
                "apellidos : " + apellidos + "," + "\n" +
                "email : " + email + "," + "\n" +
                "contrasena : " + contrasena + "," + "\n" +
                "direccion : " + direccion + "," + "\n" +
                "edad : " + edad + "," + "\n" +
                //"fechaNacimiento : " + fechaNacimiento + "," + "\n" +
                "telefono : " + telefono + "," + "\n" +
                "nombreContactoEmergencia : " + nombreContactoEmergencia + "," + "\n" +
                "telefonoContactoEmergencia : " + telefonoContactoEmergencia + "," + "\n" +
                "numLlamadas : " + numLlamadas + "," + "\n" +
                //"estados=" + estados + "," + "\n" +
                "Psiquiatra : " + psiquiatra + "\n" +
                '}'+ "\n";
    }
}

