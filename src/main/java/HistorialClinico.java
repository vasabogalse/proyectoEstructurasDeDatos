import java.util.ArrayList;

public class HistorialClinico implements handleJSON {
    public int idHistClinico;
    // Agregar fecha actual
    public ArrayList<String> antecedentes = new ArrayList<>();
    public ArrayList<String> procedimientos = new ArrayList<>();
    public ArrayList<String> recomendaciones = new ArrayList<>();
    public Psiquiatra psiquiatra;
    public Paciente paciente;
    public ArrayList<FormulaMedica> formulaMedica = new ArrayList<>();

    //Definimos el objeto del handleDB y creamos un método vacío
    handleDB db = new handleDB();
    HistorialClinico() { }

    //Establecemos los get y los set
    public int getIdHistClinico() {
        return idHistClinico;
    }
    public void setIdHistClinico(int idHistClinico) {
        this.idHistClinico = idHistClinico;
    }

    public ArrayList<String> getAntecedentes() {
        return antecedentes;
    }
    public void setAntecedentes(ArrayList<String> antecedentes) {
        this.antecedentes = antecedentes;
    }

    public ArrayList<String> getProcedimientos() {
        return procedimientos;
    }
    public void setProcedimientos(ArrayList<String> procedimientos) {
        this.procedimientos = procedimientos;
    }

