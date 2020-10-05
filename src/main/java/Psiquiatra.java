import java.util.ArrayList;
import java.util.Collections;

public class Psiquiatra implements handleJSON {

    public String idPsiquiatra;
    public String nombres;
    public String apellidos;
    public ArrayList<HistorialClinico> ListaHistClinicos;
    public ArrayList<Paciente> ListaPacientes;


    public Psiquiatra(String idPsiquiatra, String nombres, String apellidos) {
        this.idPsiquiatra = idPsiquiatra;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ListaPacientes = new ArrayList<>();
    }

    public static void asignarPsiquiatra(Paciente paciente){
        Collections.sort(SistemaDeGestionClinica.psiquiatras, PsiquiatraSort.NumPacientes);

        // ListaPacientes.add(paciente);
        paciente.setPsiquiatra(SistemaDeGestionClinica.psiquiatras.get(0));
    }


    @Override
    public String toString() {
        return "Psiquiatra{" +
                "idPsiquiatra='" + idPsiquiatra + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
