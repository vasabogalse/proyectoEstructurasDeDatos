public class Medicamento implements handleJSON{
    public int idMedicamento;
    public String nombreMedicamento;
    public int cantidadDisponible;
    public FormulaMedica formulaMedica;
    public Clinica clinica;

    public Medicamento(int idMedicamento, String nombreMedicamento, int cantidadDisponible,  Clinica clinica) {
        this.idMedicamento = idMedicamento;
        this.nombreMedicamento = nombreMedicamento;
        this.cantidadDisponible = cantidadDisponible;
        this.formulaMedica = null;
        this.clinica = clinica;
    }

    public Medicamento() {
    }

    @Override

    public String toString() {

        return "- " + nombreMedicamento + ": " + cantidadDisponible;
    }

    public void listarMedicamento(Clinica clinicaCoordinador) {
        handleDB db = new handleDB();
        System.out.println("A continuación verá cada medicamento con su id al frente");
        for (Medicamento medicamento : clinicaCoordinador.listaDeMedicamentos) {
            System.out.println(medicamento.nombreMedicamento + " - id: " + medicamento.idMedicamento);
        }

    }

    public void notificarCantidad(Clinica clinicaCoordinador) {
        for (Medicamento medicamentoClinica : clinicaCoordinador.listaDeMedicamentos) {
            if (medicamentoClinica.cantidadDisponible < 50) {
                System.out.println("Notificación: el medicamento " + medicamentoClinica.nombreMedicamento + "sólo tiene " +
                        medicamentoClinica.cantidadDisponible + "unidades disponibles!");
            }
        }
    }
}
