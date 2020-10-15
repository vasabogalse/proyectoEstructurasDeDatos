
import java.util.ArrayList;

public class Medicamento implements handleJSON{
    public int idMedicamento;
    public String nombreMedicamento;
    public int cantidadDisponible;



    handleDB db = new handleDB();


    public Medicamento(int idMedicamento, String nombreMedicamento, int cantidadDisponible) {
        this.idMedicamento = idMedicamento;
        this.nombreMedicamento = nombreMedicamento;
        this.cantidadDisponible = cantidadDisponible;

    }

    public Medicamento() {
    }

    @Override

    public String toString() {

        return "- " + nombreMedicamento + ": " + cantidadDisponible;
    }

    public void listarMedicamento(Clinica clinica) {
        System.out.println("A continuación verá cada medicamento con su id y cantidad al frente: ");
//        if (clinica.listaDeMedicamentos == null) {
//            System.out.println("Esta clínica no tiene medicamentos actualmente");
//            ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();
//            clinica.listaDeMedicamentos = listaMedicamentos;
//        }
        for (Medicamento medicamento : clinica.listaDeMedicamentos) {
            System.out.println(medicamento.nombreMedicamento + " - id: " + medicamento.idMedicamento + ", cantidad: " +
                    medicamento.cantidadDisponible + ".");
        }
    }

    public void notificarCantidad(Clinica clinicaCoordinador) {
        for (Medicamento medicamentoClinica : clinicaCoordinador.listaDeMedicamentos) {
            if (medicamentoClinica.cantidadDisponible < 50) {
                System.out.println("Notificación: el medicamento " + medicamentoClinica.nombreMedicamento + "sólo tiene " +
                        medicamentoClinica.cantidadDisponible + "unidades disponibles.");
            }
        }
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }
    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }
    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    public void crearMedicamento(){
        Medicamento medicamento = new Medicamento();
        System.out.println("Id");
        int id = SistemaDeGestionClinica.input.nextInt();
        System.out.println("Nombre");
        String nombre = SistemaDeGestionClinica.input.next();
        System.out.println("Cantidad");
        int cantidad = SistemaDeGestionClinica.input.nextInt();
        medicamento.setCantidadDisponible(cantidad);
        medicamento.setNombreMedicamento(nombre);
        medicamento.setIdMedicamento(id);
        db.updateJSON(medicamento, "medicamentos");
    }
}

