public class CoordinadorDeClinica implements handleJSON {
    public int cedulaCoordinador;
    public String emailCoordinador;
    public String contrasenaCoordinador;
    public Clinica clinicaCoordinador;

    handleDB db = new handleDB();

    public CoordinadorDeClinica() { }

    public CoordinadorDeClinica(int cedulaCoordinador, String emailCoordinador, String contrasenaCoordinador, Clinica clinicaCoordinador) {
        this.cedulaCoordinador = cedulaCoordinador;
        this.emailCoordinador = emailCoordinador;
        this.contrasenaCoordinador = contrasenaCoordinador;
        this.clinicaCoordinador = clinicaCoordinador;
    }

    public int getCedulaCoordinador() {
        return cedulaCoordinador;
    }

    public void setCedulaCoordinador(int cedulaCoordinador) {
        this.cedulaCoordinador = cedulaCoordinador;
    }

    public String getEmailCoordinador() {
        return emailCoordinador;
    }

    public void setEmailCoordinador(String emailCoordinador) {
        this.emailCoordinador = emailCoordinador;
    }

    public String getContrasenaCoordinador() {
        return contrasenaCoordinador;
    }

    public void setContrasenaCoordinador(String contrasenaCoordinador) {
        this.contrasenaCoordinador = contrasenaCoordinador;
    }

    public Clinica getClinicaCoordinador() {
        return clinicaCoordinador;
    }

    public void setClinicaCoordinador(Clinica clinicaCoordinador) {
        this.clinicaCoordinador = clinicaCoordinador;
    }

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
    public void editarClinica(){


    }


    public void borrarClinica(){
        //deleteObject();

    }

    public void registrarPsiquiatra(){

    }

    public void borrarPsiquiatra(){

    }

    public void suministrarMedicamentos(){

    }

    public void borrarMedicamento(){

    }
}
