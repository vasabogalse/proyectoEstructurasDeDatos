public class CoordinadorDeClinica extends handleDB {
    public String emailCoordinador;
    public String contrasenaCoordinador;
    public Clinica clinicaCoordinador;

    public CoordinadorDeClinica() { }

    public CoordinadorDeClinica(String emailCoordinador, String contrasenaCoordinador, Clinica clinicaCoordinador) {
        this.emailCoordinador = emailCoordinador;
        this.contrasenaCoordinador = contrasenaCoordinador;
        this.clinicaCoordinador = clinicaCoordinador;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
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
