import java.util.ArrayList;
import java.util.List;

public class DataManagement implements handleJSON {

    public List<Clinica> clinicList;
    public List<Psiquiatra> psychiatristsList;
    public List<Paciente> pacientsList;
    public List<Medicamento> medicamentList;
    public List<HistorialClinico> clinicHistorialList;
    public List<FormulaMedica> medicFormuleList;
    public List<Cita> appointmentList;

    //Constructor definition with no parameters
    public DataManagement(){
        this.clinicList = new ArrayList<>();
    }


    //Setters in order to assing an arrayList to the list
    public void setClinicList(List<Clinica> clinicList) {
        this.clinicList = clinicList;
    }
/*
    public void setPsychiatristsList(List<Psiquiatra> psychiatristsList) {
        this.psychiatristsList = psychiatristsList;
    }

    public void setPacientsList(List<Paciente> pacientsList) {
        this.pacientsList = pacientsList;
    }

    public void setMedicamentList(List<Medicamento> medicamentList) {
        this.medicamentList = medicamentList;
    }

    public void setClinicHistorialList(List<HistorialClinico> clinicHistorialList) {
        this.clinicHistorialList = clinicHistorialList;
    }

    public void setMedicFormuleList(List<FormulaMedica> medicFormuleList) {
        this.medicFormuleList = medicFormuleList;
    }

    public void setAppointmentList(List<Cita> appointmentList) {
        this.appointmentList = appointmentList;
    }*/

    //Default getter methods
    public List<Clinica> getClinicList() {
        return clinicList;
    }
/*
    public List<Psiquiatra> getPsychiatristsList() {
        return psychiatristsList;
    }

    public List<Paciente> getPacientsList() {
        return pacientsList;
    }

    public List<Medicamento> getMedicamentList() {
        return medicamentList;
    }

    public List<HistorialClinico> getClinicHistorialList() {
        return clinicHistorialList;
    }

    public List<FormulaMedica> getMedicFormuleList() {
        return medicFormuleList;
    }

    public List<Cita> getAppointmentList() {
        return appointmentList;
    }
    */
}
