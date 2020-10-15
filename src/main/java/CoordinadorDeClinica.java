import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class CoordinadorDeClinica implements handleJSON{
    public int cedulaCoordinador;
    public String contrasenaCoordinador;
    public String emailCoordinador;
    public Clinica clinicaCoordinador;

    public CoordinadorDeClinica() {
    }

    public int getCedulaCoordinador() {
        return cedulaCoordinador;
    }

    public String getContrasenaCoordinador() {
        return contrasenaCoordinador;
    }

    public static void main(String[] args) {

        handleDB db = new handleDB();
        db.readAllJSON();






        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Bienvenido Coordinado de clínica");
            System.out.println("¿Qué desea realizar?");
            System.out.println("1. editar clínica");
            System.out.println("2. borrar clínica");
            System.out.println("3. regitrar psiquiatra");
            System.out.println("4. borrar psiquiatra");
            System.out.println("5. suministrar medicamentos");
            System.out.println("6. borrar medicamento");
            System.out.println("0. salir");
            String option = input.next();
//            if (option.equals("1")) {
//               coordinadorDePrueba.editarClinica();
//            }
//            else if (option.equals("2")) {
//                coordinadorDePrueba.borrarClinica();
//            }
//            else if(option.equals("3")){
//                coordinadorDePrueba.registrarPsiquiatra();
//            }
//            else if(option.equals("4")){
//                coordinadorDePrueba.borrarPsiquiatra();
//            }
//            else if(option.equals("5")){
//                coordinadorDePrueba.suministrarMedicamentos();
//            }
//            else if(option.equals("6")){
//                coordinadorDePrueba.borrarMedicamento();
//            }
//            else if(option.equals("0")){
//                break;
//            }

        }

    }



    public void editarClinica() {
        handleDB db = new handleDB();
        Scanner input = new Scanner(System.in);
        int iJsonClinicas = 0;
        for (int i = 0; i < db.getClinicas().size(); i++) {
            if (db.getClinicas().get(i).nit == clinicaCoordinador.nit) {
                iJsonClinicas = i;
                break;
            }
        }

        while (true) {
            System.out.println("¿Qué atributo desea cambiar?");
            System.out.println("1. nombre de clínica");
            System.out.println("2. dirección");
            System.out.println("3. telfono");
            System.out.println("0. Regresar al menú principal");
            String cambio = input.next();
            if (cambio.equals("1")) {
                System.out.println("Ingrese el nuevo nombre de la clínica:");
                input.nextLine();
                String nombre = input.nextLine();
                clinicaCoordinador.nombreClinica = nombre;
                db.getClinicas().get(iJsonClinicas).nombreClinica = nombre;
                System.out.println("Se ha cambiado el nombre de la clinica exitosamente");
                break;
            }
            else if (cambio.equals("2")) {
                System.out.println("Ingrese la nueva dirección de la clínica:");
                input.nextLine();
                String direccion = input.nextLine();
                clinicaCoordinador.direccion = direccion;
                db.getClinicas().get(iJsonClinicas).direccion = direccion;
                System.out.println("Se ha cambiado la dirección de la clinica exitosamente");
                break;
            }
            else if (cambio.equals("3")) {
                System.out.println("Ingrese el nuevo teléfono de la clínica:");
                int telefono = 0;
                int aux = 0;
                while (aux == 0) {
                    while (!input.hasNextInt()) {
                        System.out.println("Por favor escriba un número: ");
                        input.next();
                    }
                    telefono = input.nextInt();
                    if (telefono <= 0) {
                        System.out.println("Por favor ingrese un número positivo mayor a 0");
                    }
                    else {
                        aux = 1;
                    }
                }
                clinicaCoordinador.telefono = telefono;
                db.getClinicas().get(iJsonClinicas).telefono = telefono;
                System.out.println("Se ha cambiado el teléfono de la clinica exitosamente");
                break;
            }

            else if (cambio.equals("0")) {
                return;
            }
            else {
                System.out.println("Ha ingresado una opción inválida");
                continue;
            }
        }
        //Modificando json coordinadores y clinicas
        db.appendArrayToJSON("clinicas");
        db.appendArrayToJSON("coordinadores");



    }



    public void borrarPsiquiatra() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el id del psiquiatra que desea eliminar de su clínica");
        int id = input.nextInt();

        if (id < 0) {
            System.out.println("Ha ingresado un id inválido");
            return;
        }

        boolean psExiste = false;
        for (int i = 0; i < clinicaCoordinador.listaDePsiquiatras.size(); i++) {
            Psiquiatra psiquiatra = clinicaCoordinador.listaDePsiquiatras.get(i);
            if (psiquiatra.idPsiquiatra == id) {
                psExiste = true;
                clinicaCoordinador.listaDePsiquiatras.remove(i);
                System.out.println("Se ha removido al psiquiatra con éxito");
                break;
            }
        }
        if (!psExiste) {
            System.out.println("No hay psiquiatra registrado con el id " + id);
        }
    }

    public void suministrarMedicamentos() {
        Scanner input = new Scanner(System.in);
        handleDB db = new handleDB();
        while(true) {
            System.out.println("Para visualizar los medicamentos de la clínica, escoja respecto a cual" +
                    " atributo los quiere que estén organizados: ");
            System.out.println("1. Nombre");
            System.out.println("2. Cantidad");
            String optcompa = input.next();

            if (optcompa.equals("1")) {
                Collections.sort(clinicaCoordinador.listaDeMedicamentos, new MedicamentoComparatorNombre());
                break;
            }
            else if (optcompa.equals("2")) {
                Collections.sort(clinicaCoordinador.listaDeMedicamentos, new MedicamentoComparatorCantidad());
                break;
            }
            else {
                System.out.println("Ingresó una opción inválida");
                continue;
            }
        }

        Medicamento med = new Medicamento();
        med.listarMedicamento(clinicaCoordinador);
        med.notificarCantidad(clinicaCoordinador);

        while (true) {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Agregar suministros de un medicamento existente");
            System.out.println("2. Agregar un medicamento nuevo");

            String optadd = input.next();
            if (optadd.equals("1")) {
                System.out.println("Ingrese el id del medicamento al que le desea aumentar la cantidad: ");
                input.nextLine();
                String c = input.nextLine();
                int numI = 0;
                char [] cadenaDivId = c.toCharArray();
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

                int idMed = numI;



                int indexMed = 0;
                for (int g = 0; g < clinicaCoordinador.listaDeMedicamentos.size(); g++) {
                    if (clinicaCoordinador.listaDeMedicamentos.get(g).idMedicamento == idMed) {
                        indexMed = g;
                        break;
                    }
                }

                System.out.println("Ingrese la cantidad de unidades a agregar al medicamento " +
                        clinicaCoordinador.listaDeMedicamentos.get(indexMed).nombreMedicamento);


                String c2 = input.nextLine();
                int numI2 = 0;
                char [] cadenaDivId2 = c2.toCharArray();
                String i2 = "";
                for (char cadenaDivIdi : cadenaDivId2) {
                    if (Character.isDigit(cadenaDivIdi)) { //Verifica que haya un número
                        i2 += cadenaDivIdi;
                    }else if (i2.equals("")) {
                        System.out.println("Dato inválido.");
                        return;
                    }
                    numI2 = Integer.parseInt(i2);
                }

                int cantidadSum = numI2;
                if (cantidadSum < 1) {
                    System.out.println("La cantidad debe ser igual o mayor a una unidad");
                }


                clinicaCoordinador.listaDeMedicamentos.get(indexMed).cantidadDisponible += cantidadSum;


//                //Actualizar en el json de clinicas
//                for (int w = 0; w < db.getClinicas().size(); w++) {
//                    if (db.getClinicas().get(w).nit == clinicaCoordinador.nit) {
//                        for (int j = 0; j < db.getClinicas().get(w).listaDeMedicamentos.size(); j++) {
//                            if (db.getClinicas().get(w).listaDeMedicamentos.get(j).idMedicamento == idMed) {
//                                db.getClinicas().get(w).listaDeMedicamentos.get(j).cantidadDisponible += cantidadSum;
//                                break;
//                            }
//                        }
//                    break;
//                    }
//                }
//
//                for (int z = 0; z < db.getMedicamentos().size(); z++) {
//                    if (db.getMedicamentos().get(z).idMedicamento == idMed) {
//                        db.getMedicamentos().get(z).cantidadDisponible += cantidadSum;
//                    }
//                }


                db.appendArrayToJSON("clinicas");
                db.appendArrayToJSON("coordinadores");
                db.appendArrayToJSON("medicamentos");
                System.out.println("Se ha suministrado el medicamento al inventario exitosamente");
                break;
                //Actualizar el medicamento modificado a la lista de medicamentos general (la que está en sistema de gestión)


            }
            else if (optadd.equals("2")) {
                System.out.println("Ingrese el nombre del medicamento a adicionar al inventario: ");
                input.nextLine();
                String nombre = input.nextLine();


                System.out.println("Ingrese la cantidad de unidades disponibles del medicamento: ");
                String c = input.nextLine();
                int numI = 0;
                char [] cadenaDivId = c.toCharArray();
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

                int cantidad = numI;
                if (cantidad < 1) {
                    System.out.println("La cantidad debe ser igual o mayor a una unidad");
                }

                int id = db.getMedicamentos().size();
                id++;


                Medicamento nuevoMedicamento = new Medicamento(id, nombre, cantidad);
                clinicaCoordinador.listaDeMedicamentos.add(nuevoMedicamento);

                //Agregar el medicamento creado a la lista de medicamentos general (la que está en sistema de gestión)
                db.updateJSON(nuevoMedicamento, "medicamentos");
                db.appendArrayToJSON("coordinadores");


//                Agregar el medicamento al json de clinicas
//            for (int j = 0; j < db.getClinicas().size(); j++) {
//                if (db.getClinicas().get(j).nit == clinicaCoordinador.nit) {
//                    db.getClinicas().get(j).listaDeMedicamentos.add(nuevoMedicamento);
//
//                    System.out.println("Medicamento creado e ingresado a inventario con éxito");
//                    break;
//                }
//            }
                db.appendArrayToJSON("clinicas");


                break;

            }
            else {
                System.out.println("Ingresó una opción inválida");
            }

        }

    }

    public void borrarMedicamento() {
        handleDB db = new handleDB();
        Scanner input = new Scanner(System.in);
        Medicamento med = new Medicamento();
        med.listarMedicamento(clinicaCoordinador);


        System.out.println("Ingrese el id del medicamento que desea eliminar: ");
        String idMedicamento = input.nextLine();
        int numI = 0;
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

        int idMedDel = numI;
        int c = 0;
        for (int h = 0; h < db.getMedicamentos().size(); h++) {
            if (db.getMedicamentos().get(h).idMedicamento == idMedDel) {
                db.getMedicamentos().remove(h);
                for (int j = 0; j < clinicaCoordinador.listaDeMedicamentos.size(); j++) {
                    if (clinicaCoordinador.listaDeMedicamentos.get(j).idMedicamento == idMedDel) {
                        clinicaCoordinador.listaDeMedicamentos.remove(j);
                        c++;
                        db.appendArrayToJSON("medicamentos");
                        db.appendArrayToJSON("coordinadores");
                    }
                }
                break;
            }


        }
        if (c == 0) {
            System.out.println("No se encontró ningún medicamento con el id " + idMedDel);
        }
        int indexClinica = 0;
        for (int k = 0; k < db.getClinicas().size(); k++) {
            if (db.getClinicas().get(k).nit == clinicaCoordinador.nit) {
                indexClinica = k;
                break;
            }
        }
        for (int j = 0; j < db.getClinicas().get(indexClinica).listaDeMedicamentos.size(); j++) {
            if (db.getClinicas().get(indexClinica).listaDeMedicamentos.get(j).idMedicamento == idMedDel) {
                db.getClinicas().get(indexClinica).listaDeMedicamentos.remove(j);
                break;
            }
        }
        db.appendArrayToJSON("clinicas");
        System.out.println("Se ha eliminado el medicamento exitosamente");

    }

    @Override
    public String toString() {
        return "{" + "\n" +
                " emailCoordinador : " + emailCoordinador + "," + "\n" +
                " contrasenaCoordinador : " + contrasenaCoordinador + "," + "\n" +
                " clinicaCoordinador : " + clinicaCoordinador.nombreClinica + "," + "\n" +
                "}";
    }

}



