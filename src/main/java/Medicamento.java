public class Medicamento implements handleJSON {
    int idMedicamento;
    String nombreMedicamento;
    int cantidadDisponible;

    handleDB db = new handleDB();
    Medicamento() { }

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
