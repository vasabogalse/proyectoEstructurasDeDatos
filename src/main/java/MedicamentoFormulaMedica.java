public class MedicamentoFormulaMedica implements handleJSON{

    //Definimos el objeto
    String nombreMedicamento;
    String dosis;
    String frecuencia;
    String diasTratamiento;
    int cantidadRetirada;

    //Definimos el objeto del handleDB y creamos un método vacío
    handleDB db = new handleDB();
    MedicamentoFormulaMedica(){}

    //Establecemos los get y los set
    public String getDosis() {
        return dosis;
    }
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFrecuencia() {
        return frecuencia;
    }
    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDiasTratamiento() {
        return diasTratamiento;
    }
    public void setDiasTratamiento(String diasTratamiento) {
        this.diasTratamiento = diasTratamiento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }
    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public int getCantidadRetirada() { return cantidadRetirada; }
    public void setCantidadRetirada(int cantidadRetirada) { this.cantidadRetirada = cantidadRetirada; }

    //Definimos la salida
    @Override
    public String toString() {
        return  "\n"+
                "Nombre: " + nombreMedicamento + "\n" +
                "Dosis: " + dosis + "\n" +
                "Frecuencia: " + frecuencia + "\n" +
                "Dias de tratamiento: " + diasTratamiento + "\n";
    }

    //Creamos los métodos de Medicamentos para Formula Médica.

    public void receta(Psiquiatra psiquiatra){
        System.out.println("Elija un medicamento de la siguiente lista:");
        Medicamento med = new Medicamento();
        Clinica clinica = new Clinica();
        for (Clinica cl : db.getClinicas()){
            if (psiquiatra.getClinicaPsiquiatra() == cl.getNit()){
                clinica=cl;
            }
        }
        med.listarMedicamento(clinica);
        System.out.println();
        System.out.println("Ingrese el id del medicamento.");
        SistemaDeGestionClinica.input.nextLine();
        String idMedicamento = SistemaDeGestionClinica.input.nextLine();
        int numI =0;
        char [] cadenaDivId = idMedicamento.toCharArray();
        String i = "";
        for (char cadenaDivIdi : cadenaDivId) {
            if (Character.isDigit(cadenaDivIdi)) { //Verifica que haya un número
                i += cadenaDivIdi;
            }else if (i.equals("")) {
                System.out.println("Dato inválido.");
                return;
            }
            numI = Integer.parseInt(i);
        }
        int cont = 0;
        for (Medicamento medicamentoFm : db.getMedicamentos()){
            if (numI == medicamentoFm.getIdMedicamento() ){
                if (medicamentoFm.getCantidadDisponible() > 0){
                    System.out.println();
                    System.out.println("Ingrese la dosis del medicamento:  (Pastillas(und) / Jarabe(frasco 100ml) / Inyecciones(Ampolla).");
                    String dosis = SistemaDeGestionClinica.input.nextLine();
                    int numD =0;
                    char [] cadenaDivDosis = dosis.toCharArray();
                    String d = "";
                    for (char cadenaDivDosi : cadenaDivDosis) {
                        if (Character.isDigit(cadenaDivDosi)) { //Verifica que haya un número
                            d += cadenaDivDosi;
                        }else if (d.equals("")) {
                            System.out.println("Dato inválido, ingrese de nuevo la dosis.");
                            return;
                        }
                        numD = Integer.parseInt(d);
                    }

                    SistemaDeGestionClinica.input.nextLine();

                    System.out.println("Ingrese la frecuencia con la que debe ser consumida el medicamento (veces al día).");

                    String frecuencia = SistemaDeGestionClinica.input.nextLine();
                    char [] cadenaDivFrecuen = frecuencia.toCharArray();
                    int numF =0;
                    String f = "";
                    for (char cadenaDivFrecueni : cadenaDivFrecuen) {
                        if (Character.isDigit(cadenaDivFrecueni)) { //Verifica que haya un número
                            f += cadenaDivFrecueni;
                        }else if (f.equals("")) {
                            System.out.println("Dato inválido, ingrese de nuevo la frecuencia.");
                            return;
                        }
                        numF = Integer.parseInt(f);
                    }
                    SistemaDeGestionClinica.input.nextLine();
                    System.out.println("Ingrese la duración del tratamiento(días).");

                    String diasTratameinto = SistemaDeGestionClinica.input.nextLine();
                    int numT = 0;
                    char [] cadenaDivdiasTratamiento = diasTratameinto.toCharArray();
                    String t = "";
                    for (char cadenaDivdiasTratamientoi : cadenaDivdiasTratamiento) {
                        if (Character.isDigit(cadenaDivdiasTratamientoi)) { //Verifica que haya un número
                            t += cadenaDivdiasTratamientoi;
                        }else if (t.equals("")) {
                            System.out.println("Dato inválido, ingrese de nuevo la duración  del tratamiento.");
                            return;
                        }
                        numT = Integer.parseInt(t);
                    }
                    if (medicamentoFm.getCantidadDisponible()  >= numD * numF * numT) {
                        System.out.println();
                        System.out.println("¿Esta seguro de que desea recetar este medicamento: " + medicamentoFm.getNombreMedicamento() + " con una dosis de: " + dosis + " y una frecuencia de: " + frecuencia + " durante: " + diasTratameinto + "?  Y/N");
                        String option = SistemaDeGestionClinica.input.next();
                        if (option.equals("Y")||option.equals("y")) {
                            MedicamentoFormulaMedica medicamentoFormMed = new MedicamentoFormulaMedica();
                            medicamentoFormMed.setDosis(dosis);
                            medicamentoFormMed.setDiasTratamiento(diasTratameinto);
                            medicamentoFormMed.setFrecuencia(frecuencia);
                            medicamentoFormMed.setNombreMedicamento(medicamentoFm.getNombreMedicamento());
                            db.updateJSON(medicamentoFormMed, "medicamentoFormulaMedica");
                            medicamentoFm.setCantidadDisponible(medicamentoFm.getCantidadDisponible() - numD * numF * numT);
                            db.getMedicamentos().add(medicamentoFm);
                            db.appendArrayToJSON("medicamentos");
                            System.out.println();
                            System.out.println("Medicamento ingresado correctamente.");
                            System.out.println();
                            medicamentoFormMed.setCantidadRetirada(numD * numF * numT);
                            cont++;
                            break;
                        } else if (option.equals("N")||option.equals("n")) {
                            MedicamentoFormulaMedica medicamentoFormMed = null;
                            System.out.println();
                            System.out.println("Vuelve a ingresar los datos.");
                            System.out.println();
                            db.updateJSON(medicamentoFormMed, "medicamentoFormulaMedica");
                            cont++;
                            break;
                        }else{
                            System.out.println();
                            System.out.println("Respuesta inválida.");
                            System.out.println();
                            MedicamentoFormulaMedica medicamentoFormMed = null;
                            db.updateJSON(medicamentoFormMed, "medicamentoFormulaMedica");
                            cont++;
                            break;
                        }
                    } else {
                        MedicamentoFormulaMedica medicamentoFormMed = null;
                        System.out.println();
                        System.out.println("No hay suficientes unidades de este medicamento disponibles.");
                        cont++;
                        db.updateJSON(medicamentoFormMed, "medicamentoFormulaMedica");
                        break;
                    }
                }else{
                    MedicamentoFormulaMedica medicamentoFormMed = null;
                    System.out.println();
                    System.out.println("No hay unidades disponibles de este medicamento.");
                    cont++;
                    db.updateJSON(medicamentoFormMed, "medicamentoFormulaMedica");
                    break;
                }
            }else{
                MedicamentoFormulaMedica medicamentoFormMed = null;
                db.updateJSON(medicamentoFormMed, "medicamentoFormulaMedica");
            }
        }
        if (cont == 0){
            System.out.println("Este medicamento no está registrado en el sistema.");
        }
    }
}
