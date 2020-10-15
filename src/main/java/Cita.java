import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Cita implements handleJSON {
    public int idCita;
    public String estadoCita;
    public Boolean prioridad;
    public int paciente;
    public int psiquitra;
    public Calendar fechaCita = new GregorianCalendar();

    handleDB db = new handleDB();
    public Cita() { }

    public static Psiquiatra psiquiatra = new Psiquiatra();

    //Establecemos los get y los set
    public int getIdCita() {
        return idCita;
    }
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Calendar getFechaCita() {
        return fechaCita;
    }
    public void setFechaCita(Calendar fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getEstadoCita() {
        return estadoCita;
    }
    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public Boolean getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(Boolean prioridad) {
        this.prioridad = prioridad;
    }

    public int getPaciente() {
        return paciente;
    }
    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }
    public int getPsiquitra() {
        return psiquitra;
    }
    public void setPsiquitra(int psiquitra) {
        this.psiquitra = psiquitra;
    }

    public void crearCita(Paciente paciente) {
        int idCitas = 0;
        for (Cita citas : db.getCitas()) {
            idCitas = citas.idCita;
        }
        idCitas++;
        Cita cita = new Cita();
        cita.setIdCita(idCitas);
        cita.setPrioridad(false);
        cita.setEstadoCita("Pendiente");
        //paciente
        agendar();
        if(getFechaCita().get(Calendar.HOUR_OF_DAY)==0){
            return;
        }
        cita.setFechaCita(getFechaCita());
        for (Psiquiatra pq: db.getPsiquiatras()){
            if (paciente.getPsiquiatra() == pq.getIdPsiquiatra()){
                psiquiatra = pq;
            }
        }
     /*   cita.setPaciente(paciente.idPaciente);
        cita.setPsiquitra(psiquiatra.getIdPsiquiatra());

        paciente.getListaCitas().add(cita);
        psiquiatra.getListaCitas().add(cita);
        int indice = 0;
        for (Paciente pc : psiquiatra.getListaPacientes()){
            if (paciente.getIdPaciente()== pc.getIdPaciente()){
              indice = psiquiatra.getListaPacientes().indexOf(pc);
            }
        }
        psiquiatra.getListaPacientes().get(indice).getListaCitas().add(cita);
        db.appendArrayToJSON("pacientes");
        db.appendArrayToJSON("psiquiatras");*/
        db.updateJSON(cita, "citas");
    }
    public void verCita(){
        int count = 0;
        for (Cita cita : db.getCitas()) {
            if (db.getCitas().size()>0) {
                cita.getFechaCita().setTimeZone(TimeZone.getTimeZone("America/Bogota"));
                System.out.println();
                System.out.println("Paciente: " + "cedula:" );
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Id: "+cita.idCita);
                if (cita.prioridad.equals(false)){
                    System.out.println("Tipo: GENERAL. ");
                }else{
                    System.out.println("Tipo: PRIORITARIA. ");
                }
                System.out.println("Fecha: "+ cita.fechaCita.get(Calendar.DATE) +"/" + (cita.fechaCita.get(Calendar.MONTH)+1) +"/"+ cita.fechaCita.get(Calendar.YEAR)+".");
                if (cita.fechaCita.get(Calendar.HOUR_OF_DAY)<12){
                    System.out.println("Hora: "+ cita.fechaCita.get(Calendar.HOUR) +":"+ cita.fechaCita.get(Calendar.MINUTE)+"0 AM.");
                }else{
                    System.out.println("Hora: "+ cita.fechaCita.get(Calendar.HOUR) +":"+ cita.fechaCita.get(Calendar.MINUTE)+"0 PM.");
                }

                System.out.println("Estado: "+cita.estadoCita);
                System.out.println("Especialista: "+ psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                //System.out.println("Clinica: "+cita.psiquiatra);
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------");
                count++;
            }
        }
        if (count==0){
            System.out.println();
            System.out.println("Primero ingrese alguna cita.");
        }
    }
    public void cancelarCita(){
        for(Cita citas: db.getCitas()){
            citas.verCita();
            break;
        }
        System.out.println("Ingrese el id de la cita que desea cancelar.");
        String idc = SistemaDeGestionClinica.input.next();
        int numC = 0;
        char[] cadenaDivIdc = idc.toCharArray();
        String c = "";
        for (char cadenaDivIdci : cadenaDivIdc) {
            if (Character.isDigit(cadenaDivIdci)) { //Verifica que haya un número
                c += cadenaDivIdci;
            } else if (c.equals("")) {
                System.out.println("Dato inválido.");
                return;
            }
            numC = Integer.parseInt(c);
        }
        int count = 0;
        for (Cita cita : db.getCitas()){
            cita.getFechaCita().setTimeZone(TimeZone.getTimeZone("America/Bogota"));
            if (cita.idCita == numC) {
                count++;
                System.out.println("¿Está seguro de que quiere cancelar esta cita? Y/N");
                System.out.println();
                System.out.println("Paciente: " + "cedula:" );
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Id: "+cita.idCita);
                if (cita.prioridad.equals(false)){
                    System.out.println("Tipo: GENERAL.");
                }else{
                    System.out.println("Tipo: PRIORITARIA.");
                }
                System.out.println("Fecha: "+ cita.fechaCita.get(Calendar.DATE) +"/" + (cita.fechaCita.get(Calendar.MONTH)+1) +"/"+ cita.fechaCita.get(Calendar.YEAR)+".");
                if (cita.fechaCita.get(Calendar.HOUR_OF_DAY)<12){
                    System.out.println("Hora: "+ cita.fechaCita.get(Calendar.HOUR) +":"+ cita.fechaCita.get(Calendar.MINUTE)+"0 AM.");
                }else{
                    System.out.println("Hora: "+ cita.fechaCita.get(Calendar.HOUR) +":"+ cita.fechaCita.get(Calendar.MINUTE)+"0 PM.");
                }
                System.out.println("Estado: "+cita.estadoCita);
                System.out.println("Especialista: "+ psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------");
                while (true) {
                    String opccion = SistemaDeGestionClinica.input.next();
                    if (opccion.equals("Y")||opccion.equals("y")) {
                        int index = db.getCitas().indexOf(cita);
                        db.deleteObjectInArray(index, "citas");
                        System.out.println("Cita cancelada con exito.");
                        return;
                    } else if (opccion.equals("N")||opccion.equals("n")) {
                        break;
                    }
                }
            }
        }
        if(count==0) {
            System.out.println("Esta cita no se encuentra en el registro.");
        }
    }
    public void editarCita(){
        for(Cita citas: db.getCitas()){
            citas.verCita();
            break;
        }
        System.out.println("Ingrese el id de la cita que desea modificar.");
        String idC = SistemaDeGestionClinica.input.next();
        int numC =0;
        char [] cadenaDivIdC = idC.toCharArray();
        String i = "";
        for (char cadenaDivIdCi : cadenaDivIdC) {
            if (Character.isDigit(cadenaDivIdCi)) {
                i += cadenaDivIdCi;
            }else if (i.equals("")) {
                System.out.println("Dato inválido.");
                return;
            }
            numC = Integer.parseInt(i);
        }
        for (Cita cita : db.getCitas()) {
            cita.getFechaCita().setTimeZone(TimeZone.getTimeZone("America/Bogota"));
            if (cita.idCita == numC) {
                if(cita.prioridad.equals(true)){
                    System.out.println("Las citas prioritarias no se pueden editar.");
                    return;
                }
                int index = db.getCitas().indexOf(cita);
                db.deleteObjectInArray(index, "citas");
                cita.setIdCita(cita.idCita);
                cita.setPrioridad(false);
                cita.setEstadoCita("Pendiente.");
                agendar();
                cita.setFechaCita(getFechaCita());
                db.updateJSON(cita, "citas");
                break;
            }
        }
    }
    public void crearEmergencia(Paciente paciente){
        int idCitas = 0;
        for (Cita citas : db.getCitas()) {
            idCitas = citas.idCita;
        }
        idCitas++;
        Cita cita = new Cita();
        cita.setIdCita(idCitas);
        cita.setPrioridad(true);
        cita.setEstadoCita("Pendiente.");
        agendarPrioritaria();
        if(getFechaCita().get(Calendar.HOUR_OF_DAY)==0){
            return;
        }
        cita.setFechaCita(fechaCita);

      /*  for (Psiquiatra pq: db.getPsiquiatras()){
            if (paciente.getPsiquiatra() == pq.getIdPsiquiatra()){
                psiquiatra = pq;
            }
        }

        paciente.getListaCitas().add(cita);
        psiquiatra.getListaCitas().add(cita);
        int indice = 0;
        for (Paciente pc : psiquiatra.getListaPacientes()){
            if (paciente.getIdPaciente()== pc.getIdPaciente()){
                indice = psiquiatra.getListaPacientes().indexOf(pc);
            }
        }
        psiquiatra.getListaPacientes().get(indice).getListaCitas().add(cita);
        db.appendArrayToJSON("pacientes");
        db.appendArrayToJSON("psiquiatras");*/

        db.updateJSON(cita, "citas");
    }
    public void mensajeEmergencia(){
        String [] mensaje = {"No estás solo en esto. Nos preocupamos por ti y queremos ayudarte." , "Pedir ayuda no es un signo de debilidad, sino de fortaleza.", "Estamos aquí para lo que necesites. ", "La depresión es un problema de salud real y tratable." ,"¿Qué podemos hacer para apoyarte?"};
        int size = mensaje.length-1;
        int numRandom = (int)Math.round(Math.random()*size);
        System.out.println(mensaje[numRandom]);
    }
    public void atenderCita() {
        for (Cita citas : db.getCitas()) {
            citas.verCita();
            break;
        }
        System.out.println("Ingrese el id de la cita.");
        String idC = SistemaDeGestionClinica.input.next();
        int numC = 0;
        char[] cadenaDivIdC = idC.toCharArray();
        String i = "";
        for (char cadenaDivIdCi : cadenaDivIdC) {
            if (Character.isDigit(cadenaDivIdCi)) {
                i += cadenaDivIdCi;
            } else if (i.equals("")) {
                System.out.println("Dato inválido.");
                return;
            }
            numC = Integer.parseInt(i);
        }
        for (Cita cita : db.getCitas()) {
            if (cita.idCita == numC) {
                while (true) {
                    System.out.println();
                    System.out.println("---------------------------------------------------------------------------------");
                    System.out.println("1. Pendiente.");
                    System.out.println("2. Atendida.");
                    System.out.println("3. Cancelada.");
                    System.out.println("---------------------------------------------------------------------------------");
                    System.out.println();
                    System.out.println("Marque 0 para cancelar.");
                    System.out.println();
                    System.out.println("Por favor elija una opción.");
                    String opcion = SistemaDeGestionClinica.input.next();
                    switch (opcion) {
                        case "1":
                            return;
                        case "2":
                            cita.setEstadoCita("Atendida.");
                            db.appendArrayToJSON("citas");
                            System.out.println("La cita ha sido atendida.");
                            //append a los otros JSON
                            return;
                        case "3":
                            while (true) {
                                System.out.println("¿Está seguro de que desea cancelar esta cita? Esta acción no se puede deshacer. Y/N");
                                String opcion1 = SistemaDeGestionClinica.input.next();
                                if (opcion1.equals("Y") || opcion1.equals("y")) {
                                    int index = db.getCitas().indexOf(cita);
                                    db.deleteObjectInArray(index, "citas");
                                    //append a los otros JSON
                                    System.out.println("Cita cancelada con exito.");
                                    return;
                                } else if (opcion1.equals("N") || opcion1.equals("n")) {
                                    break;
                                }
                            }
                        case "0":
                            return;
                    }
                }
            }
        }
    }
    //Paciente paciente
    public void agendar() {
        Calendar fechaDeseada = new GregorianCalendar();
        System.out.println("Ingrese la fecha en la que desea agendar una cita. (DD/MM/YYYY)");
        System.out.println();
        System.out.println("Día:");
        String dia = SistemaDeGestionClinica.input.next();
        int numDia = 0;
        char[] cadenaDivDia = dia.toCharArray();
        String i = "";
        for (char cadenaDivDiai : cadenaDivDia) {
            if (Character.isDigit(cadenaDivDiai)) { //Verifica que haya un número
                i += cadenaDivDiai;
            } else if (i.equals("")) {
                System.out.println("Dato inválido.");
                fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                return;
            }
            numDia = Integer.parseInt(i);
        }
        if (numDia > 31) {
            System.out.println("Un mes tiene como máximo 31 dias. Ingrese los datos nuevamente.");
            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
            return;
        }
        System.out.println("Mes:");
        String mes = SistemaDeGestionClinica.input.next();
        int numMes = 0;
        char[] cadenaDivMes = mes.toCharArray();
        String j = "";
        for (char cadenaDivMesi : cadenaDivMes) {
            if (Character.isDigit(cadenaDivMesi)) { //Verifica que haya un número
                j += cadenaDivMesi;
            } else if (j.equals("")) {
                System.out.println("Dato inválido.");
                fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                return;
            }
            numMes = Integer.parseInt(j);
        }
        if (numMes > 12) {
            System.out.println("Un año tiene como máximo 12 meses. Ingrese los datos nuevamente.");
            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
            return;
        }
        System.out.println("Año:");
        String ano = SistemaDeGestionClinica.input.next();
        int numAno = 0;
        char[] cadenaDivAno = ano.toCharArray();
        String k = "";
        for (char cadenaDivAnoi : cadenaDivAno) {
            if (Character.isDigit(cadenaDivAnoi)) { //Verifica que haya un número
                k += cadenaDivAnoi;
            } else if (k.equals("")) {
                System.out.println("Dato inválido.");
                fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                return;
            }
            numAno = Integer.parseInt(k);
        }
        if (numAno < 2020) {
            System.out.println("Dato inválido.");
            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
            return;
        }
        if (numMes == 1) {
            fechaDeseada.set(numAno, Calendar.JANUARY, numDia);
        } else if (numMes == 2) {
            if (numDia > 29) {
                System.out.println("Febrero tiene como máximo 28 días, 29 si es año bisiesto. Ingrese los datos nuevamente.");
                fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                return;
            }
            if ((numDia == 29 & numAno != 2024) & (numDia == 29 & numAno != 2028) & (numDia == 29 & numAno != 2032)) {
                System.out.println("Para que febrero tenga 29 días el año debe ser bisiesto. Ingrese los datos nuevamente.");
                fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                return;
            }
            fechaDeseada.set(numAno, Calendar.FEBRUARY, numDia);
        } else if (numMes == 3) {
            fechaDeseada.set(numAno, Calendar.MARCH, numDia);
        } else if (numMes == 4) {
            if (numDia > 30) {
                System.out.println("Abril tiene como máximo 30 dias. Ingrese los datos nuevamente.");
                fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                return;
            }
            fechaDeseada.set(numAno, Calendar.APRIL, numDia);
        } else if (numMes == 5) {
            fechaDeseada.set(numAno, Calendar.MAY, numDia);
        } else if (numMes == 6) {
            if (numDia > 30) {
                System.out.println("Junio tiene como máximo 30 dias. Ingrese los datos nuevamente.");
                fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                return;
            }
            fechaDeseada.set(numAno, Calendar.JUNE, numDia);
        } else if (numMes == 7) {
            fechaDeseada.set(numAno, Calendar.JULY, numDia);
        } else if (numMes == 8) {
            fechaDeseada.set(numAno, Calendar.AUGUST, numDia);
        } else if (numMes == 9) {
            if (numDia > 30) {
                System.out.println("Septiembre tiene como máximo 30 dias. Ingrese los datos nuevamente.");
                fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                return;
            }
            fechaDeseada.set(numAno, Calendar.SEPTEMBER, numDia);
        } else if (numMes == 10) {
            fechaDeseada.set(numAno, Calendar.OCTOBER, numDia);
        } else if (numMes == 11) {
            if (numDia > 30) {
                System.out.println("Noviembre tiene como máximo 30 dias. Ingrese los datos nuevamente.");
                fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                return;
            }
            fechaDeseada.set(numAno, Calendar.NOVEMBER, numDia);
        } else if (numMes == 12) {
            fechaDeseada.set(numAno, Calendar.DECEMBER, numDia);
        }
        Calendar fechaActual = Calendar.getInstance();
        if ((fechaActual.get(Calendar.DAY_OF_YEAR) + 1) - fechaDeseada.get(Calendar.DAY_OF_YEAR) == 1) {
            System.out.println("Las citas deben ser programadas con al menos un día de anticipación.");
            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
            return;
        }
        if (fechaDeseada.before(fechaActual)) {
            System.out.println("Fecha no disponible.");
            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
            return;
        }
        if (fechaDeseada.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            System.out.println("El horario de nuestros especialistas va de lunes a sábado, de 8:00 AM a 6:00 PM para atención general. Por favor ingrese otra fecha.");
            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
            return;
        }
        String disponibilidad = "Disponible";
        String disponibilidad1 = "Disponible";
        String disponibilidad2 = "Disponible";
        String disponibilidad3 = "Disponible";
        String disponibilidad4 = "Disponible";
        String disponibilidad5 = "Disponible";
        String disponibilidad6 = "Disponible";
        String disponibilidad7 = "Disponible";

        for (Cita cita : db.getCitas()) {
            if ((cita.getFechaCita().get(Calendar.DATE) == fechaDeseada.get(Calendar.DATE)) && (cita.getFechaCita().get(Calendar.MONTH) == fechaDeseada.get(Calendar.MONTH)) && (cita.getFechaCita().get(Calendar.YEAR) == fechaDeseada.get(Calendar.YEAR))) {
                for(Cita citas : db.getCitas()) {
                    citas.getFechaCita().setTimeZone(TimeZone.getTimeZone("America/Bogota"));
                    if (citas.getFechaCita().get(Calendar.HOUR_OF_DAY)==8) { disponibilidad = "No disponible."; }
                    if (citas.getFechaCita().get(Calendar.HOUR_OF_DAY)== 9) { disponibilidad1 = "No disponible."; }
                    if (citas.getFechaCita().get(Calendar.HOUR_OF_DAY)==10) { disponibilidad2 = "No disponible."; }
                    if (citas.getFechaCita().get(Calendar.HOUR_OF_DAY)==11) { disponibilidad3 = "No disponible."; }
                    if (citas.getFechaCita().get(Calendar.HOUR_OF_DAY)==14) { disponibilidad4 = "No disponible."; }
                    if (citas.getFechaCita().get(Calendar.HOUR_OF_DAY)==15) { disponibilidad5 = "No disponible."; }
                    if (citas.getFechaCita().get(Calendar.HOUR_OF_DAY)==16) { disponibilidad6 = "No disponible."; }
                    if (citas.getFechaCita().get(Calendar.HOUR_OF_DAY)==17) { disponibilidad7 = "No disponible."; }
                }
                while (true) {
                    System.out.println();
                    System.out.println("El especialista " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() + " presenta la siguiente agenda el día ingresado:");
                    System.out.println();
                    System.out.println("---------------------------------------------------------------------------------");
                    System.out.println("1. 8:00 AM - 9:00 AM:   " + disponibilidad);
                    System.out.println("2. 9:00 AM - 10:00 AM:  " + disponibilidad1);
                    System.out.println("3. 10:00 AM - 11:00 AM: " + disponibilidad2);
                    System.out.println("4. 11:00 AM - 12:00 M:  " + disponibilidad3);
                    System.out.println("5. 2:00 PM - 3:00 PM:   " + disponibilidad4);
                    System.out.println("6. 3:00 PM - 4:00 PM:   " + disponibilidad5);
                    System.out.println("7. 4:00 PM - 5:00 PM:   " + disponibilidad6);
                    System.out.println("8. 5:00 PM - 6:00 PM:   " + disponibilidad7);
                    System.out.println("---------------------------------------------------------------------------------");
                    System.out.println();
                    System.out.println("Marque 0 si no desea agendar una cita en alguno de estos horarios.");
                    System.out.println();
                    System.out.println("Por favor elija una opción");
                    String opccion = SistemaDeGestionClinica.input.next();
                    switch (opccion) {
                        case "1":
                            if (disponibilidad.equals("No disponible.")) {
                                System.out.println("Este horario no está disponible, intente nuevamente.");
                                return;
                            }
                            while (true) {
                                System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 8 + ":" + 0 + "0 AM  Y/N");
                                String opcion1 = SistemaDeGestionClinica.input.next();
                                if (opcion1.equals("Y")||opcion1.equals("y")) {
                                    int hora = 8;
                                    int minuto = 0;
                                    int segundo = 0;
                                    fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);
                                    System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 AM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() );
                                    System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                                    return;
                                } else if (opcion1.equals("N")||opcion1.equals("n")) {
                                    fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                                    return;
                                }
                            }
                        case "2":
                            if (disponibilidad1.equals("No disponible.")) {
                                System.out.println("Este horario no está disponible, intente nuevamente.");
                                return;
                            }
                            while (true) {
                                System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 9 + ":" + 0 + "0 AM.  Y/N");
                                String opcion1 = SistemaDeGestionClinica.input.next();
                                if (opcion1.equals("Y")||opcion1.equals("y")) {
                                    int hora = 9;
                                    int minuto = 0;
                                    int segundo = 0;
                                    fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);
                                    System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 AM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                                    System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:"+".");
                                    return;
                                } else if (opcion1.equals("N")||opcion1.equals("n")) {
                                    fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                                    return;
                                }
                            }
                        case "3":
                            if (disponibilidad2.equals("No disponible.")) {
                                System.out.println("Este horario no está disponible, intente nuevamente.");
                                return;
                            }
                            while (true) {
                                System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 10 + ":" + 0 + "0 AM.  Y/N");
                                String opcion1 = SistemaDeGestionClinica.input.next();
                                if (opcion1.equals("Y")||opcion1.equals("y")) {
                                    int hora = 10;
                                    int minuto = 0;
                                    int segundo = 0;
                                    fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 AM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                                    System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                                    return;
                                } else if (opcion1.equals("N")||opcion1.equals("n")) {
                                    fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                                    return;
                                }
                            }
                        case "4":
                            if (disponibilidad3.equals("No disponible.")) {
                                System.out.println("Este horario no está disponible, intente nuevamente.");
                                return;
                            }
                            while (true) {
                                System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 11 + ":" + 0 + "0 AM.  Y/N");
                                String opcion1 = SistemaDeGestionClinica.input.next();
                                if (opcion1.equals("Y")||opcion1.equals("y")) {
                                    int hora = 11;
                                    int minuto = 0;
                                    int segundo = 0;
                                    fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 AM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                                    System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                                    return;
                                } else if (opcion1.equals("N")||opcion1.equals("n")) {
                                    fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                                    return;
                                }
                            }
                        case "5":
                            if (disponibilidad4.equals("No disponible.")) {
                                System.out.println("Este horario no está disponible, intente nuevamente.");
                                return;
                            }
                            while (true) {
                                System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 2 + ":" + 0 + "0 PM.  Y/N");
                                String opcion1 = SistemaDeGestionClinica.input.next();
                                if (opcion1.equals("Y")||opcion1.equals("y")) {
                                    int hora = 14;
                                    int minuto = 0;
                                    int segundo = 0;
                                    fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 PM con el especialista: "+ psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                                    System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                                    return;
                                } else if (opcion1.equals("N")||opcion1.equals("n")) {
                                    fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                                    return;
                                }
                            }
                        case "6":
                            if (disponibilidad5.equals("No disponible.")) {
                                System.out.println("Este horario no está disponible, intente nuevamente.");
                                return;
                            }
                            while (true) {
                                System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 3 + ":" + 0 + "0 PM.  Y/N");
                                String opcion1 = SistemaDeGestionClinica.input.next();
                                if (opcion1.equals("Y")||opcion1.equals("y")) {
                                    int hora = 15;
                                    int minuto = 0;
                                    int segundo = 0;
                                    fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 PM con el especialista: "+ psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                                    System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                                    return;
                                } else if (opcion1.equals("N")||opcion1.equals("n")) {
                                    fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                                    return;
                                }
                            }
                        case "7":
                            if (disponibilidad6.equals("No disponible.")) {
                                System.out.println("Este horario no está disponible, intente nuevamente.");
                                return;
                            }
                            while (true) {
                                System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 4 + ":" + 0 + "0 PM.  Y/N");
                                String opcion1 = SistemaDeGestionClinica.input.next();
                                if (opcion1.equals("Y")||opcion1.equals("y")) {
                                    int hora = 16;
                                    int minuto = 0;
                                    int segundo = 0;
                                    fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 PM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                                    System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                                    return;
                                } else if (opcion1.equals("N")||opcion1.equals("n")) {
                                    fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                                    return;
                                }
                            }
                        case "8":
                            if (disponibilidad7.equals("No disponible.")) {
                                System.out.println("Este horario no está disponible, intente nuevamente.");
                                return;
                            }
                            while (true) {
                                System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 5 + ":" + 0 + "0 PM.  Y/N");
                                String opcion1 = SistemaDeGestionClinica.input.next();
                                if (opcion1.equals("Y")||opcion1.equals("y")) {
                                    int hora = 17;
                                    int minuto = 0;
                                    int segundo = 0;
                                    fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 PM con el especialista: "+ psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                                    System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                                    return;
                                } else if (opcion1.equals("N")||opcion1.equals("n")) {
                                    fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                                    return;
                                }
                            }
                        case "0":
                            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                            return;
                    }

                }
            }
        }
        while (true) {
            System.out.println();
            System.out.println("El especialista " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() + " presenta la siguiente agenda el día ingresado:");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("1. 8:00 AM - 9:00 AM:   Disponible.");
            System.out.println("2. 9:00 AM - 10:00 AM:  Disponible.");
            System.out.println("3. 10:00 AM - 11:00 AM: Disponible.");
            System.out.println("4. 11:00 AM - 12:00 M:  Disponible.");
            System.out.println("5. 2:00 PM - 3:00 PM:   Disponible.");
            System.out.println("6. 3:00 PM - 4:00 PM:   Disponible.");
            System.out.println("7. 4:00 PM - 5:00 PM:   Disponible.");
            System.out.println("8. 5:00 PM - 6:00 PM:   Disponible.");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Marque 0 si no desea agendar una cita en alguno de estos horarios");
            System.out.println();
            System.out.println("Por favor elija una opcción");
            String opccion = SistemaDeGestionClinica.input.next();
            switch (opccion) {
                case "1":
                    while (true) {
                        System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 8 + ":" + 0 + "0 AM.  Y/N");
                        String opcion1 = SistemaDeGestionClinica.input.next();
                        if (opcion1.equals("Y")||opcion1.equals("y")) {
                            int hora = 8;
                            int minuto = 0;
                            int segundo = 0;
                            fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);
                            System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 AM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                            System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                            return;
                        } else if (opcion1.equals("N")||opcion1.equals("n")) {
                            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                            return;
                        }
                    }
                case "2":
                    while (true) {
                        System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 9 + ":" + 0 + "0 AM.  Y/N");
                        String opcion1 = SistemaDeGestionClinica.input.next();
                        if (opcion1.equals("Y")||opcion1.equals("y")) {
                            int hora = 9;
                            int minuto = 0;
                            int segundo = 0;
                            fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);
                            System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 AM con el especialista: "+ psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                            System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                            return;
                        } else if (opcion1.equals("N")||opcion1.equals("n")) {
                            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                            return;
                        }
                    }
                case "3":
                    while (true) {
                        System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 10 + ":" + 0 + "0 AM.  Y/N");
                        String opcion1 = SistemaDeGestionClinica.input.next();
                        if (opcion1.equals("Y")||opcion1.equals("y")) {
                            int hora = 10;
                            int minuto = 0;
                            int segundo = 0;
                            fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 AM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                            System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                            return;
                        } else if (opcion1.equals("N")||opcion1.equals("n")) {
                            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                            return;
                        }
                    }
                case "4":
                    while (true) {
                        System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 11 + ":" + 0 + "0 AM.  Y/N");
                        String opcion1 = SistemaDeGestionClinica.input.next();
                        if (opcion1.equals("Y")||opcion1.equals("y")) {
                            int hora = 11;
                            int minuto = 0;
                            int segundo = 0;
                            fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 AM con el especialista: "+ psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                            System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                            return;
                        } else if (opcion1.equals("N")||opcion1.equals("n")) {
                            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                            return;
                        }
                    }
                case "5":
                    while (true) {
                        System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 2 + ":" + 0 + "0 PM.  Y/N");
                        String opcion1 = SistemaDeGestionClinica.input.next();
                        if (opcion1.equals("Y")||opcion1.equals("y")) {
                            int hora = 14;
                            int minuto = 0;
                            int segundo = 0;
                            fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 PM con el especialista: "+ psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                            System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                            return;
                        } else if (opcion1.equals("N")||opcion1.equals("n")) {
                            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                            return;
                        }
                    }
                case "6":
                    while (true) {
                        System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 3 + ":" + 0 + "0 PM.  Y/N");
                        String opcion1 = SistemaDeGestionClinica.input.next();
                        if (opcion1.equals("Y")||opcion1.equals("y")) {
                            int hora = 15;
                            int minuto = 0;
                            int segundo = 0;
                            fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 PM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                            System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                            return;
                        } else if (opcion1.equals("N")||opcion1.equals("n")) {
                            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                            return;
                        }
                    }
                case "7":
                    while (true) {
                        System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 4 + ":" + 0 + "0 PM.  Y/N");
                        String opcion1 = SistemaDeGestionClinica.input.next();
                        if (opcion1.equals("Y")||opcion1.equals("y")) {
                            int hora = 16;
                            int minuto = 0;
                            int segundo = 0;
                            fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 PM con el especialista: "+ psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                            System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                            return;
                        } else if (opcion1.equals("N")||opcion1.equals("n")) {
                            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                            return;
                        }
                    }
                case "8":
                    while (true) {
                        System.out.println("¿Está seguro de que desea agendar una cita para el: " + fechaDeseada.get(Calendar.DATE) + "/" + (fechaDeseada.get(Calendar.MONTH) + 1) + "/" + fechaDeseada.get(Calendar.YEAR) + " a las: " + 5 + ":" + 0 + "0 PM.  Y/N");
                        String opcion1 = SistemaDeGestionClinica.input.next();
                        if (opcion1.equals("Y")||opcion1.equals("y")) {
                            int hora = 17;
                            int minuto = 0;
                            int segundo = 0;
                            fechaCita.set(fechaDeseada.get(Calendar.YEAR), fechaDeseada.get(Calendar.MONTH), fechaDeseada.get(Calendar.DATE), hora, minuto, segundo);System.out.println("Su cita ha sido agendada para el: " + fechaCita.get(Calendar.DATE) + "/" + (fechaCita.get(Calendar.MONTH) + 1) + "/" + fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) + ":" + fechaCita.get(Calendar.MINUTE) + "0 PM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                            System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                            return;
                        } else if (opcion1.equals("N")||opcion1.equals("n")) {
                            fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                            return;
                        }
                    }
                case "0":
                    fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
                    return;
            }
        }
    }

    public void agendarPrioritaria() {
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaPrioritaria = new GregorianCalendar();
        fechaPrioritaria.set(fechaActual.get(Calendar.YEAR), fechaActual.get(Calendar.MONTH), fechaActual.get(Calendar.DATE),(fechaActual.get(Calendar.HOUR_OF_DAY)+ 2),0,0);
        for(Cita citas : db.getCitas()){
            citas.getFechaCita().setTimeZone(TimeZone.getTimeZone("America/Bogota"));
            if(fechaPrioritaria.get(Calendar.HOUR_OF_DAY)>=7 & fechaPrioritaria.get(Calendar.HOUR_OF_DAY)<=17) {
                if (citas.getFechaCita().get(Calendar.HOUR_OF_DAY) == fechaPrioritaria.get(Calendar.HOUR_OF_DAY)) {
                    while (fechaPrioritaria.get(Calendar.HOUR_OF_DAY) <= 17){
                        if (citas.getFechaCita().get(Calendar.HOUR_OF_DAY) == fechaPrioritaria.get(Calendar.HOUR_OF_DAY)){
                            fechaPrioritaria.set(fechaActual.get(Calendar.YEAR), fechaActual.get(Calendar.MONTH), fechaActual.get(Calendar.DATE), (fechaPrioritaria.get(Calendar.HOUR_OF_DAY) + 1), 0, 0);
                        }else{
                            break;
                        }
                    }
                } else {
                    fechaCita.set(fechaPrioritaria.get(Calendar.YEAR), fechaPrioritaria.get(Calendar.MONTH), fechaPrioritaria.get(Calendar.DATE), fechaPrioritaria.get(Calendar.HOUR_OF_DAY), 0, 0);
                    if (citas.fechaCita.get(Calendar.HOUR_OF_DAY)<12){
                        System.out.println("Su cita de emergencia ha sido agendada para el: " + fechaCita.get(Calendar.DATE) +"/" + (fechaCita.get(Calendar.MONTH)+1) +"/"+ fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) +":"+ fechaCita.get(Calendar.MINUTE)+"0 AM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +"." );
                    }else{
                        System.out.println("Su cita de emergencia ha sido agendada para el: " + fechaCita.get(Calendar.DATE) +"/" + (fechaCita.get(Calendar.MONTH)+1) +"/"+ fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) +":"+ fechaCita.get(Calendar.MINUTE)+"0 PM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +"." );
                    }
                    System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                    return;
                }
            }else {
                fechaPrioritaria.set(fechaActual.get(Calendar.YEAR), fechaActual.get(Calendar.MONTH), (fechaActual.get(Calendar.DATE)+1), 7, 0, 0);
                if (citas.getFechaCita().get(Calendar.HOUR_OF_DAY) == fechaPrioritaria.get(Calendar.HOUR_OF_DAY)) {
                    while (fechaPrioritaria.get(Calendar.HOUR_OF_DAY) <= 17){
                        if (citas.getFechaCita().get(Calendar.HOUR_OF_DAY) == fechaPrioritaria.get(Calendar.HOUR_OF_DAY)){
                            fechaPrioritaria.set(fechaActual.get(Calendar.YEAR), fechaActual.get(Calendar.MONTH), fechaActual.get(Calendar.DATE), (fechaPrioritaria.get(Calendar.HOUR_OF_DAY) + 1), 0, 0);
                            if (fechaPrioritaria.get(Calendar.HOUR_OF_DAY) == 17){
                                fechaPrioritaria.set(fechaActual.get(Calendar.YEAR), fechaActual.get(Calendar.MONTH), (fechaActual.get(Calendar.DATE)+1),7,0,0);
                            }
                        }else{
                            break;
                        }
                    }
                } else {
                    fechaPrioritaria.set(fechaPrioritaria.get(Calendar.YEAR), fechaPrioritaria.get(Calendar.MONTH), fechaPrioritaria.get(Calendar.DATE), fechaPrioritaria.get(Calendar.HOUR_OF_DAY), 0, 0);
                    if (citas.fechaCita.get(Calendar.HOUR_OF_DAY)<12){
                        System.out.println("Su cita de emergencia ha sido agendada para el: " + fechaCita.get(Calendar.DATE) +"/" + (fechaCita.get(Calendar.MONTH)+1) +"/"+ fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) +":"+ fechaCita.get(Calendar.MINUTE)+"0 AM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +".");
                    }else{
                        System.out.println("Su cita de emergencia ha sido agendada para el: " + fechaCita.get(Calendar.DATE) +"/" + (fechaCita.get(Calendar.MONTH)+1) +"/"+ fechaCita.get(Calendar.YEAR) + " a las: " + fechaCita.get(Calendar.HOUR) +":"+ fechaCita.get(Calendar.MINUTE)+"0 PM con el especialista: " + psiquiatra.getNombres() + " " + psiquiatra.getApellidos() +"." );
                    }
                    System.out.println("Recuerde que debe llegar al menos 15 minutos antes a la clinica:  " + "ubicada en:");
                    return;
                }
            }
        }
        fechaCita.set(0,Calendar.JANUARY,0,0,0,0);
    }

}