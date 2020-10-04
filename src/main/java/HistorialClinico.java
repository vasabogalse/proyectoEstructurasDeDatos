import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HistorialClinico implements handleJSON{
    public static Scanner input = new Scanner(System.in);

    public int idHistClinico;
    public String antecedentes;
    public String procedimientos;
    public String recomendaciones;
    // public Psiquiatra psiquiatra;
    //public FormulaMedica formulaMedica;
    //public Paciente paciente;

    public List<HistorialClinico> HistList;

    public HistorialClinico(){
        this.HistList = new ArrayList<>();
    }

    public HistorialClinico(int idHistClinico, String antecedentes, String procedimientos, String recomendaciones) {
        this.idHistClinico = idHistClinico;
        this.antecedentes = antecedentes;
        this.procedimientos = procedimientos;
        this.recomendaciones = recomendaciones;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                "idHistClinico=" + idHistClinico + "," + "\n" +
                "antecedentes=" + antecedentes + "," + "\n" +
                "procedimientos=" + procedimientos + "," + "\n" +
                "recomendaciones=" + recomendaciones + "\n" +
                '}'+ "\n";
    }

    public static void  crearHistClinico(){

        int idHist = 0;
        for (HistorialClinico histClinico : SistemaDeGestionClinica.HistClinicosJava){
            idHist = histClinico.idHistClinico;
        }

        System.out.println("El paciente ya se encuentra registrado en el sistema,por favor diligencie la historia clinica.");
        System.out.println("Antecedentes: ");
        String antecedentes = input.nextLine();
        System.out.println("Recomendaciones: ");
        String recomendaciones = input.nextLine();
        System.out.println("Procedimientos: ");
        String procedimientos = input.nextLine();

        idHist++;
        HistorialClinico nuevoHistClinico = new HistorialClinico(idHist,antecedentes,procedimientos,recomendaciones);

        SistemaDeGestionClinica.histClinicos.add(nuevoHistClinico);
        System.out.println("La historia clinica se creó correctamente con el id: " + idHist);
        SistemaDeGestionClinica.histGuar.writeJSON(SistemaDeGestionClinica.histClinicos, "historialesClinicos");
        ArrayList<HistorialClinico> HistClinicosJava = SistemaDeGestionClinica.histGuar.readJSON(HistorialClinico.class, "historialesClinicos");

        System.out.println(SistemaDeGestionClinica.histClinicos.toString());
    }

    public static void editarHistClinico(){}
    public static void borrarHistClinico(){}
    public static void verHistClinico(){}

}
