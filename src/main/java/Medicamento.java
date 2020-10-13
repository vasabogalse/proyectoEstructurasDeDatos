public class Medicamento implements handleJSON{
    public int idMedicamento;
    public String nombreMedicamento;
    public int cantidadDisponible;
    public FormulaMedica formulaMedica;
    public int nitClinicaMed;

    public Medicamento(int idMedicamento, String nombreMedicamento, int cantidadDisponible, int nitClinicaMed) {
        this.idMedicamento = idMedicamento;
        this.nombreMedicamento = nombreMedicamento;
        this.cantidadDisponible = cantidadDisponible;
        this.formulaMedica = null;
        this.nitClinicaMed = nitClinicaMed;
    }

    public Medicamento() {
    }

    @Override

    public String toString() {

        return "- " + nombreMedicamento + ": " + cantidadDisponible;
    }

    public void listarMedicamento(Clinica clinica) {
        handleDB db = new handleDB();
        System.out.println("A continuación verá cada medicamento con su id y cantidad al frente");
        for (Medicamento medicamento : clinica.listaDeMedicamentos) {
            System.out.println(medicamento.nombreMedicamento + " - id: " + medicamento.idMedicamento + ", cantidad: " + medicamento.cantidadDisponible);
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
}
