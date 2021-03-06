import java.util.ArrayList;

public class handleDB implements handleJSON {
    // arreglos de estado actual de los JSON y operativos
    public static ArrayList<Clinica> clinicas = new ArrayList<>();
    public static ArrayList<Psiquiatra> psiquiatras = new ArrayList<>();
    public static ArrayList<CoordinadorDeClinica> coordinadores = new ArrayList<>();
    public static ArrayList<Paciente> pacientes = new ArrayList<>();
    public static ArrayList<Medicamento> medicamentos = new ArrayList<>();
    public static ArrayList<Cita> citas = new ArrayList<>();
    public static ArrayList<FormulaMedica> formulas = new ArrayList<>();
    public static ArrayList<HistorialClinico> historiales = new ArrayList<>();
    public static ArrayList<MedicamentoFormulaMedica> medicamentoForMed = new ArrayList<>();

    public handleDB(){ }

    // getters
    public ArrayList<Clinica> getClinicas() {
        return clinicas;
    }
    public ArrayList<Psiquiatra> getPsiquiatras() {
        return psiquiatras;
    }
    public ArrayList<CoordinadorDeClinica> getCoordinadores() {
        return coordinadores;
    }
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }
    public ArrayList<Cita> getCitas() {
        return citas;
    }
    public ArrayList<FormulaMedica> getFormulas() {
        return formulas;
    }
    public ArrayList<HistorialClinico> getHistoriales() {
        return historiales;
    }
    public ArrayList<MedicamentoFormulaMedica> getMedicamentoForMed() { return medicamentoForMed; }

    public void readAllJSON(){
        Clinica clinica = new Clinica();
        Psiquiatra psiquiatra = new Psiquiatra();
        CoordinadorDeClinica coordinador = new CoordinadorDeClinica();
        Paciente paciente = new Paciente();
        Medicamento medicamento = new Medicamento();
        Cita cita = new Cita();
        FormulaMedica formulaMedica = new FormulaMedica();
        HistorialClinico historialClinico = new HistorialClinico();
        MedicamentoFormulaMedica medicamentoFormulaMedica = new MedicamentoFormulaMedica();

        clinicas = clinica.readJSON(Clinica.class,"clinicas");
        psiquiatras = psiquiatra.readJSON(Psiquiatra.class,"psiquiatras");
        coordinadores = coordinador.readJSON(CoordinadorDeClinica.class,"coordinadores");
        pacientes = paciente.readJSON(Paciente.class, "pacientes");
        medicamentos = medicamento.readJSON(Medicamento.class,"medicamentos");
        citas = cita.readJSON(Cita.class, "citas");
        formulas = formulaMedica.readJSON(FormulaMedica.class,"formulas");
        historiales = historialClinico.readJSON(HistorialClinico.class,"historiales");
        medicamentoForMed = medicamentoFormulaMedica.readJSON(MedicamentoFormulaMedica.class, "medicamentoFormulaMedica");
    }

    public <T> void updateJSON(T o1, String jsonFile){
        switch (jsonFile){
            case "clinicas":
                clinicas.add((Clinica) o1);
                break;
            case "psiquiatras":
                psiquiatras.add((Psiquiatra) o1);
                break;
            case "pacientes":
                pacientes.add((Paciente) o1);
                break;
            case "medicamentos":
                medicamentos.add((Medicamento) o1);
                break;
            case "formulas":
                formulas.add((FormulaMedica) o1);
                break;
            case "citas":
                citas.add((Cita) o1);
                break;
            case "historiales":
                historiales.add((HistorialClinico) o1);
                break;
            case "medicamentoFormulaMedica" :
                medicamentoForMed.add((MedicamentoFormulaMedica) o1);
                break;
        }
        appendArrayToJSON(jsonFile);
    }

    public void appendArrayToJSON(String jsonFile){
        switch (jsonFile) {
            case "clinicas":
                Clinica clinica = new Clinica();
                clinica.writeJSON(clinicas, "clinicas");
                break;
            case "psiquiatras":
                Psiquiatra psiquiatra = new Psiquiatra();
                psiquiatra.writeJSON(psiquiatras, "psiquiatras");
                break;
            case "pacientes":
                Paciente paciente = new Paciente();
                paciente.writeJSON(pacientes, "pacientes");
                break;
            case "medicamentos":
                Medicamento medicamento = new Medicamento();
                medicamento.writeJSON(medicamento, "medicamento");
                break;
            case "formulas":
                FormulaMedica formula = new FormulaMedica();
                formula.writeJSON(formulas, "formulas");
                break;
            case "citas":
                Cita cita = new Cita();
                cita.writeJSON(citas, "citas");
                break;
            case "historiales":
                HistorialClinico historial = new HistorialClinico();
                historial.writeJSON(historiales, "historiales");
                break;
            case "medicamentoFormulaMedica" :
                MedicamentoFormulaMedica medicamentoFormulaMedica = new MedicamentoFormulaMedica();
                medicamentoFormulaMedica.writeJSON(medicamentoForMed, "medicamentoFormulaMedica");
                break;
        }
    }

    public void deleteObjectInArray(int index, String jsonFile){
        switch (jsonFile){
            case "clinicas":
                clinicas.remove(index);
                break;
            case "psiquiatras":
                psiquiatras.remove(index);
                break;
            case "pacientes":
                pacientes.remove(index);
                break;
            case "medicamentos":
                medicamentos.remove(index);
                break;
            case "formulas":
                formulas.remove(index);
                break;
            case "citas":
                citas.remove(index);
                break;
            case "historiales":
                historiales.remove(index);
                break;
            case "medicamentoFormulaMedica" :
                medicamentoForMed.remove(index);
                break;
        }
        appendArrayToJSON(jsonFile);
    }

    public Paciente buscarPaciente(String id){
        Paciente paciente = new Paciente();
        for (Paciente pc : pacientes){
            if (pc.getIdPaciente().equals(id)){
                paciente=pc;
            }
        }
        return paciente;
    }

    @Override
    public String toString() {
        return "handleDB{" +
                "clinicas=" + clinicas +
                ", psiquiatras=" + psiquiatras +
                ", coordinadores=" + coordinadores +
                ", pacientes=" + pacientes +
                ", medicamentos=" + medicamentos +
                ", citas=" + citas +
                ", formulas=" + formulas +
                ", historiales=" + historiales +
                '}';
    }
}
