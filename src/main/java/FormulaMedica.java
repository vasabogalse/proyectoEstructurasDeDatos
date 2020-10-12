import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FormulaMedica implements handleJSON{

    //Definimos el objeto
    int idFormulaMedica;
    Date fechaFormulacion;
    ArrayList<MedicamentoFormulaMedica> medicamentoFM = new ArrayList<>();

    //Definimos el objeto del handleDB y creamos un método vacío
    handleDB db = new handleDB();
    FormulaMedica(){}

    //Establecemos los get y los set
    public int getIdFormulaMedica() {
        return idFormulaMedica;
    }
    public void setIdFormulaMedica(int idFormulaMedica) {
        this.idFormulaMedica = idFormulaMedica;
    }

    public Date getFechaFormulacion() {
        return fechaFormulacion;
    }
    public void setFechaFormulacion(Date fechaFormulacion) {
        this.fechaFormulacion = fechaFormulacion;
    }

    public ArrayList<MedicamentoFormulaMedica> getMedicamentoFM() { return medicamentoFM; }
    public void setMedicamentoFM(ArrayList<MedicamentoFormulaMedica> medicamentoFM) { this.medicamentoFM = medicamentoFM; }

    //Creamos una variable global para la fecha
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //Creamos los métodos de fórmula médica
    public void crearFormulaMedica(){
        int idForMed = 0;
        for (FormulaMedica forMed : db.getFormulas()) { idForMed = forMed.idFormulaMedica; }
        idForMed++;
        FormulaMedica formulaMedica = new FormulaMedica();
        formulaMedica.setIdFormulaMedica(idForMed);
        Date fechaActual = new Date();
        formulaMedica.setFechaFormulacion(fechaActual);
        MedicamentoFormulaMedica mfm = new MedicamentoFormulaMedica();
        mfm.receta();
        formulaMedica.medicamentoFM.add(db.getMedicamentoForMed().get(db.getMedicamentoForMed().size() - 1));
        int index = formulaMedica.medicamentoFM.lastIndexOf(null);
        if(index == formulaMedica.medicamentoFM.size()-1){
            formulaMedica.medicamentoFM.remove(index);
        }
        while(db.getMedicamentoForMed().contains(null)){
            db.getMedicamentoForMed().remove(null);}
        db.appendArrayToJSON("medicamentoFormulaMedica");
        while (true) {
            System.out.println();
            System.out.println("¿Desea agregar otro medicamento a esta fórmula médica? Y/N");
            String option1 = SistemaDeGestionClinica.input.next();
            if (option1.equals("Y") || option1.equals("y")) {
                mfm.receta();
                formulaMedica.medicamentoFM.add(db.getMedicamentoForMed().get(db.getMedicamentoForMed().size() - 1));
                    int index1 = formulaMedica.medicamentoFM.lastIndexOf(null);
                    if(index1 == formulaMedica.medicamentoFM.size()-1){
                        formulaMedica.medicamentoFM.remove(index1);
                    }
                while(db.getMedicamentoForMed().contains(null)){
                    db.getMedicamentoForMed().remove(null);}
                db.appendArrayToJSON("medicamentoFormulaMedica");
            } else if (option1.equals("N") || option1.equals("n")) {
                if (formulaMedica.medicamentoFM.isEmpty()) {
                    return;
                }
                while(db.getMedicamentoForMed().contains(null)){
                db.getMedicamentoForMed().remove(null);}
                db.appendArrayToJSON("medicamentoFormulaMedica");
                break;
            }
        }
        db.updateJSON(formulaMedica, "formulas");
        System.out.println();
        System.out.println("La fórmula médica se creó correctamente con el id: " + formulaMedica.getIdFormulaMedica());
        System.out.println();
    }

    public void verFormulaMedica(){
        int count = 0;
        for (FormulaMedica forMed : db.getFormulas()) {
            if (db.getFormulas().size()>0) {
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Id: "+forMed.idFormulaMedica);
                System.out.println("Fecha: " + sdf.format(forMed.fechaFormulacion));
                System.out.println();
                System.out.println("Medicamentos:");
                if (forMed.medicamentoFM.size()>0) {
                    System.out.println("---------------------------------------------------------------------------------");
                    for(int i=0; i<forMed.medicamentoFM.size(); i++) {
                        int n= i+1;
                        System.out.println(n+". " + forMed.medicamentoFM.get(i));
                    }
                    System.out.println("---------------------------------------------------------------------------------");
                    count++;
                } else {
                    System.out.println();
                    System.out.println("No hay médicamentos registrados en esta fórmula médica");
                    System.out.println("---------------------------------------------------------------------------------");
                    count++;
                    break;
                }
            }
        }
        if (count==0){
            System.out.println();
        System.out.println("Primero ingrese alguna fórmula médica");
        }
    }

    public void borrarFormulaMedica(){
        System.out.println();
        System.out.println("Ingrese el id de la fórmula médica que desea borrar");
        SistemaDeGestionClinica.input.nextLine();
        String idFM = SistemaDeGestionClinica.input.nextLine();
        int numFM =0;
        char [] cadenaDivIdFM = idFM.toCharArray();
        String i = "";
        for (char cadenaDivIdFMi : cadenaDivIdFM) {
            if (Character.isDigit(cadenaDivIdFMi)) {
                i += cadenaDivIdFMi;
            }else if (i.equals("")) {
                System.out.println("Dato inválido.");
                return;
            }
            numFM = Integer.parseInt(i);
        }
        int count = 0;
        for (FormulaMedica ForMed : db.getFormulas()) {
            if (ForMed.idFormulaMedica == numFM) {
                int index = db.getFormulas().indexOf(ForMed);
                System.out.println("¿Está seguro de que quiere borrar esta fórmula médica? Y/N");
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Id: "+ForMed.idFormulaMedica);
                System.out.println("Fecha: " + sdf.format(ForMed.fechaFormulacion));
                System.out.println();
                System.out.println("Medicamentos:");
                System.out.println();
                if (ForMed.medicamentoFM.size()>0) {
                    System.out.println("---------------------------------------------------------------------------------");
                    for(int j=0; j<ForMed.medicamentoFM.size(); j++) {
                        int n= j+1;
                        System.out.println(n+". " + ForMed.medicamentoFM.get(j));
                    }
                    System.out.println("---------------------------------------------------------------------------------");
                }
                while (true) {
                    String opccion = SistemaDeGestionClinica.input.next();
                    if (opccion.equals("Y")||opccion.equals("y")) {
                        int posicion = 0;
                        for (FormulaMedica forMedi : db.getFormulas()){
                            if (db.getFormulas().indexOf(forMedi) != index){
                                posicion += forMedi.medicamentoFM.size();
                            }else{
                                break;
                            }
                        }
                        for (MedicamentoFormulaMedica medFor: ForMed.medicamentoFM) {
                            for (Medicamento med : db.getMedicamentos()) {
                                if (med.getNombreMedicamento().equals(medFor.getNombreMedicamento())) {
                                    med.setCantidadDisponible(med.getCantidadDisponible() + medFor.getCantidadRetirada());
                                }
                            }
                            db.appendArrayToJSON("medicamentos");
                            db.deleteObjectInArray(posicion, "medicamentoFormulaMedica");
                        }
                        db.deleteObjectInArray(index, "formulas");
                        System.out.println("Fórmula médica borrada con exito.");
                        return;
                    } else if (opccion.equals("N")||opccion.equals("n")) {
                        count++;
                        break;
                    }
                }
            }
        }
        if(count==0) {
            System.out.println("Esta fórmula médica no se encuentra en el registro.");
        }
    }
}








