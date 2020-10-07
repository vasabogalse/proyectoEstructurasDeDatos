import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;

public class handleDB implements handleJSON {
    public static ArrayList<Clinica> clinicas = new ArrayList<>();
    public static ArrayList<Psiquiatra> psiquiatras = new ArrayList<>();
    public static ArrayList<CoordinadorDeClinica> coordinadores = new ArrayList<>();
    public static ArrayList<Paciente> pacientes = new ArrayList<>();
    public static ArrayList<Medicamento> medicamentos = new ArrayList<>();
    public static ArrayList<Cita> citas = new ArrayList<>();
    public static ArrayList<FormulaMedica> formulas = new ArrayList<>();
    public static ArrayList<HistorialClinico> historiales = new ArrayList<>();

    public handleDB(){ }

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

    public void readAllJSON(){
        Clinica clinica = new Clinica();
        Psiquiatra psiquiatra = new Psiquiatra();
        CoordinadorDeClinica coordinador = new CoordinadorDeClinica();
        Paciente paciente = new Paciente();
        Medicamento medicamento = new Medicamento();
        Cita cita = new Cita();
        FormulaMedica formulaMedica = new FormulaMedica();
        HistorialClinico historialClinico = new HistorialClinico();

        clinicas = clinica.readJSON(Clinica.class,"clinicas");
        psiquiatras = psiquiatra.readJSON(Psiquiatra.class,"psiquiatras");
        coordinadores = coordinador.readJSON(CoordinadorDeClinica.class,"coordinadores");
        pacientes = paciente.readJSON(Paciente.class, "pacientes");
        medicamentos = medicamento.readJSON(Medicamento.class,"medicamentos");
        citas = cita.readJSON(Cita.class, "citas");
        formulas = formulaMedica.readJSON(FormulaMedica.class,"formulas");
        historiales = historialClinico.readJSON(HistorialClinico.class,"historiales");

         System.out.println("Clinicas");
         System.out.println(clinicas);
         System.out.println("Psiquiatras");
         System.out.println(psiquiatras);
         System.out.println("Coordinadores");
         System.out.println(coordinadores);
         System.out.println("Pacientes");
         System.out.println(pacientes);
         System.out.println("Medicamentos");
         System.out.println(medicamentos);
         System.out.println("Citas");
         System.out.println(citas);
         System.out.println("Formulas");
         System.out.println(formulas);
         System.out.println("Historiales");
         System.out.println(historiales);
    }

    public <T> void appendObject(T o1, String jsonFile){
        switch (jsonFile){
            case "clinicas":
                Clinica clinica = new Clinica();
                clinicas.add((Clinica) o1);
                clinica.writeJSON(clinicas, "clinicas");
            case "psiquiatras":
                Psiquiatra psiquiatra = new Psiquiatra();
                psiquiatras.add((Psiquiatra) o1);
                psiquiatra.writeJSON(psiquiatras,"psiquiatras");
            case "pacientes":
                Paciente paciente = new Paciente();
                pacientes.add((Paciente) o1);
                paciente.writeJSON(pacientes, "pacientes");
            case "medicamentos":
                Medicamento medicamento = new Medicamento();
                medicamentos.add((Medicamento) o1);
                medicamento.writeJSON(medicamento, "medicamentos");
            case "formulas":
                FormulaMedica formulaMedica = new FormulaMedica();
                formulas.add((FormulaMedica) o1);
                formulaMedica.writeJSON(formulaMedica, "formulas");
            case "citas":
                Cita cita = new Cita();
                citas.add((Cita) o1);
                cita.writeJSON(cita, "citas");
            case "historiales":
                HistorialClinico historialClinico = new HistorialClinico();
                historiales.add((HistorialClinico) o1);
                historialClinico.writeJSON(historialClinico, "historiales");
        }
    }

    public void deleteObject(int index, String jsonFile){
        switch (jsonFile){
            case "clinicas":
                clinicas.remove(index);
                Clinica clinica = new Clinica();
                clinica.writeJSON(clinicas, "clinicas");
            case "psiquiatras":
                psiquiatras.remove(index);
                Psiquiatra psiquiatra = new Psiquiatra();
                psiquiatra.writeJSON(psiquiatras,"psiquiatras");
            case "pacientes":
                pacientes.remove(index);
                Paciente paciente = new Paciente();
                paciente.writeJSON(pacientes, "pacientes");
            case "medicamentos":
                medicamentos.remove(index);
                Medicamento medicamento = new Medicamento();
                medicamento.writeJSON(medicamento, "medicamentos");
            case "formulas":
                formulas.remove(index);
                FormulaMedica formulaMedica = new FormulaMedica();
                formulaMedica.writeJSON(formulaMedica, "formulas");
            case "citas":
                citas.remove(index);
                Cita cita = new Cita();
                cita.writeJSON(cita, "citas");
            case "historiales":
                historiales.remove(index);
                HistorialClinico historialClinico = new HistorialClinico();
                historialClinico.writeJSON(historialClinico, "historiales");
        }
    }

    public <T> void orderArrays(String jsonFile, Function<T, String> func){
        switch (jsonFile){
            case "clinicas":
                Clinica clinica = new Clinica();
                //Collections.sort(clinicas, func.apply);
            case "psiquiatras":
                Psiquiatra psiquiatra = new Psiquiatra();
            case "pacientes":
                Paciente paciente = new Paciente();
            case "medicamentos":
                Medicamento medicamento = new Medicamento();
            case "formulas":
                FormulaMedica formulaMedica = new FormulaMedica();
            case "citas":
                Cita cita = new Cita();
                cita.writeJSON(cita, "citas");
            case "historiales":
                HistorialClinico historialClinico = new HistorialClinico();
        }
    }

    // listar cada una de las clases: Son por lo menos 7 métodos de ordenamiento

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
