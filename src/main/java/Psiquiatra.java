import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Psiquiatra implements handleJSON {
    public int idPsiquiatra;
    public String nombres;
    public String apellidos;
    public String emailPsiquiatra;
    public String clavePsiquiatra;
    public String Sexo;
    public String direccion;
    public int edad;
    public Date fechaNacimiento;
    public int tel;
    public ArrayList<HistorialClinico> ListaHistoriales;
    public ArrayList<Paciente> ListaPacientes;
    public ArrayList<Cita> citas;
    public int nitClinicaPsiquiatra;

    handleDB db = new handleDB();
    Scanner input = new Scanner(System.in);

    public Psiquiatra(){ }

    public Psiquiatra(int idPsiquiatra, String nombres, String apellidos, String emailPsiquiatra, String clavePsiquiatra,
                      String sexo, String direccion, int edad, Date fechaNacimiento, int tel, int nitClinicaPsiquiatra) {
        this.idPsiquiatra = idPsiquiatra;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.emailPsiquiatra = emailPsiquiatra;
        this.clavePsiquiatra = clavePsiquiatra;
        Sexo = sexo;
        this.direccion = direccion;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.tel = tel;
        this.nitClinicaPsiquiatra = nitClinicaPsiquiatra;
    }

    public Psiquiatra(int idPsiquiatra, String emailPsiquiatra, String clavePsiquiatra) {
        this.idPsiquiatra = idPsiquiatra;
        this.emailPsiquiatra = emailPsiquiatra;
        this.clavePsiquiatra = clavePsiquiatra;
    }

    public int getIdPsiquiatra() {
        return idPsiquiatra;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmailPsiquiatra() {
        return emailPsiquiatra;
    }

    public String getClavePsiquiatra() {
        return clavePsiquiatra;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getTel() {
        return tel;
    }

    public ArrayList<HistorialClinico> getListaHistoriales() {
        return ListaHistoriales;
    }

    public ArrayList<Paciente> getListaPacientes() {
        return ListaPacientes;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public int getNitClinicaPsiquiatra() {
        return nitClinicaPsiquiatra;
    }


    public void setIdPsiquiatra(int idPsiquiatra) {
        this.idPsiquiatra = idPsiquiatra;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmailPsiquiatra(String emailPsiquiatra) {
        this.emailPsiquiatra = emailPsiquiatra;
    }

    public void setClavePsiquiatra(String clavePsiquiatra) {
        this.clavePsiquiatra = clavePsiquiatra;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setListaHistoriales(ArrayList<HistorialClinico> listaHistoriales) {
        ListaHistoriales = listaHistoriales;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        ListaPacientes = listaPacientes;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    public void setNitClinicaPsiquiatra(int nitClinicaPsiquiatra) {
        this.nitClinicaPsiquiatra = nitClinicaPsiquiatra;
    }

    @Override
    public String toString() {
        return "{"  + "\n" +
                "idPsiquiatra : " + idPsiquiatra + "," + "\n" +
                "emailPsiquiatra : " + emailPsiquiatra + "," + "\n" +
                "clavePsiquiatra : " + clavePsiquiatra + "," + "\n" +
                '}';
    }

    public void registrarPsiquiatra(Clinica clinicaCoordinador) {
        Scanner input = new Scanner(System.in);

        //Pedir datos y validar los necesarios
        System.out.println("Ingrese el primer nombre (y segundo si tiene) del psiquiatra a registrar:");
        String nombres = input.nextLine();

        System.out.println("Ingrese los apellidos del psiquiatra a registrar:");
        String apellidos = input.nextLine();

        System.out.println("Ingrese el email del psiquiatra a registrar:");
        String email = input.nextLine();

        System.out.println("Ingrese la contraseña del psiquiatra a registrar:");
        String contrasena = input.nextLine();

        String sexo = "";
        while(true) {
            System.out.println("Ingrese el sexo del(de la) psiquiatra: ");
            System.out.println("1. Masculino");
            System.out.println("2. Femenino");
            System.out.println("3. Otro");
            sexo = input.next();
            if (sexo.equals("1")) {
                sexo = "masculino";
                break;
            } else if (sexo.equals("2")) {
                sexo = "femenino";
                break;
            } else if (sexo.equals("3")) {
                sexo = "otro";
                break;
            } else {
                System.out.println("Ingresó una respuesta inválida. Por favor elija una opción");
            }
        }

        System.out.println("Ingrese la dirección del psiquiatra a registrar:");
        input.nextLine();
        String direccion = input.nextLine();

        System.out.println("Ingrese la edad del psiquiatra a registrar:");
        int edad = 0;
        int aux = 0;
        while (aux == 0) {
            while (!input.hasNextInt()) {
                System.out.println("Por favor escriba sólo un número correspondiente  a la edad: ");
                input.next();
            }
            edad = input.nextInt();
            if (edad < 18) {
                System.out.println("La edad ingresada es inválida, debe ser mayor(o igual) a 18");
            }
            else {
                aux = 1;
            }
        }

        System.out.println("Ingrese el año de nacimiento");
        input.nextLine();
        int year = 0;
        int aux1 = 0;
        while (aux1 == 0) {
            while (!input.hasNextInt()) {
                System.out.println("Por favor escriba sólo el número coorespondiente al año de nacimiento: ");
                input.next();
            }
            year = input.nextInt();
            if (year > 2020 || year < 1920) {
                System.out.println("Año de nacimiento inválido.  Por favor vuelva a ingresar el año de nacimiento");
            }
            else {
                aux1 = 1;
            }
        }
        String yearStr = Integer.toString(year);

        System.out.println("Ingrese el mes de nacimiento");
        int mes = 0;
        int aux2 = 0;
        while (aux2 == 0) {
            while (!input.hasNextInt()) {
                System.out.println("Por favor escriba sólo el número coorespondiente al mes de nacimiento: ");
                input.next();
            }
            mes = input.nextInt();
            if (mes > 12 || mes < 1) {
                System.out.println("Mes de nacimiento inválido. Por favor vuelva a ingresar el mes de nacimiento");
            }
            else {
                aux2 = 1;
            }
        }
        String mesStr = Integer.toString(mes);
        if (mesStr.length() == 1) {
            mesStr = "0" + mesStr;
        }

        System.out.println("Ingrese el día de nacimiento");
        int dia = 0;
        int aux3 = 0;
        while (aux3 == 0) {
            while (!input.hasNextInt()) {
                System.out.println("Por favor escriba sólo el número coorespondiente al día de nacimiento: ");
                input.next();
            }
            dia = input.nextInt();
            if (dia > 31 || dia < 1) {
                System.out.println("Día de nacimiento inválido. Por favor vuelva a ingresar el día de nacimiento");
            }
            else {
                aux3 = 1;
            }
        }
        String diaStr = Integer.toString(dia);
        if (diaStr.length() == 1) {
            diaStr = "0" + diaStr;
        }

        System.out.println("Enter the Date ");

        String date = diaStr + "-" + mesStr + "-" + yearStr;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento = null;
        try {
            //Parsing the String
            fechaNacimiento = dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(fechaNacimiento);

        System.out.println("Ingrese el teléfono del psiquiatra a registrar: ");
        int telefono = 0;
        int aux4 = 0;
        while (aux4 == 0) {
            while (!input.hasNextInt()) {
                System.out.println("Por favor escriba un número: ");
                input.next();
            }
            telefono = input.nextInt();
            if (telefono <= 0) {
                System.out.println("Por favor ingrese un número positivo mayor a 0");
            }
            else {
                aux4 = 1;
            }
        }

        //Crear id del psiquiatra
        int idPsiquiatra = 0;
        if (clinicaCoordinador.listaDePsiquiatras == null) {
            idPsiquiatra = 0;
        }
        else {
            idPsiquiatra = clinicaCoordinador.listaDePsiquiatras.size();
        }


        Psiquiatra nuevoPsiquiatra = new Psiquiatra(idPsiquiatra, nombres, apellidos, email, contrasena,
                sexo, direccion, edad, fechaNacimiento, telefono, clinicaCoordinador.nit);

        //Agregar nuevo psiquiatra a lista json de psiquiatras

        db.updateJSON(nuevoPsiquiatra, "psiquiatras");
        //Falta agregar el psiquiatra a la lista de psiquiatras de la clinica en el json


    }

//    public void editarPsiquiatra(int idPsiquiatra) {
//        Collections.sort(db.getPsiquiatras(), ClinicSort.idOrderPsiquiatra);
//        Psiquiatra ps = new Psiquiatra();
//        ps.setIdPsiquiatra(idPsiquiatra);
//        int indexPsiquiatra = Collections.binarySearch(db.getPsiquiatras(), ps, ClinicSort.idOrderPsiquiatra);
//        ps = db.getPsiquiatras().get(indexPsiquiatra);
//        String opt = "";
//        String guardarCambio = "";
//        String correoNuevo = "", claveNueva = "", direccionNueva = "";
//        int nuevoTelefono = 0;
//        System.out.println("__________________________________________________");
//        System.out.println("            Editar perfil de psicólogo");
//        System.out.println("--------------------------------------------------");
//        while(true){
//            System.out.println("Selecciones el campo a editar/actualizar");
//            System.out.println("1. Correo");
//            System.out.println("2. Contraseña");
//            System.out.println("3. Dirección");
//            System.out.println("4. Teléfono");
//            System.out.println("0. Regresar al menú principal");
//            System.out.println("----------------------------------------------");
//            opt = input.next();
//            if(opt.equals("1")){
//                System.out.println("Ingrese el nuevo correo electrónico:");
//                correoNuevo = input.next().toLowerCase();
//                break;
//            } else if(opt.equals("2")) {
//                System.out.println("Ingrese la nueva contraseña");
//                claveNueva = input.next();
//            } else if(opt.equals("3")){
//                System.out.println("Ingrese la nueva dirección");
//                direccionNueva = input.next().toLowerCase();
//                break;
//            } else if(opt.equals("4")) {
//                System.out.println("Ingrese el nuevo teléfono");
//                nuevoTelefono = input.nextInt();
//                break;
//            } else if(opt.equals("0")){
//                return;
//            }else {
//                System.out.println("Ingresaste una opción incorrecta");
//            }
//            System.out.println("¿Desea cambiar guardar el cambio? Y/N: ");
//            guardarCambio = input.next().toLowerCase();
//            if(guardarCambio.equals("y")){
//                switch (opt) {
//                    case "1":
//                        for(int i = 0; i <= db.getPsiquiatras().size(); i++){
//                            if(db.getPsiquiatras().get(i).idPsiquiatra == idPsiquiatra) {
//                                db.getPsiquiatras().get(i).setEmailPsiquiatra(correoNuevo);
//                                break;
//                            }
//                        }
//                        break;
//                    case "2":
//                        for(int i = 0; i <= db.getPsiquiatras().size(); i++){
//                            if(db.getPsiquiatras().get(i).idPsiquiatra == idPsiquiatra) {
//                                db.getPsiquiatras().get(i).setClavePsiquiatra(claveNueva);
//                                break;
//                            }
//                        }
//                        break;
//                    case "3":
//                        for(int i = 0; i <= db.getPsiquiatras().size(); i++){
//                            if(db.getPsiquiatras().get(i).idPsiquiatra == idPsiquiatra) {
//                                db.getPsiquiatras().get(i).setDireccion(direccionNueva);
//                                break;
//                            }
//                        }
//                        break;
//                    case "4":
//                        for(int i = 0; i <= db.getPsiquiatras().size(); i++) {
//                            if (db.getPsiquiatras().get(i).idPsiquiatra == idPsiquiatra) {
//                                db.getPsiquiatras().get(i).setTel(nuevoTelefono);
//                                break;
//                            }
//                        }
//                        break;
//                }
//                db.appendArrayToJSON("psiquiatras");
//            } else if(guardarCambio.equals("n")){
//                System.out.println("Si no cierra el sistema puede guardar sus cambios en la opción 6 del menú principal");
//                break;
//            }
//        }
//    }
}