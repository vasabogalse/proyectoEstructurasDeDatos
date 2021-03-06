import java.util.Collections;
import java.util.Scanner;

public class CoordinadorDeClinica implements handleJSON {
    public String cedulaCoordinador;
    public String emailCoordinador;
    public String contrasenaCoordinador;
    public int clinicaCoordinador;

    handleDB db = new handleDB();
    Scanner input = new Scanner(System.in);

    public CoordinadorDeClinica() { }

    public CoordinadorDeClinica(String cedulaCoordinador, String emailCoordinador, String contrasenaCoordinador, int clinicaCoordinador) {
        this.cedulaCoordinador = cedulaCoordinador;
        this.emailCoordinador = emailCoordinador;
        this.contrasenaCoordinador = contrasenaCoordinador;
        this.clinicaCoordinador = clinicaCoordinador;
    }

    public String getCedulaCoordinador() { return cedulaCoordinador;}
    public void setCedulaCoordinador(String cedulaCoordinador) { this.cedulaCoordinador = cedulaCoordinador; }
    public String getEmailCoordinador() { return emailCoordinador; }
    public void setEmailCoordinador(String emailCoordinador) { this.emailCoordinador = emailCoordinador; }
    public String getContrasenaCoordinador() { return contrasenaCoordinador; }
    public void setContrasenaCoordinador(String contrasenaCoordinador) { this.contrasenaCoordinador = contrasenaCoordinador; }
    public int getClinicaCoordinador() { return clinicaCoordinador; }
    public void setClinicaCoordinador(int clinicaCoordinador) { this.clinicaCoordinador = clinicaCoordinador; }

    @Override
    public String toString() {
        return "{" + "\n" +
                " cedulaCoordinador : " + cedulaCoordinador + "," + "\n" +
                " emailCoordinador : " + emailCoordinador + "," + "\n" +
                " contrasenaCoordinador : " + contrasenaCoordinador + "," + "\n" +
                " clinicaCoordinador : " + clinicaCoordinador + "," + "\n" +
                "}";
    }

    // metodos de la clase

}
