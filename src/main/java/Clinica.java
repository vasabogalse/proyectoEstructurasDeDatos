import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Clinica implements handleJSON{
    public int nit;
    public String nombreClinica;
    public String direccion;
    public int telefono;
    public List<Clinica> clinicList;

    public Clinica(){
        this.clinicList = new ArrayList<>();
    }

    public Clinica(int nit, String nombreClinica, String direccion, int telefono) {
        this.nit = nit;
        this.nombreClinica = nombreClinica;
        this.direccion = direccion;
        this.telefono = telefono;
        //this.medicamento = medicamento;
        //this.psiquiatra = psiquiatra;
        //this.coordinadorDeClinica = coordinadorDeClinica;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                " nit : " + nit + "," + "\n" +
                " nombreClinica : " + nombreClinica + "," + "\n" +
                " direccion : " + direccion + "," + "\n" +
                " telefono : " + telefono + "\n" +
                '}' + "\n";
    }

    public void setClinicList(List<Clinica> clinicList) {
        this.clinicList = clinicList;
    }

    public List<Clinica> getClinicList() {
        return clinicList;
    }
}
