import java.util.ArrayList;

public class Psiquiatra implements handleJSON {
    public int idPsiquiatra;
    public String nombres;
    public String apellidos;
    public String emailPsiquiatra;
    public String clavePsiquiatra;
    public ArrayList<Integer> listaHistoriales = new ArrayList<>();
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Cita> listaCitas = new ArrayList<>();

    handleDB db = new handleDB();

    public void setIdPsiquiatra(int idPsiquiatra) {
        this.idPsiquiatra = idPsiquiatra;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmailPsiquiatra(String emailPsiquiatra) {
        this.emailPsiquiatra = emailPsiquiatra;
    }

    public void setClavePsiquiatra(String clavePsiquiatra) {
        this.clavePsiquiatra = clavePsiquiatra;
    }


    public int getIdPsiquiatra() {
        return idPsiquiatra;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmailPsiquiatra() {
        return emailPsiquiatra;
    }

    public String getClavePsiquiatra() {
        return clavePsiquiatra;
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public ArrayList<Integer> getListaHistoriales() {
        return listaHistoriales;
    }

    public void crearPsiquiatra(){
        Psiquiatra psiquiatra = new Psiquiatra();
        System.out.println("Id");
        int id = SistemaDeGestionClinica.input.nextInt();
        SistemaDeGestionClinica.input.nextLine();
        System.out.println("Nombre");
        String nombre = SistemaDeGestionClinica.input.nextLine();
        System.out.println("Apellidos");
        String apellidos = SistemaDeGestionClinica.input.nextLine();
        System.out.println("Email");
        String email = SistemaDeGestionClinica.input.nextLine();
        System.out.println("clave");
        String clave = SistemaDeGestionClinica.input.nextLine();

        psiquiatra.setIdPsiquiatra(id);
        psiquiatra.setNombres(nombre);
        psiquiatra.setApellidos(apellidos);
        psiquiatra.setEmailPsiquiatra(email);
        psiquiatra.setClavePsiquiatra(clave);
        db.updateJSON(psiquiatra, "psiquiatras");
    }




}
