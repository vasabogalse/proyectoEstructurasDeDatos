import java.util.ArrayList;
import java.util.Collections;

public class Clinica implements handleJSON{
    public int nit;
    public String nombreClinica;
    public String direccion;
    public int telefono;
    public CoordinadorDeClinica coordinadorDeClinica;
    public ArrayList<Medicamento> listaDeMedicamentos;
    public ArrayList<Psiquiatra> listaDePsiquiatras;

    handleDB db = new handleDB();

    public Clinica(){
    }

    public Clinica(int nit, String nombreClinica, String direccion, int telefono) {
        this.nit = nit;
        this.nombreClinica = nombreClinica;
        this.direccion = direccion;
        this.telefono = telefono;
        this.coordinadorDeClinica = coordinadorDeClinica;
        this.listaDeMedicamentos = new ArrayList<>();
        this.listaDePsiquiatras = new ArrayList<>();
    }

    public Clinica(int nit, String nombreClinica, String direccion, int telefono, ArrayList<Medicamento> listaDeMedicamentos, ArrayList<Psiquiatra> listaDePsiquiatras) {
        this.nit = nit;
        this.nombreClinica = nombreClinica;
        this.direccion = direccion;
        this.telefono = telefono;
        this.coordinadorDeClinica = coordinadorDeClinica;
        this.listaDeMedicamentos = listaDeMedicamentos;
        this.listaDePsiquiatras = listaDePsiquiatras;
    }

    public int getNit() { return nit; }

    public void verificarCoordinadorClinica(String email, String contrasena){
        // busqueda lineal o binarySearch?
        for(CoordinadorDeClinica coordinador : db.getCoordinadores()){
            if(coordinador.contrasenaCoordinador.equals(contrasena)){
                // menuCoordinador();
            }
        }
    }

    public void verClinica(){

    }

    // primero se ejecuta esta para ordenar el arreglo
    public void ordenarClinicas(String atributo, String orden){
        if(atributo.equals("1")){
            if(orden.equals("1")){
                Collections.sort(db.getClinicas(), ClinicSort.nitOrder);
            } else {
                Collections.sort(db.getClinicas(), ClinicSort.nitOrder.reversed());
            }
        } // los otros casos
    }

    // luego se ejecuta esta para poder imprimir el arreglo ordenado
    public void listarClinicas(String atributo, String orden){
        ordenarClinicas(atributo, orden);
        int i = 0;
        for(Clinica clinica : db.getClinicas()){
            System.out.println("______________________________");
            System.out.println("        Clinica " + (i + 1));
            System.out.println("------------------------------");
            System.out.println(clinica);
        }
    }

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
