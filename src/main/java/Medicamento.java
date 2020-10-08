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
        System.out.println("A continuación verá cada medicamento con el numero respectivo con el que lo seleccionara" +
                ", el nombre y la cantidad disponible");
        for (int i = 0; i < clinicaCoordinador.listaDeMedicamentos.size(); i++) {
            System.out.println((i + 1) + " - " + nombreMedicamento + ": " + cantidadDisponible);
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
