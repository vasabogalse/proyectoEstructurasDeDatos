public class Clinica implements handleJSON {
    public int nit;
    public String nombreClinica;
    public String direccion;
    public int telefono;
    public Medicamento medicamento;
    public Psiquiatra psiquiatra;
    public CoordinadorDeClinica coordinadorDeClinica;

    public Clinica(int nit, String nombreClinica, String direccion, int telefono) {
        this.nit = nit;
        this.nombreClinica = nombreClinica;
        this.direccion = direccion;
        this.telefono = telefono;
        //this.medicamento = medicamento;
        //this.psiquiatra = psiquiatra;
        //this.coordinadorDeClinica = coordinadorDeClinica;
    }

    //metodos
}