    public ArrayList<String> getRecomendaciones() {
        return recomendaciones;
    }
    public void setRecomendaciones(ArrayList<String> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public Psiquiatra getPsiquiatra() {
        return psiquiatra;
    }
    public void setPsiquiatra(Psiquiatra psiquiatra) {
        this.psiquiatra = psiquiatra;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ArrayList<FormulaMedica> getFormulaMedica() { return formulaMedica; }
    public void setFormulaMedica(ArrayList<FormulaMedica> formulaMedica) { this.formulaMedica = formulaMedica; }

    //Creamos los métodos de historial clinico
    public void crearHistClinico(Psiquiatra psiquiatra) {
        System.out.println("Ingrese la cédula del paciente");
        int cedulaPaci = SistemaDeGestionClinica.input.nextInt();

        for (Paciente pacienteSis : db.getPacientes()) {
            if (pacienteSis.getIdPaciente() == cedulaPaci) {
                for (Paciente paciente : psiquiatra.getListaPacientes()) {
                    if (paciente.getIdPaciente() == cedulaPaci) {
                        System.out.println(paciente.getHistorialClinico());
                        if (paciente.getHistorialClinico() == 0) {
                            SistemaDeGestionClinica.input.nextLine();
                            System.out.println("El paciente se encuentra en su lista de pacientes, por favor diligencie la historia clinica.");

                            int idHist = 0;
                            HistorialClinico historialClinico = new HistorialClinico();
                            for (HistorialClinico histClinico : db.getHistoriales()) {
                                idHist = histClinico.idHistClinico;
                            }
                            idHist++;
                            historialClinico.setIdHistClinico(idHist);

                            SistemaDeGestionClinica.input.nextLine();

                            System.out.println();
                            System.out.println("Ingrese algún antecedente. Si no hay antecedente digite N/A.");
                            String antecedentes = SistemaDeGestionClinica.input.nextLine();
                            historialClinico.antecedentes.add(0, antecedentes);
                            if (!antecedentes.equals("N/A") & !antecedentes.equals("n/a") & !antecedentes.equals("N/a") & !antecedentes.equals("n/A")) {
                                while (true) {
                                    System.out.println();
                                    System.out.println("¿Desea agregar otro antecedente?  Y/N");
                                    String opccion = SistemaDeGestionClinica.input.next();
                                    if (opccion.equals("Y") || opccion.equals("y")) {
                                        System.out.println("Ingrese algún antecedente: ");
                                        SistemaDeGestionClinica.input.nextLine();
                                        String antecedentes1 = SistemaDeGestionClinica.input.nextLine();
                                        historialClinico.antecedentes.add(antecedentes1);
                                    } else if (opccion.equals("N") || opccion.equals("n")) {
                                        break;
                                    }
                                }
                            }
                            System.out.println();
                            SistemaDeGestionClinica.input.nextLine();
                            System.out.println("Ingrese algún procedimiento. Si no hay procedimientos digite N/A. ");
                            String procedimientos = SistemaDeGestionClinica.input.nextLine();
                            historialClinico.procedimientos.add(procedimientos);
                            if (!procedimientos.equals("N/A") & !procedimientos.equals("n/a") & !procedimientos.equals("N/a") & !procedimientos.equals("n/A")) {
                                while (true) {
                                    System.out.println("¿Desea agregar otro procedimiento?  Y/N");
                                    String opcion = SistemaDeGestionClinica.input.next();
                                    if (opcion.equals("Y") || opcion.equals("y")) {
                                        System.out.println("Ingrese algún procedimiento: ");
                                        SistemaDeGestionClinica.input.nextLine();
                                        String procedimiento1 = SistemaDeGestionClinica.input.nextLine();
                                        historialClinico.procedimientos.add(procedimiento1);
                                        System.out.println();
                                    } else if (opcion.equals("N") || opcion.equals("n")) {
                                        break;
                                    }
                                }
                            }
                            System.out.println();
                            SistemaDeGestionClinica.input.nextLine();
                            System.out.println("Ingrese alguna recomendación. Si no hay recomendaciones digite N/A. ");
                            String recomendaciones = SistemaDeGestionClinica.input.nextLine();
                            historialClinico.recomendaciones.add(recomendaciones);
                            if (!recomendaciones.equals("N/A") & !recomendaciones.equals("n/a") & !recomendaciones.equals("N/a") & !recomendaciones.equals("n/A")) {
                                while (true) {
                                    System.out.println();
                                    System.out.println("¿Desea agregar otra recomendación?  Y/N");
                                    String opccion = SistemaDeGestionClinica.input.next();
                                    if (opccion.equals("Y") || opccion.equals("y")) {
                                        System.out.println("Ingrese alguna recomendación: ");
                                        SistemaDeGestionClinica.input.nextLine();
                                        String recomendacion1 = SistemaDeGestionClinica.input.nextLine();
                                        historialClinico.recomendaciones.add(recomendacion1);
                                    } else if (opccion.equals("N") || opccion.equals("n")) {
                                        break;
                                    }
                                }
                            }
                            historialClinico.setAntecedentes(historialClinico.antecedentes);
                            historialClinico.setRecomendaciones(historialClinico.recomendaciones);
                            historialClinico.setProcedimientos(historialClinico.procedimientos);

                            int cont = 1;
                            while (true) {
                                System.out.println("¿Desea agregar una fórmula médica a este historial clinico? Y/N");
                                String option1 = SistemaDeGestionClinica.input.next();
                                if (option1.equals("Y") || option1.equals("y")) {
                                    FormulaMedica fm = new FormulaMedica();
                                    fm.crearFormulaMedica();
                                    historialClinico.formulaMedica.add(db.getFormulas().get(db.getFormulas().size() - 1));
                                    break;
                                } else if (option1.equals("N") || option1.equals("n")) {
                                    setFormulaMedica(null);
                                    break;
                                }
                            }
                            paciente.setHistorialClinico(idHist);
                            psiquiatra.getListaHistoriales().add(historialClinico.idHistClinico);
                            db.appendArrayToJSON("pacientes");
                            db.appendArrayToJSON("psiquiatras");
                            historialClinico.setPaciente(paciente);
                            historialClinico.setPsiquiatra(psiquiatra);

                            db.updateJSON(historialClinico, "historiales");
                            System.out.println();
                            System.out.println("La historia clinica se creó correctamente con el id: " + historialClinico.getIdHistClinico());
                            System.out.println();
                            return;
                        } else {
                            System.out.println("El paciente ya tiene un historial clinico registrado.");
                            return;
                        }
                    }
                }
                System.out.println("El paciente no se encuentra en su lista de pacientes.");
                return;
            }
        }
        System.out.println("El paciente no se encuentra registrado en el sistema.");
    }

    public  void editarHistClinico(Psiquiatra psiquiatra) {
        System.out.println("Ingrese la cédula del paciente");
        int cedulaPaci = SistemaDeGestionClinica.input.nextInt();

        for (Paciente pacienteSis : db.getPacientes()){
            if(pacienteSis.getIdPaciente() == cedulaPaci){
                for (Paciente paciente : psiquiatra.getListaPacientes()){
                    if (paciente.getIdPaciente() == cedulaPaci) {
                        for (HistorialClinico historialClinico: db.getHistoriales()){
                            if (historialClinico.getPaciente().getIdPaciente() == cedulaPaci){
                                String option;
                                label:
                                while (true) {
                                    System.out.println();
                                    System.out.println("Escoja la información que desea agregar:");
                                    System.out.println("1. Antecedentes.");
                                    System.out.println("2. Procedimientos.");
                                    System.out.println("3. Recomendaciones.");
                                    System.out.println("4. fórmula médica.");
                                    System.out.println("0. Regresar.");
                                    option = SistemaDeGestionClinica.input.next();
                                    switch (option) {
                                        case "1":
                                            System.out.println("Antecedentes anteriores: ");
                                            for (String antec: historialClinico.getAntecedentes()){
                                                System.out.println("    - " + antec);
                                            }
                                            System.out.println();
                                            SistemaDeGestionClinica.input.nextLine();
                                            System.out.println("Ingrese el nuevo antecedente: ");
                                            String antec = SistemaDeGestionClinica.input.nextLine();
                                            historialClinico.getAntecedentes().add(antec);
                                            while (true) {
                                                System.out.println("¿Desea agregar otro antedecente?  Y/N");
                                                String opcion = SistemaDeGestionClinica.input.next();
                                                if (opcion.equals("Y") || opcion.equals("y")) {
                                                    System.out.println("Ingrese algún antedecente: ");
                                                    SistemaDeGestionClinica.input.nextLine();
                                                    String antc1 = SistemaDeGestionClinica.input.nextLine();
                                                    historialClinico.getAntecedentes().add(antc1);
                                                    System.out.println();
                                                } else if (opcion.equals("N") || opcion.equals("n")) {
                                                    break;
                                                }
                                            }
                                            break;
                                        case "2":
                                            System.out.println("Procedimientos anteriores: ");
                                            for (String procedi: historialClinico.getProcedimientos()){
                                                System.out.println("    - " + procedi);
                                            }
                                            System.out.println();
                                            SistemaDeGestionClinica.input.nextLine();
                                            System.out.println("Ingrese el nuevo procedimiento: ");
                                            String procedi = SistemaDeGestionClinica.input.nextLine();
                                            historialClinico.getProcedimientos().add(procedi);
                                            while (true) {
                                                System.out.println("¿Desea agregar otro procedimiento?  Y/N");
                                                String opcion = SistemaDeGestionClinica.input.next();
                                                if (opcion.equals("Y") || opcion.equals("y")) {
                                                    System.out.println("Ingrese algún procedimiento: ");
                                                    SistemaDeGestionClinica.input.nextLine();
                                                    String procedi1 = SistemaDeGestionClinica.input.nextLine();
                                                    historialClinico.getProcedimientos().add(procedi1);
                                                    System.out.println();
                                                } else if (opcion.equals("N") || opcion.equals("n")) {
                                                    break;
                                                }
                                            }
                                            break;
                                        case "3":
                                            System.out.println("Recomendaciones anteriores: ");
                                            for (String reco: historialClinico.getRecomendaciones()){
                                                System.out.println("    - " + reco);
                                            }
                                            System.out.println();
                                            SistemaDeGestionClinica.input.nextLine();
                                            System.out.println("Ingrese la nueva recomendación: ");
                                            SistemaDeGestionClinica.input.nextLine();
                                            String reco = SistemaDeGestionClinica.input.nextLine();
                                            historialClinico.getRecomendaciones().add(reco);
                                            while (true) {
                                                System.out.println("¿Desea agregar otro recomendación?  Y/N");
                                                String opcion = SistemaDeGestionClinica.input.next();
                                                if (opcion.equals("Y") || opcion.equals("y")) {
                                                    System.out.println("Ingrese alguna recomendación: ");
                                                    SistemaDeGestionClinica.input.nextLine();
                                                    String reco1 = SistemaDeGestionClinica.input.nextLine();
                                                    historialClinico.getRecomendaciones().add(reco1);
                                                    System.out.println();
                                                } else if (opcion.equals("N") || opcion.equals("n")) {
                                                    break;
                                                }
                                            }
                                            break;
                                        case "4":
                                            FormulaMedica fm = new FormulaMedica();
                                            fm.crearFormulaMedica();
                                            historialClinico.formulaMedica.add(db.getFormulas().get(db.getFormulas().size() - 1));
                                            break;
                                        case "0":
                                            break label;
                                    }
                                }
                                db.appendArrayToJSON("historiales");
                                System.out.println("Modificación exitosa.");
                                return;
                            }
                        }
                        System.out.println("El paciente no tiene un historial registrado.");
                        return;
                    }
                }
                System.out.println("El paciente no se encuentra en su lista de pacientes.");
                return;
            }
        }
        System.out.println("El paciente no se encuentra registrado en el sistema.");
    }

    public  void verHistClinico(Psiquiatra psiquiatra) {
        System.out.println("Ingrese la cédula del paciente");
        int cedulaPaci = SistemaDeGestionClinica.input.nextInt();

        for (Paciente pacienteSis : db.getPacientes()){
            if(pacienteSis.getIdPaciente() == cedulaPaci){
                for (Paciente paciente : psiquiatra.getListaPacientes()){
                    if (paciente.getIdPaciente() == cedulaPaci) {
                        for (HistorialClinico historialClinico : db.getHistoriales()){
                            if (historialClinico.getPaciente().getIdPaciente() == cedulaPaci){
                                System.out.println(historialClinico.toString());
                                return;
                            }
                        }
                        System.out.println("El paciente no tiene un historial registrado.");
                        return;
                    }
                }
                System.out.println("El paciente no se encuentra en su lista de pacientes.");
                return;
            }
        }
        System.out.println("El paciente no se encuentra registrado en el sistema.");
    }

    public  void borrarHistClinico(Paciente paciente) {
        int indiceHist =0;
        for (HistorialClinico historialClinico: db.getHistoriales()){
            if (historialClinico.getPaciente().idPaciente == paciente.getIdPaciente()){
                indiceHist = db.getHistoriales().indexOf(historialClinico);

                //Eliminar relación psiquiatra
                for (Psiquiatra psiquiatra: db.getPsiquiatras()){
                    if (historialClinico.getPsiquiatra().getIdPsiquiatra() == psiquiatra.getIdPsiquiatra()){
                        psiquiatra.getListaHistoriales().remove(historialClinico);
                    }
                }

                //Eliminar relación fórmula médica
                int idForMed;
                FormulaMedica formulaMedica = new FormulaMedica();
                int size =historialClinico.getFormulaMedica().size();
                int indice=0;
                while (size >0){
                    String enteroString = null;
                    idForMed =historialClinico.getFormulaMedica().get(size-1).getIdFormulaMedica();
                    enteroString= Integer.toString(idForMed);
                    System.out.println(enteroString);
                    formulaMedica.borrarFormulaMedica(enteroString);
                    indice++;
                    size--;
                }

            }
        }
        db.deleteObjectInArray(indiceHist, "historiales");
    }

    @Override
    public String toString() {
        return "HistorialClinico{" +
                "idHistClinico=" + idHistClinico +
                ", antecedentes=" + antecedentes +
                ", procedimientos=" + procedimientos +
                ", recomendaciones=" + recomendaciones +
                ", psiquiatra=" + psiquiatra +
                ", paciente=" + paciente +
                ", formulaMedica=" + formulaMedica +
                '}';
    }
}
