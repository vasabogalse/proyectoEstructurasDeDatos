import java.util.ArrayList;
import java.util.Comparator;

public class Clinica implements handleJSON{
    public int nit;
    public String nombreClinica;
    public String direccion;
    public int telefono;
//    public CoordinadorDeClinica coordinadorDeClinica;
    public ArrayList<Medicamento> listaDeMedicamentos;
    public ArrayList<Psiquiatra> listaDePsiquiatras;

    public Clinica(){
    }

    public Clinica(int nit, String nombreClinica, String direccion, int telefono) {
        this.nit = nit;
        this.nombreClinica = nombreClinica;
        this.direccion = direccion;
        this.telefono = telefono;
//        this.coordinadorDeClinica = coordinadorDeClinica;
        this.listaDeMedicamentos = new ArrayList<>();
        this.listaDePsiquiatras = new ArrayList<>();
    }

    public Clinica(int nit, String nombreClinica, String direccion, int telefono, ArrayList<Medicamento> listaDeMedicamentos, ArrayList<Psiquiatra> listaDePsiquiatras) {
        this.nit = nit;
        this.nombreClinica = nombreClinica;
        this.direccion = direccion;
        this.telefono = telefono;
//        this.coordinadorDeClinica = coordinadorDeClinica;
        this.listaDeMedicamentos = listaDeMedicamentos;
        this.listaDePsiquiatras = listaDePsiquiatras;
    }

    public int getNit() { return nit; }

    @Override
    public String toString() {
        return "{" + "\n" +
                " nit : " + nit + "," + "\n" +
                " nombreClinica : " + nombreClinica + "," + "\n" +
                " direccion : " + direccion + "," + "\n" +
                " telefono : " + telefono + "\n" +
                '}';
    }
}
