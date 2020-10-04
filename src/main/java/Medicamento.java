public class Medicamento {
    public String idMedicamento;
    public String nombreMedicamento;
    public int cantidadDisponible;
    public FormulaMedica formulaMedica;
    public Clinica clinica;

    public Medicamento(String idMedicamento, String nombreMedicamento, int cantidadDisponible, FormulaMedica formulaMedica, Clinica clinica) {
        this.idMedicamento = idMedicamento;
        this.nombreMedicamento = nombreMedicamento;
        this.cantidadDisponible = cantidadDisponible;
        this.formulaMedica = formulaMedica;
        this.clinica = clinica;
    }

    @Override

    public String toString() {
        return "- " + nombreMedicamento + ": " + cantidadDisponible;
    }

    public void listarMedicamentos() {
        for (Medicamento medicamento : clinica.medicamento) {
            System.out.println("- " + nombreMedicamento + ": " + cantidadDisponible);
        }
    }

    public void notificarCantidad() {
        for (Medicamento medicamento : clinica.medicamento) {
            if (medicamento.cantidadDisponible < 50) {
                System.out.println("Notificación: el medicamento " + medicamento.nombreMedicamento +
