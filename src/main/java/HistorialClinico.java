import java.util.ArrayList;

public class HistorialClinico implements handleJSON {
    public int idHistClinico;
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


        for (Paciente pacienteSis : db.getPacientes()){
            if (pacienteSis.getIdPaciente() == cedulaPaci){
                for (Paciente paciente : psiquiatra.getListaPacientes()){
                    if (paciente.getIdPaciente() == cedulaPaci){
                        if (paciente.getHistorialClinico() == 0){
                            SistemaDeGestionClinica.input.nextLine();
                            System.out.println("El paciente se encuentra en su lista de pacientes, por favor diligencie la historia clinica.");

                            int idHist = 0;
                            HistorialClinico historialClinico = new HistorialClinico();
                            for (HistorialClinico histClinico : db.getHistoriales()) { idHist = histClinico.idHistClinico; }
                            idHist++;
                            historialClinico.setIdHistClinico(idHist);

                            SistemaDeGestionClinica.input.nextLine();

                            System.out.println();
                            System.out.println("Ingrese algún antecedente. Si no hay antecedente digite N/A.");
                            String antecedentes = SistemaDeGestionClinica.input.nextLine();
                            historialClinico.antecedentes.add(0, antecedentes);
                            if (!antecedentes.equals("N/A")&!antecedentes.equals("n/a")&!antecedentes.equals("N/a")&!antecedentes.equals("n/A")) {
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
                            System.out.println("Ingrese alguna recomendación. Si no hay recomendaciones digite N/A. ");
                            String recomendaciones = SistemaDeGestionClinica.input.nextLine();
                            historialClinico.recomendaciones.add(recomendaciones);
                            if (!recomendaciones.equals("N/A")&!recomendaciones.equals("n/a")&!recomendaciones.equals("N/a")&!recomendaciones.equals("n/A")) {
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
                            System.out.println();
                            SistemaDeGestionClinica.input.nextLine();
                            System.out.println("Ingrese algún procedimiento. Si no hay procedimientos digite N/A. ");
                            String procedimientos = SistemaDeGestionClinica.input.nextLine();
                            historialClinico.procedimientos.add(procedimientos);
                            if (!procedimientos.equals("N/A")&!procedimientos.equals("n/a")&!procedimientos.equals("N/a")&!procedimientos.equals("n/A")) {
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
                            historialClinico.setAntecedentes(historialClinico.antecedentes);
                            historialClinico.setRecomendaciones(historialClinico.recomendaciones);
                            historialClinico.setProcedimientos(historialClinico.procedimientos);

                            int cont=1;
                            while (true) {
                                System.out.println("¿Desea agregar una fórmula médica a este historial clinico? Y/N");
                                String option1 = SistemaDeGestionClinica.input.next();
                                if (option1.equals("Y") || option1.equals("y")) {
                                    FormulaMedica fm = new FormulaMedica();
                                    fm.crearFormulaMedica();
                                    historialClinico.formulaMedica.add(db.getFormulas().get(db.getFormulas().size()-1));
                                    break;
                                } else if (option1.equals("N") || option1.equals("n")) {
                                    setFormulaMedica(null);
                                    break;
                                }
                            }
                            paciente.setHistorialClinico(historialClinico.getIdHistClinico());
                            psiquiatra.getListaHistoriales().add(historialClinico.idHistClinico);
                            db.appendArrayToJSON("pacientes");
                            db.appendArrayToJSON("psiquiatras");
                            historialClinico.setPaciente(paciente);
                            historialClinico.setPsiquiatra(psiquiatra);

                            db.updateJSON(historialClinico, "historiales");
                            System.out.println();
                            System.out.println("La historia clinica se creó correctamente con el id: " + historialClinico.getIdHistClinico());
                            System.out.println();
                        }else{
                            System.out.println("El paciente ya tiene un historial clinico registrado.");
                        }
                    }
                }
                System.out.println("El paciente no se encuentra en su lista de pacientes.");
            }
        }
        System.out.println("El paciente no se encuentra registrado en el sistema.");


    }

    public static void editarHistClinico() {
        System.out.println("Ingrese la cédula del paciente a quien corresponde la historia médica");
        String cedulaPaciente = SistemaDeGestionClinica.input.nextLine();
        //me busca en las formulas medicas la cedula del paciente.
    }
    public static void borrarHistClinico() {
    }
    public static void verHistClinico() {
    }

}

}
