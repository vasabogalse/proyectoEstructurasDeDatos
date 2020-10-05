import java.util.ArrayList;



public class HistorialClinico implements handleJSON{

    public int idHistClinico;
    public String antecedentes;
    public String procedimientos;
    public String recomendaciones;
    public Psiquiatra psiquiatra;
    public Paciente paciente;
    public ArrayList<FormulaMedica> listaForMedicas;


    HistorialClinico(){ }

    public HistorialClinico(int idHistClinico, String antecedentes, String procedimientos, String recomendaciones) {
        this.idHistClinico = idHistClinico;
        this.antecedentes = antecedentes;
        this.procedimientos = procedimientos;
        this.recomendaciones = recomendaciones;
        /* this.listaForMedicas = null;*/
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
        ArrayList<HistorialClinico> ListaHistClinicos;
        ListaHistClinicos = SistemaDeGestionClinica.histClinicos;
        int idHist = 0;
        for (HistorialClinico histClinico : ListaHistClinicos){
            idHist = histClinico.idHistClinico;
        }

        SistemaDeGestionClinica.input.nextLine();
        System.out.println("El paciente ya se encuentra registrado en el sistema,por favor diligencie la historia clinica.");
        System.out.println("Antecedentes: ");
        String antecedentes = SistemaDeGestionClinica.input.nextLine();
        System.out.println("Recomendaciones: ");
        String recomendaciones = SistemaDeGestionClinica.input.nextLine();
        System.out.println("Procedimientos: ");
        String procedimientos = SistemaDeGestionClinica.input.nextLine();

        idHist++;
        HistorialClinico nuevoHistClinico = new HistorialClinico(idHist,antecedentes,procedimientos,recomendaciones);


        ListaHistClinicos.add(nuevoHistClinico);
        System.out.println("La historia clinica se creó correctamente con el id: " + idHist);

        HistorialClinico histGuar = new HistorialClinico();

        histGuar.writeJSON(ListaHistClinicos, "historialesClinicos");

        ListaHistClinicos = histGuar.readJSON(HistorialClinico.class, "historialesClinicos");

        SistemaDeGestionClinica.histClinicos = ListaHistClinicos;
        System.out.println(SistemaDeGestionClinica.histClinicos.toString());


    }

    public static void editarHistClinico(){ }

    public static void borrarHistClinico(){}

    public static void verHistClinico(){}





}
